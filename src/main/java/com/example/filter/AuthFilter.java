package com.example.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebFilter("/user/*")
    public class AuthFilter implements Filter {

        public void init(FilterConfig filterConfig) {
            // Initialization code goes here (if needed)
        }

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            // Check if "user" attribute exists in the session
            if (httpRequest.getSession().getAttribute("user") == null) {
                // Redirect to login page
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            } else {
                // User is logged in, allow the request to proceed
                chain.doFilter(request, response);
            }
        }

        public void destroy() {
            // Cleanup code goes here (if needed)
        }
    }

