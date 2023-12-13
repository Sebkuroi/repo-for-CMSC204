public class Town implements Comparable<Town>
{
	private String name;

	Town(String name)
	{
		this.name = name;
	}

	public int compareTo(Town town) 
	{      
		return this.name.compareTo(town.name);
	}
	
	public boolean equals(Object obj) 
	{
		Town town = (Town) obj;
		return this.name.equals(town.name);
	}

	public String getName() 
	{
		return name;
	}

	public int hashCode() 
	{
		return name.hashCode();
	}

	public String toString() 
	{
		return name;
	}
}