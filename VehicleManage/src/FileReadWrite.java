import java.io.*;
import java.util.*;

public class FileReadWrite
{
	private static File f;
	public static void writeVehiclesToFile(String fileName, ArrayList<Vehicle> vehsList) throws IOException
	{	
		FileOutputStream file = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(vehsList);
		out.close();
		file.close();
	}

// @SuppressWarnings("unchecked")
	public static boolean readVehicleFromFile(String fileName) throws IOException, ClassNotFoundException
	{
		f = new File(fileName);
		//ArrayList<Vehicle> vehList = new ArrayList<Vehicle>();
		if (f.exists())
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			ManageHiring.setVehicleList((ArrayList<Vehicle>) in.readObject());
			in.close();
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void writeCustomersToFile(String fileName, ArrayList<Customer> custList) throws IOException
	{
		FileOutputStream file = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(custList);
		out.close();
		file.close();
	}

//@SuppressWarnings("unchecked")
	public static boolean readCustomersfromFile(String fileName) throws IOException, ClassNotFoundException 
	{
		f = new File(fileName);
		//ArrayList<Customer> cusList = new ArrayList<Customer>();
		if (f.exists()) 
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			ManageHiring.setCustomerList((ArrayList<Customer>) in.readObject());
			in.close();
			return true;
		} 
		else 
		{
			return false;
		}
}
}