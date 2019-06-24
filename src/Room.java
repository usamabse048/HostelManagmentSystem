import java.io.Serializable;

public class Room implements Serializable
{
	private Student s;
	private boolean occupied = false;
	public Room()
	{
		
	}
	public Room (Student s1)
	{
		this.occupied = true;
		this.s = s1;
		
	}
	
	//getter
	public Student getS()
	{
		return s;
	}
	public boolean getOccupied()
	{
		return occupied;
	}
	
	//Setter
	public void setOccupied(boolean occupied) 
	{
		this.occupied = occupied;
	}
	public void setS(Student s) {
		this.s = s;
		this.occupied = true;
	}

	public void removeStudent()
	{
		this.s = null;
		this.occupied = false;
	}
}
