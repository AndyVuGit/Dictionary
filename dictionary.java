import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
	public static void main(String[] args) throws Exception
	{
		//Rundown of what will entail
		/*
		 * Get data.
		 * use hashing to store words with their japanese version. Problem is how to store the japanese version. Solution: store in pairs.
		 * Take in a word and search for it in our own data. 
		 * return the japanese version of the word.
		*/
		
		//Openning the file
		File file = new File("data.txt");
		Scanner scanner = new Scanner(file);
		
		Map<String, String> dictMap = new HashMap<String, String>();
		while (scanner.hasNextLine())
		{
			//------------Import Data-------------
			String engWord = scanner.next();
			String japWord = scanner.next();
			
			//------------Hashing Data------------
			dictMap.put(engWord, japWord);
			scanner.nextLine();
		}
		
		scanner.close();
		
		
		//--------Get user input on what word to search up--------
		Scanner input = new Scanner(System.in);
		String key = "";
		while(!key.equals("quit")){
			key = input.next();
			if(key.equals("quit")){
				break;
			}
			
			if(dictMap.get(key) == null){
				System.out.println("The word is not in our database");
			}
			else{
				System.out.println(dictMap.get(key));
			}
		}
		
		input.close();
	}
}
