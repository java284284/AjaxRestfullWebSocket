package ch07.ex06.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ch07.ex06.model.Dog;

public class MyServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent event) {
	}

	public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        String dogBreed = sc.getInitParameter("breed");
        Dog d = new Dog(dogBreed);
        sc.setAttribute("myDog", d);
        sc.log("Yahoo, MyServletContexttListener...功能無誤，它的血統為" + dogBreed);
	}
}