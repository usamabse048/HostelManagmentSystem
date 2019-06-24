import java.io.Serializable;
import java.util.ArrayList;

public class Hostel implements Serializable
{
	private String name;
	private ArrayList<Room> rooms;
//	private ArrayList<Chef>  chefs;
	//private ArrayList<Sweeper> sweepers;
	//private Admin admin;
	
	
	public Hostel() 
	{
		
	}
	
	public Hostel(String name,int rooms)
	{
		this.name = name;
		if(rooms>0)
		{
			this.rooms = new ArrayList();
			for(int i = 0;i<rooms;i++)
			{
				this.rooms.add(new Room());
			}
		}
	//	this.sweepers = new ArrayList();
	//	this.chefs = new ArrayList();
		
	}

	//Setters
	/*
	public void setChefs(ArrayList<Chef> chefs) 
	{
		this.chefs = chefs;
	}
	*/
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setRooms(ArrayList<Room> rooms) 
	{
		this.rooms = rooms;
	}
	/*
	public void setSweepers(ArrayList<Sweeper> sweepers)
	{
		this.sweepers = sweepers;
	}
	public void setAdmin(Admin admin)
	{
		this.admin = admin;
	}
	*/
	
	//getters
	public String getName() 
	{
		return name;
	}
	/*
	public ArrayList<Chef> getChefs() 
	{
		return chefs;
	}
	*/
	public ArrayList<Room> getRooms() 
	{
		return rooms;
	}
	/*
	public ArrayList<Sweeper> getSweepers()
	{
		return sweepers;
	}*/
	public int getNoOfRooms()
	{
		return rooms.size();
	}
	
/*	public Admin getAdmin() 
	{
		return admin;
	}
	*/
	//Add Student
	public void addStudent(Student s)
	{
		for(int i = 0;i<this.rooms.size();i++)
		{
			if(this.rooms.get(i).getOccupied() == false)
			{
				this.rooms.get(i).setS(s);
				this.rooms.get(i).setOccupied(true);
				break;
			}
		}
		
	}
	
	//Get No of occupied rooms
	public int getNoOfOccupiedRooms()
	{
		int counter = 0;
		for(int i = 0;i<rooms.size();i++)
		{
			if(this.rooms.get(i).getOccupied() == true)
			{
				
				counter++;
			}
		}
		return counter;
	}
	
	//space available or not
	public boolean roomAvailable()
	{
		if(this.getNoOfOccupiedRooms() == this.rooms.size())
		{
			return false;
		}
		else if(this.getNoOfOccupiedRooms() < this.rooms.size())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public String toString()
	{
		return "Name: "+this.getName()+"     No.of Rooms: "+this.getNoOfRooms();
		
	}
	
}
