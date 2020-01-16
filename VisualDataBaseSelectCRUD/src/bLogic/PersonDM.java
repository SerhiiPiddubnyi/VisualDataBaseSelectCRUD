package bLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import dal.IDao;
import veiw.DDialog;
import veiw.DPanel;

public class PersonDM extends AbstractTableModel
{
	private static PersonDM instance;
	ArrayList<Person> pp;
	DPanel dPanel;
	public ActionCreate aCreate;
	public ActionUpdate aUpdate;
	public ActionDelete aDelete;
	public ActionRead aRead;
	public ActionSelectDB aSelectDB;
//	public ActionDialogOk aDialogOk;
//	public ActionDialogCan aDialogCan;
	public PersonFabricDao pFabricDao;

	IDao dDao;

	private PersonDM() 
	{
		pp = new ArrayList<>();
		aCreate =  new ActionCreate();
		aUpdate = new ActionUpdate();
		aDelete = new ActionDelete();
		aRead = new ActionRead();
		aSelectDB = new ActionSelectDB();
		pFabricDao = PersonFabricDao.getInstance();
//		aDialogOk = new ActionDialogOk();
//		aDialogCan = new ActionDialogCan();
	}

	public void read()
	{
		pp = dDao.read();
		fireTableDataChanged();
	}
	
	void setValuesDialig(DDialog dDialog)
	{
		int index = dPanel.jtab.getSelectedRow();
		Person p = pp.get(index);
		dDialog.setFilds(p.id, p.fName, p.lName, p.age);
	}

	public DPanel setPanel(DPanel dPanel)
	{
		this.dPanel = dPanel;
		return dPanel;
	}

	public static PersonDM getInstance() 
	{
		if (instance == null)
			instance = new PersonDM();

		return instance;
	}


	@Override
	public String getColumnName(int index) 
	{
		String[] columnNames = {"ID", "FNames", "LNames", "Age"};

		return columnNames[index];
	}

	@Override
	public int getColumnCount() 
	{
		return 4;
	}

	@Override
	public int getRowCount() 
	{

		return pp.size();
	}

	@Override
	public Object getValueAt(int row, int column) 
	{
		Person p = pp.get(row);
		switch (column) 
		{
		case 0:	return p.id;
		case 1:	return p.fName;
		case 2:	return p.lName;
		case 3:	return p.age;

		default: return null;
		}

	}

	class ActionCreate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (dDao == null)
				throw new NullPointerException();
			
			DDialog dDialog = new DDialog();
			dDialog.setModal(true);
			dDialog.setVisible(true);

			if (dDialog.getState())
			{
				Person p = null;
				int id = Integer.parseInt(dDialog.txtId.getText());
				String fName = dDialog.txtFName.getText();
				String lName = dDialog.txtSName.getText();
				int age = Integer.parseInt(dDialog.txtAge.getText());
				p = new Person(id, fName, lName, age);

				dDao.create(p);			
				
				read();
			}
			
//			dDialog.resetState();

		}
	}

	class ActionUpdate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			DDialog dDialog = new DDialog();
			setValuesDialig(dDialog);
			dDialog.txtId.setEnabled(false);
			dDialog.setModal(true);
			dDialog.setVisible(true);

			if (dDialog.getState())
			{
				Person p = null;
				int id = Integer.parseInt(dDialog.txtId.getText());
				String fName = dDialog.txtFName.getText();
				String lName = dDialog.txtSName.getText();
				int age = Integer.parseInt(dDialog.txtAge.getText());
				p = new Person(id, fName, lName, age);

				dDao.update(p);

				read();
			}
//			dDialog.resetState();
		}
	}

	class ActionDelete implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			DDialog dDialog = new DDialog();
			setValuesDialig(dDialog);
			dDialog.txtAge.setEnabled(false);
			dDialog.txtFName.setEnabled(false);
			dDialog.txtSName.setEnabled(false);
			dDialog.setModal(true);
			dDialog.setVisible(true);


			if (dDialog.getState())
			{
				Person p = null;
				int id = Integer.parseInt(dDialog.txtId.getText());
				p = new Person(id, null, null, 0);

				dDao.delete(p);

				read();
			}
			
//			dDialog.resetState();

		}
	}

	class ActionRead implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			read();

		}
	}

	class ActionSelectDB implements ActionListener
	{
		String dataBase = null;

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			dataBase = e.getActionCommand();
			dDao = pFabricDao.fabricDao(dataBase);
			read();
		}
	}
	
//	class ActionDialogOk implements ActionListener
//	{
//		@Override
//		public void actionPerformed(ActionEvent e) 
//		{
//			DDialog dDialog =(DDialog) e.getSource();
//			dDialog.setState(true);
//			dDialog.setVisible(false);
//			
//		}
//	}
//	
//	class ActionDialogCan implements ActionListener
//	{
//		@Override
//		public void actionPerformed(ActionEvent e) 
//		{
//			DDialog dDialog =(DDialog) e.getSource();
//			dDialog.setState(false);
//			dDialog.setVisible(false);
//			
//		}
//		
//	}

}
