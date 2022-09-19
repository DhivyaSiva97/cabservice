/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.LoginBean;
import db.util.DBConnection;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import static sun.jvm.hotspot.HelloWorld.e;

/**
 *
 * @author Admin
 */
public class LoginDao {
    public String authenticateUser(LoginBean loginBean) throws SQLException
     {
         String name = loginBean.getName();
         String password = loginBean.getPassword();
 
         Connection con = null;
         Statement statement = null;
         ResultSet resultSet = null;
 
         String nameDB = "";
         String passwordDB = "";
 
        
             con = (Connection) DBConnection.createConnection(); //Fetch database connection object
             statement = (Statement) con.createStatement(); //Statement is used to write queries. Read more about it.
             resultSet = statement.executeQuery()("select name,password from login");  
             
             while(resultSet.next()) // Until next row is present otherwise it return false
             {
                 nameDB = resultSet.getString("name"); //fetch the values present in database
                 passwordDB = resultSet.getString("password");
                 
 
               if((name.equals(nameDB) && password.equals(passwordDB)))
               {
               } else {
                   return "SUCCESS"; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
             }
        }
              e.printStackTrace();
        return null;
             }
             
         }



