package bLogic;

import dal.DAOH2;
import dal.DAOMock;
import dal.DAOMySQL;
import dal.IDao;

public class PersonFabricDao 
{
	private DAOMock dMock;
	private DAOH2 dH2;
	private DAOMySQL dMySQL;
	private IDao dDao;
	private static PersonFabricDao instance;
	
	
	public IDao fabricDao (String dataBase)
	{
		switch (dataBase) 
		{
		case "Mock":
			if (dMock == null) 
				dMock = new DAOMock();
			dDao = dMock;
			break;
			
		case "H2":
			if (dH2 == null) 
				dH2 = new DAOH2();
			dDao = dH2;
			break;
			
		case "MySQL":
			if (dMySQL == null) 
				dMySQL = new DAOMySQL();
			dDao = dMySQL;
			break;
		}
		
		return dDao;
	}
	
	public static PersonFabricDao getInstance()
	{
		if (instance == null)
			instance = new PersonFabricDao();
		
		return instance;
	}
	
	
}
