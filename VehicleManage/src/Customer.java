import java.io.Serializable;

public abstract class Customer  implements Serializable
{
	private String ID;                 //instance variable declaration for customer class
	private String name;
	private String phone;
	
	public Customer(String ID,String name,String phone)    //constructor for customer class
	{
		this.ID = ID;
		this.name = name;
		this.phone = phone;
	}
	
	public abstract double getDiscount(double tot_charge);
	
	public String getcusID()             //accessors for instance variables
	{
		return ID;
	}
	
	public void setcusID(String ID)
	{
		this.ID = ID;
	}
	
	public String getcusname()
	{
		return name;
	}
	
	public void setcusname(String name)
	{
		this.name = name;
	}
	
	public String getcusphone()
	{
		return phone;
	}
	
	public void setcusphone(String phone)
	{
		this.phone = phone;
	}
	
	public void print()
	{
		System.out.println("**************** Vehicle Details ****************");
		System.out.print("Customer ID="+this.getcusID());
		System.out.print("\tName="+this.getcusname());
		System.out.print("\tPhone="+this.getcusphone());
		
		
		
	}
	
}
