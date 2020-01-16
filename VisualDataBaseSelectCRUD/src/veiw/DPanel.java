package veiw;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import bLogic.Person;
import bLogic.PersonDM;
import dal.DAOMock;
import dal.IDao;

public class DPanel extends JPanel
{
	public JTable jtab;

	public DPanel()
	{
		PersonDM dPersonDM = PersonDM.getInstance();
		setLayout(null);
		
		setBackground(Color.gray);
		setBounds(0, 30, 900, 550);
		
		jtab = new JTable(dPersonDM);
		JScrollPane tabScrollPage = new JScrollPane(jtab);
		tabScrollPage.setPreferredSize(new Dimension(300, 250));
		tabScrollPage.setBounds	(10, 10, 590, 450);
		
		add (tabScrollPage);

		JButton btnCreate, btnRead, btnUpdate, btnDelete;
		JRadioButton mock, h2, mySQL;
		
		btnCreate = new JButton("Create");
		btnRead = new JButton("Reàd");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		
		mock = new JRadioButton("Mock");
		h2 = new JRadioButton("H2");
		mySQL = new JRadioButton("MySQL");
		
		btnCreate.setBounds(630, 170, 100, 40);
		btnRead.setBounds(750, 170, 100, 40);
		btnUpdate.setBounds(630, 220, 100, 40);
		btnDelete.setBounds(750, 220, 100, 40);
		
		mock.setBounds(630, 270, 100, 25);
		h2.setBounds(630, 310, 100, 25);
		mySQL.setBounds(630, 350, 100, 25);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(mock);
		radioGroup.add(h2);
		radioGroup.add(mySQL);
		
		btnCreate.addActionListener(dPersonDM.aCreate);
		btnRead.addActionListener(dPersonDM.aRead);
		btnUpdate.addActionListener(dPersonDM.aUpdate);
		btnDelete.addActionListener(dPersonDM.aDelete);
		
		mock.setActionCommand("Mock");
		h2.setActionCommand("H2");
		mySQL.setActionCommand("MySQL");
		
		mock.addActionListener(dPersonDM.aSelectDB);
		h2.addActionListener(dPersonDM.aSelectDB);
		mySQL.addActionListener(dPersonDM.aSelectDB);

		add(btnCreate);
		add(btnRead);
		add(btnUpdate);
		add(btnDelete);
		
		
		add(mock);
		add(h2);
		add(mySQL);
	}

}
