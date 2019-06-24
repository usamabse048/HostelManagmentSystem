import java.io.Serializable;

public class Employee extends Person implements Serializable
{
	private String serviceId;   
	private double salary;
	
	//constructor
	public Employee()
	{
		super();
		
	}
	public Employee(String fn,String cnic,char g,String add,String cn,int age,String serviceId,double salary)
	{
		super(fn,cnic,g,add, cn, age);
		this.serviceId = serviceId;
		this.salary = salary;
	}
	
	//setter
	
	
	public void setSalary(double salary)
	{
		if(salary>=0)
		{
			this.salary = salary;			
		}
	}
	public void setServiceId(String serviceId)
	{
		this.serviceId = serviceId;
	}
	
	
	//getter
	public double getSalary() 
	{
		return salary;
	}
	public String getServiceId()
	{
		return serviceId;
	}
	
	@Override
	public String toString()
	{
		
		return this.getFirstName()+"\n"+this.getAge()+"	"+this.getCnic()+"\n"+this.getContactNum()+"	"+this.getGender();
	}
	

}
