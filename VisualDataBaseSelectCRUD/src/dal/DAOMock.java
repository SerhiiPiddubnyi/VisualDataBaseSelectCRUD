package dal;

import java.util.ArrayList;
import bLogic.Person;

public class DAOMock implements IDao
{

	ArrayList<Person> pp; 

	public DAOMock() 
	{
		pp = new ArrayList<>();
		
		pp.add(new Person(0, "Konstantin", "Ivanov", 39));
		pp.add(new Person(1, "Ivan", "Ivanov", 19));
		pp.add(new Person(2, "Ivan", "Petrov", 21));
		pp.add(new Person(3, "Ivan", "Sidorov", 15));
		pp.add(new Person(4, "stepan", "Ivanov", 19));
		pp.add(new Person(5, "Stepan", "Sidorov", 33));
		pp.add(new Person(6, "Stepan", "Petrov", 48));
		pp.add(new Person(8, "taras", "Petrenko", 26));
		pp.add(new Person(9, "Taras", "Ivanenko", 3));
		pp.add(new Person(10, "Taras", "Sidorenko", 83));
		pp.add(new Person(11, "Nikolay", "Taran", 52));
		pp.add(new Person(12, "Igor", "Stepanenko", 51));
		pp.add(new Person(14, "nikolay", "Stepanov", 11));
		pp.add(new Person(15, "Nikolay", "Gerasimov", 12));
		
	} 

	@Override
	public void create(Person p) 
	{		
		pp.add(p);		
	}

	@Override
	public void update(Person p) 
	{
		int id;

		for (Person o : pp) {
			id = o.id;

			if (p.id == o.id) 
			{
				o.fName = p.fName;
				o.lName = p.lName;
				o.age = p.age;

				return;
			}
		}

	}

	@Override
	public void delete(Person p) 
	{
		int id;

		for (Person o : pp) {
			id = o.id;

			if (p.id == o.id) 
			{
				pp.remove(o);

				return;
			}
		}

	}

	@Override
	public ArrayList<Person> read() 
	{
		return pp;
	}

}
