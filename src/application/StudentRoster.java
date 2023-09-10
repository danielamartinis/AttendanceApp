package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentRoster {
	static ArrayList<Student> record = new ArrayList<Student>();
	//getter
	public static ArrayList<Student> getRecord() {
		return record;
	}
	//setter
	public static void load_roster(String fileName) {
		record.clear();
		/////////////////////////////////////////////
		Scanner infile = null;
		try {
			infile = new Scanner(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace(); // prints error(s)
			System.exit(0); // Exits entire program
		}
		/////////////////////////////////////////////
		while (infile.hasNextLine()) {
			String line = infile.nextLine();
			Student load = Student.fromString(line);
			record.add(load);
		}
	}
	public static void print_collection() {
		//prints logs read into the collection of your choice
		System.out.println("** Those students on roster **");
		for (Student s : record) {
			String name = s.getlastName() + ", " + s.getfirstName();
			System.out.println(name);
		}
	}
	public static void print_count() {
		//prints the number of logs read into the collection of your choice
		System.out.println(record.size());
	}
}
