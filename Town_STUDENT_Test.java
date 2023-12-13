import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test
{
    private Town StudentTown1, StudentTown2, StudentTown3;

    @Before
    public void setUp() throws Exception
    {
        StudentTown1 = new Town("Town1");
        StudentTown2 = new Town("Town2");
        StudentTown3 = new Town("Town1"); 
    }

    @Test
    public void testTownConstructor() 
    {
        assertEquals("Town1", StudentTown1.getName());
    }

    @Test
    public void testCompareTo() 
    {
        assertTrue(StudentTown1.compareTo(StudentTown2) < 0);
        assertEquals(0, StudentTown1.compareTo(StudentTown3)); 
    }

    @Test
    public void testEquals() 
    {
        assertTrue(StudentTown1.equals(StudentTown3)); 
        assertFalse(StudentTown1.equals(StudentTown2)); 
    }

    @Test
    public void testHashCode() 
    {
        assertEquals(StudentTown1.hashCode(), StudentTown3.hashCode()); 
        assertNotEquals(StudentTown1.hashCode(), StudentTown2.hashCode()); 
    }

    @Test
    public void testGetName()
    {
        assertEquals("Town1", StudentTown1.getName());
    }

    @Test
    public void testToString() 
    {
        assertEquals("Town1", StudentTown1.toString());
    }
}