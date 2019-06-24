import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Object;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class ShowStudentFrame extends JFrame
{
	ArrayList<Admin> exist1 = new ArrayList();
	
	//JLabel l1,l2,l3,l4;
	JButton b1;
	
	public ShowStudentFrame() 
	{
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Admin Portal");
		setLayout(new BorderLayout());   
		setVisible(true);
		
		try
		{
			
			exist1 = RW.readData("exist.ser");
			JPanel opanel = new JPanel();
			int l = exist1.get(0).getHostel().getRooms().size();
			opanel.setLayout(new GridLayout(l,1));
			
			
			for(int i = 0;i<exist1.get(0).getHostel().getRooms().size();i++)
			{
				if(exist1.get(0).getHostel().getRooms().get(i).getOccupied() == false)
				{
					
				}
				else
				{
					JLabel l1 = new JLabel("Name:  "+exist1.get(0).getHostel().getRooms().get(i).getS().getFirstName());
					JLabel l2 = new JLabel("RollNo:  "+exist1.get(0).getHostel().getRooms().get(i).getS().getRollNo());
					JLabel l3 = new JLabel("Address:  "+ exist1.get(0).getHostel().getRooms().get(i).getS().getAddress());
					JLabel l4 = new JLabel("Hostel:  "+ exist1.get(0).getHostel().getRooms().get(i).getS().getH());
					
					JPanel innpanel = new JPanel();
					innpanel.setLayout(new GridLayout(2,2));
					innpanel.add(l1);innpanel.add(l2);
					innpanel.add(l3);innpanel.add(l4);
					innpanel.setBorder(BorderFactory.createLineBorder(Color.black));
					opanel.add(innpanel);
					//break;
					
					
				}
			}
			add(opanel,BorderLayout.CENTER);
			b1 = new JButton("Back");
			b1.addActionListener(new BackActionListener());
			add(b1,BorderLayout.SOUTH);
		} 
		catch(FileNotFoundException fgf)
		{
			System.out.println("fnf in show student Frame");
		}
		catch(IOException els)
		{
			System.out.println("io in ssf");
		}
		catch (Exception ekk) 
		{
			System.out.println("Exception in show student Frame");
		}
		
	}
	
	public class BackActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			AdminFrame af = new AdminFrame();
			dispose();
		}
		
	}
	
	

}
