package info.vforvincent.comp3021.pos;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Log {
	
	private PrintWriter logWriter;
	
	public Log() {
		try {
			logWriter = new PrintWriter(POS.LOG_FILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add(String message) {
		System.out.println("<LOG> " + message);
		logWriter.println(message);
	}
}
