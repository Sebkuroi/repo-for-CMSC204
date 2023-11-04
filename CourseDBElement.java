/**
* CDE class 
* @author Sebastian Black
*/
public  class CourseDBElement implements Comparable 
{
	private String id, RoomNum, instructorsName;
	private int CRN, credvalue;
	
	public CourseDBElement() 
	{
		this.id = null;
		this.RoomNum= null;
		this.instructorsName = null;
		this.CRN = 0;
		this.credvalue = 0;
	}
	
	public CourseDBElement(String id, int CRN, int credvalue, String RoomNum, String instructorsName) 
	{
		this.id = id;
		this.CRN = CRN;
		this.credvalue = credvalue;
		this.RoomNum = RoomNum;
		this.instructorsName = instructorsName;
	}
	
	
	
	@Override
	public int hashCode()
	{
		return Integer.toString(CRN).hashCode();
	}
	
	@Override
	public int compareTo( CourseDBElement element) 
	{
		if (this.CRN > element.getCRN())
		{
			return 1;
		}
		else if (this.CRN < element.getCRN())
		{
			return -1;
		}
		else return 0;
	}
	
	public String getID() 
	{
		return id;
	}
	public String getRoomNum() 
	{
		return RoomNum;
	}
	public String getinstructorsName() 
	{
		return instructorsName;
	}
	public int getCRN() 
	{
		return CRN;
	}

	public int getcredvalue() 
	{
		return credvalue;
	}

	public void setID(String id)
	{
		this.id = id;
	}
	public void setRoomNum(String RoomNum)
	{
		this.RoomNum = RoomNum;
	}
	public void setinstructorsName(String instructorsName)
	{
		this.instructorsName = instructorsName;
	}
	public void setCRN(int CRN) 
	{
		this.CRN = CRN;
	}

	public void setcredvalue(int credvalue) 
	{
		this.credvalue = credvalue;
	}
	
	public String toString() {
		String CRNretrival="Course:"+id+" CRN:"+CRN+" Credits:"+credvalue+" Instructor:"+instructorsName+" Room:"+RoomNum;
		return CRNretrival;
	}
}