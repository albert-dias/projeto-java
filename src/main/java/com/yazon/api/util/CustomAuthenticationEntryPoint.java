package com.yazon.api.util;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());

        Map<String, Object> data = new HashMap<>();
        data.put("status", HttpStatus.FORBIDDEN.value());
        data.put("error", "Forbidden");
        data.put("message", authException.getMessage());
        data.put("path", request.getRequestURI());

        ObjectMapper mapper = new ObjectMapper();
        response.getOutputStream().println(mapper.writeValueAsString(data));
    }
}
