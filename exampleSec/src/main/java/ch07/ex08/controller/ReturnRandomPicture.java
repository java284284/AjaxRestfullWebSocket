package ch07.ex08.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/ch07/randomPicture.do")
public class ReturnRandomPicture extends HttpServlet {	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/gif");
        
        String[] picArray = {"autumn_fs.jpg","winter008.jpg","wall166.jpg",
        		            "Omoe_Island_Denmark.jpg","fs.jpg","m001.jpg",
        		            "m12.jpg","m46.jpg","m536.jpg"};
        int index = (int)(Math.random() * picArray.length );
        
        ServletContext ctx = getServletContext() ;         
        InputStream is = ctx.getResourceAsStream("/images/" + picArray[index]);        
        int count = 0 ; 
        byte[] bytes = new byte[1024];
        OutputStream os = response.getOutputStream();
        while ((count = is.read(bytes)) != -1 ) {
            os.write(bytes, 0, count);
        }
        os.flush();
        os.close();
	}
}