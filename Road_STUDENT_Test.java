import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {
    private Town StudentTown1, StudentTown2;
    private Road StudentRoad1, StudentRoad2, StudentRoad3;

    @Before
    public void setUp() throws Exception {
        StudentTown1 = new Town("Town1");
        StudentTown2 = new Town("Town2");

        StudentRoad1 = new Road(StudentTown1, StudentTown2, 2, "Road1");
        StudentRoad2 = new Road(StudentTown1, StudentTown2, "Road2");
        StudentRoad3 = new Road(StudentTown2, StudentTown1, 2, "Road1"); 
    }


    @Test
    public void CompareTo() {
        assertTrue(StudentRoad1.compareTo(StudentRoad2) < 0);
    }

    @Test
    public void Contains() {
        assertTrue(StudentRoad1.contains(StudentTown1));
        assertFalse(StudentRoad1.contains(new Town("Town3")));
    }

    @Test
    public void Equals() {
    	assertTrue(StudentRoad1.equals(StudentRoad3)); 
    }

    @Test
    public void ToString() {
        assertEquals("Town1 via Road1 to Town2 2 mi", StudentRoad1.toString());
    }

    @Test
    public void GetDestination() {
        assertEquals(StudentTown2, StudentRoad1.getDestination());
    }

    @Test
    public void GetName() {
        assertEquals("Road1", StudentRoad1.getName());
    }

    @Test
    public void GetSource() {
        assertEquals(StudentTown1, StudentRoad1.getSource());
    }

    @Test
    public void GetWeight() {
        assertEquals(2, StudentRoad1.getWeight());
    }
}