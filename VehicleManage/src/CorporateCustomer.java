
public class CorporateCustomer extends Customer
{
	private int rate;
	
	public CorporateCustomer(String ID,String name,String phone,int rate)
	{
		super(ID,name,phone);
		this.rate = rate;
	}
	
	public int getrate()
	{
		return rate;
	}
	
	public void setrate(int rate)
	{
		this.rate = rate;
	}
	
	public double getDiscount(double tot_charge)      //calculating the discount 
	{
		double discount_made;
		double discount = 0.0;
		discount_made =  tot_charge * (rate/100);
		discount = tot_charge - discount_made;
		return discount;
	}
	
	public void print()
	{
		System.out.println();
		super.print();
		System.out.println("Rate :" +this.getrate());
	}
}
