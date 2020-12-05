import java.util.Scanner;

public class TestVehicle {
	public static void main(String args[]) throws StatusException, OdometerException    
	{       
		
		String vehs_id;
//		int j;

		Vehicle vehs[] = new Vehicle[6];
		
		Scanner scan = new Scanner(System.in);
		vehs[0] = new Vehicle("QJT123","Starlet 99",35.0,190000);
		vehs[1] = new Vehicle("PTU121","Holden 03",60.0,165000);
		vehs[2] = new Vehicle("OCD856","Camry 04",65.0,230000);
		vehs[3] = new Vehicle("TYR852","Subaru 02",60.0,270000); 
		vehs[4] = new PremiumVehicle("TUX132","BMW 05",90.0,12000,100,10000,5000);
		vehs[5] = new PremiumVehicle("TEY749","Jaguar 06",125.0,27000,120,12000,20000);
		
		System.out.println("Choose any one vehicle from the below");
		for(int i=0;i<5;i++)
		{
			System.out.println("Vehicle ID: "+vehs[i].getID());
			System.out.println("Description: "+vehs[i].getdescription());
		}
		char resp;
		do
		{
//		System.out.println("Enter the lowest price range: ");
//		int lowest_price = scan.nextInt();
//		System.out.println("Enter the Highest price range: ");
//		int highest_price = scan.nextInt();

//		int cnt = 0;
//		for(int i=0;i<6;i++)
//		{
//			if(lowest_price <= vehs[i].getdaily_rate() && highest_price >= vehs[i].getdaily_rate())
//			{
//				System.out.println("Vehicle ID: "+vehs[i].getID()+"\t"+
//				"Description: "+vehs[i].getdescription()+"\t"+
//				"Daily Rate: "+vehs[i].getdaily_rate());
//			}
//			else
//			{
//				cnt++;
//			}
//		}
//		
//		if(cnt == 5)
//			System.out.println("No vehicles are found in the given price range");
//		
//		System.out.print("Vehicle ID: ");
//		scan.nextLine();
//		String veh_id = scan.nextLine();
		
//		for(j=0;j<6;j++)
//		{
//			if(veh_id.compareTo(vehs[j].getID()) == 0)
//			{
//				break;
//			}
//		}
//		
//		if(j == 5)
//			System.out.println("No such ID");
		
		    System.out.println();
		    
			System.out.println("Display Available cars 1");              
			System.out.println("Hire Vehicle 2");
			System.out.println("Complete hire 3");
			System.out.println("Service Vehicle 4");
			System.out.println("Complete Service 5");
			System.out.println("Exit 6");

            int choice = scan.nextInt();
            
            switch(choice)
            {
                case 1: for(int i=0;i<vehs.length;i++)
                		{
                	     	vehs[i].print();
                		}
            	        break;
                case 2: System.out.println("Enter the Vehicle ID");
                		scan.nextLine();
    	                vehs_id = scan.nextLine();
    	                
    	                int j;
    	                
    	                for(j=0;j<vehs.length;j++)
    	        		{
    	        			if(vehs[j].getID().compareTo(vehs_id) == 0)
    	        			{
    	        				break;
    	        			}
    	        		}	
    	                if(j == 6)
    	                {
    	                	System.out.println("Not Available");
    	                	break;
    	                }
    	                	System.out.println("Enter hirer ID: ");
        	                String ID_hire = scan.nextLine();
        	                
        	                try {
        	                	vehs[j].hire(ID_hire);
        	                }
        	                catch(Exception e)
        	                {
        	                	System.out.println("Exception occured: " +e);
        	                }
   
    	        	  break;
    	        case 3: System.out.println("Enter the Vehicle ID");
                		scan.nextLine();
                		vehs_id = scan.nextLine();
                		
                		int m;
                		for(m=0;m<6;m++)
    	        		{
    	        			if(vehs[m].getID().compareTo(vehs_id) == 0)
    	        			{
    	        				break;
    	        			}
    	        		}	
    	                if(m == 6)
    	                {
    	                	System.out.println("Not Available");
    	                	break;
    	                }
    	                
    	               System.out.println("Enter Odometer reading: ");
     	        	   int odo = scan.nextInt();
     	        	   double val = vehs[m].hireComplete(odo);
     	        	   if ( val > 0.0 )       
     	        	   {          
     	        			System.out.print("\nCar " + vehs_id + " is returned by " + vehs[m].getHirer());             
     	        			System.out.println(" Charges = " + val + " odo Reading = " + odo);         
     	        	   }       
     	        	   else          
     	        			System.out.println("\nWARNING: Car " + vehs_id+ " could not be returned from hire ");  
     	        					
     	        	   break;
     	        				
     	        case 4: System.out.println("Enter the Vehicle ID");
        				scan.nextLine();
        				vehs_id = scan.nextLine();
            		
        				
        				int k;
                		for(k=0;k<6;k++)
    	        		{
    	        			if(vehs[k].getID().compareTo(vehs_id) == 0)
    	        			{
    	        				break;
    	        			}
    	        		}	
    	                if(k == 6)
    	                {
    	                	System.out.println("Not Available");
    	                	break;
    	                }
    	                
    	                try 
    	                {
    	                	vehs[k].service();
    	                }
    	                catch(Exception e)
    	                {
    	                	System.out.println("Exception occured: " +e);
    	                }
     	        			
     	        			
     	        		
            	break;
            	
            	case 5: System.out.println("Enter the Vehicle ID");
						scan.nextLine();
						vehs_id = scan.nextLine();
    		
						int l;
                		for(l=0;l<6;l++)
    	        		{
    	        			if(vehs[l].getID().compareTo(vehs_id) == 0)
    	        			{
    	        				break;
    	        			}
    	        		}	
    	                if(l == 6)
    	                {
    	                	System.out.println("Not Available");
    	                	break;
    	                }
						
						System.out.println("Enter Odometer reading: ");
						int odometer = scan.nextInt();
						try{
						vehs[l].serviceComplete(odometer) ;
						}
						catch(Exception e)
						 {
    	                	System.out.println("Exception occured: " +e);
    	                }
							break;
						
            	case 6 : break;
            }

            System.out.println("Any more transactions? ");
            resp = scan.next().charAt(0);
		}while(resp != 'n' && resp != 'N' );
		
		
		for(int i=0;i<6;i++)
		{
			vehs[i].print();
		}
	}		
}
