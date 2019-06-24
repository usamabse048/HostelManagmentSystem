import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.Object;
import java.awt.Component;
import java.awt.Container;
import java.awt.Window;

import javax.swing.*;
	
public class StudentFrame extends JFrame
{

	ArrayList<Student> existStd = new ArrayList();
	ArrayList<Admin>  axe = new ArrayList();
	ArrayList<Admin> existA = new ArrayList();
	ArrayList<Room> room1 = new ArrayList();
	
	ArrayList<Student> std = new ArrayList();
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JButton b1,b2,b3,b4;
	JButton logout;
	
	public StudentFrame() 
	{
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Student Portal");
		setLayout(new BorderLayout());   
		setVisible(true);
		
		
		try
		{
			existStd=RW.readData("existStd.ser");
			System.out.println("mmmX");
			
			l1 = new JLabel("Name:  "+existStd.get(0).getFirstName());
			l2 = new JLabel("ADDRESS:  "+existStd.get(0).getAddress());
			l3 = new JLabel("CNIC:   "+existStd.get(0).getCnic());
			l4 = new JLabel("GENDER:   "+existStd.get(0).getGender());
			l5 = new JLabel("AGE:    "+existStd.get(0).getAge());
			l6 = new JLabel("HOSTEL NAME:    "+existStd.get(0).getH());
			l7 = new JLabel("University:    "+existStd.get(0).getUniversity());
			l8 = new JLabel("RollNo:    "+existStd.get(0).getRollNo());
			
			JPanel dPanel = new JPanel();
			dPanel.setLayout(new GridLayout(4,2));
			
			dPanel.add(l1);dPanel.add(l2);
			dPanel.add(l3);dPanel.add(l4);
			dPanel.add(l5);dPanel.add(l6);
			dPanel.add(l7);dPanel.add(l8);
			

			JPanel oPanel = new JPanel();
			oPanel.setLayout(new GridLayout(2,1));
			
			b1 = new JButton("Leave Hostel");
			b1.addActionListener(new LeaveActionListener());
			b2 = new JButton("Logout");
			b2.addActionListener(new LogoutActionListener());
			
			
			add(dPanel,BorderLayout.CENTER);
			
			oPanel.add(b1);oPanel.add(b2);
			add(oPanel,BorderLayout.SOUTH);
			
			
			

			
		
	}
		catch(FileNotFoundException fnff)
		{
			System.out.println("fnf in Stuent FrameAction");
		}
		catch(Exception ex)
		{
			System.out.println("Exception in StudentFrameAction");
		}
		finally
		{
			
		}
			
		
		
			
		}
	
	public class LeaveActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
			
			try
			{
				axe = RW.readData("myAdmin.ser");
				existA = RW.readData("exist.ser");
				std = RW.readData("student.ser");
				boolean check = false;
				if(existA.get(0).getHostel().getName().equals(existStd.get(0).getH()))
				{
					check = true;
				}
				
				for(int i = 0;i<std.size();i++)
				{
					if(std.get(i).getH().equals(existStd.get(0).getH()))
					{
						std.get(i).setH("");
						break;
					}
				}
				
				for(int i = 0;i<axe.size();i++)
				{
					if(axe.get(i).getHostel().getName().equals(existStd.get(0).getH()))
					{
						
						room1 = axe.get(i).getHostel().getRooms();
						for(int j = 0;j<room1.size();j++)
						{
							if(room1.get(j).getOccupied() == false)
							{
								
							}
							else if(room1.get(j).getS().getFirstName().equals(existStd.get(0).getFirstName()))
							{
								room1.get(j).setS(null);
								room1.get(j).setOccupied(false);
								break;
							}
						}
						axe.get(i).getHostel().setRooms(room1);
						break;
						
						
								
						
					}
				}
					
					existStd.get(0).setH("");
					
					
					
					
					if(check)
					{
						room1 = existA.get(0).getHostel().getRooms();
						for(int j = 0;j<room1.size();j++)
						{
							if(room1.get(j).getOccupied() == false)
							{
								
							}
							else if(room1.get(j).getS().getFirstName().equals(existStd.get(0).getFirstName()))
							{
								room1.get(j).setS(null);
								room1.get(j).setOccupied(false);
								break;
							}
						}
						existA.get(0).getHostel().setRooms(room1);
						
						RW.writeData(existA, "exist.ser");
						
						
						
					}
					
					RW.writeData(std,"student.ser");
					RW.writeData(axe, "myAdmin.ser");
					RW.writeData(existStd, "existStd.ser");
					StudentFrameX hsf = new StudentFrameX();
					
					
					dispose();
					
						
				
					
				}
				
			
			
			catch(FileNotFoundException fnff)
			{
				System.out.println("fnf in Stuent FrameAction");
			}
			catch(Exception ex)
			{
				System.out.println("Exception in StudentFrameAction");
			}
				
			finally
			{
				
			}

		
			
			
		}
	}
	
	public class LogoutActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			//setVisible(false);
			StudentMainFrame mf = new StudentMainFrame();
			dispose();
			
		}



}
}
