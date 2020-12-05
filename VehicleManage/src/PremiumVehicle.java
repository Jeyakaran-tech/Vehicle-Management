import java.io.Serializable;

public class PremiumVehicle extends Vehicle implements Serializable
{
	private int free_mile_allow;
	private int service_length;
	private int last_odometer;
	
	public PremiumVehicle(String VehicleID,String description,double daily_rate,int odometer,int free_mile_allow, int service_length,int last_odometer)  //constructor
	{
		super(VehicleID, description, daily_rate, odometer);
		this.free_mile_allow = free_mile_allow;
		this.service_length = service_length;
		this.last_odometer = last_odometer;
	}
	
	public int getmileageallowance()     // accessors for every instance variable
	{
		return free_mile_allow;
	}
	
	public void setmileageallowance(int free_mile_allow)
	{
		this.free_mile_allow = free_mile_allow;
	}
	
	public int getservicelength()
	{
		return service_length;
	}

	public void setservicelength(int service_length)
	{
		this.service_length = service_length;
	}
	
	public int getlast_odometer()
	{
		return last_odometer;
	}
	
	public void setlast_odometer(int last_odometer)
	{
		this.last_odometer =  last_odometer;
	}
	
	public void serviceComplete(int odo)  throws StatusException, OdometerException   //completing the service
	{
		super.serviceComplete(odo);
	}
	
	public double hireComplete(int odo) throws StatusException, OdometerException     //returning the premium vehicle from hire
	{
		double daily_charge = super.hireComplete(odo);
		DateTime no_of_days = new DateTime();
		double charges = 0.0;
	
		if(daily_charge > -1.0)
		{
			charges = charges + ((odo - getlast_odometer()) - getmileageallowance() * DateTime.diffDays(no_of_days, getHiredatetime())) * 0.01;
			setodometer(odo);
			return charges;
		}
		else
			return -1.0;
	}
	       
	public void hire(String HirerID) throws StatusException        //hiring the premium vehicle
	{
		if(this.getodometer() < (this.service_length + this.last_odometer))
		{
			super.hire(HirerID);		
		}
	}
	
	public void print()  //printing the details
	{
		System.out.println("**************** Vehicle Details ****************");
		System.out.println(DateTime.getCurrentTime());
		System.out.print("Vehicle ID= "+this.getID());
		System.out.print("\tDescription= "+this.getdescription());
		System.out.print("\tStatus= "+this.getstatus());
		System.out.print("\tDaily Rate= "+this.getdaily_rate());
		System.out.println("\tOdometer reading= "+this.getodometer());
		System.out.print("\tMileage allowance= "+this.getmileageallowance());
		System.out.print("\tService Length= "+this.getservicelength());
		System.out.print("\tLast Service= "+this.getlast_odometer());

		if(this.getstatus().equals("H"))
		{
			System.out.println("Hirer="+this.getHirer());
		    System.out.println("Date/Time of hire="+this.getHiredatetime());
		}
		System.out.println();
	}
}
	
