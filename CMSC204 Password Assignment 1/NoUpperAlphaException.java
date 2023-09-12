
/**
 * An exception that ensures the password contains an upper case letter
 * @author Sebastian Black
 */
public class NoUpperAlphaException extends Exception 
{
    /**
     * if invalid then the following message will appear
     */
    public NoUpperAlphaException() 
    {
        super(" The password must contain at least one uppercase alphabetic character ");
    }
}