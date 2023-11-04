/**
 * defining the structure
 * @author Sebastian Black
 *
 */
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseDBManager_STUDENT_TEST 
{
	private CourseDBManagerInterface manager = new CourseDBManager();
	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		manager = new CourseDBManager();
	}
	/**
	 * Set dataManager reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
		manager = null;
	}
	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() 
	{
		try 
		{
			manager.add("MATH181",30233,4,"Distance Learning","Alexander Alexander");
		}
		catch(Exception e) 
		{
			fail("This should not have caused an Exception");
		}
	}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead()
	{
		try 
		{
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 30788 4 online Sebastian Black");
			inFile.print("CMSC201 30634 4 online Sebas Black");
			inFile.close();
			manager.readFile(inputFile);
			assertEquals("CMSC204",manager.get(30788).getID());
			assertEquals("CMSC201",manager.get(30634).getID());
			manager.readFile(inputFile);
		}
		catch (Exception e) 
		{
			fail("Should not have thrown an exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll()
	{
		manager.add("CMSC204",30788,4,"online","Sebastian Black");
		manager.add("CMSC203",30723,4,"online","Seb Black");
		manager.add("CMSC201",30634,4,"online","Sebas Black");
		ArrayList<String> list = manager.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:30788 Credits:4 Instructor:Sebastian Black Room:online");
	 	assertEquals(list.get(1),"\nCourse:CMSC203 CRN:30723 Credits:4 Instructor:Seb Black Room:online");
		assertEquals(list.get(2),"\nCourse:CMSC201 CRN:30634 Credits:4 Instructor:Sebas Black Room:online");
	}
	

}