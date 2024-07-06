package com.abhishek.registation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class Registation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String uname = request.getParameter("name");
        String uemail = request.getParameter("email");
        String upwd = request.getParameter("pass");
        String umobile = request.getParameter("contact");
        
        String url = "jdbc:postgresql://localhost:5432/users?useSSL=false";
        String user = "postgres";
        String pass = "aBC@1234";
        

        String insert = "INSERT INTO userinfos (uname, uemail, upwd, umobile) VALUES (?, ?, ?, ?)";
        RequestDispatcher dispatcher = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = con.prepareStatement(insert);
            pst.setString(1, uname);
            pst.setString(2, uemail);
            pst.setString(3, upwd);
            pst.setString(4, umobile);
            
            int rowCount = pst.executeUpdate();
            dispatcher = request.getRequestDispatcher("registration.jsp");
            if (rowCount > 0) {
                request.setAttribute("status", "success");
            } else {
                request.setAttribute("status", "failed");
            }
            dispatcher.forward(request, response);
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
