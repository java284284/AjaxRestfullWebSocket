package ch07.ex07.web;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

import ch07.ex07.model.CoffeeBean;

import java.io.*;
import java.util.*;

/* 
 本程式由文字檔(CoffeeData.txt)逐筆讀入資料，然後產生CoffeeBean物件，
 然後依序加入coffeeList之內，最後此coffeeList加入到context內。
 */
@WebListener
public class ServletContextListenerDemo00 implements ServletContextListener {
	List<CoffeeBean> coffeeList = new ArrayList<CoffeeBean>();
	ServletContext context;

	public void contextInitialized(ServletContextEvent sce) {
		context = sce.getServletContext();
		populateFromFile();
		context.setAttribute("COFFEE_LIST", coffeeList);
	}

	public void populateFromFile() {
		try {
			String dataPath = context.getInitParameter("dataPath");
			context.log("System Message:DataPath=" + dataPath);
			InputStream is = context.getResourceAsStream(dataPath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] cofData = line.split(",");
				int code = Integer.parseInt(cofData[0].trim());
				String name = cofData[1].trim();
				double price = Double.parseDouble(cofData[2].trim());
				double discount = Double.parseDouble(cofData[3].trim());
				CoffeeBean cof = new CoffeeBean(code, name, price, discount);
				coffeeList.add(cof);
			}
		} catch (IOException e) {
			context.log("IOException:" + e);
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		context.log("系統訊息: 正常關機");
	}
}