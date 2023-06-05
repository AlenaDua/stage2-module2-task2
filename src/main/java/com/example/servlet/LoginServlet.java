package com.example.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Check if "user" attribute exists in the session
        if (request.getSession().getAttribute("user") != null) {
            // User is already logged in, redirect to hello.jsp
            response.sendRedirect(request.getContextPath() + "/user/hello.jsp");
        } else {
            // User is not logged in, redirect to login.jsp
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // Check if login and password are correct
      if("user".equals(login) && "admin".equals(password)) {
          // Set "user" attribute in the session
          request.getSession().setAttribute("user", login);

          //Redirect to hello.jsp
          response.sendRedirect(request.getContextPath() + "/user/hello.jsp");
      } else {
          // Forward to login.jsp
          request.getRequestDispatcher("/login.jsp").forward(request, response);
      }
  }
}

