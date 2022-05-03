/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.controller;

import iotbay.model.User;
import iotbay.model.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author matthewsorbara
 */
public class UpdateServlet extends HttpServlet  {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        
        User user = new User(name, email, password, phone);
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        try {
            if (user != null) {
                session.setAttribute("user", user);
                session.setAttribute("updated", "Update successful.");
                System.out.println("updated " + user.getPhone());
                manager.updateUser(name, email, password, phone);
                request.getRequestDispatcher("welcome.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("edit.jsp");
        
        
    }
    
    
    
    
    
}
