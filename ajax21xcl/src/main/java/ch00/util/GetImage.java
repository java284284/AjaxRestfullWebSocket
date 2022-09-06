package ch00.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch04._03.dao.impl.BookDaoImpl;
import ch04._03.model.BookBean;

//@WebServlet("/ch00/util/GetImage") 
public class GetImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			BookBean bb = null;
			String no = request.getParameter("no");
			int ino = -1;
			if (no != null) {
				try {
					ino = Integer.parseInt(no);
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					ino = -1;
				}
				BookDaoImpl bj = new BookDaoImpl();
				bj.setBookId(ino);
				bb = bj.getBook();
			}
			
			String mimeType = null;
			if (bb == null) {
				is = getServletContext().getResourceAsStream(
						"/images/NoImage.gif");
				mimeType = "image/gif";
			} else {
				Blob blob = bb.getCoverImage();
				if (blob == null){
					is = getServletContext().getResourceAsStream(
							"/images/NoImage.gif");
					mimeType = "image/gif";
				} else {
				   is = blob.getBinaryStream();
				   mimeType = getServletContext().getMimeType(bb.getFileName());
				}
			}
			response.setContentType(mimeType);
			os = response.getOutputStream();
			int len = 0 ; 
			byte[] b = new byte[8192];
			while ( ( len = is.read(b) )!= -1){
				os.write(b, 0, len);
			}
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} finally {
			if (is != null){
				is.close();
			}
			if (os != null){
				os.close();
			}
		}
	}

}
