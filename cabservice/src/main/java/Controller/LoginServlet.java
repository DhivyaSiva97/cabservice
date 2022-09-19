/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import bean.LoginBean;
import dao.LoginDao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class LoginServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        //Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
 
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
 
        LoginBean loginBean = new LoginBean(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
 
        loginBean.setEmail(email); //setting the username and password through the loginBean object then only you can get it in future.
         loginBean.setPassword(password);
 
        LoginDao loginDao = new LoginDao(); //creating object for LoginDao. This class contains main logic of the application.
 
        String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
 
        if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
         {
             request.setAttribute("Name", name); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
             request.getRequestDispatcher("/Login.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
         }
         else
         {
             request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
             request.getRequestDispatcher("/login.jsp").forward(request, response);//forwarding the request
         }
    }
    }

