/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.model.dao;

import java.sql.Connection;

/**
 *
 * @author matthewsorbara
 */
public abstract class DB {
    protected String URL = "jdbc:derby://localhost:1527/";
    protected String db = "users";
    protected String dbuser = "iotadmin";
    protected String dbpass = "password";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
    
    
}
