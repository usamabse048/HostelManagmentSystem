import java.io.Serializable;

public class Admin extends Person implements Serializable
{
	private Hostel hostel; 
	private String userName;
	private String password;
	
	
	public Admin()
	{
		
	}
	public Admin(String fn,String cnic,char g,String add,String cn,int age,Hostel hostel1,String un,String pw)
	{
		super(fn,cnic,g,add,cn,age);
		//underHostel action listner mai set karna hai
		this.hostel = hostel1;
		this.userName = un;
		this.password = pw;
	
		
	}
	
	//setters
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	private void setPassword(String password) 
	{
		this.password = password;
	}
	
	@Override
	public void setAddress(String address) 
	{
		super.setAddress(address);
	}
	@Override
	public void setAge(int age)
	{
		super.setAge(age);
	}
	@Override
	public void setCnic(String cnic)
	{
		super.setCnic(cnic);
	}
	@Override
	public void setContactNum(String contactNum)
	{
		super.setContactNum(contactNum);
	}
	@Override
	public void setFirstName(String firstName)
	{
		super.setFirstName(firstName);
	}
	@Override
	public void setGender(char gender)
	{
		super.setGender(gender);
	}
	public void setHostel(Hostel hostel)
	{
		this.hostel = hostel;
	}
	
	//getter
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	 @Override
	public String getAddress() 
	{
		return super.getAddress();
	}
	 @Override
	public int getAge() 
	{
		return super.getAge();
	}
	 @Override
	public String getCnic() 
	{
		return super.getCnic();
	}
	@Override
	public String getContactNum() 
	{
		return super.getContactNum();
	}
	@Override
	public String getFirstName() 
	{
		return super.getFirstName();
	}
	@Override
	public char getGender()
	{
		return super.getGender();
	}
	public Hostel getHostel()
	{
		return hostel;
	}
	
	
	
}
