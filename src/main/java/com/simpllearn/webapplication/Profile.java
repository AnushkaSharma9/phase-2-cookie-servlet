package com.simpllearn.webapplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    //read cookies
   Cookie[] cks = request.getCookies();
   if(cks!=null) {
	   String userEmail = cks[0].getValue();
	   if(userEmail.equals("admin@gmail.com")) {
		   out.println("<h1 style='color:green'> Welcome to User Profile '" +userEmail+ "'</h1>");   
	   }
   } else {
	   out.println("<h1 style='color:red'> Invalid access, please login to access the profile</h1>");
       request.getRequestDispatcher("login.html").include(request,response);
   }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
