package ch03.servletood._05;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ch03/_05/ShowCityTime")
public class ShowCityTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String city = request.getParameter("city");
		String cityName = request.getParameter("cityName");
		TimeZone tz = TimeZone.getTimeZone(city);
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(tz);
		Date date = new Date();
        out.println(cityName + "現在時間：" + sdf.format(date));
	}
}
