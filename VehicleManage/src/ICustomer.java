
public class ICustomer extends Customer{
	private int Cusmileage;

	public ICustomer(String ID,String name,String phone, int Cusmileage)      // accessors for ICustomer class
	{
		super(ID,name,phone);
		this.Cusmileage = Cusmileage;
	}
	
	public void setcusmileage(int Cusmileage)
	{
		this.Cusmileage = Cusmileage;
	}
	
	public int getcusmileage()
	{
		return Cusmileage;
	}
	
	
	
	public double getDiscount(double tot_charge)            //definition for get discount 
	{
		double discount = 0.0;
		if(this.Cusmileage > 100000 && this.Cusmileage <= 200000)
		{
			discount = tot_charge * 0.1;
		}
		else if(this.Cusmileage > 200000)
		{
			discount = tot_charge * 0.2;
		}
		discount = tot_charge - discount;
		return discount;
	
	}
	
	public void print()
	{
		System.out.println();
		super.print();
		System.out.println("Mileage :" +this.getcusmileage());
	}

	
}
