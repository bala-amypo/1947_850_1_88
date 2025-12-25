package com.example.demo.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleHelloServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.getWriter().write("Hello from Simple Servlet");
    }
    
    public String getServletInfo() {
        return "SimpleHelloServlet";
    }
}