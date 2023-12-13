import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> 
{
	private Set<Town> towns = new HashSet<>();
	private Set<Road> roads = new HashSet<>();
	private ArrayList<String> Path = new ArrayList<>();
	private Town destination;

	public Road getEdge(Town sourceVertex, Town destinationVertex)
	{
	    if (sourceVertex == null || destinationVertex == null) 
	    {
	        return null;
	    }

	    for (Road road : roads) 
	    {
	        if (road.contains(sourceVertex) && road.contains(destinationVertex)) 
	        {
	            return road;
	        }
	    }
	    return null;
	}

	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException, NullPointerException
	{
	    if (sourceVertex == null || destinationVertex == null) 
	    {
	        throw new NullPointerException();
	    }
	    if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex)) 
	    {
	        throw new IllegalArgumentException();
	    }
	    Road road = new Road(sourceVertex, destinationVertex, weight, description);
	    roads.add(road);
	    return road;
	}

	
	public boolean addVertex(Town town) 
	{
	    if (town == null)
	    {
	        throw new NullPointerException();
	    }
	    if (!towns.contains(town)) 
	    {
	        towns.add(town);
	        return true;
	    }
	    return false;
	}

	
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) 
	{
	    for (Road road : roads) 
	    {
			if (road.contains(sourceVertex) && road.contains(destinationVertex))
			{
				return true;
			}
		}
		return false;
	}

	
	public boolean containsVertex(Town town) 
	{
		return towns.contains(town);
	}

	
	public Set<Road> edgeSet()
	{
		 Set<Road> road = new HashSet<>();
		 road.addAll(roads);
		    return road;
	}

	
	public Set<Road> edgesOf(Town town)
	{
		if (town == null) 
		{
	        throw new NullPointerException();
	    }
		
		Set<Road> road = new HashSet<>();
		for (Road Road : roads) 
		{
			if (Road.contains(town)) 
			{
				road.add(Road);
			}
		}
		if (road.isEmpty()) 
		{
	        throw new IllegalArgumentException("");
	    }
		return road;
	}

	
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight,String description) 
	{
		Road road = null;
		for (Road roads : roads) 
		{
			if (roads.contains(destinationVertex) && roads.contains(sourceVertex) && (weight > -1) && description != null) 
			{
				road = roads;
			}
		}
		 if (road != null && roads.remove(road))
		 {
		        return road;
		 }
			return null;
	}

	
	public boolean removeVertex(Town town) 
	{
		return towns.remove(town);
	}

	
	public Set<Town> vertexSet() 
	{
		return towns;
	}

	
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {

		destination = destinationVertex;
		dijkstraShortestPath(sourceVertex);
		
		ArrayList<Road> roadPath = new ArrayList<>();

		boolean Source = false;
		boolean Destination = false;

		for (Road r : roads) {
		    if (r.contains(sourceVertex)) {
		    	Source = true;
		    }
		    if (r.contains(destinationVertex)) {
		    	Destination = true;
		    }
		    if (Source && Destination) 
		    { 
		        break;
		    }
		}

		if (!Source || !Destination) {
		    return new ArrayList<>();
		}

		for (int i = 0; i < Path.size() - 1; i++) {
			Town source = new Town(Path.get(i));
			Town destination = new Town(Path.get(i + 1));
			Road road = getEdge(source, destination);
			roadPath.add(new Road(source, destination, road.getWeight(), road.getName()));
		}

		Path.clear();

		ArrayList<String> PathDescriptions = new ArrayList<>();
		for (Road road : roadPath) {
			PathDescriptions.add(road.toString());
		}
		return PathDescriptions;
	}

	
	public void dijkstraShortestPath(Town sourceVertex) 
	{
		List<Town> Rowsandcolumbs = new ArrayList<>(towns);

		int[][] adjacencyMatrix = new int[towns.size()][towns.size()];
		for (int i = 0; i < towns.size(); i++)
		{
		    for (int j = 0; j < towns.size(); j++) 
		    {
				if (i == j || !containsEdge(Rowsandcolumbs.get(i), Rowsandcolumbs.get(j))) 
				{
					adjacencyMatrix[i][j] = 0;
				}
				else 
				{
					 adjacencyMatrix[i][j] = getEdge(Rowsandcolumbs.get(i), Rowsandcolumbs.get(j)).getWeight();
		        }
			}
		}
		
		int startingTown = 0;
		for (Town town : Rowsandcolumbs) 
		{
		    if (town.equals(sourceVertex)) 
		    {
		        break;
		    }
		    startingTown++;
		}

		int stoppingTown = 0;
		for (Town town : Rowsandcolumbs) 
		{
		    if (town.equals(destination)) 
		    {
		        break;
		    }
		    stoppingTown++;
		}

		int numberofTowns = towns.size();
		int[] shortestdistance = new int[numberofTowns];
		int[] minpath = new int[numberofTowns];
		boolean[] visited = new boolean[numberofTowns];
		for (int i = 0; i < numberofTowns; i++)
		{
			shortestdistance[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		shortestdistance[startingTown] = 0;
		minpath[startingTown] = -1;
		
		for (int i = 1; i < numberofTowns; i++) 
		{
			int nearestTown = -1;
			int minDistance = Integer.MAX_VALUE;
			for (int Index = 0; Index < numberofTowns; Index++) 
			{
				if (!visited[Index] && shortestdistance[Index] < minDistance) 
				{
					nearestTown = Index;
					minDistance = shortestdistance[Index];
				}
			}

			visited[nearestTown] = true;

			for (int Index = 0; Index < numberofTowns; Index++) 
			{
				int Distance = adjacencyMatrix[nearestTown][Index];
				if (Distance > 0 && ((minDistance + Distance) < shortestdistance[Index])) 
				{
					minpath[Index] = nearestTown;
					shortestdistance[Index] = minDistance + Distance;
				}
			}

		}
		
		ShortestPath(stoppingTown, minpath);
	}

	private void ShortestPath(int sourceVertex, int[] minpath) 
	{
		int Index = 0;
		if (sourceVertex == -1) 
		{
			return;
		}

		ShortestPath(minpath[sourceVertex], minpath);

		for (Town town : towns) 
		{
			if (Index == sourceVertex) 
			{
				Path.add(town.getName());
			}
			Index++;
		}
	}
}