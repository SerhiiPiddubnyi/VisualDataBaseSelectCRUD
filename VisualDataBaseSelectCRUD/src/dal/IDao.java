package dal;
import java.sql.SQLException;
import java.util.ArrayList;

import bLogic.Person;

public interface IDao 
{
	void create (Person p) ;
	void update (Person p) ;
	void delete (Person p) ;
	ArrayList<Person> read() ;	
}
