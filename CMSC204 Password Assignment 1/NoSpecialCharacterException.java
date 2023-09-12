
/**
 * An exception that ensures the password must containt at least one special character
 * @author Sebastian Black
 */
public class NoSpecialCharacterException extends Exception 
{
    /**
     * if invalid then the following message will appear
     */
    public NoSpecialCharacterException() 
    {
        super("The password must contain at least one special character");
    }
}