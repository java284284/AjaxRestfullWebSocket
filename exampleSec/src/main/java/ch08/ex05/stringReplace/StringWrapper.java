package ch08.ex05.stringReplace;

import java.io.*;
import javax.servlet.http.*;

public class StringWrapper extends HttpServletResponseWrapper {
	StringWriter writer = new StringWriter();
	public StringWrapper(HttpServletResponse response) {
		super(response);
	}
	public PrintWriter getWriter() {
		return new PrintWriter(writer);
	}
	public String toString() {
		return writer.toString();
	}
}
