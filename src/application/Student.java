package application;
public class Student {
	private String firstName;
	private String lastName;
	
	//setter
	Student(String l, String f) {
		lastName = l;
		firstName = f;
	}
	//getters
	public String getfirstName() {
		return firstName;
	}
	public String getlastName() {
		return lastName;
	}
	
	public String toString() {
		return (lastName + ", " + firstName);
	}
	public static Student fromString(String record) {
        String[] components = record.split(",");
        String last = components[0].trim();
        String first = components[1].trim();
        return new Student(last, first);
    }
}
