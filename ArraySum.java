/**
 * sum of values in array
 * @author Sebastian Black
 */
public class ArraySum 
{
/**
 *  a array in which the elements need to sum.
 * @return 16 and 24 
 */
	public int sumOfArray (Integer[] a, int index)
	{
		if ( index == 0)
			return a[index];
		else
			return a[index] + sumOfArray (a, index-1);
		
	}
}

	