package info.vforvincent.comp3021.pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Log {
	
	private PrintWriter logWriter;
	
	public Log(String fileName) {
		try {
			logWriter = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Log File Not Found");
		}
	}
	
	public void add(String message) {
		logWriter.println(message);
		System.out.println("<LOG> " + message);
	}

	public PrintWriter getWriter() {
		return logWriter;
	}
}
