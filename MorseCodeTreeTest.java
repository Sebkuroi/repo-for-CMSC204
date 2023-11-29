import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTest {
	MorseCodeTree morseCodeTree  = new MorseCodeTree();
	@Before
	public void setUp() throws Exception 
	{
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test
	public void testFetch() 
	{
		assertEquals("M",morseCodeTree .fetch("--"));
	}
	
	@Test
	public void testInsert()
	{
		 morseCodeTree.insert("..-", "U");
	     assertEquals("U", morseCodeTree.fetch("..-"));
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("E");
		list.add("T");
		list.add("I"); 
		list.add("A"); 	
		list.add("N"); 
		list.add("M");
		list.add("S");
		list.add("U");
		list.add("R");
		list.add("W");
		list.add("D");
		list.add("K");
		list.add("G");
		list.add("O");
		list.add("H");
		list.add("V");
		list.add("F");
		list.add("L");
		list.add("P");
		list.add("J");
		list.add("B");
		list.add("X");
		list.add("C");
		list.add("Y");
		list.add("Z");
		list.add("Q");
		assertEquals(26, list.size());
	}
	@Test
	public void testLNRoutputTraversal() 
	{
		ArrayList<String> list = new ArrayList<>();
        morseCodeTree.LNRoutputTraversal(morseCodeTree.getRoot(), list);
        assertNotNull(list);
	}
}