package com.bcorp.polaris.storefront.security.jwt;

import com.bcorp.polaris.storefront.security.CoreUserDetailsService;
import com.bcorp.polaris.storefront.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter
{
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CoreUserDetailsService coreUserDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        try
        {
            String jwt = getJwtFromRequest(request);
            if (jwt != null && jwtTokenUtil.validateJwtToken(jwt))
            {
                final String uid = jwtTokenUtil.getUidFromToken(jwt);
                final UserDetails userDetails = coreUserDetailsService.loadUserByUsername(uid);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        catch (Exception e)
        {
            log.error("Cannot set user authentication: {}", e);
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request)
    {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
        {
            return bearerToken.substring(7);
        }
        return null;
    }

//    private String getJwtFromCookie(HttpServletRequest request)
//    {
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies)
//        {
//            if (accessTokenCookieName.equals(cookie.getName()))
//            {
//                String accessToken = cookie.getValue();
//                return accessToken;
//            }
//        }
//        return null;
//    }
//
//    private String getJwtToken(HttpServletRequest request, boolean fromCookie)
//    {
//        if (fromCookie) return getJwtFromCookie(request);
//
//        return getJwtFromRequest(request);
//    }
}
