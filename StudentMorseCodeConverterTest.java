 
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StudentMorseCodeConverterTest {

	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish("- .... .. ... / - . ... - / ... .... --- ..- .-.. -.. / .-- --- .-. -.- / .. ..-. / .- .-.. .-.. / --. --- . ... / .-- . .-.. .-..");
		assertEquals("this test should work if all goes well", converter1);

	}
	@Test
	public void testConvertMorseFileToEnglishString() {	

		File file = new File("src/DaisyDaisy.txt"); 
		try {
			assertEquals("im half crazy all for the love of you", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
	

}
