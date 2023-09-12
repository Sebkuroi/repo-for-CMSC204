
/**
 * An exception that ensures the passwords match
 * @author Sebastian Black
 */
public class UnmatchedException extends Exception 
{
    /**
     * if invalid then the following message will appear
     */
    public UnmatchedException() 
    {
        super("Passwords do not match");
    }
}