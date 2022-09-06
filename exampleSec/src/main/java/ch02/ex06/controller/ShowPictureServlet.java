package ch02.ex06.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *  1. 本Servlet產生非文字性資料的回應
 *  2. 通常Servlet不會產生文字性的回應，但如果要產生
 *     非文字性資料的回應(如圖片)，必須編寫下列兩行：
 *     
       response.setContentType("image/jpeg");  //  "image/gif"
       OutputStream  os = response.getOutputStream();
 */
@WebServlet("/ch02/ShowPictureServlet")
public class ShowPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	   String[] pics = {"autumn_fs.jpg" , "fs.jpg", "m001.jpg"};
	   int num = (int)(Math.random() * pics.length) + 0;
	   // deployDir: 本應用系統在伺服器內的部署資料夾
       String deployDir = getServletContext().getRealPath("/");
	   // imageDir : 存放圖片檔的資料夾，它位於部署資料夾之下的images資料夾      
       String imageDir = deployDir + "\\images\\" ;    
	   InputStream is = new FileInputStream(imageDir + pics[num]);
	   response.setContentType("image/jpeg");
	   OutputStream os = response.getOutputStream();
	   byte[] b = new byte[1024]; 
	   int len ; 
	   while( ( len = is.read(b) ) != -1 ){
		   os.write(b, 0, len);
	   }
	   is.close();
	   os.close();	   
	}
}
