import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.lang.Object;
import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateAccountFrame extends JFrame
{
	
	ArrayList<Admin> ad1 =  new ArrayList();
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JPasswordField p1;
	JButton b1,b2;
	
	
	
	public CreateAccountFrame() 
	{
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Admin Portal");
		setLayout(new BorderLayout());   
		setVisible(true);
		
		l1 = new JLabel("Enter Name");
		l2 = new JLabel("Enter CNIC Number");
		l3 = new JLabel("Gender");
		l4 = new JLabel("Enter Address");
		l5 = new JLabel("Enter Contact Number");
		l6 = new JLabel("Enter Age");
		l7 = new JLabel("Enter Hostel Name");
		l8 = new JLabel("Enter Number of Rooms");
		l9 =  new JLabel("Set User Name");
		l10 = new JLabel("Set Password");
		
		TextFieldListener tfl = new TextFieldListener();
		
		
		t1 = new  JTextField(20);
		t2 = new  JTextField(20);
		t2.addKeyListener(tfl);
		
		t3 = new  JTextField(20);
		t4 = new  JTextField(20);
		t5 = new  JTextField(20);
		t5.addKeyListener(tfl);
		
		t6 = new  JTextField(20);
		t6.addKeyListener(tfl);
		
		t7 = new  JTextField(20);
		
		t8 = new  JTextField(20);
		t8.addKeyListener(tfl);
		
		t9 =  new JTextField(20);
		p1 = new JPasswordField(20);
		
		
		b1 = new JButton("Submit");
		SubmitActionListener sal = new SubmitActionListener();
		b1.addActionListener(sal);
		
		JPanel inPanel = new JPanel();
		inPanel.setLayout(new GridLayout(10,2));
		inPanel.add(l1);inPanel.add(t1);
		inPanel.add(l2);inPanel.add(t2);
		inPanel.add(l3);inPanel.add(t3);
		inPanel.add(l4);inPanel.add(t4);
		inPanel.add(l5);inPanel.add(t5);
		inPanel.add(l6);inPanel.add(t6);
		inPanel.add(l7);inPanel.add(t7);
		inPanel.add(l8);inPanel.add(t8);
		inPanel.add(l9);inPanel.add(t9);
		inPanel.add(l10);inPanel.add(p1);
		
		add(inPanel,BorderLayout.CENTER);
		b2 = new JButton("back");
		BackActionListener bal = new BackActionListener();
		b2.addActionListener(bal);
		JPanel lpanel = new JPanel(new GridLayout(2,1));
		lpanel.add(b1);lpanel.add(b2);
		add(lpanel,BorderLayout.SOUTH);
		
		
		
		
		
		
		
	}
	
	//TextFieldListener
	public class TextFieldListener extends KeyAdapter
	{
	
			
	/*	public void keyTyped(KeyEvent e) 
		{
			char c = e.getKeyChar();
			System.out.println(c);
			
		}
		*/
		
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
			     if ((  (c < '0') || (c > '9') ) &&(c != KeyEvent.VK_PERIOD)&& (c != KeyEvent.VK_BACK_SPACE))
			     {
			         e.consume();  // ignore event
			     }
			 }
		
	}
	
	//ActionListener
	
	public class SubmitActionListener implements ActionListener
	{
		

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("") || t6.getText().equals("") || t7.getText().equals("") || t8.getText().equals("") || t9.getText().equals("") || p1.getText().equals("") )
			{
				JOptionPane.showMessageDialog(null, "Please Fill Complete Form");
			}
			else
			{
			b1.setEnabled(false);
			Hostel h1 = new Hostel(t7.getText(),Integer.parseInt(t8.getText()));
			Admin a1 = new Admin(t1.getText(),t2.getText(),t3.getText().charAt(0),t4.getText(),t5.getText(),Integer.parseInt(t6.getText()),h1,t9.getText(),p1.getText());
			
			try
			{
				ad1 =RW.readData("myAdmin.ser");
				ad1.add(a1);
				System.out.println("Reading complete in createAccountFrame");
				RW.writeData(ad1, "myAdmin.ser");
				System.out.println("writing  complete in createAccountFrame");
				
				
			}
			catch(FileNotFoundException fnfe)
			{
				System.out.println("fileNotFound in createAccountFrame");
				
				ad1.add(a1);
				try 
				{
					RW.writeData(ad1, "myAdmin.ser");
					System.out.println("xx");
				}
				catch(IOException lolo)
				{
					System.out.println("IO Exception myAdmin");
				}
				catch (Exception e1) 
				{
					System.out.println("Exception whileWriting myAdmin.ser in createAccount Frame");
				}
				
			}
			catch(Exception eee)
			{
				System.out.println("Exception in createAccountFrame while submitting");
			}
			
			
		}
		}		
		
	}
	public class BackActionListener implements ActionListener
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
