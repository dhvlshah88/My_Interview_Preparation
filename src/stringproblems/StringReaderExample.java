package stringproblems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringReaderExample {

	public static void main(String[] args) {
		String filePath = "";
		try {
			String line = readStringFromFile(filePath);
			String[] testString = line.split(";");
			String[] replaceString = testString[1].split(",");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String readStringFromFile(String filePath) throws IOException{
		String currentLine = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			while((currentLine = reader.readLine())!= null) {
				System.out.println(currentLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return currentLine; 
	}
}
