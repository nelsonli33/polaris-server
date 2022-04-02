package com.bcorp.polaris.security.jwt;

import com.bcorp.polaris.core.payload.ServerErrorResponse;
import com.bcorp.polaris.core.payload.ServerResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class TokenAuthenticationEntryPoint implements AuthenticationEntryPoint
{
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException
    {
        log.error("Unauthorized error: {}", authException.getMessage());

        ServerErrorResponse serverErrorResponse = new ServerErrorResponse();
        ServerResponse serverResponse = ServerResponse.builder()
                .code(401)
                .message("Unauthorized")
                .build();
        serverErrorResponse.setError(serverResponse);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), serverErrorResponse);
    }
}
