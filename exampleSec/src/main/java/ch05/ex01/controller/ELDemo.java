package ch05.ex01.controller;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import ch05.ex01.model.OrderBean;
@WebServlet("/ch05/ELDemo.do")
public class ELDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Case1 屬性物件是字串物件==>透過EL來取用，${識別字串}
		request.setAttribute("Case1", "第一種情況，屬性物件是字串物件，也就是本字串");
		
		// Case2 屬性物件是JavaBean物件==>透過 EL 來取用，${識別字串.JavaBean的性質}
		Date orderDate = Date.valueOf("2011-01-12");
		OrderBean ob = new OrderBean(65851, orderDate, "kitty968", 2587);
		request.setAttribute("Case2", ob);
		
		// Case3 屬性物件是Map物件==>透過EL來取用，${識別字串.鍵值}就可取得對應的value
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mapkey1", "Hello, World字串");
		map.put("mapkey2", ob);		
		request.setAttribute("Case3", map);
		
		// Case4 屬性物件是元素是JavaBean物件的陣列==>搭配JSTL的<c:forEach>與EL 來取用
		Date orderDate1 = Date.valueOf("2011-01-01");
		Date orderDate2 = Date.valueOf("2011-01-11");
		Date orderDate3 = Date.valueOf("2011-01-21");
		OrderBean ob1 = new OrderBean(65824, orderDate1, "array123", 1507);
		OrderBean ob2 = new OrderBean(42301, orderDate2, "array456", 2507);
		OrderBean ob3 = new OrderBean(94337, orderDate3, "array789", 3507);
		OrderBean oba[] = {ob1, ob2, ob3};
		request.setAttribute("Case4", oba);

		// Case5 屬性物件是元素是JavaBean物件的Collection==>搭配JSTL的<c:forEach>與EL 來取用
		Date orderDate41 = Date.valueOf("2010-10-06");
		Date orderDate42 = Date.valueOf("2010-10-16");
		Date orderDate43 = Date.valueOf("2010-10-26");
		OrderBean ob4 = new OrderBean(15426, orderDate41, "collection123", 107);
		OrderBean ob5 = new OrderBean(25030, orderDate42, "collection456", 9705);
		OrderBean ob6 = new OrderBean(35231, orderDate43, "collection789", 824);
		Collection<OrderBean> obc = new ArrayList<OrderBean>();
		obc.add(ob4);
		obc.add(ob5); 
		obc.add(ob6);
		request.setAttribute("Case5", obc);
		
		// Case6 Key或Value是JavaBean物件的Map==>搭配JSTL的<c:forEach>與EL 來取用
		Date orderDate51 = Date.valueOf("2001-01-05");
		Date orderDate52 = Date.valueOf("2001-01-15");
		Date orderDate53 = Date.valueOf("2001-01-25");
		OrderBean ob7 = new OrderBean(52841, orderDate51, "map123", 1007);
		OrderBean ob8 = new OrderBean(90461, orderDate52, "map456", 9005);
		OrderBean ob9 = new OrderBean(24750, orderDate53, "map789", 6824);
		Map<String, OrderBean> obm = new HashMap<String, OrderBean>();
		obm.put("obmKey1", ob7);
		obm.put("obmKey2", ob8); 
		obm.put("obmKey3", ob9);
		request.setAttribute("Case6", obm);		
		RequestDispatcher rd = request.getRequestDispatcher("/ch05/ex01/ELDemo.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
