
/**
 * An exception that ensures the password is more than 6 characters
 * @author Sebastian Black
 */
public class LengthException extends Exception 
{
    /**
     * if invalid then the following message will appear
     */
    public LengthException() 
    {
        super("The password must be at least 6 characters long");
    }
}