package ch05.ex02.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ch05/ex02/ReadParameters.do")
public class ReadParametersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
       Map<String, String> errorMessage = new HashMap<String, String>();
       request.setAttribute("errorMSG", errorMessage);
       String custName = request.getParameter("customerName");
       String address  = request.getParameter("address");
       if (custName == null || custName.trim().length() ==0) {
    	   errorMessage.put("NameError", "姓名欄不能空白");
       }
       if (address == null || address.trim().length() ==0) {
    	   errorMessage.put("AddrError", "地址欄不能空白");
       }
       if (errorMessage.size() != 0){ // 表示有錯誤
    	    errorMessage.put("overAllMSG", "請更正下列錯誤：");
    	    RequestDispatcher rd = request.getRequestDispatcher("/ch05/ex02/InputData.jsp");
    	    rd.forward(request, response);
    	    return;
       }
       RequestDispatcher rd = request.getRequestDispatcher("/ch05/ex02/InputDataSuccess.jsp");
       rd.forward(request, response);
	   return;
	}
}