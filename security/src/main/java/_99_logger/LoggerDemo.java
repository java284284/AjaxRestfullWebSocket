package _99_logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerDemo {

	public static void main(String[] args) {
		Logger log = Logger.getLogger("...");
		log.setLevel(Level.ALL);
		log.info("Hello Log");
		log.severe("严重信息");
        log.warning("警示信息");
        log.info("一般信息");
        log.config("设定方面的信息");
        log.fine("细微的信息");
        log.finer("更细微的信息");
        log.finest("最细微的信息");

	}

}
