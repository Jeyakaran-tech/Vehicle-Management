import java.io.Serializable;
import java.sql.Date;
import java.util.Scanner; 

class Vehicle implements Serializable
{
	private String HirerID;
	private String VehicleID;
	private String description;
	private String status;
	private double daily_rate; 
	private int odometer;
	
    DateTime dttime = new DateTime();
    
	public Vehicle(String VehicleID,String description,double daily_rate,int odometer)  //constructor for vehicle
	{
		this.VehicleID = VehicleID;
		this.description = description;
		this.daily_rate = daily_rate;
		this.odometer = odometer;
		status = "A";
	}
	
	public String getID()   //accessors for instance variable
	{
		return VehicleID;
	}
	
	public void setID(String VehicleID)
	{
		this.VehicleID = VehicleID;
	}

	public String getHirer()
	{
		return HirerID;
	}
	
	public void setHirer(String HirerID)
	{
		this.HirerID = HirerID;
	}
	
	public String getdescription()
	{
		return description;
	}
	
	public void setdescription(String description)
	{
		this.description = description;
	}

	public String getstatus()
	{
		return status;
	}
	
	public void setstatus(String status)
	{
		this.status = status;
	}

	public double getdaily_rate()
	{
		return daily_rate;
	}
	
	public void setdaily_rate(double daily_rate)
	{
		this.daily_rate = daily_rate;
	}
	
	public int getodometer()
	{
		return odometer;
	}
	
	public void setodometer(int odometer)
	{
		this.odometer = odometer;
	}
	
	public DateTime getHiredatetime()
	{
		return dttime;
	}
	
	public void setHiredatetime(DateTime dttime)
	{
		this.dttime = dttime;
	}
	
	public void hire(String HirerID) throws StatusException     //hire method
	{
		
			if(this.status.equals("H") ||  this.status.equals("S"))   //checking the status if H or S
			{
				throw new StatusException("The vehicle "+this.VehicleID+ " can't be hired");  //throwing the status exception
				
			}
			else
			{
				setHiredatetime(dttime);
				this.HirerID = HirerID;
				this.status = "H";  //setting the status to H indicating that the vehicle is hired
				System.out.println("The vehicle "+this.VehicleID+" hired to "+ HirerID);
			}	
	}
	
	public void service() throws StatusException  //service method
	{
		
			if(this.status.equals("H") ||  this.status.equals("S"))//checking the status if H or S
			{
				throw new StatusException("The vehicle "+this.VehicleID+ " can't be serviced");
			}
			else
			{
				this.status = "S";   //setting the status to S indicating that the vehicle is hired
				System.out.println("The vehicle "+this.VehicleID+" is now sent for service");
			}
	}
	
	public void serviceComplete(int odo) throws StatusException, OdometerException //completing the service
	{
		    if(this.status.equals("S"))   //checking the status if  S
			{
		    	this.status = "A";  //setting the status to A
			}
		    else
		    {
				throw new StatusException("The vehicle can't complete the service");
			}
			
			if(this.odometer < odo)
		    {
		    	this.odometer = odo;
		    }
			else
			{
				throw new OdometerException("The vehicle can't complete the service");
		    }
			System.out.println("The service gets completed for the vehicle" +this.VehicleID);
	}

	public double hireComplete(int odo) throws StatusException, OdometerException  //completing the hire
	{	  
			if(this.status.equals("A") ||  this.status.equals("S"))   //checking the status if A or S
			{
				throw new StatusException("The vehicle can't complete the hire");
			}
			if(this.odometer > odo)
			{
				throw new OdometerException("The vehicle can't complete the hire");
			}
			else
		   {
			this.odometer = odo;
			DateTime daysElapsed = new DateTime();
			this.status = "A";
			return (this.daily_rate*DateTime.diffDays(daysElapsed, dttime));
		   }
	}
	
	public void print()
	{
		System.out.println("**************** Vehicle Details ****************");
		System.out.println(DateTime.getCurrentTime());
		System.out.print("Vehicle ID="+this.getID());
		System.out.print("\tDescription="+this.getdescription());
		System.out.print("\tStatus="+this.getstatus());
		System.out.print("\tDaily Rate="+this.getdaily_rate());
		System.out.println("\tOdometer reading="+this.getodometer());
		
		if(this.status.equals("H"))
		{
			System.out.println("Hirer="+this.getHirer());
		    System.out.println("Date/Time of hire="+this.getHiredatetime());
		}
		System.out.println();
	}
}




