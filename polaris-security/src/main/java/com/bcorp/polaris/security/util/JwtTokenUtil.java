package com.bcorp.polaris.security.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Slf4j
@Component(value = "jwtTokenUtil")
public class JwtTokenUtil
{
    @Value("${polaris.app.jwtSecret}")
    private String jwtSecret;

    @Value("${polaris.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateToken(Authentication authentication)
    {
        return Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(generateSecretKeyByDecoder(jwtSecret), SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUidFromToken(String token)
    {
        final JwtParser parser = Jwts.parserBuilder().setSigningKey(generateSecretKeyByDecoder(jwtSecret)).build();
        return parser.parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken)
    {
        try
        {
            final JwtParser parser = Jwts.parserBuilder().setSigningKey(generateSecretKeyByDecoder(jwtSecret)).build();
            parser.parseClaimsJws(authToken);
            return true;
        }
        catch (SignatureException e)
        {
            log.error("Invalid JWT signature: {}", e.getMessage());
        }
        catch (MalformedJwtException e)
        {
            log.error("Invalid JWT token: {}", e.getMessage());
        }
        catch (ExpiredJwtException e)
        {
            log.error("JWT token is expired: {}", e.getMessage());
        }
        catch (UnsupportedJwtException e)
        {
            log.error("JWT token is unsupported: {}", e.getMessage());
        }
        catch (IllegalArgumentException e)
        {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    private SecretKey generateSecretKeyByDecoder(String base64Secret)
    {
        final byte[] keyBytes = Decoders.BASE64.decode(base64Secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
