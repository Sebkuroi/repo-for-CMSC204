
/**
 * An exception that ensures the password does not containt 2 or more of the same charater in a row
 * @author Sebastian Black
 */
public class InvalidSequenceException extends Exception 
{
    /**
     * if invalid then the following message will appear
     */
    public InvalidSequenceException() 
    {
        super(" The password cannot contain more than two of the same character in sequence ");
    }
}