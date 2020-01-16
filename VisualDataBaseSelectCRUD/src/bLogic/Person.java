package bLogic;

public class Person {
	public int id;
	public String fName;
	public String lName;
	public int age;

	public Person (int id, String fName, String lName, int age)
	{
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}
	
	@Override
	public String toString() {
	
		String out = new String();
		out += Integer.toString(id)+ ", " +
				fName + ", " +
				lName + ", " +
				Integer.toString(age);
		
		return out;
	}
}
