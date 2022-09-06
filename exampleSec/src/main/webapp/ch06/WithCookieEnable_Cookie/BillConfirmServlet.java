package com.iiishop.book.controller;

import pk.domain.* ;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Support classes

import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class BillConfirmServlet extends HttpServlet {
	
   public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
         throws IOException {
      ShoppingCart sc ;
      HttpSession session = request.getSession();
      
      sc = (ShoppingCart)session.getAttribute("ShoppingCart") ;
      if  ( sc == null ) {
    	    generateErrorResponse(request, response);
    	    return ;
      }
      generateBookListing(request, response);
   
   }
   public void generateBookListing(HttpServletRequest request,
                                       HttpServletResponse response)
         throws IOException {
      // Retrieve the HttpSession object
      HttpSession session = request.getSession();
     
      // Specify the content type is HTML
      response.setContentType("text/html; charset=Big5");
      PrintWriter out = response.getWriter();
     
      ShoppingCart sc = (ShoppingCart)session.getAttribute("ShoppingCart") ;
      double totalPrice = 0;
      int counter = 0  ;
      Iterator it = sc.getAllBooks() ;
      while (it.hasNext() ) {
      	 counter++ ; 
      	 Book book = (Book)it.next() ;
      	 totalPrice += book.getPrice() ;
      }	 

      out.println("<HTML>");
      out.println("<HEAD>");
      out.println("<TITLE>購物車內容</TITLE>");
      out.println("</HEAD>");
      out.println("<BODY BGCOLOR='white'><CENTER>");
      if ( counter == 0 ) {
      	 out.println("<P>您尚未購買任何商品，請輕鬆瀏覽各項商品，慢慢挑選<P>");
      } else {
      	 out.println("    購物總金額: " + totalPrice + ", 件數: " + counter  +"<P>");
         out.println("    您的購物清單如下<P>");
         out.println("<TABLE BORDER='0' WIDTH='600'>");
         out.println("<TR  BGCOLOR='#CCFFFF' >");
         out.println("  <TH ALIGN='center'>書號</TH>");
         out.println("  <TH ALIGN='center'>書名</TH>");
         out.println("  <TH ALIGN='center'>單價</TH>");
         out.println("</TR>");
         
         it = sc.getAllBooks() ;
         while (it.hasNext() ) {
         	  out.println("<TR  BGCOLOR='#CCCCFF' >");
         	  Book book = (Book)it.next() ;
         	  String title = book.getTitle() ;
         	  String bookId = book.getBookId() ;
         	  double price = book.getPrice() ;
         	  out.println("<TD>" + bookId + "</TD>");
         	  out.println("<TD>" + title + "</TD>");
         	  out.println("<TD>" + price + "</TD>");
         	  out.println("</TR>");
         }
         
         out.println("</TABLE>");
      }
      out.println();
      out.println("</BODY>");
      out.println("</HTML>");
   }
   public void generateErrorResponse(HttpServletRequest request,
                                    HttpServletResponse response)
         throws IOException {

    
    
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.println("<HTML>");
      out.println("<HEAD>");
      out.println("<TITLE>ShoppingCart Errors</TITLE>");
      out.println("</HEAD>");
      out.println("<BODY BGCOLOR='white'>");
      out.println("<TABLE BORDER='0' WIDTH='600'>");
      out.println("<TR>");
      out.println("  <TD COLSPAN='2' BGCOLOR='#CCCCFF' ALIGN='center'>");
      out.println("    <H3>購物車不存在</H3>");
      out.println("  </TD>");
      out.println("</TR>");
      out.println("</TABLE>");
      out.println();
      out.println("<BR>");
      out.println();
      out.println("</BODY>");
      out.println("</HTML>");
    
   } 
  
  

}
