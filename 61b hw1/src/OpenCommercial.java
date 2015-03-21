
import java.net.*;
import java.io.*;
public class OpenCommercial {
	public static void main(String[] args) throws Exception{
		BufferedReader keyboard;
		String inputLine;
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		inputLine = keyboard.readLine();
		URL u = new URL("http://www."+inputLine+".com");
		String[] inLines = new String[5];
		//u.openstream(),URL u, these 2 new conceptions
		try{
			BufferedReader website = new BufferedReader(new InputStreamReader(u.openStream()));
			for(int i=0;i<5;i++){
				inLines[i] = website.readLine();
			}
		}
		catch(IOException e){
			throw new Exception(e);
		}
		
		for(int i=0;i<5;i++){
			int reverseIndex = 5-i-1;
			System.out.println(inLines[reverseIndex]);
		}
	}
}
