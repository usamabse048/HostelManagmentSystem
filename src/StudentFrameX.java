
import java.awt.BorderLayout;
import java.awt.Color;
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
	
public class StudentFrameX extends JFrame
{
	ArrayList<Admin> axe = new ArrayList();
	ArrayList<Student> existStd = new ArrayList();
	ArrayList<Admin> exist = new ArrayList();
	ArrayList<Student> std = new ArrayList();
	ArrayList<Room> room1 = new ArrayList();
	ArrayList<Room> room2 = new ArrayList();
	
	
	JButton b1,b2,b3;
	JLabel l1,l2,l3;
	
	JTextField t1;
	public StudentFrameX() 
	{
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Student Portal");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		 //  setContentPane(new JLabel(new ImageIcon("back1.jpg")));
		    
		setVisible(true);
		
		try
		{
			axe = RW.readData("myAdmin.ser");
			
			JPanel pl = new JPanel();
			pl.setLayout(new GridLayout(axe.size(),1));
			
			for(int i = 0;i<axe.size();i++)
			{
				JPanel px = new JPanel();
				px.setLayout(new GridLayout(1,2));
				
				l1 = new JLabel("Hostel Name:  "+axe.get(i).getHostel().getName());

				l2 = new JLabel("Romms Avaliable:  "+Boolean.toString(axe.get(i).getHostel().roomAvailable()));
				
			/*	b1 = new JButton("Join Hostel");
				b1.addActionListener(new JoinActionListener());*/
				
				px.add(l1);px.add(l2);
				px.setBorder(BorderFactory.createLineBorder(Color.black));
				//px.add(b1);
				pl.add(px);
			}
			
			JPanel kx = new JPanel();
			kx.setLayout(new BorderLayout());
			
			JPanel lx = new JPanel();
			lx.setLayout(new GridLayout(1,3));
			l3 = new JLabel("Enter Hostel Name:  ");
			t1 = new JTextField(20);
			b1 = new JButton("Join Hostel");
			b1.addActionListener(new JoinActionListener());
			
			lx.add(l3);lx.add(t1);lx.add(b1);
			b2 = new JButton("Logout");
			b2.addActionListener(new LogoutActionListener());
			kx.add(lx,BorderLayout.CENTER);
			
			JPanel pp = new JPanel();
			pp.setLayout(new GridLayout(2,1));
			
			b3 = new JButton("Refresh");
			b3.addActionListener(new RefreshListener());
			pp.add(b3);pp.add(b2);
			kx.add(pp,BorderLayout.SOUTH);
			
			add(kx,BorderLayout.SOUTH);
			
			add(pl,BorderLayout.CENTER);
		}
		
		
		
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File not found frameX");
			JOptionPane.showMessageDialog(null, "NO hostel has been created yet wait...");
			StudentMainFrame smf = new StudentMainFrame();
			dispose();
			
		}
		catch(Exception ed)
		{
			System.out.println("Exception in frameX");
		}
		
		
	}
	
	public class RefreshListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			StudentFrameX sfx = new StudentFrameX();
			dispose();
		}
	}
	
	public class JoinActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			b1.setEnabled(false);
			
			try
			{
				std = RW.readData("std.ser");
				existStd = RW.readData("existStd.ser");
				exist = RW.readData("exist.ser");
				  
				
				if(exist.get(0).getHostel().getName().equals(t1.getText()))
				{
					room2 = exist.get(0).getHostel().getRooms();
					for(int j = 0;j<room2.size();j++)
					{
						if(room2.get(j).getOccupied() == false)
						{
						  //	existStd.get(0).setH(axe.get(i).getHostel().getName());
							
							room2.get(j).setOccupied(true);
							room2.get(j).setS(existStd.get(0));
							break;
						}
					}
					exist.get(0).getHostel().setRooms(room2);
					
				}
				boolean check = true;
				for(int i = 0;i<axe.size();i++)
				{
					if(axe.get(i).getHostel().getName().equals(t1.getText()))
					{
						room1 = axe.get(i).getHostel().getRooms();
						for(int j = 0;j<room1.size();j++)
						{
							if(room1.get(j).getOccupied() == false)
							{
								check = false;
								
								existStd.get(0).setH(axe.get(i).getHostel().getName());
								
								room1.get(j).setOccupied(true);
								room1.get(j).setS(existStd.get(0));
								
								for(int k = 0 ;k<std.size();k++)
								{
									if(std.get(k).getFirstName().equals(existStd.get(0).getFirstName()))
									{
										System.out.println(axe.get(i).getHostel().getName());
										
										std.set(k, existStd.get(0));
								
										
										j = room1.size()+1;
										i = axe.size()+1;
										break;
									}
									
								}
								
								//break;
							}
							//break;
						}
					}
				}
				if(check)
				{
					JOptionPane.showMessageDialog(null, "Room not availabel");
				}
				else
				{
					RW.writeData(axe, "myAdmin.ser");
					RW.writeData(exist, "exist.ser");
					RW.writeData(existStd, "existStd.ser");
					RW.writeData(std, "std.ser");
					StudentFrame sf = new StudentFrame();
					dispose();
				}
				
				
				
			}
			catch(FileNotFoundException fnfe)
			{
				System.out.println("xf");
			}
			catch(Exception eds)
			{
				System.out.println("xExcep");
			}
			
			
		}
		
	}
	public class RefreshActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			StudentFrameX sfx = new StudentFrameX();
			dispose();
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
