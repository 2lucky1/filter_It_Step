package com.muntian.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "encoding",initParams = {
        @WebInitParam(name = "connection", value = "jdbc:mysql://localhost/site")
})

public class EncodingFilter implements Filter {

    private String connection;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        connection = filterConfig.getInitParameter("connection");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("connection", connection);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
