import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Graph_STUDENT_Test 
{
    private GraphInterface<Town, Road> StudentGraph;
    private Town[] Studenttown;

    @Before
    public void setUp() throws Exception 
    {
        StudentGraph = new Graph();
        Studenttown = new Town[12];

        for (int i = 1; i < 12; i++) {
            Studenttown[i] = new Town("Studenttown" + i);
            StudentGraph.addVertex(Studenttown[i]);
        }

        StudentGraph.addEdge(Studenttown[1], Studenttown[2], 2, "StudentRoadA");
        StudentGraph.addEdge(Studenttown[1], Studenttown[3], 4, "StudentRoadB");
        StudentGraph.addEdge(Studenttown[2], Studenttown[4], 6, "StudentRoadC");
        StudentGraph.addEdge(Studenttown[3], Studenttown[5], 1, "StudentRoadD");
    }

    @After
    public void tearDown() throws Exception 
    {
        StudentGraph = null;
    }

    @Test
    public void testGetEdge() 
    {
        assertEquals(new Road(Studenttown[1], Studenttown[2], 2, "StudentRoadA"), StudentGraph.getEdge(Studenttown[1], Studenttown[2]));
    }

    @Test
    public void testAddEdge() 
    {
        assertFalse(StudentGraph.containsEdge(Studenttown[3], Studenttown[4]));
        StudentGraph.addEdge(Studenttown[3], Studenttown[4], 3, "StudentRoadE");
        assertTrue(StudentGraph.containsEdge(Studenttown[3], Studenttown[4]));
    }

    @Test
    public void testAddVertex() 
    {
        Town newTown = new Town("Studenttown12");
        assertFalse(StudentGraph.containsVertex(newTown));
        StudentGraph.addVertex(newTown);
        assertTrue(StudentGraph.containsVertex(newTown));
    }

    @Test
    public void testContainsEdge() 
    {
        assertTrue(StudentGraph.containsEdge(Studenttown[1], Studenttown[2]));
        assertFalse(StudentGraph.containsEdge(Studenttown[2], Studenttown[3]));
    }

    @Test
    public void testContainsVertex() 
    {
        assertTrue(StudentGraph.containsVertex(new Town("Studenttown2")));
        assertFalse(StudentGraph.containsVertex(new Town("Studenttown12")));
    }

    @Test
    public void testEdgeSet()
    {
        Set<Road> roads = StudentGraph.edgeSet();
        ArrayList<String> roadArrayList = new ArrayList<>();
        for (Road road : roads) 
        {
            roadArrayList.add(road.getName());
        }
        Collections.sort(roadArrayList);
        assertEquals("StudentRoadA", roadArrayList.get(0));
    }

    @Test
    public void testEdgesOf() 
    {
        Set<Road> roads = StudentGraph.edgesOf(Studenttown[1]);
        ArrayList<String> roadArrayList = new ArrayList<>();
        for (Road road : roads) 
        {
            roadArrayList.add(road.getName());
        }
        Collections.sort(roadArrayList);
        assertEquals("StudentRoadA", roadArrayList.get(0));
    }

    @Test
    public void testRemoveEdge()
    {
        assertTrue(StudentGraph.containsEdge(Studenttown[1], Studenttown[2]));
        StudentGraph.removeEdge(Studenttown[1], Studenttown[2], 2, "StudentRoadA");
        assertFalse(StudentGraph.containsEdge(Studenttown[1], Studenttown[2]));
    }

    @Test
    public void testRemoveVertex() 
    {
        assertTrue(StudentGraph.containsVertex(Studenttown[2]));
        StudentGraph.removeVertex(Studenttown[2]);
        assertFalse(StudentGraph.containsVertex(Studenttown[2]));
    }

    @Test
    public void testVertexSet() 
    {
        Set<Town> towns = StudentGraph.vertexSet();
        assertTrue(towns.contains(Studenttown[1]));
        assertFalse(towns.contains(new Town("Studenttown12")));
    }

    	public void testStudentTown3ToStudentTown5() {
    	    String beginTown = "StudentTown_3", endTown = "StudentTown_5";
    	    Town beginIndex = null, endIndex = null;
    	    Set<Town> towns = StudentGraph.vertexSet();
    	    for (Town town : towns) {
    	        if (town.getName().equals(beginTown)) {
    	            beginIndex = town;
    	        }
    	        if (town.getName().equals(endTown)) {
    	            endIndex = town;
    	        }
    	    }
        if (beginIndex != null && endIndex != null) 
        {
            ArrayList<String> path = StudentGraph.shortestPath(beginIndex, endIndex);
            assertNotNull(path);
            assertTrue(path.size() > 0);
            assertEquals("StudentTown_3 via StudentRoadD to StudentTown_5 1 mi",path.get(0).trim());
        }
        else 
        {
            fail("Town names are not valid");
        }
    }
}