package veiw;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import bLogic.PersonDM;

public class DDialog extends JDialog 
{
	PersonDM dPersonDM = PersonDM.getInstance();
	public JTextField txtId, txtFName, txtSName, txtAge;
	
	private boolean result = false;

	public DDialog()
	{
		JLabel lId, lFName, lSName, lAge;
		
		setLayout(null);
		setBounds(300, 200, 250, 260);
		
		lId = new JLabel("ID:");
		lFName = new JLabel("First Name:");
		lSName = new JLabel("Second Name:");
		lAge = new JLabel("Age:");

		txtId = new JTextField();
		txtFName = new JTextField();
		txtSName = new JTextField();
		txtAge = new JTextField();
		
		lId.setBounds(10, 10, 100, 20);
		lFName.setBounds(10, 50, 100, 20);
		lSName.setBounds(10, 90, 100, 20);
		lAge.setBounds(10, 130, 100, 20);

		txtId.setBounds(120, 10, 100, 25);
		txtFName.setBounds(120, 50, 100, 25);
		txtSName.setBounds(120, 90, 100, 25);
		txtAge.setBounds(120, 130, 100, 25);
		
		add(lId);
		add(lFName);
		add(lSName);
		add(lAge);
		
		add(txtId);
		add(txtFName);
		add(txtSName);
		add(txtAge);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(30, 180, 70, 30);
//		btnOk.addActionListener(dPersonDM.aDialogOk);
		add(btnOk);
		JButton btnCan = new JButton("Cancel");
		btnCan.setBounds(120, 180, 70, 30);
//		btnOk.addActionListener(dPersonDM.aDialogCan);
		add(btnCan);
	
		btnOk.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				result = true;
				setVisible(false);
			}
		});
		
		btnCan.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				result = false;
				setVisible(false);
			}
		});
	
	}
	
	public boolean getState() 
	{
		return result;
	}
	
	public void setState(boolean result) 
	{
		this.result = result;
	}
	
	public void resetState() 
	{
		result = false;
		txtId.setText("");
		txtFName.setText("");
		txtSName.setText("");
		txtAge.setText("");
	}
	
	public void setFilds (int id, String fName, String lName, int age)
	{
		txtId.setText("" + id);
		txtFName.setText(fName);
		txtSName.setText(lName);
		txtAge.setText("" + age);
	}
	
	

}
