package ch07_02;

import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SelectMemberDataListener implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent sce) {
	}
	public void contextInitialized(ServletContextEvent event) {
		// 由傳入的參數取出ServletContext物件
		ServletContext context = event.getServletContext();
		// 讀取系統啟始參數: DBString
		String dbString = context.getInitParameter("DBString");
		// 新建MemberDAO類別的物件: dao (Model元件)
//		MemberDAO dao = new MemberDAO(dbString);
		// 請dao物件讀取資料庫內的Member資料
//		Collection<MemberBean> col = dao.select();
		// 將傳回的Collection物件col放入context物件內
//		context.setAttribute("contextMemberBean", col);
	}
}
