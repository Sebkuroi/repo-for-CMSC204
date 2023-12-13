public class Road implements Comparable<Road> 
{
	private Town source, destination;
	private int weight;
	private String name;

	Road(Town source, Town destination, int weight, String name) 
	{
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.name = name;
	}
	
	Road(Town source, Town destination, String name) 
	{
		this.source = source;
		this.destination = destination;
		this.weight = 1;
		this.name = name;
	}

	public int compareTo(Road road)
	{
		return this.name.compareTo(road.name);
	}

	public boolean contains(Town town)
	{
		return source.getName().equals(town.getName()) || destination.getName().equals(town.getName());
	}

	public boolean equals(Object obj)
	{
		Road road = (Road) obj;
		return (this.source.equals(road.source) && this.destination.equals(road.destination))|| (this.source.equals(road.destination) && this.destination.equals(road.source));
	}
	public Town getDestination() 
	{
		return destination;
	}
	public String getName()
	{
		return name;
	}
	public Town getSource()
	{
		return source;
	}
	public int getWeight() 
	{
		return weight;
	}

	public String toString() 
	{
		return source.getName() + " via " + name + " to " + destination.getName() + " " + weight+ " mi";
	}
}