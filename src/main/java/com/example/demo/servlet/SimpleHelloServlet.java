package com.example.demo.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SimpleHelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setContentType("text/plain");
        resp.getWriter().write("Hello from Simple Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // For test requirement: POST should not throw exceptions and return 200 or 405
        resp.setStatus(200);
    }

    @Override
    public String getServletInfo() {
        return "SimpleHelloServlet - basic hello servlet";
    }
}
