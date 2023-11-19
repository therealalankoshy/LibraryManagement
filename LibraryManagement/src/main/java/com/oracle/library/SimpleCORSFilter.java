package com.oracle.library;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCORSFilter implements Filter {

    @Value("${security.cors.allow-origin}")
    private String allowOrigin;

    @Value("${security.cors.allow-methods}")
    private String allowMethods;

    @Value("${security.cors.max-age}")
    private String maxAge;

    @Value("${security.cors.allow-headers}")
    private String allowHeaders;
    
    @Value("${security.cors.allow-credentials}")
    private String allowCredentials;

    public SimpleCORSFilter() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        final String requestScheme = request.getScheme();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", allowMethods);
        response.setHeader("Access-Control-Max-Age", maxAge);
        response.setHeader("Access-Control-Allow-Headers", allowHeaders);
        response.setHeader("Access-Control-Allow-Credentials", allowCredentials);

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}