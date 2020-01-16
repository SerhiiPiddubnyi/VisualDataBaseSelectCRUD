package veiw;
import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import bLogic.PersonDM;

public class DMenu extends JMenuBar
{
	PersonDM dPersonDM = PersonDM.getInstance();
	private static DMenu instance;
	
	public static String name = "Data Base";
	
	public DMenu()
	{
		setBackground(Color.cyan);
		setBounds(0, 0, 600, 30);

		add (new DBMenu());
	}	
	
	class DBMenu  extends JMenu
	{
		
		public DBMenu()
		{
			super (name);
			
			JMenuItem mock, h2, mySQL;;
			
			mock = new JMenuItem("Mock");
			h2 = new JMenuItem("H2");
			mySQL = new JMenuItem("MySQL");
			
			mock.setActionCommand("Mock");
			h2.setActionCommand("H2");
			mySQL.setActionCommand("MySQL");
			
			mock.addActionListener(dPersonDM.aSelectDB);
			h2.addActionListener(dPersonDM.aSelectDB);
			mySQL.addActionListener(dPersonDM.aSelectDB);
			
			add(mock);
			add(h2);
			add(mySQL);
		}
	}
	
	public static DMenu getInstatnce() 
	{
		if (instance == null) 
			instance = new DMenu();
		
		return instance;
	}
	
}
