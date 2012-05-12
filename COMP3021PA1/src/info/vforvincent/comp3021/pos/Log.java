package info.vforvincent.comp3021.pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
	
	private PrintWriter logWriter;
	
	public Log(String fileName) {
		try {
			logWriter = new PrintWriter(new FileWriter(fileName), true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Log File Not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add(String message) {
		logWriter.println(message);
		System.out.println(message);
	}
	
	public void add(String message, boolean displayOnConsole) {
		logWriter.println(message);
		if (displayOnConsole) {
			System.out.println(message);
		}
	}

	public PrintWriter getWriter() {
		return logWriter;
	}
}
