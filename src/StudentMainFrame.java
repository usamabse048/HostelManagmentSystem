
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

public class StudentMainFrame extends JFrame
{
	ArrayList<Student> std1 =  new ArrayList();
	JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	JPasswordField p1;
	JButton b1,b2;
	
	
	public StudentMainFrame() 
	{
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Student Portal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		 //  setContentPane(new JLabel(new ImageIcon("back1.jpg")));
		    
		setVisible(true);
		
		JPanel pll = new JPanel();
		pll.setLayout(new BorderLayout());
		
		l4 = new JLabel("Student Login",JLabel.CENTER);
		l4.setFont(new Font("Tahoma",Font.PLAIN,20));
		
		pll.add(l4,BorderLayout.CENTER);

		
		l1 = new JLabel("Enter User Name: ");
		l2 =  new JLabel("Enter Password: ");
		l3 = new JLabel("Create new Account: ");
		
		t1 = new JTextField(20);
		p1 = new JPasswordField(20);
		
		b1 = new JButton("Enter");
		EnterActionListener eal = new EnterActionListener();
		b1.addActionListener(eal);
		b2 = new JButton("Create Account");
		CreateActionListener cal = new CreateActionListener();
		b2.addActionListener(cal);
		
		JPanel epanel= new JPanel();
		epanel.setLayout(new BorderLayout());
		//creating panel inside epanel
		JPanel inEPanel =  new JPanel();
		inEPanel.setLayout(new GridLayout(2,2,10,10));
		
		//adding compnents to inEPanel
		inEPanel.add(l1);inEPanel.add(t1);
		inEPanel.add(l2);inEPanel.add(p1);
		
		//adding components in epanel
		epanel.add(inEPanel,BorderLayout.CENTER);
		epanel.add(b1,BorderLayout.SOUTH);
		
		JPanel cpanel = new JPanel();
		cpanel.setLayout(new GridLayout(1,2,10,10));
		cpanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//adding compnents in cpanel
		cpanel.add(l3);cpanel.add(b2);
		
		//adding compnents to real panel
		add(epanel,BorderLayout.CENTER);
		add(cpanel,BorderLayout.SOUTH);
		add(pll,BorderLayout.NORTH);
		
	}
	
	public class EnterActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			boolean check = true;
			
		
			try
			{
				std1 = RW.readData("std.ser");
				
				for(int i = 0;i<std1.size();i++)
				{
					if(std1.get(i).getUserName().equals(t1.getText())  && std1.get(i).getPassword().equals(p1.getText()))
					{
						b1.setEnabled(false);
						check = false;
						System.out.println("imposible std");
						ArrayList<Student> existStd = new ArrayList();
						existStd.add(std1.get(i));
						
						try
						{
							RW.writeData(existStd, "existStd.ser"); //For transfering this admin object to adminFrame
							
						}
					
						catch(FileNotFoundException fnf)
						{
							System.out.println("fnf exception while writing existStd");
						}
						catch(IOException ie)
						{
						
							System.out.println("IO  exception while writing existStd");
						}
						catch (Exception ex) 
						{
						
							System.out.println("ex  exception while writing existStd");
						}
						//setVisible(false);
						//**************
						
						System.out.println(existStd.get(0).getH());
						
						if(existStd.get(0).getH().equals(""))
						{
							System.out.println("Hostel Name: "+existStd.get(0).getH());
							//StudentFrame af = new StudentFrame();   //Calling AdminFrame
							
							StudentFrameX sfx = new StudentFrameX();
						}
						else
						{
							StudentFrame af = new StudentFrame();   //Calling AdminFrame
							
							
						}
						
						dispose();
					
						
						break;
					
						
					}
				}
			}
				
			catch(FileNotFoundException fnfe)
			{
				System.out.println("File Not found in enterActionListener of StudentMainFrame");
				JOptionPane.showMessageDialog(null, "UserName/Password does not exist....Create new Account");
				
				
			}
				
			catch(IOException ioe)
			{
				System.out.println("IO exception Std main frame while reading");

			}
			catch(Exception ex)
			{
				System.out.println("lora war gya in StdmainFrame");
				
			}
			
			if(check)
			{
				System.out.println("id/pw doesnt found");
				
				JOptionPane.showMessageDialog(null, "UserName/Password does not exist....Create new Account");
				
			}
		}
	}
	
	public class CreateActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			b2.setEnabled(false);
			
			CreateStudentAccountFrame caf = new CreateStudentAccountFrame();
			dispose();
			
			
		}
	}
	
	

}
