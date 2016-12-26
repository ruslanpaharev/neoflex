package support;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWorker {
	
	public static byte[] readAllBytes(String text){
			
		byte[] file = null;
		Path path = Paths.get(text);
			
		try {
			file = Files.readAllBytes(path);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
			
		return file;
	}
		
	public static void writeAllBytes(byte[] file, String text){
					
		Path path = Paths.get(text);
			
		try {
			Files.write(path, file, StandardOpenOption.CREATE);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
			
	}
	
}
