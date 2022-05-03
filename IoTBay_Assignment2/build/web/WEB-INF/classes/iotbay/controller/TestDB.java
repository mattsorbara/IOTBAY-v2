/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import iotbay.model.User;
import iotbay.model.dao.*;


/**
 *
 * @author matthewsorbara
 */
public class TestDB {
    
    private static Scanner sc = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;
    
    public static void main(String[] args) throws SQLException {
        (new TestDB()).runQueries();
    }
    
    public TestDB() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public char readChoice() {
        return sc.nextLine().charAt(0);
        
    }
    
    private void runQueries() throws SQLException {
        char c;
        
        while ((c = readChoice()) != '*') {
            switch(c) {
                case 'C':
                    testAdd();
                    break;
                
//                case 'R':
//                    testRead();
//                    break;
//                    
//                case 'U':
//                    testUpdate();
//                    break;
//                
//                case 'D':
//                    testDelete();
//                    break;
//                    
//                case 'S':
//                    showAll();
//                    break;
//                    
//                default:
//                    System.out.println("Unknown command.");
//                    break;
                    
                 
            }
        }
    }
    
    private void testAdd() {
        System.out.print("User name: ");
        String name = sc.nextLine();
        
        System.out.print("User email: ");
        String email = sc.nextLine();
        
        System.out.print("User password: ");
        String password = sc.nextLine();
        
        System.out.print("User phone: ");
        String phone = sc.nextLine();
        
        try {
            db.addUser(name, email, password, phone);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("User is added to the database.");
    }
    
    
    
    
    
}
