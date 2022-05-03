/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.model.dao;

import iotbay.model.User;
import java.sql.*;
import java.util.ArrayList;




public class DBManager {
    
    private Statement st;
    
    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    public User findUser(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTADMIN.Users WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String userEmail = rs.getString(2);
            String userPass = rs.getString(3);
            if (userEmail.equals(email) && userPass.equals(password)) {
                String userName = rs.getString(1);
                String userPhone = rs.getString(4);
                return new User(userName, userEmail, password, userPhone);
                
            }
        }
        return null;
    }
    
    public void addUser(String name, String email, String password, String phone) throws SQLException {
        st.executeUpdate("INSERT INTO IOTADMIN.Users " + "VALUES ('" + name + "', '" + email + "', '" + password +"','" + phone + "', 'customer')");
    }
    
    public void updateUser(String name, String email, String password, String phone) throws SQLException {
        st.executeUpdate("UPDATE IOTADMIN.Users SET NAME='" + name + "',PASSWORD='" + password + "',PHONE='" + phone + "' WHERE EMAIL='" + email + "'");
        
    }
    
    public void deleteUser(String email) throws SQLException {
        st.executeUpdate("DELETE FROM IOTADMIN.Users WHERE EMAIL='" + email + "'");
    }
    
    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "SELECT * FROM IOTADMIN.Users";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList<User>();
        
        while (rs.next()) {
            String name = rs.getString(1);
            String email = rs.getString(2);
            String password = rs.getString(3);
            String phone = rs.getString(4);
            
            temp.add(new User(name,email,password,phone));
        }
        return temp;
    }
    
    public boolean checkStudent(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTADMIN.Users where EMAIL='" + email + "' AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String userEmail = rs.getString(2);
            String userPass = rs.getString(3);
            if (userEmail.equals(email) && userPass.equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public void addLog(Timestamp login, Timestamp logout, String email) throws SQLException {
        st.executeUpdate("INSERT INTO IOTADMIN.Logs " + "VALUES ('" + email + "', '" + login + "', '" + logout + "')");
    }
    
    public ResultSet fetchAllLogs(String email) throws SQLException {
        String fetch = "SELECT * FROM IOTADMIN.Logs WHERE EMAIL='" + email + "'";
        ResultSet rs = st.executeQuery(fetch);
        return rs;
    }
    
    public ResultSet filterLogs(Timestamp from, Timestamp to, String email) throws SQLException {
        String filter = "SELECT * FROM IOTADMIN.Logs WHERE EMAIL='" + email + "' AND LOGIN >= '" + from + "' AND LOGIN <= '" + to + "'";
        ResultSet rs = st.executeQuery(filter);
        return rs;
    }
     
     
    
}
