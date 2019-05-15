package classes;

public class Person
{
	private String firstName;
	private String lastName;
	private String cnic;
	private char gender;
	private String address;
	private String contactNum;
	private int age;
	
	//constructor
	public Person()
	{
		
	}
	public Person(String fn,String ln,String cnic,char g,String add,String cn,int age )
	{
		this.firstName = fn;
		this.lastName = ln;
		this.cnic = cnic;
		this.gender = g;
		this.contactNum = cn;
		if(age>=12)
		{
			this.age = age;
		}
		
		this.address = add;
		
	}
	
	//setters
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public void setAge(int age) 
	{
		if(age>=12)
		{
			this.age = age;
		}
		
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public void setCnic(String cnic) 
	{
		this.cnic = cnic;
	}
	public void setContactNum(String contactNum)
	{
		this.contactNum = contactNum;
	}
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	
	//getters
	
	public String getAddress() 
	{
		return address;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public int getAge()
	{
		return age;
	}
	public String getCnic()
	{
		return cnic;
	}
	public String getContactNum() 
	{
		return contactNum;
	}
	public char getGender() 
	{
		return gender;
	}
	
	@Override
	public String toString()
	{
		return this.getFirstName()+" "+this.getLastName()+"\n"+this.getAge()+"	"+this.getCnic()+"\n"+this.getContactNum()+"	"+this.getGender();
	}

}
