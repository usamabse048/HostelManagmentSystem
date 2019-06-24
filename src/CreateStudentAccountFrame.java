import javax.swing.*;


import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.lang.Object;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateStudentAccountFrame extends JFrame
{
	ArrayList<Student> std1 =  new ArrayList();
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JPasswordField p1;
	JButton b1,b2;
	
	public CreateStudentAccountFrame()
	{
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Student Portal");
		setLayout(new BorderLayout());   
		setVisible(true);
		
		l1 = new JLabel("Enter Name");
		l2 = new JLabel("Enter CNIC Number");
		l3 = new JLabel("Gender");
		l4 = new JLabel("Enter Address");
		l5 = new JLabel("Enter Contact Number");
		l6 = new JLabel("Enter Age");
		l7 = new JLabel("Enter Roll Num");
		l8 = new JLabel("Enter University");
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
		
		
		t9 =  new JTextField(20);
		p1 = new JPasswordField(20);
		
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
		b1 = new JButton("Submit");
		b1.addActionListener(new SubmitActionListener());
		b2 = new JButton("back");
		b2.addActionListener(new BackActionListener());
		
		JPanel xpanel = new JPanel();
		xpanel.setLayout(new GridLayout(2,1));
		xpanel.add(b1);xpanel.add(b2);
		
		add(xpanel,BorderLayout.SOUTH);
	
		
	}
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
	
	public class SubmitActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			b1.setEnabled(false);
			Student st1 = new Student(t1.getText(),t2.getText(),t3.getText().charAt(0),t4.getText(),t5.getText(),Integer.parseInt(t6.getText()),t7.getText(),t8.getText(),t9.getText(),p1.getText());
			
			try
			{
				std1 =RW.readData("std.ser");
				std1.add(st1);
				System.out.println("Reading complete in StudentcreateAccountFrame");
				RW.writeData(std1, "std.ser");
				System.out.println("writing  complete in createAccountFrame");
				
				
			}
			catch(FileNotFoundException fnfe)
			{
				System.out.println("fileNotFound in createStudentAccountFrame");
				
				std1.add(st1);
				try 
				{
					RW.writeData(std1, "std.ser");
					System.out.println("xx");
				}
				catch(IOException lolo)
				{
					System.out.println("IO Exception student.ser");
				}
				catch (Exception e1) 
				{
					System.out.println("Exception whileWriting student.ser in createStudentAccount Frame");
				}
				
			}
			catch(Exception eee)
			{
				System.out.println("Exception in createStudentAccountFrame while submitting");
			}
			
		}
	}
	
	public class BackActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			b2.setEnabled(false);
			StudentMainFrame af = new StudentMainFrame();
			
			dispose();
		}
		
	}
	

}
