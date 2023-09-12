
/**
 * An exception that ensures the password is 6 to 9 characters long
 * @author Sebastian Black
 */
public class WeakPasswordException extends Exception 
{
    /**
     * if invalid then the following message will appear
     */
    public WeakPasswordException() 
    {
        super(" The password is OK but weak - it contains fewer than 10 characters ");
    }
}