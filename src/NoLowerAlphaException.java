
/**
 * An exception that ensures the password has at least one lower case letter
 * @author Sebastian Black
 */
public class NoLowerAlphaException extends Exception 
{
    /**
     * if invalid then the following message will appear
     */
    public NoLowerAlphaException() 
    {
        super("The password must contain at least one lowercase alphabetic character");
    }
}