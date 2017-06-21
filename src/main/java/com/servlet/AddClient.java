package com.servlet;

import com.entity.Client;
import com.entity.Course;
import com.repository.ClientDAO;
import com.service.CRUDService;
import com.service.SubscribeService;

import javax.naming.ldap.LdapName;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Daniel Paredes on 21/6/2017.
 */
public class AddClient extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        response.setContentType("text/html");

        response.setCharacterEncoding( "UTF-8" );

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");

        out.println("<html>");

        out.println("<head>");

        out.println("<meta charset=\"utf-8\" />");

        out.println("<title>Add Client</title>");

        out.println("</head>");

        out.println("<body>");

        out.println("<p> Agregar SERVLET </p>");

        out.println("</body>");

        out.println("</html>");


        CRUDService nuevocurso = new CRUDService();

        nuevocurso.addCourse("LO56","Anglais");

        response.sendRedirect(request.getContextPath()+"/index.jsp");







    }
}