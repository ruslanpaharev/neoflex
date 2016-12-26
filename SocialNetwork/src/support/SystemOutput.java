package support;

import java.io.PrintStream;

public class SystemOutput {

	private static PrintStream stream;
	
	public static void setSystemOutputNullable(){
		
		stream = System.out;
		System.setOut(null);
	}
	
	public static void setSystemOutputPrintable(){
		
		System.setOut(stream);
	}	
}
