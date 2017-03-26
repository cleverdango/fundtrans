package com.mybank.fundtrans.controller;

import org.apache.catalina.filters.ExpiresFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by yazawanico on 2017/3/20.
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST},urlPatterns = {"/*"})


//todo
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       // HttpServletRequest req = (HttpServletRequest)request;

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
