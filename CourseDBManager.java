/**
* CDM class
* @author Sebastian Black
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface
{
		CourseDBStructure DBstructure = new CourseDBStructure(100);
		
	@Override
	public void add(String id, int CRN, int credvalue, String getRoomNum, String instructorsName) 
	
	{
		DBstructure.add(new CourseDBElement(id, CRN, credvalue, getRoomNum, instructorsName));
	}
	
	@Override
	public CourseDBElement get(int CRN) 
	{
		try 
		{
			return DBstructure.get(CRN);
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	@Override
	public void readFile(File input) throws FileNotFoundException 
	{
		Scanner scan = new Scanner(input);
		String[] course;
		CourseDBElement element;
		while (scan.hasNextLine()) 
		{
			course = scan.nextLine().split(" ");
			element = new CourseDBElement(course[0], Integer.parseInt(course[1]), Integer.parseInt(course[2]), course[3], course[4]);
			DBstructure.add(element);
		}
		scan.close();
	}
	@Override
	public ArrayList<String> showAll()
	{
		return DBstructure.showAll();
	}
}