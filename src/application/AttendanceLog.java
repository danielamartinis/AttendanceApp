package application;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class AttendanceLog {
	//raw data
	static ArrayList<Log> entry = new ArrayList<Log>();
	static ArrayList<String> silly = new ArrayList<>();
	//organized data for printing
	static Map<String, List<String>> nameRecords = new LinkedHashMap<>();
	//getters (besides those from Log)
	public static ArrayList<Log> getEntries() {
		return entry;
	}
	public static ArrayList<String> getPrinter() {
		return silly;
	}
	public static Map<String, List<String>> getPolished() {
		return nameRecords;
	}
	//setters (besides those from Log)
	public static void setPolished() {
		nameRecords.clear();
		for (Log logEntry : entry) {
			String lname = logEntry.getlastName();
			String fname = logEntry.getfirstName();
			String name = lname + ", " + fname;
			String time = logEntry.getTime();
			String date = logEntry.getDate();
			String dateTime = time + ", " + date;
			
			if (nameRecords.containsKey(name)) {
				nameRecords.get(name).add(dateTime);
			}
			else {
				List<String> dateTimes = new ArrayList<>();
				dateTimes.add(dateTime);
				nameRecords.put(name, dateTimes);
			}
		}
	}
	public static void load_log(String fileName) {
		//loads a single file of attendance data into a collection of your choice
		entry.clear();
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
			Log load = Log.fromString(line);
			entry.add(load);
		}
	}
	
	public static void print_collection() {
		//prints logs read into the collection of your choice
		System.out.println("** This is the entire Collection Data currently stored **");
		setPolished();
		for (Map.Entry<String, List<String>> i : nameRecords.entrySet()) {
            String name = i.getKey();
            List<String> dateTimes = i.getValue();
            
            String full = name + " " + dateTimes;
            silly.add(full);
            System.out.println(full);
        }
		
	}
	public static void print_count() {
		//prints the number of logs read into the collection of your choice
		System.out.println(nameRecords.size());
	}
}
