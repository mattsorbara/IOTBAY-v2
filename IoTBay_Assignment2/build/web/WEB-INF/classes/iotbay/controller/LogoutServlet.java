/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.controller;

import iotbay.model.User;
import iotbay.model.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;  
import java.util.Date;
import java.sql.Timestamp;


/**
 *
 * @author matthewsorbara
 */
public class LogoutServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        DBManager manager = (DBManager)session.getAttribute("manager");
        String userEmail = ((User)session.getAttribute("user")).getEmail();
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        
        
        Timestamp logout = new Timestamp(new Date().getTime());  
        Timestamp login = (Timestamp)session.getAttribute("loginTimestamp");  
        
        try {
            manager.addLog(login, logout, userEmail);
        } catch (SQLException ex) {
            System.out.println("Error: log not created.");
        }
        
        
        
        session.invalidate();
        request.getRequestDispatcher("home.jsp").include(request, response);
        
    }
    
}
