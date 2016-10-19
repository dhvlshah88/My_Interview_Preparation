/**
 * 
 */
package numberproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Dhaval
 *
 */
public class Armstrong {

	public static boolean isNumberArmstrong(String value){
		boolean result = false;
		
		if(value.isEmpty()){
			return result;
		}
		
		int powerValue = value.length();
		int number = Integer.parseInt(value);
		int sum = 0;
		
		for(int i = 0;  i < powerValue; i++){
			sum += Math.pow(Character.getNumericValue(value.charAt(i)), powerValue);
		}
		
		if(sum == number){
			result = true;
		}
		
		return result;
	}
	
	@SuppressWarnings("unused")
	private static void readFromFile(String filePath){
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			
			String currentLine = "";
			
			while((currentLine = br.readLine())!= null){
				//Validation
				isNumberArmstrong(currentLine);
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		if(isNumberArmstrong("153")){
			System.out.println("TRUE");
		}else
		{
			System.out.println("FALSE");
		}

		//String filePath = "";
		//readFromFile(filePath);
	}

}
