package application;

public class Log {
	private String firstName;
	private String lastName;
	private String time;
	private String date;
	
	//setter
	Log(String l, String f, String t, String d) {
		lastName = l;
		firstName = f;
		time = t;
		date = d;
	}
	//getters
	public String getfirstName() {
		return firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public String getTime() {
		return time;
	}
	public String getDate() {
		return date;
	}
	public static Log fromString(String record) {
        String[] components = record.split(",");
        String last = components[0].trim();
        String first = components[1].trim();
        String t = components[2].trim();
        String d = components[3].trim();
        return new Log(last, first, t, d);
    }
	public String toString() {
		return (lastName + ", " + firstName + ", " + time + ", " + date);
	}
}
