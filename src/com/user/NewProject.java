package com.user;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class NewProject extends HttpServlet {



    @java.lang.Override
    protected void doGet (HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter out = servletResponse.getWriter();
        out.print("<html><body>");
        out.print("<b>Welcome</b>");
        out.print("</body></html>");
        servletResponse.setContentType("text/html");
        PrintWriter p= servletResponse.getWriter();
        String username=servletRequest.getParameter("username");
        String password=servletRequest.getParameter("password");
        Connection connection=null;

        try{
Class.forName("org.postgresql.Driver");
connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","admin");
            PreparedStatement psl=connection.prepareStatement("insert into list1 values (?,?)");
            psl.setString(1,username);
            psl.setString(2,password);
            psl.executeUpdate();
//            String username = servletRequest.getParameter("EnterId");
//            String password = servletRequest.getParameter("PinNum");

        }
        catch (Exception e){
            System.out.println("we are in catch block"+e);
        }
        finally {
            if(connection!=null)
                try{
                connection.close();
                }catch (Exception e){}

        }
    }
}
