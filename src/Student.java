import java.io.Serializable;

public class Student extends Person implements Serializable
{
	private String rollNo;
	private String university;
	private String userName;
	private String password;
	private String h;
	
	
	
	 public Student()
	 {
		 super();
	}
	/* public Student(String fn,String cnic,char g,String add,String cn,int age,String rn,String uni)
	 {
		
		 super(fn,cnic,g,add,cn,age); 
		 this.rollNo = rn;
		 this.university = uni;
		 
	}
	*/
	 public Student(String fn,String cnic,char g,String add,String cn,int age,String rn,String uni,String un,String pw,String h)
	 {
		 super(fn,cnic,g,add,cn,age);
		 this.rollNo = rn;
		 this.university = uni;
		 this.userName = un;
		 this.password = pw;
		 this.h = h;
		 
	 }
	 public Student(String fn,String cnic,char g,String add,String cn,int age,String rn,String uni,String un,String pw)
	 {
		 super(fn,cnic,g,add,cn,age);
		 this.rollNo = rn;
		 this.university = uni;
		 this.userName = un;
		 this.password = pw;
		 this.h = "";
		 
	 }
	 
	 
	 //setters
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
	public void setRollNo(String rollNo)
	{
		this.rollNo = rollNo;
	}
	public void setUniversity(String university) 
	{
		this.university = university;
	}
	public void setH(String h) {
		this.h = h;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//getters
	
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
	public String getRollNo() 
	{
		return rollNo;
	}
	public String getUniversity() 
	{
		return university;
	}
	public String getH() {
		return h;
	}
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return userName;
	}

}
