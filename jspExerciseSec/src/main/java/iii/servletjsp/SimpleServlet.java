package iii.servletjsp;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/FirstSimpleProgram")
public class SimpleServlet extends HttpServlet {
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
     System.out.println("這是doGet()方法印出的訊息");
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
     System.out.println("這是doPost()方法印出的訊息");
  }
    
}
