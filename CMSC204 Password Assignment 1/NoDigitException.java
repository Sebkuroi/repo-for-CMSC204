
/**
 * An exception that ensures the password coontains at least one digit
 * @author Sebastian Black
 */
public class NoDigitException extends Exception 
{
    /**
     * if invalid then the following message will appear
     */
    public NoDigitException() 
    {
        super(" The password must contain at least one digit ");
    }
}