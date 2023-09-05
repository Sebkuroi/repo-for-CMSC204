

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

	/**
	 * this is a gradebook test for the gradebook.java to see if all
	 * methods function properly
	 * @author James Gibbs
	 *
	 */
class GradebookTester {
	GradeBook gradebook1;
	GradeBook gradebook2;

	@BeforeEach
	void setUp() throws Exception 
	{
		gradebook1 = new GradeBook(5);
		gradebook1.addScore(67);
		gradebook1.addScore(76);
		gradebook2 = new GradeBook(5);
		gradebook2.addScore(25);
		gradebook2.addScore(52);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		gradebook2.addScore(88);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		gradebook1 = null;
		gradebook2 = null;
	}

	@Test
	void testAddScore() 
	{
		assertTrue(gradebook1.toString().equals("67.0 76.0 "));
		assertTrue(gradebook2.toString().equals("25.0 52.0 88.0 "));
		assertEquals(2, gradebook1.getScoreSize());
		assertEquals(3, gradebook2.getScoreSize());
	}

	@Test
	void testSum() 
	{
		assertEquals(143, gradebook1.sum());
		assertEquals(165, gradebook2.sum());
	}

	@Test
	void testMinimum() 
	{
		assertEquals(67, gradebook1.minimum());
		assertEquals(25, gradebook2.minimum());
	}

	@Test
	void testFinalScore() 
	{
		assertEquals(76, gradebook1.finalScore());
		assertEquals(140, gradebook2.finalScore());
	}
}