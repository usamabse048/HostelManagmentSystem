import java.util.*;
import java.io.*;

public class RW
{
	public static  void writeData(ArrayList a1,String fn) throws Exception
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fn));
			for(int i = 0;i<a1.size();i++)
			{
				oos.writeObject(a1.get(i));
			}
			oos.close();
			
		}
		finally
		{
			
		}
		
		
		
	}
	public static ArrayList readData(String fn) throws Exception
	{
		ArrayList a1 = new ArrayList();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fn));
		boolean EOF = false;
		
			while(EOF != true)
			{
				try
				{
					a1.add(ois.readObject());
				}
				catch(EOFException ee)
				{
					EOF = true;
				}
				
			}
			ois.close();
			
			return a1;
		
	}

}
