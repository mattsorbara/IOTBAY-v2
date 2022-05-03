/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.controller;

import iotbay.model.User;
import iotbay.model.dao.DBManager;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author matthewsorbara
 */
public class LogServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        DBManager manager = (DBManager)session.getAttribute("manager");
        User user = (User)session.getAttribute("user");
        
        String fromString = request.getParameter("from")+":00";
        String toString = request.getParameter("to")+":00";

        Timestamp fromTime = Timestamp.valueOf(fromString.replace("T"," "));
        Timestamp toTime = Timestamp.valueOf(toString.replace("T"," "));
        
        try {
           ResultSet filteredLogs = manager.filterLogs(fromTime, toTime, user.getEmail());
           
           session.setAttribute("userLogRows", filteredLogs);
           session.setAttribute("from", fromString.replace("T"," "));
           session.setAttribute("to", toString.replace("T"," "));
           
           request.getRequestDispatcher("viewLogs.jsp").forward(request, response);
           
        } catch (SQLException ex) {
            System.out.println("SQL Error.");
        }
        

        
    }
        
       
    
}
