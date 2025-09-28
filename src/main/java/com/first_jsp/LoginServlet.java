package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/login.do")

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String view = "/WEB-INF/views/login.jsp";  // intentionally wrong
        String name= request.getParameter("name");
        request.setAttribute("name",name);

        if (getServletContext().getResource(view) == null) {
            getServletContext().log("Missing JSP: " + view);
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // If the JSP doesn't exist, throw a 500 with a stack trace in console
        if (getServletContext().getResource(view) == null) {
            throw new ServletException("View not found: " + view);
        }

        System.out.println(request.getParameter("name"));
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            request.setAttribute("name", request.getParameter("name"));
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
        }

}