/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import iotbay.model.dao.DBConnector;
import iotbay.model.dao.DBManager;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;


/**
 *
 * @author matthewsorbara
 */

public class ConnectionServlet extends HttpServlet {
    
    private DBConnector db;
    private DBManager manager;
    private Connection connect;
    
    @Override
    public void init() {

        try {
            db = new DBConnector();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        response.setContentType("text/html;charest=UTF-8");
        HttpSession session = request.getSession();
        connect = db.openConnection();
        
        try {
            manager = new DBManager(connect);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("manager", manager);
    }
    
    @Override
    public void destroy() {
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
