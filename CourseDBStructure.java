/**
* defining the structure
* @author Sebastian Black
*
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface
{
	ArrayList<LinkedList<CourseDBElement>> Table;
	
	public CourseDBStructure(int cources)
	{
		boolean prime = false;
		int Base = (int) (cources/1.5);
		int integer = Base + (3 - (Base % 4));
		while (!prime)
		{
			prime = true;
			for(int i = 2; i <= integer/2; i++)
		       {
		           if((integer%i)==0)
		           {
					prime = false;
					break;
				    }
		       }
			if (!prime)
				integer += 4;
		}
		
		Table = new ArrayList<LinkedList<CourseDBElement>>();
		for (int i = 0; i < integer; i++)
		{
			Table.add(new LinkedList<CourseDBElement>());
		}
	}
	
	public CourseDBStructure(String Testing, int size)
	{

		Table = new ArrayList<LinkedList<CourseDBElement>>();
		for (int i = 0; i < size; i++)
		{
			Table.add(new LinkedList<CourseDBElement>());
		}
	}
	
	@Override
	public void add(CourseDBElement element) 
	{
		for (LinkedList<CourseDBElement> bucket: Table)
		{
			for (CourseDBElement existingCRN : bucket)
		{
				if (existingCRN.getCRN() == element.getCRN()) {
	                bucket.set(bucket.indexOf(existingCRN), element);
	                return;
				}
			}
		}
		int bucketindex = element.hashCode() % Table.size();
		Table.get(bucketindex).add(element);
	}
	
	@Override
	public CourseDBElement get(int crn) throws IOException 
	{
		for (LinkedList<CourseDBElement> bucket: Table)
		{
			for (CourseDBElement element : bucket)
			{
				if (element.getCRN() == crn)
					return element;
			}
		}
		throw new IOException();
	}
	

	@Override
	public ArrayList<String> showAll() {
		// Instance Vars
		ArrayList<String> allinfo = new ArrayList<String>();
		for (LinkedList<CourseDBElement> bucket: Table)
		{
			for (CourseDBElement element : bucket)
			{
				if (element != null) 
				{
					allinfo.add("\nCourse:" + element.getID() + " CRN:" + element.getCRN() + " Credits:" + element.getcredvalue() + " Instructor:" + element.getinstructorsName() + " Room:" + element.getRoomNum());
				}
			}
		}
		return allinfo;
	}

	@Override
	public int getTableSize() {
		return Table.size();
	}
}