package com.example.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")

public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        //Remove "user" attribute from the session
        request.getSession().removeAttribute("user");

        // Invalidate the session
        request.getSession().invalidate();

        // Redirect to login.jsp
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
