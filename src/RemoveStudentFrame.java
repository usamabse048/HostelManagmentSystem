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

public class RemoveStudentFrame extends JFrame
{
	ArrayList<Admin> exist1 = new ArrayList();
	ArrayList<Admin> axe = new ArrayList();
	ArrayList<Room> room1 = new ArrayList();
	ArrayList<Student> std = new ArrayList();
	
	
	JLabel l1;
	JTextField t1;
	JButton b1,b2;
	
	public RemoveStudentFrame() 
	{
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Admin Portal");
		setLayout(new BorderLayout());   
		setVisible(true);
		
		
		l1 = new JLabel("Enter Name to Remove");
		t1 = new JTextField(20);
		
		JPanel lpanel =  new JPanel();
		lpanel.setLayout(new GridLayout(1,2));
		lpanel.add(l1);lpanel.add(t1);
		
		add(lpanel,BorderLayout.CENTER);
		
		b1 = new JButton("Remove");
		b1.addActionListener(new RemoveActionListener());
		
		
		b2 = new JButton("back");
		b2.addActionListener(new BackActionListener());
		
		JPanel opanel = new JPanel();
		opanel.setLayout(new GridLayout(2,1));
		opanel.add(b1);opanel.add(b2);
		
		add(opanel,BorderLayout.SOUTH);
		
		
		
	}
	
	public class RemoveActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				b1.setEnabled(false);
				axe = RW.readData("myAdmin.ser");
				exist1 =  RW.readData("exist.ser");
				std = RW.readData("std.ser");
				boolean check = true;
				
				for(int i = 0;i<std.size();i++)
				{
					if(std.get(i).getH().equals(exist1.get(0).getHostel().getName()))
					{
						std.get(i).setH("");
					}
				}
				
				room1 = exist1.get(0).getHostel().getRooms();
				for(int i = 0;i<room1.size();i++)
				{
					if(room1.get(i).getS() == null)
					{
						
					}
					else if(room1.get(i).getS().getFirstName().equals( t1.getText()))
					{
						room1.get(i).setS(null);
						room1.get(i).setOccupied(false);
						check = false;
						
					}
				}
				exist1.get(0).getHostel().setRooms(room1);
				
				
				for(int i = 0;i<axe.size();i++)
				{
					if((axe.get(i).getUserName().equals(exist1.get(0).getUserName())) && (axe.get(i).getPassword().equals(exist1.get(0).getPassword())))
					{
						axe.set(i,exist1.get(0));
						break;
						
					}
				}
				RW.writeData(exist1, "exist.ser");
				RW.writeData(axe,"myAdmin.ser");
				RW.writeData(std, "std.ser");
				if(check)
				{
					JOptionPane.showMessageDialog(null,"Student not found");
				}
				else
				{
					
				}
			
				
			}
			catch(Exception fnfe)
			{
				System.out.println("Exception found in RemoveNewStudentFrame");
				
				
			}
				
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
