import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Nuke2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br;
		String input;
		
		br = new BufferedReader(new InputStreamReader(System.in));
		try{
			input = br.readLine();
		}
		catch(IOException e){
			throw new Exception(e);
		}
		
		input = input.charAt(0) + input.substring(2);
		System.out.println(input);
	}
}
