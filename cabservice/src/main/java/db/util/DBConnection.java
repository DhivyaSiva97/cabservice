/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBConnection {
    public static Connection createConnection()
 {
     Connection con = null;
     String url = "jdbc:mysql://localhost:3306/users"; //MySQL URL and followed by the database name
     String username = "root"; //MySQL username
     String password = "Java@1234"; //MySQL password   
     try 
     {
         try 
         {
            Class.forName("com.mysql.cj.jdbc.Driver"); //loading mysql driver 
         } 
         catch (ClassNotFoundException e)
         {
            e.printStackTrace();
         } 
         con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
         System.out.println("Printing connection object "+con);
     } 
     catch (SQLException e) 
     {
        e.printStackTrace();
     }
     return con; 
 }
}
