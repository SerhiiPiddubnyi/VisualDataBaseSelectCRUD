package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bLogic.Person;

public class DAOH2 implements IDao
{
	ArrayList<Person> pp;


	@Override
	public void create(Person p) 
	{
		try 
		{
			Class.forName("org.h2.Driver");
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}

		try(Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				Statement st = con.createStatement()) 
		{
			st.execute("INSERT INTO PERSON (id, fName, lName, age) VALUES(" +p.id + ", '"+ p.fName +"', '"+ p.lName +"', " + p.age +");");
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}

	}

	@Override
	public void update(Person p) 
	{

		try 
		{
			Class.forName("org.h2.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				Statement st = con.createStatement())
		{
			st.executeUpdate("UPDATE person  SET fname = '" + p.fName +"', lname= '" +p.lName +"', age="+p.age +" WHERE id = " + p.id + "");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
 
		
	}

	@Override
	public void delete(Person p) 
	{
		try 
		{
			Class.forName("org.h2.Driver");
		} 
		catch (ClassNotFoundException e) 
		{	
			e.printStackTrace();
		}
		
		
		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				Statement st = con.createStatement())
		{
			st.execute("DELETE FROM PERSON WHERE ID= "+ p.id +";");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		
	}

	@Override
	public ArrayList<Person> read()  
	{
		pp = new ArrayList<>();
		
		try 
		{
			Class.forName("org.h2.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				Statement st = con.createStatement()) 
		{
			ResultSet rs = st.executeQuery("select * from Person");

			while (rs.next())
			{
				pp.add(new Person(rs.getInt("id"), rs.getString(2), rs.getString("lName"), rs.getInt(4)));
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		return pp;
	}
}
