package application;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AttendanceApp {
	static String rName;
	static String sName;
	//functions to call in print
	static ArrayList<String> absent = new ArrayList<String>();
	static ArrayList<String> swipes = new ArrayList<String>();
	static ArrayList<String> firstSwipe = new ArrayList<String>();
	static ArrayList<String> late = new ArrayList<String>();
	static ArrayList<String> log_data = new ArrayList<String>();
	static ArrayList<String> present = new ArrayList<String>();
	static ArrayList<String> attendees = new ArrayList<String>();
	static ArrayList<String> attendees_dt = new ArrayList<String>();
	static ArrayList<String> attendees_days = new ArrayList<String>();
	static ArrayList<String> first_enter = new ArrayList<String>();
	//getters
	public static ArrayList<String> getAbsent() {
		return absent;
	}
	public static ArrayList<String> getSwipes() {
		return swipes;
	}
	public static ArrayList<String> getFSwipe() {
		return firstSwipe;
	}
	public static ArrayList<String> getLate() {
		return late;
	}
	public static ArrayList<String> getLogD() {
		return log_data;
	}
	public static ArrayList<String> getPresent() {
		return present;
	}
	public static ArrayList<String> getAttendees() {
		return attendees;
	}
	public static ArrayList<String> getAttDT() {
		return attendees_dt;
	}
	public static ArrayList<String> getAttDays() {
		return attendees_days;
	}
	public static ArrayList<String> getFEnter() {
		return first_enter;
	}
	//setters
	AttendanceApp(String r, String s) {
		//constructor
		rName = r;
		sName = s;
		
	}
	public static void list_students_not_in_class() {
		//Compare and place those students that did not show up for class into a list
		absent.clear();
		StudentRoster.load_roster(rName);
		AttendanceLog.load_log(sName);
		
		ArrayList<Log> sHold = AttendanceLog.entry;
		ArrayList<Student> rHold = StudentRoster.record;
		
		//add all names in roster to the list
		for (Student i : rHold) {
			String students = i.getlastName() + ", " + i.getfirstName();
			absent.add(students);
		}
		//now remove if not on swipe log
		for (Log k : sHold) {
			String absentee = k.getlastName() + ", " + k.getfirstName();
			absent.remove(absentee);
		}
	}
	public static void list_all_times_checking_in_and_out(String last, String first) {
		//Looking at the swiping log, this function will list all in and outs for a particular Student
		swipes = new ArrayList<>();
		AttendanceLog.load_log(sName);
		
		ArrayList<Log> sHold = AttendanceLog.entry;
		String target = last + ", " + first;
		
		for (Log i : sHold) {
			String stu = i.getlastName() + ", " + i.getfirstName();
			if (stu.equals(target)) {
				String hold = stu + ", " + i.getTime() + ", " + i.getDate();
				swipes.add(hold);
			}
		}
	}
	public static void list_all_times_checked_in() {
		//returns a list of when all student(s) FIRST swipe in
		firstSwipe.clear();
		AttendanceLog.load_log(sName);
		
		ArrayList<Log> sHold = AttendanceLog.entry;
		ArrayList<String> noRepeats = new ArrayList<String>();
		
		
		for (Log i : sHold) {
			String checker = i.getlastName() + ", " + i.getfirstName();
			if (!noRepeats.contains(checker)) {
				String hold = checker + ", " + i.getTime() + ", " + i.getDate();
				firstSwipe.add(hold);
				noRepeats.add(checker);
			}
		}
	}
	public static void list_students_late_to_class(String timeStamp, String date) {
		//returns a list of those records of students who swiped in late into the class
		//LORD HELP ME I HATED MAKING THIS FUNCTION but also it was kinda fun once it worked
		late.clear();
		AttendanceLog.load_log(sName);
		//get the class period
        String[] timeParts = timeStamp.split(":");
		String firstTwoNumbers = timeParts[0];
		//////////////////////
		ArrayList<Log> sHold = AttendanceLog.entry;
		ArrayList<String> noRepeats = new ArrayList<String>();
		
		int cnt = 0;
		int bound = 0;
		//for 11/2/2022
		if (date.contains("11/2/2022")) {
			if (firstTwoNumbers.contains("09")) {
				bound = 250;
			}
			if (firstTwoNumbers.contains("12")) {
				bound = 500;
			}
			if (firstTwoNumbers.contains("16")) {
				bound = 700;
			}
		}
		//for 11/3/2022
				if (date.contains("11/3/2022")) {
					if (firstTwoNumbers.contains("08")) {
						bound = 250;
					}
					if (firstTwoNumbers.contains("12")) {
						bound = 500;
					}
					if (firstTwoNumbers.contains("18")) {
						bound = 700;
					}
				}
		
		for (Log i : sHold) {
			if ((i.getDate()).equals(date)) {
				String checker = i.getlastName() + ", " + i.getfirstName();
				if (!noRepeats.contains(checker)) {
					//timestamp > time of student check in (aka they are late)
					if ((i.getTime()).compareTo(timeStamp) > 0) {
						String hold = checker + ", " + i.getTime() + ", " + i.getDate();
						late.add(hold);
					}
					noRepeats.add(checker);
				}
				cnt++;
				if (cnt == bound) {
					break;
				}	
			}
		}
	}
	public static void print_attendance_data_for_student(String last, String first) {
		//display the log-in data student for that particular, if present
		log_data.clear();
		AttendanceLog.load_log(sName);
		AttendanceLog.setPolished();
		
		Map<String, List<String>> sHold = AttendanceLog.nameRecords;
		
		String fullName = last + ", " + first;
		for (Map.Entry<String, List<String>> i : sHold.entrySet()) {
            String name = i.getKey();
            List<String> dateTimes = i.getValue();
            if (name.contains(fullName)) {
                String hold = name + " " + dateTimes;
                log_data.add(hold);
            }
        }
		//if nothing was added
		if (log_data.isEmpty()) {
			String none = "No student of this name in the attendance log";
			log_data.add(none);
		}
		System.out.println("** Looking up Student Attendance Data **");
		for (String i : log_data) {
			System.out.println(i);
		}
	}
	public static void is_present(String last, String first, String date) {
		boolean status = false;
		//return true if a student and a certain date, logged into the class
		present.clear();
		AttendanceLog.load_log(sName);
		
		ArrayList<Log> sHold = AttendanceLog.entry;
		
		String fullName = last + ", " + first;
		for (Log i : sHold) {
			if ((i.getDate()).equals(date)) {
				String checker = i.getlastName() + ", " + i.getfirstName();
				if (checker.contains(fullName)) {
					status = true;
					break;
				}
			}
		}
		System.out.println("** Looking to see if Student was present on date **");
		System.out.println(status);
	}
	public static void list_all_students_checked_in(String date) {
		//return a list of students that attended class on a given date
		attendees.clear();
		AttendanceLog.load_log(sName);
		
		ArrayList<Log> sHold = AttendanceLog.entry;
		ArrayList<String> noRepeats = new ArrayList<String>();
		
		for (Log i : sHold) {
			String checker = i.getlastName() + ", " + i.getfirstName();
			if (date.equals(i.getDate())) {
				if (!noRepeats.contains(checker)) {
					attendees.add(checker);
					noRepeats.add(checker);
				}
			}
		}
	}
	public static void list_all_students_checked_in_before(String timeStamp, String date) {
		//return a list of students that attended class on a given date and BEFORE a given time
		attendees_dt.clear();
		AttendanceLog.load_log(sName);
		
		//get the class period
        String[] timeParts = timeStamp.split(":");
		String firstTwoNumbers = timeParts[0];
		//////////////////////
		ArrayList<Log> sHold = AttendanceLog.entry;
		ArrayList<String> noRepeats = new ArrayList<String>();
		
		int cnt = 0;
		int bound = 0;
		//for 11/2/2022
		if (date.contains("11/2/2022")) {
			if (firstTwoNumbers.contains("09")) {
				bound = 250;
			}
			if (firstTwoNumbers.contains("12")) {
				bound = 500;
			}
			if (firstTwoNumbers.contains("16")) {
				bound = 700;
			}
		}
		//for 11/3/2022
				if (date.contains("11/3/2022")) {
					if (firstTwoNumbers.contains("08")) {
						bound = 250;
					}
					if (firstTwoNumbers.contains("12")) {
						bound = 500;
					}
					if (firstTwoNumbers.contains("18")) {
						bound = 700;
					}
				}
		
		for (Log i : sHold) {
			if ((i.getDate()).equals(date)) {
				String checker = i.getlastName() + ", " + i.getfirstName();
				if (!noRepeats.contains(checker)) {
					//timestamp > time of student check in (aka they are late)
					if ((i.getTime()).compareTo(timeStamp) < 0) {
						attendees_dt.add(checker);
					}
					noRepeats.add(checker);
				}
				cnt++;
				if (cnt == bound) {
					break;
				}	
			}
		}
	}
	public static void list_students_attendance_count(int days) {
		//return a list of students that have attended a (integer) particular amount of days
		attendees_days.clear();
		AttendanceLog.load_log(sName);
		
		ArrayList<Log> sHold = AttendanceLog.entry;
		Map<String, Integer> attendanceCountMap = new LinkedHashMap<>();;

        // Count the attendance for each student
        for (Log i : sHold) {
            String studentName = i.getlastName() + ", " + i.getfirstName();
            attendanceCountMap.put(studentName, attendanceCountMap.getOrDefault(studentName, 0) + 1);
        }
        // Get the students with the specified attendance count
        for (Map.Entry<String, Integer> k : attendanceCountMap.entrySet()) {
            if (k.getValue() == days) {
                attendees_days.add(k.getKey());
            }
        }
	}
	public static void get_first_student_to_enter(String date) {
		//returns the student that swiped in first
		first_enter.clear();
		AttendanceLog.load_log(sName);
		
		ArrayList<Log> sHold = AttendanceLog.entry;
		
		String best = null;
		Log first = null;
		for (Log i : sHold) {
			if ((i.getDate()).equals(date)) {
				if (first == null || i.getTime().compareTo(first.getTime()) < 0) {
					best = i.getlastName() + ", " + i.getfirstName();
					first = i;
                }
			}
		}
		first_enter.add(best);
		System.out.println("** First student to enter on this date **");
		for (String i : first_enter) {
			System.out.println(i);
		}
	}
	public static void print_query_list(ArrayList<?> lst) {
		//prints the list created by a query (lists produced by other functions)
		for (int i = 0; i < lst.size(); ++i) {
			System.out.println(lst.get(i));
		}
	}
	public static void print_count(ArrayList<?> lst) {
		//prints the number of items in a list. That list is likely a result of a query
		System.out.println("There were " + lst.size() + " records for this query");
	}
}
