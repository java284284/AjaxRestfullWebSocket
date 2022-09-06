package ch03.servletood._06;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ch03/_06/getPicture.do")
public class SendPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> list = new ArrayList<>();
	int previousIndex = -1;
    public void init(){
    	list.add("fs.jpg");
    	list.add("m001.jpg");
    	list.add("m12.jpg");
    	list.add("m46.jpg");
    	list.add("m536.jpg");
    	list.add("v06.jpg");
    }
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int index = (int)(Math.random() * list.size());
		while (previousIndex == index) {
			index = (int)(Math.random() * list.size());
		}
		previousIndex = index;
		String filename = list.get(index);
		ServletContext ctx = getServletContext();
		String mimeType = ctx.getMimeType(filename);
		response.setContentType("text/plain");  
		
		String path = openFileForObservation();    // 此方法僅用來開啟ㄧ個觀察用的檔案
		
		try (
			InputStream is = ctx.getResourceAsStream("/images/" + filename);
			OutputStream os = response.getOutputStream();
			FileOutputStream fos1 = new FileOutputStream(path);
		){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] b = new byte[819200];
			int len = 0;
			while ((len= is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			byte[] bytes = baos.toByteArray();
			String prefix = "data:" + mimeType + ";base64,";
			// 由於java.io.OutputStream類別無法寫出字串，因此將字串轉為位元組陣列寫出
			os.write(prefix.getBytes("UTF-8"));
			Base64.Encoder be = Base64.getEncoder();	
			os.write(be.encode(bytes));
			// 觀察用: 觀察資料寫出的格式 
			fos1.write(prefix.getBytes("UTF-8"));
			fos1.write(be.encode(bytes));
		} 
	}

	private String openFileForObservation() {
		FileOutputStream fos = null;
		String[] paths = {"d:\\aaa.txt", "e:\\aaa.txt", "f:\\aaa.txt", "g:\\aaa.txt"};
		for (String s : paths){
		   try {  
			   fos = new FileOutputStream(s);
			   //System.out.println("檔案位置:" + s);
			   return s;
			} catch (IOException ex1) {
			   ;
			} finally {
			   if (fos != null)
				  try {
					fos.close();
				  } catch (IOException ex) {
					ex.printStackTrace();
				  }
			}
		}
		return null;
	}
}
