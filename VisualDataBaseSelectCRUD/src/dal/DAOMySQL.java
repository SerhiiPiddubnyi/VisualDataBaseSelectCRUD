package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bLogic.Person;

public class DAOMySQL implements IDao
{
	ArrayList<Person> pp;
	ForConnect info = new ForConnect();


	@Override
	public void create(Person p)
	{
		Connection con = null;
		Statement st = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}

		try 
		{
			con = DriverManager.getConnection(info.URL_MYSQL, info.USER_MYSQL, info.PASSWORD_MYSQL);
			st = con.createStatement();
			st.execute("INSERT INTO PERSON (id, fName, lName, age) VALUES(" +p.id + ", '"+ p.fName +"', '"+ p.lName +"', " + p.age +");");
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update(Person p) 
	{
		Connection con = null;
		Statement st = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			con = DriverManager.getConnection(info.URL_MYSQL, info.USER_MYSQL, info.PASSWORD_MYSQL);
			st = con.createStatement();
			st.executeUpdate("UPDATE person  SET fname = '" + p.fName +"', lname= '" +p.lName +"', age="+p.age +" WHERE id = " + p.id + "");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(Person p) 
	{
		Connection con = null;
		Statement st = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{	
			e.printStackTrace();
		}
		
		
		try {
			con = DriverManager.getConnection(info.URL_MYSQL, info.USER_MYSQL, info.PASSWORD_MYSQL);
			st = con.createStatement();
			st.execute("DELETE FROM PERSON WHERE ID= "+ p.id +";");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public ArrayList<Person> read()  
	{
		pp = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(info.URL_MYSQL, info.USER_MYSQL, info.PASSWORD_MYSQL);
			st = con.createStatement();

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
		finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pp;
	}
}
