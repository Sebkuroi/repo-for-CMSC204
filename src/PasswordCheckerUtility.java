import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	/**
	 * Thise is supposed to check all of the main functions 
	 * @author Sebastian Black
	 *
	 */
	
	static void comparePasswords(String password, String Valid) throws UnmatchedException
	{
		if (!password.equals(Valid))throw new UnmatchedException();
	}
	
	static boolean comparePasswordsWithReturn(String password, String Valid)
	{
		return password.equals(Valid);
	}

	static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> Invalidpasswords = new ArrayList<String>();
		
		for (int attempt = 0; attempt < passwords.size(); attempt++)
		{
			try
			{
				isValidPassword(passwords.get(attempt));
			}
			catch (Exception e)
			{
				Invalidpasswords.add(passwords.get(attempt) + " " + e.getMessage());
			}
		}
		return Invalidpasswords;
	}

	static boolean hasBetweenSixAndNineChars(String password)
	{
		if (6 <= password.length() && password.length() <= 9)
				return true;
		else
				return false;
	}
	
	static boolean hasDigit(String password) throws NoDigitException
	{
		if (!password.matches(".*\\d.*"))
			throw new NoDigitException();
		return true;
	}
	static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
	{
		if (!password.matches(".*[^A-Za-z0-9].*"))
			throw new NoSpecialCharacterException();
		return true;
	}
	static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		if (!password.matches(".*[a-z].*"))
			throw new NoLowerAlphaException();
		return true;
	}
	static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		if (!password.matches(".*[A-Z].*"))
			throw new NoUpperAlphaException();
		return true;
	}
	
	static boolean isValidLength(String password) throws LengthException
	{
		if (password.length() < 6)
			throw new LengthException();
		return true;
	}
	
	static boolean isValidPassword(String text) throws Exception
	{
		try
		{
			if (isValidLength(text) && hasDigit(text) && hasUpperAlpha(text) && hasLowerAlpha(text) && hasSpecialChar(text) && NoSameCharInSequence(text))
				return true;
		}
		catch (Exception e)
		{
			throw e;
		}
		return false;
	}
	static boolean isWeakPassword(String attempt) throws WeakPasswordException
	{
		if (hasBetweenSixAndNineChars(attempt))
			throw new WeakPasswordException();
		else 
			return false;
	}
	
	static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
	{
		for (int character = 1; character < password.length(); character++)
		{
			if (password.charAt(character) == password.charAt(character-1))
				throw new InvalidSequenceException();
		}
		return true;
	}
}