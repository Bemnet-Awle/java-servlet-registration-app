package com.hrs.bemni.proj.studentapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Maps the servlet to both endpoints requested
@WebServlet(urlPatterns = {"/register", "/show_all"})
public class StudentServlet extends HttpServlet {

    // Handle GET requests (View All Students)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String path = request.getServletPath();

        if ("/show_all".equals(path)) {
            List<Student> students = new ArrayList<>();
            try (Connection conn = DBConnection.getConnection()) {
                String sql = "SELECT * FROM students";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("year")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // Pass the list to the JSP view
            request.setAttribute("studentList", students);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } else {
            // Redirect root or unknown get requests to the form
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // Handle POST requests (Register Student)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String path = request.getServletPath();

        if ("/register".equals(path)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String yearStr = request.getParameter("year");

            // Basic Validation
            if (name != null && !name.isEmpty() && email != null && yearStr != null) {
                try (Connection conn = DBConnection.getConnection()) {
                    String sql = "INSERT INTO students (name, email, year) VALUES (?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, name);
                    stmt.setString(2, email);
                    stmt.setInt(3, Integer.parseInt(yearStr));
                    
                    stmt.executeUpdate();
                    
                    // On success, redirect to the list view
                    response.sendRedirect("show_all");
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("error", "Database Error: " + e.getMessage());
                }
            } else {
                request.setAttribute("error", "All fields are required.");
            }
            
            // If there was an error, reload the form with the error message
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}