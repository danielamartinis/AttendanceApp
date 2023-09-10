package application;

import java.util.Scanner;

public class Driver {
//////////////////////////////////////////////////////////
	//For the controller to use
//////////////////////////////////////////////////////////
	private static String swipeFile;
	private static String rosterFile;
	private static String fName;
	private static String lName;
	private static String date;
	private static String time;
	private static int days;
	
	public static void setRosterFile(String filePath) {
        rosterFile = filePath;
    }
	public static void setSwipeFile(String filePath) {
        swipeFile = filePath;
    }
	public static void setfName(String f) {
		fName = f;
    }
	public static void setlName(String l) {
		lName = l;
    }
	public static void setDate(String d) {
		date = d;
    }
	public static void setTime(String t) {
		time = t;
    }
	public static void setDays(int ds) {
		days = ds;
    }
	//AttendanceLog
	public static void callA() {
		AttendanceLog.load_log(swipeFile);
    }
	public static void callB() {
		AttendanceLog.print_collection();
    }
	public static void callC() {
		AttendanceLog.print_count();
    }
	//StudentRoster
	public static void callD() {
		StudentRoster.load_roster(rosterFile);
    }
	public static void callE() {
		StudentRoster.print_collection();
    }
	public static void callF() {
		StudentRoster.print_count();
    }
	//AttendanceApp
	public static void callG() {
		new AttendanceApp(rosterFile, swipeFile);
        AttendanceApp.list_students_not_in_class();
    }
	public static void callH() {
		new AttendanceApp(rosterFile, swipeFile);
        AttendanceApp.list_all_times_checking_in_and_out(lName, fName);
    }
	public static void callI() {
		new AttendanceApp(rosterFile, swipeFile);
		AttendanceApp.list_all_times_checked_in();
    }
	public static void callJ() {
		new AttendanceApp(rosterFile, swipeFile);
		AttendanceApp.list_students_late_to_class(time, date);
    }
	public static void callK() {
		new AttendanceApp(rosterFile, swipeFile);
		AttendanceApp.get_first_student_to_enter(date);
    }
	public static void callL() {
		new AttendanceApp(rosterFile, swipeFile);
		AttendanceApp.print_attendance_data_for_student(lName, fName);
    }
	public static void callM() {
		new AttendanceApp(rosterFile, swipeFile);
		AttendanceApp.is_present(lName, fName, date);
    }
	public static void callN() {
		new AttendanceApp(rosterFile, swipeFile);
		AttendanceApp.list_all_students_checked_in(date);
    }
	public static void callO() {
		new AttendanceApp(rosterFile, swipeFile);
		AttendanceApp.list_all_students_checked_in_before(time, date);
    }
	public static void callP() {
		new AttendanceApp(rosterFile, swipeFile);
		AttendanceApp.list_students_attendance_count(days);
    }
	public static void callQ() {
		new AttendanceApp(rosterFile, swipeFile);
		AttendanceApp.get_first_student_to_enter(date);
    }
	public static void callR(String helper) {
		if (helper.contains("G")) {
    		System.out.println("** Students missing in class **");
    		AttendanceApp.print_query_list(AttendanceApp.absent);
    	}
    	if (helper.contains("H")) {
    		System.out.println("** List all swipe in and out for a student **");
    		AttendanceApp.print_query_list(AttendanceApp.swipes);
    	}
    	if (helper.contains("I")) {
    		System.out.println("** Check in times for all students who attended **");
    		AttendanceApp.print_query_list(AttendanceApp.firstSwipe);
    	}
    	if (helper.contains("J")) {
    		System.out.println("** Students that arrived late **");
    		AttendanceApp.print_query_list(AttendanceApp.late);
    	}
    	if (helper.contains("K") || helper.contains("Q")) {
    		System.out.println("** First student to enter on this date **");
    		AttendanceApp.print_query_list(AttendanceApp.first_enter);
    	}
    	if (helper.contains("L")) {
    		System.out.println("** Looking up Student Attendance Data **");
    		AttendanceApp.print_query_list(AttendanceApp.log_data);
    	}
    	if (helper.contains("M")) {
    		System.out.println("** Looking to see if Student was present on date **");
    		AttendanceApp.print_query_list(AttendanceApp.present);
    	}
    	if (helper.contains("N")) {
    		System.out.println("** Students present on this date **");
    		AttendanceApp.print_query_list(AttendanceApp.attendees);
    	}
    	if (helper.contains("O")) {
    		System.out.println("** Those present on this date & before a time **");
    		AttendanceApp.print_query_list(AttendanceApp.attendees_dt);
    		AttendanceApp.print_count(AttendanceApp.attendees_dt);
    	}
    	if (helper.contains("P")) {
    		System.out.println("** Those who attended BOTH classes **");
    		AttendanceApp.print_query_list(AttendanceApp.attendees_days);
    		AttendanceApp.print_count(AttendanceApp.attendees_days);
    	}
    }
	public static void callS(String helper) {
		if (helper.contains("G")) {
    		AttendanceApp.print_count(AttendanceApp.absent);
    	}
    	if (helper.contains("H")) {
    		AttendanceApp.print_count(AttendanceApp.swipes);
    	}
    	if (helper.contains("I")) {
    		AttendanceApp.print_count(AttendanceApp.firstSwipe);
    	}
    	if (helper.contains("J")) {
    		AttendanceApp.print_count(AttendanceApp.late);
    	}
    	if (helper.contains("K") || helper.contains("Q")) {
    		AttendanceApp.print_count(AttendanceApp.first_enter);
    	}
    	if (helper.contains("L")) {
    		AttendanceApp.print_count(AttendanceApp.log_data);
    	}
    	if (helper.contains("M")) {
    		AttendanceApp.print_count(AttendanceApp.present);
    	}
    	if (helper.contains("N")) {
    		AttendanceApp.print_count(AttendanceApp.attendees);
    	}
    	if (helper.contains("O")) {
    		AttendanceApp.print_count(AttendanceApp.attendees_dt);
    	}
    	if (helper.contains("P")) {
    		AttendanceApp.print_count(AttendanceApp.attendees_days);
    	}
    }
//////////////////////////////////////////////////////////////////////	
	public static void main(String[] args) {
		//the files
		String file1 = "dataAllShow1stClass.txt";
		String file2 = "dataAllShow1stAnd2ndClass.txt";
		String file3 = "rosters.txt";
		String file4 = "dataAllShow1stClassInandOut.txt";
		
		//menu
		Scanner in = new Scanner(System.in);
		String printHelp = "";
        while (true) {
            System.out.print("Enter your choice: ");
            String choice = in.nextLine().toUpperCase();
            switch (choice) {
                case "0":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case "A":
                    AttendanceLog.load_log(file4);
                    break;
                case "B":
                    AttendanceLog.print_collection();
                    break;
                case "C":
                    AttendanceLog.print_count();
                    break;
                case "D":
                    StudentRoster.load_roster(file3);
                    break;
                case "E":
                    StudentRoster.print_collection();
                    break;
                case "F":
                    StudentRoster.print_count();
                    break;
                case "G":
                	new AttendanceApp(file3, file4);
                    AttendanceApp.list_students_not_in_class();
                    printHelp = "G";
                    break;
                case "H":
                	new AttendanceApp(file3, file4);
                    AttendanceApp.list_all_times_checking_in_and_out("Ince", "Sally");
                    printHelp = "H";
                    break;
                case "I":
                	new AttendanceApp(file3, file4);
                    AttendanceApp.list_all_times_checked_in();
                    printHelp = "I";
                    break;
                case "J":
                	new AttendanceApp(file3, file4);
                    AttendanceApp.list_students_late_to_class("09:47:00", "11/2/2022");
                    printHelp = "J";
                    break;
                case "K":
                	new AttendanceApp(file3, file4);
                    AttendanceApp.get_first_student_to_enter("11/2/2022");
                    printHelp = "K";
                    break;
                case "L":
                	new AttendanceApp(file3, file4);
                    AttendanceApp.print_attendance_data_for_student("Morrison", "Simon");
                    printHelp = "L";
                    break;
                case "M":
                	new AttendanceApp(file3, file4);
                    AttendanceApp.is_present("Morrison", "Simon", "11/2/2022");
                    printHelp = "M";
                    break;
                case "N":
                	new AttendanceApp(file3, file4);
                    AttendanceApp.list_all_students_checked_in("11/2/2022");
                    printHelp = "N";
                    break;
                case "O":
                	new AttendanceApp(file3, file4);
                    AttendanceApp.list_all_students_checked_in_before("09:45:04", "11/2/2022");
                    printHelp = "O";
                    break;
                case "P":
                	new AttendanceApp(file3, file4);
                    AttendanceApp.list_students_attendance_count(2);
                    printHelp = "P";
                    break;
                case "Q":
                	new AttendanceApp(file3, file4);
                    AttendanceApp.get_first_student_to_enter("11/3/2022");
                    printHelp = "Q";
                    break;
                case "R":
                    // based on the latest query, print the query
                	if (printHelp.contains("G")) {
                		System.out.println("** Students missing in class **");
                		AttendanceApp.print_query_list(AttendanceApp.absent);
                	}
                	if (printHelp.contains("H")) {
                		System.out.println("** List all swipe in and out for a student **");
                		AttendanceApp.print_query_list(AttendanceApp.swipes);
                	}
                	if (printHelp.contains("I")) {
                		System.out.println("** Check in times for all students who attended **");
                		AttendanceApp.print_query_list(AttendanceApp.firstSwipe);
                	}
                	if (printHelp.contains("J")) {
                		System.out.println("** Students that arrived late **");
                		AttendanceApp.print_query_list(AttendanceApp.late);
                	}
                	if (printHelp.contains("K") || printHelp.contains("Q")) {
                		System.out.println("** First student to enter on this date **");
                		AttendanceApp.print_query_list(AttendanceApp.first_enter);
                	}
                	if (printHelp.contains("L")) {
                		System.out.println("** Looking up Student Attendance Data **");
                		AttendanceApp.print_query_list(AttendanceApp.log_data);
                	}
                	if (printHelp.contains("M")) {
                		System.out.println("** Looking to see if Student was present on date **");
                		AttendanceApp.print_query_list(AttendanceApp.present);
                	}
                	if (printHelp.contains("N")) {
                		System.out.println("** Students present on this date **");
                		AttendanceApp.print_query_list(AttendanceApp.attendees);
                	}
                	if (printHelp.contains("O")) {
                		System.out.println("** Those present on this date & before a time **");
                		AttendanceApp.print_query_list(AttendanceApp.attendees_dt);
                		AttendanceApp.print_count(AttendanceApp.attendees_dt);
                	}
                	if (printHelp.contains("P")) {
                		System.out.println("** Those who attended BOTH classes **");
                		AttendanceApp.print_query_list(AttendanceApp.attendees_days);
                		AttendanceApp.print_count(AttendanceApp.attendees_days);
                	}
                    break;
                case "S":
                	//based on the latest query, print the count
                	if (printHelp.contains("G")) {
                		AttendanceApp.print_count(AttendanceApp.absent);
                	}
                	if (printHelp.contains("H")) {
                		AttendanceApp.print_count(AttendanceApp.swipes);
                	}
                	if (printHelp.contains("I")) {
                		AttendanceApp.print_count(AttendanceApp.firstSwipe);
                	}
                	if (printHelp.contains("J")) {
                		AttendanceApp.print_count(AttendanceApp.late);
                	}
                	if (printHelp.contains("K") || printHelp.contains("Q")) {
                		AttendanceApp.print_count(AttendanceApp.first_enter);
                	}
                	if (printHelp.contains("L")) {
                		AttendanceApp.print_count(AttendanceApp.log_data);
                	}
                	if (printHelp.contains("M")) {
                		AttendanceApp.print_count(AttendanceApp.present);
                	}
                	if (printHelp.contains("N")) {
                		AttendanceApp.print_count(AttendanceApp.attendees);
                	}
                	if (printHelp.contains("O")) {
                		AttendanceApp.print_count(AttendanceApp.attendees_dt);
                	}
                	if (printHelp.contains("P")) {
                		AttendanceApp.print_count(AttendanceApp.attendees_days);
                	}
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
	}

}
