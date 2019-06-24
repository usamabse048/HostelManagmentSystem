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

public class AdminFrame extends JFrame
{
	ArrayList<Admin> exist = new ArrayList();
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JButton b1,b2,b3,b4;
	JButton logout;
	
	
	public AdminFrame() 
	{
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Admin Portal");
		setLayout(new BorderLayout());   
		setVisible(true);
		
		try
		{
			exist=RW.readData("exist.ser");
			System.out.println("qqqqq");
			
			l1 = new JLabel("ADMIN:  "+exist.get(0).getFirstName());
			l2 = new JLabel("ADDRESS:  "+exist.get(0).getAddress());
			l3 = new JLabel("CNIC:   "+exist.get(0).getCnic());
			l4 = new JLabel("GENDER:   "+exist.get(0).getGender());
			l5 = new JLabel("AGE:    "+exist.get(0).getAge());
			l6 = new JLabel("HOSTEL NAME:    "+exist.get(0).getHostel().getName());
			l7 = new JLabel("Total Rooms:    "+exist.get(0).getHostel().getNoOfRooms());
			l8 = new JLabel("ROOMS OCCUPIED:    "+exist.get(0).getHostel().getNoOfOccupiedRooms());
			
			JPanel dPanel = new JPanel();
			dPanel.setLayout(new GridLayout(4,2));
			
			dPanel.add(l1);dPanel.add(l2);
			dPanel.add(l3);dPanel.add(l4);
			dPanel.add(l5);dPanel.add(l6);
			dPanel.add(l7);dPanel.add(l8);
			

			JPanel oPanel = new JPanel();
			oPanel.setLayout(new BorderLayout());
			
			
			JPanel kPanel = new JPanel();
			kPanel.setLayout(new GridLayout(1,3));
			b1 =  new JButton("Add New Student");
			b1.addActionListener(new AddStudentActionListener());
			b2 =  new JButton("Remove Student");
			b2.addActionListener(new RemoveStudentActionListener());
			//b3 =  new JButton("Join Requests");
			
			b4 = new JButton("Student List");
			b4.addActionListener(new ListActionListener());
			
			kPanel.add(b1);kPanel.add(b2);
			kPanel.add(b4);
			
			oPanel.add(kPanel,BorderLayout.CENTER);
			logout = new JButton("LOGOUT");
			LogoutActionListener lal = new LogoutActionListener();
			logout.addActionListener(lal);
			oPanel.add(logout,BorderLayout.SOUTH);
			
			
			add(dPanel,BorderLayout.CENTER);
			add(oPanel,BorderLayout.SOUTH);
			
			
			
			
		}
		catch (FileNotFoundException fnf)
		{
			System.out.println("File Not found in AdminFrame while reading exist");
			
		}
		catch(Exception el)
		{
			System.out.println("Exception in adminFrame");
		}

	}
	
	
	public class ListActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			ShowStudentFrame ssf = new ShowStudentFrame();
			dispose();
		}
		
	}

	public class AddStudentActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			addNewStudentFrame ansf = new addNewStudentFrame();
			dispose();
		}
		
	}
	public class RemoveStudentActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			RemoveStudentFrame rsf = new RemoveStudentFrame();
			dispose();
		}
		
	}
	
	public class LogoutActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			//setVisible(false);
			MainFrame mf = new MainFrame();
			dispose();
			
		}
		
	}
	

}
