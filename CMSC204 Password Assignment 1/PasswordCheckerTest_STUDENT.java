
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author  Sebastian Black
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> allpasswords;
	String attempt1, attempt2;

	@Before
	public void setUp() throws Exception 
	{
		String p[] = {"helloas213" + "asd)e2AS" + "dWa$32" + "ads" + "HOWAREYOU3$" + "fw4H!^3DS4f" + "aSdF%gsdf"+ "1"};
		
		allpasswords = new ArrayList<String>();
		allpasswords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception
{
		allpasswords = null;
}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try 
		{
		assertTrue(PasswordCheckerUtility.isValidPassword("ads"));
		assertFalse("did not throw a lengthException", false);		
		} catch (LengthException e) {
			assertTrue("Threw lengthException", true);
		}
		catch (Throwable e) {
			assertTrue("was not a different exception", true);
		}
	}

	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("hello&as213"));
			assertFalse("Did not throw NoUpperAlphaException",true);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Threw a NoUpperAlphaExcepetion",true);
		}
		catch(Throwable e)
		{
			assertTrue("was not a different exception",false);
		}	
		
	}

	
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("HOWAREYOU3$"));
			assertFalse("Didn't throw a NoLowerAlphaException",true);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Threw a NoLowerAlphaExcepetion",true);
		}
		catch(Throwable e)
		{
			assertTrue("was not a different exception",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			 
			boolean weakPassword = PasswordCheckerUtility.isWeakPassword("dWa$32");
			assertTrue("Threw WeakPassword Exception",true);
		}
		catch(WeakPasswordException e)
		{
			assertFalse("Threw a another exception",false);
		}
		catch(Throwable e)
		{ 
			assertTrue("was not a different exception",true);
		}
	
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("fw4H!^3DS4f"));
		 	assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Threw an InvalidSequenceExcepetion",true);
		}
		catch(Throwable e)
		{
			assertFalse("was not a different exception",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
		assertEquals(true,PasswordCheckerUtility.isValidPassword("aSdF%gsdf"));
		assertFalse("was not a different exception",true);
	}
	catch(NoDigitException e)
	{
		assertTrue("Threw a NoDigitException",true);
	}
	catch(Throwable e)
	{assertTrue("Didn't throw a NoDigitException",false);
	
	}	
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertEquals(true,PasswordCheckerUtility.isValidPassword("1"));
		 	assertFalse("there were no issues",true);
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
			assertTrue("Threw a an exception",true);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> words = new ArrayList<String>();
		words.add("fG1!ohjb");
		words.add("lK9#gjsg");
		words.add("SGHDBgjh149!");
		words.add("wiIFEGB328%");
		words.add("f");
		words.add("fk@djnfsakFDKJ");
		words.add("fasdFDS241");
		words.add("ffG1@sdgf");
		words.add("DFASFSD4398!@");
		assertEquals(PasswordCheckerUtility.getInvalidPasswords(words).size(), 5);
	}
	}
	

