import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface 
{

	private Graph graph = new Graph();

	public boolean addRoad(String town1, String town2, int distance, String roadName)
	{
		return (graph.addEdge(new Town(town1), new Town(town2), distance, roadName) != null);
	}

	public String getRoad(String town1, String town2)
	{
		return graph.getEdge(new Town(town1), new Town(town2)).getName();
	}

	public boolean addTown(String name) 
	{
		return graph.addVertex(new Town(name));
	}

	public Town getTown(String name)
	{
		   for (Town town : graph.vertexSet()) 
		   {
		        if (town.getName().equals(name)) 
		        {
		            return town;
		        }
		    }
		    return null;
		}

	public boolean containsTown(String name) 
	{
		return graph.containsVertex(new Town(name));
	}

	public boolean containsRoadConnection(String town1, String town2) 
	{
		return graph.containsEdge(new Town(town1), new Town(town2));
	}

	public ArrayList<String> allRoads() 
	{
		   ArrayList<String> roads = new ArrayList<>();
		    for (Road road : graph.edgeSet()) 
		    {
		    	roads.add(road.getName());
		    }
		    Collections.sort(roads);
		    return roads;
	}
	

	public boolean deleteRoadConnection(String town1, String town2, String road) 
	{
		return graph.removeEdge(new Town(town1), new Town(town2), 0, road) != null;
	}

	public boolean deleteTown(String name) 
	{
		return graph.removeVertex(new Town(name));
	}

	public ArrayList<String> allTowns() 
	{
		 ArrayList<String> towns = new ArrayList<>();
		    for (Town town : graph.vertexSet()) 
		    {
		    	towns.add(town.getName());
		    }
		    Collections.sort(towns);
		    return towns;
	}

	public ArrayList<String> getPath(String town1, String town2)
	{
		return graph.shortestPath(new Town(town1), new Town(town2));
	}

	public void populateTownGraph(File file) throws FileNotFoundException, IOException 
	{
	  Scanner readinput = new Scanner(file);

	  while (readinput.hasNextLine()) 
	  {
        String line = readinput.nextLine();
        String[] parts = line.split("[,;]");

        if (parts.length >= 4) 
        {
            String roadName = parts[0];
            int distance = Integer.parseInt(parts[1]);
            Town town1 = new Town(parts[2]);
            Town town2 = new Town(parts[3]);

            graph.addVertex(town1);
            graph.addVertex(town2);
            graph.addEdge(town1, town2, distance, roadName);
        }
    }

	  readinput.close();
}
}