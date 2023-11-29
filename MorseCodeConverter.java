import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter 
{
	public static String printTree() 
	{
		ArrayList<String> treeList = tree.toArrayList();
		   return String.join(" ", treeList).toLowerCase();
	}
	
	public static String convertToEnglish(String morseCode)
	{
	    MorseCodeTree tree = new MorseCodeTree();
	    StringBuilder Englishwords = new StringBuilder();
	    String[] fullwords = morseCode.split(" / ");

	    for (String word : fullwords)
	    {
	        for (String letter : word.split(" "))
	        {
	        	Englishwords.append(tree.fetch(letter));
	        }
	        Englishwords.append(" ");
	    }
	    return Englishwords.toString().trim().toLowerCase();
	}
	
	static MorseCodeTree tree = new MorseCodeTree();
	public static String convertToEnglish(File morsecodefile) throws FileNotFoundException 
	{
		
		Scanner scan = new Scanner(morsecodefile);
		String code = "";
		while (scan.hasNextLine()) 
		{
			code += scan.nextLine();
		}
		return convertToEnglish(code);
	}
}