package veiw;
import javax.swing.JFrame;
import bLogic.PersonDM;

public class DFrame extends JFrame
{
	
	public DFrame()
	{
		setLayout(null);
		setTitle("DataBase");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 100, 950, 600);
	
		DPanel dButonPanel = new DPanel();
		DMenu dMenu = new DMenu();

		add (dButonPanel);
		add (dMenu);
	
		PersonDM dm = PersonDM.getInstance();
		
		dm.setPanel(dButonPanel);
		
		setVisible(true);
	}
}
