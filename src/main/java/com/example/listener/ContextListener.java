package com.example.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();

        // Set "servletTimeInit" attribute with the current date and time
        servletContext.setAttribute("servletTimeInit", LocalDateTime.now());
    }
   public void contextDestroyed(ServletContext event) {

   }
}
