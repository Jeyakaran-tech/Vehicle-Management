import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageHiring implements Serializable
{
	static ArrayList<Customer> cust = new ArrayList<Customer>();   //creating the array list for Customer
	static ArrayList<Vehicle> vehs = new ArrayList<Vehicle>();   //creating the array list for Customer
	static Vehicle vehicle ;
	static Customer customer;
	
	public static ArrayList<Vehicle> getVehicleList()
	{
		return vehs;
	}
	
	public static ArrayList<Customer> getCustomerList()
	{
		return cust;
	}
	
	public static  void setCustomerList(ArrayList<Customer> customerlist) 
	{
		ManageHiring.cust = customerlist;
	}
	
	public static  void setVehicleList(ArrayList<Vehicle> vehiclelist) 
	{
		ManageHiring.vehs = vehiclelist;
	}
	
	public static int getVehicleID ()          
	{
		Scanner scan = new Scanner (System.in);

		String VehiID;
		System.out.println("Enter Vehicle ID");
		VehiID = scan.nextLine();           //getting the vehicle ID
		for(int i=0;i<vehs.size();i++)
		{
			if(vehs.get(i).getID().equals(VehiID))
			{
				return i;
			}
		}
		return -1;
	}
	
	public static int getCustomerID ()
	{
		Scanner scan = new Scanner (System.in);

		String CustID;
		System.out.println("Enter Customer ID");     //getting the customer ID
		CustID = scan.nextLine();
		for(int i=0;i<cust.size();i++)
		{
			if(cust.get(i).getcusID().equals(CustID))
			{
				return i;
			}
		}
		return -1;
	}

	public static void main (String args[])  throws StatusException, OdometerException, ClassNotFoundException, IOException
	{
		Scanner scan = new Scanner (System.in);  //Scanner class declaration
		int choice;
		int k,l;

		do 
		{
			System.out.println();
			System.out.println("1 Reading a vehicle from a file");              
			System.out.println("2 Reading a customer from a file");              
			System.out.println("3 Add new Vehicle");              
			System.out.println("4 Add new Customer");
			System.out.println("5 Display the vehicle in the required range");
			System.out.println("6 Hire a vehicle");
			System.out.println("7 Complete a hire");
			System.out.println("8 Send the vehicle from service");
			System.out.println("9 Receive the vehicle from service");
			System.out.println("10 Display all the vehicles");
			System.out.println("11 Choose to advance the time");
			System.out.println("12 Exit");
			
			choice = scan.nextInt();
			switch(choice)
			{
				case 1 : if(FileReadWrite.readVehicleFromFile("Vehicle.txt"))   //Checking the file was there or not
						{
							if(vehs.isEmpty())     //checking the file is empty or not
							{
								System.out.println("No vehicles found");
							
							}
							else 
							{
								for(int i=0;i<vehs.size();i++)
								{
									vehs.get(i).print();
								
								}
							}
						}
						else
						{
							System.out.println("No file was found");
						}
						break;
						
				case 2 : if(FileReadWrite.readCustomersfromFile("Customers.txt"))   //Checking the file was there or not
						 {
							if(cust.isEmpty())   //checking the file is empty or not
							{
								System.out.println("No Customers found");
							}
							else 
							{
								for(int i=0;i<cust.size();i++)
								{
									cust.get(i).print();
								}
							}
						 }
						 else
						 {
							 System.out.println("No file was found");
						 }
							break;
							
				case 3:	add_vehicle();
				         break;
				case 4 : add_Customer();
				         break;
				case 5 : daily_rate_check(vehs);
				         break;
				         
				case 6 : 	if(FileReadWrite.readVehicleFromFile("Vehicle.txt"))  
							{
								if(vehs.isEmpty())
								{
									System.out.println("No vehicles found");
								    break;
								}
								
							}
							
							else
							{
								System.out.println("No file was found");
								break;
							}
				
				
							
							if(FileReadWrite.readCustomersfromFile("Customers.txt"))  
							{
								if(cust.isEmpty())
								{
									System.out.println("No Customers found");
									break;
								}
								
							}
							else
							{
								System.out.println("No file was found");
								break;
							}
						
						k=getVehicleID();
						l=getCustomerID();

						if(k == -1)
						{
							System.out.println("No matching vehicles found");
						    break;
						}
						
						else if(l == -1)
						{
							System.out.println("No matching customers found");
						    break;
						}
						
						else
						{
							int i;
							boolean s = true;
							for( i =0;i<vehs.size();i++)
							{
								if(cust.get(l).getcusID().equals(vehs.get(i).getHirer()))
								{
									if(cust.get(l) instanceof CorporateCustomer && vehs.get(i).getstatus().equals("H"))
									{
										System.out.println("Vehicle already hired!!!");
										s = false;
										break;
									}
									else if(cust.get(l) instanceof ICustomer )
									{
										System.out.println("Cannot hire more than one vehicle!!!");
										s = false;
										break;

									}
									else if(vehs.get(i).getstatus().equals("H"))
									{
										s = false;
										break;
									}
								}
							}
							try 
							{
							if(s == true)
								vehs.get(k).hire(cust.get(l).getcusID());
								FileReadWrite.writeVehiclesToFile("vehicle.txt", vehs);
							}
							catch(Exception e)
        	                {
        	                	System.out.println("Exception occured: " +e);
        	                }
						}
						break;
						
				case 7: if(FileReadWrite.readVehicleFromFile("Vehicle.txt"))  
				{
					if(vehs.isEmpty())
					{
						System.out.println("No vehicles found");
					    break;
					}
					
				}
				
				else
				{
					System.out.println("No file was found");
					break;
				}
	
	
				
				if(FileReadWrite.readCustomersfromFile("Customers.txt"))  
				{
					if(vehs.isEmpty())
					{
						System.out.println("No Customers found");
						break;
					}
					
				}
				else
				{
					System.out.println("No file was found");
					break;
				}
				
							k=getVehicleID();
							l=getCustomerID();

						if(k == -1)
							System.out.println("No matching vehicles found");
				
						else if(l == -1)
							System.out.println("No matching customers found");
				
						else
						{
							System.out.println("Enter the odometer reading");
							int odo = scan.nextInt();
							double charges = vehs.get(k).hireComplete(odo);
							
							try {
							if(charges > -1)
							{
								System.out.println("The vehicle got returned");
								System.out.println("The charges are "+cust.get(l).getDiscount(charges));
								FileReadWrite.writeVehiclesToFile("vehicle.txt", vehs);
							}
							}
							catch(Exception e)
							{
        	                	System.out.println("Exception occured: " +e);

							}
							

						}
						break;
						
				case 8: if(FileReadWrite.readVehicleFromFile("Vehicle.txt"))  
						{
							if(vehs.isEmpty())
							{
								System.out.println("No vehicles found");
								break;
							}
							
						}
				
						else
						{
							System.out.println("No file was found");
							break;
						}
				
						k=getVehicleID();
						
						try {
						if(k != -1)
						{
							vehs.get(k).service();
							FileReadWrite.writeVehiclesToFile("vehicle.txt", vehs);
						}
						}
						catch(Exception e)
						{
    	                	System.out.println("Exception occured: " +e);
						}
						
						break;
						
				case 9: if(FileReadWrite.readVehicleFromFile("Vehicle.txt"))  
						{
							if(vehs.isEmpty())
							{
								System.out.println("No vehicles found");
								break;
							}
							
						}
		
						else
						{
							System.out.println("No file was found");
							break;
						}
		
						k=getVehicleID();
				
						try {
						if(k != -1)
						{
							System.out.println("Enter odometer reading:");
							int odo = scan.nextInt();
							vehs.get(k).serviceComplete(odo);
							FileReadWrite.writeVehiclesToFile("vehicle.txt", vehs);
						}
						}
						catch(Exception e)
						{
    	                	System.out.println("Exception occured: " +e);

						}
						
						break;
						
				case 10 : if(FileReadWrite.readVehicleFromFile("Vehicle.txt"))  
						  {
					 			if(vehs.isEmpty())
					 			{
					 				System.out.println("No vehicles found");
					 				break;
					 			}		
					 			else
					 			{
					 				for(int i = 0; i<vehs.size(); i++)
					 					vehs.get(i).print();
					 			}
						  }
						  else
						  {
							  System.out.println("No file was found");
							  break;
						  }
						break;
				case 11 : System.out.println("Enter the number of days to advance: ");
			              int days = scan.nextInt();
			              DateTime.setAdvance(days, 0, 0);
				case 12 : break;

			}
			
		
		}while(choice != 12 );
	}
	public static void add_vehicle () throws IOException 
	{
		String veh_id;
		String veh_type;
		String description;
		double daily_rate;
		int mile_allow;
		int service_length;
		int last_odo;
		int odometer;
		char resp;
	
		Scanner scan = new Scanner(System.in);
     

		
		int flag =0;
		do
		{
			System.out.println("Enter the Vehicle type to be added:(Vehicle/Premium) ");
			veh_type = scan.nextLine();
			
			if(veh_type.equals("Vehicle") || veh_type.equals("Premium"))
				flag = 1;
			else
			{
				flag = 0;
				System.out.println("Only (Vehicle or Premium) is allowed");
			}
		}while(flag == 0);
		
		int value = 0;
		do 
		{
		System.out.println("Enter the Vehicle ID to be added: ");
		veh_id = scan.nextLine();
		
		if(veh_id.length() != 6)
		{
			System.out.println("Check the length(6)");
			value = 1;
		}
		
		else
		{
			if(!vehs.isEmpty())
			{
				for(int i=0;i<vehs.size();i++)
				{
					if(vehs.get(i).getID().equalsIgnoreCase(veh_id))
					{
						System.out.println("Vehicle ID already exists......");
						value = 1;
						break;
					}
				}
			}
			else
			{
				value =0;
			}
		}
		}while(value == 1);

		System.out.println("Enter the Vehicle description to be added: ");
		description = scan.nextLine();
		System.out.println("Enter the daily rate of the Vehicle to be added: ");
		daily_rate = scan.nextDouble();
		System.out.println("Enter the odometer of the Vehicle to be added: ");
		odometer = scan.nextInt();
		
		if(veh_type.equals("Vehicle"))
		{
			vehicle = new Vehicle(veh_id,description,daily_rate,odometer);
			vehs.add(vehicle);
		}
		
		else 
		{
			System.out.println("Enter the mileage allowance: ");
			mile_allow = scan.nextInt();
			System.out.println("Enter the service length of the Vehicle to be added: ");
			service_length = scan.nextInt();
			System.out.println("Enter the odometer of the Vehicle to be added: ");
			last_odo = scan.nextInt();
			
			vehicle = new PremiumVehicle(veh_id,description,daily_rate,odometer,mile_allow,service_length,last_odo);
			vehs.add(vehicle);
        }
		FileReadWrite.writeVehiclesToFile("Vehicle.txt", vehs);

	}
	
	
	public static void add_Customer () throws IOException         //method for adding the customer
	{
		String cus_type;
		String cus_name;
		String cus_ID;
		int mileage;
		String phone;
		int rate;
		
		Scanner scan = new Scanner(System.in);
		

       
       //getting the customer type 
		int flag =0;
		do
		{
			System.out.println("Enter the Customer type to be added:(Individual/Corporate) ");
			cus_type = scan.nextLine();
			
			if(cus_type.equals("Individual") || cus_type.equals("Corporate"))
				flag = 1;
			else
			{
				flag = 0;
				System.out.println("Enter the correct option :) ");
			}
		}while(flag == 0);
		
		
		//getting the customer ID
		int value = 0;
		do 
		{
		System.out.println("Enter the Customer ID: ");
		cus_ID = scan.nextLine();
		
		if(cus_ID.length() != 6  || (cus_ID.charAt(0) != 'C' && cus_ID.charAt(0) != 'c'))
		{
			System.out.println("Invalid value. Check your length(6) and beginning letter should be C or c");
			value = 1;
		}
		
		else
		{
			if(!cust.isEmpty())
			{
				for(int i=0;i<cust.size();i++)
				{
					if(cust.get(i).getcusID().equalsIgnoreCase(cus_ID))
					{
						System.out.println("Customer ID already exists.......");
						value = 1;
						break;
					}
				}
			}
			else
			{
				value =0;
			}
		}
		}while(value == 1);
		
		System.out.println("Enter the customer name: ");
		cus_name = scan.nextLine();
		
		System.out.println("Enter the Phone number: ");
		phone = scan.nextLine();
		
		if(cus_type.equals("Individual"))
		{
			System.out.println("Enter the Customer mileage: ");
			mileage = scan.nextInt();
			
			customer = new ICustomer(cus_ID,cus_name,phone,mileage);
			cust.add(customer);
		}
		
		else 
		{
			System.out.println("Enter the rate: ");
			rate = scan.nextInt();
			
			customer = new CorporateCustomer(cus_ID,cus_name,phone,rate);
			cust.add(customer);
        }
FileReadWrite.writeCustomersToFile("Customers.txt", cust);
	}

	public static void daily_rate_check(ArrayList<Vehicle> vehs) 
	{
		Scanner scan = new Scanner (System.in);
		double lowest,highest;
		int count =0;
		
		System.out.println("Enter the lowest price range: ");
		lowest = scan.nextDouble();
		
		System.out.println("Enter the highest price range: ");
		highest = scan.nextDouble();

		if(vehs.isEmpty())
		{
			System.out.println("No vehicle is added. Please add the vehicle first");
		}
		
		
		for(int i=0; i<vehs.size();i++)
		{
			if(vehs.get(i).getdaily_rate() >= lowest && vehs.get(i).getdaily_rate() <= highest)
			{
				System.out.println("Vehicle ID: "+vehs.get(i).getID()+"\t"+
									"Description: "+vehs.get(i).getdescription()+"\t"+
									"Daily Rate: "+vehs.get(i).getdaily_rate());
			}
			else
			{
				count++;
			}
		}
		
		if(count == vehs.size())
			System.out.println("Sorry!!! No vehicles are available in the price range");

	}

}
	