package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.application.Platform;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;


public class SampleController {
	@FXML private Button uploadR;
	@FXML private Label rFileName;
	@FXML private Button uploadS;
	@FXML private Label sFileName;
	@FXML private Button exit;
	@FXML private Button A;
	@FXML private Button B;
	@FXML private Button C;
	@FXML private Button D;
	@FXML private Button E;
	@FXML private Button F;
	@FXML private Button G;
	@FXML private Button H;
	@FXML private Button I;
	@FXML private Button J;
	@FXML private Button K;
	@FXML private Button L;
	@FXML private Button M;
	@FXML private Button N;
	@FXML private Button O;
	@FXML private Button P;
	@FXML private Button Q;
	@FXML private Button R;
	@FXML private Button S;
	@FXML private TextArea t;
	
	//helper to track which function list will be called by print_query_list and print_count
	static String helper = "";
	public void pressUploadRoster(ActionEvent e) {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File(System.getProperty("user.home")));
		fc.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
		
		File f = fc.showOpenDialog(null);
		if (f != null) {
			Driver.setRosterFile(f.getName());
			rFileName.setText("Selected file: " + f.getAbsolutePath());
		}
		
	}
	public void pressUploadSwipe(ActionEvent e) {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File(System.getProperty("user.home")));
		fc.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
		
		File f = fc.showOpenDialog(null);
		if (f != null) {
			Driver.setSwipeFile(f.getName());
			sFileName.setText("Selected file: " + f.getAbsolutePath());
		}
		
	}
	public void pressExit(ActionEvent e) {
		Platform.exit();
		
	}
	public void pressA(ActionEvent e) {
		Driver.callA();
	}
	public void pressB(ActionEvent e) {
		// Redirect the console output to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
       
        Driver.callB();

        // Reset the console output
        System.out.flush();
        System.setOut(originalOut);

        String output = outputStream.toString();

        // Set the output to the TextArea
        t.setText(output);
	}
	public void pressC(ActionEvent e) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        
        Driver.callC();

        // Reset the console output
        System.out.flush();
        System.setOut(originalOut);

        String output = outputStream.toString();

        t.setText(output);
	}
	public void pressD(ActionEvent e) {
		Driver.callD();
	}
	public void pressE(ActionEvent e) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        
        Driver.callE();

        // Reset the console output
        System.out.flush();
        System.setOut(originalOut);

        String output = outputStream.toString();

        t.setText(output);
	}
	public void pressF(ActionEvent e) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
      
        Driver.callF();

        // Reset the console output
        System.out.flush();
        System.setOut(originalOut);

        String output = outputStream.toString();

        t.setText(output);
	}
	public void pressG(ActionEvent e) {
		helper = "G";
        Driver.callG();
	}
	public void pressH(ActionEvent e) {
		helper = "H";
		//Creating the input dialog so that the user can put in the names/dates/times/days
		TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Enter Student Information");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Enter the student's first name:");

	    Optional<String> result = dialog.showAndWait();
	    if (result.isPresent()) 
	    {
	       Driver.setfName(result.get());
	
	        
	        dialog.setContentText("Enter the student's last name:");
	        result = dialog.showAndWait();
	        if (result.isPresent()) {
	            Driver.setlName(result.get());

	        }
	    }
        Driver.callH();
	}
	public void pressI(ActionEvent e) {
		helper = "I";
        Driver.callI();
	}
	public void pressJ(ActionEvent e) {
		helper = "J";
		TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Enter Student Information");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Enter the time:");

	    Optional<String> result = dialog.showAndWait();
	    if (result.isPresent()) 
	    {
	       Driver.setTime(result.get());
	
	        
	        dialog.setContentText("Enter the date:");
	        result = dialog.showAndWait();
	        if (result.isPresent()) {
	            Driver.setDate(result.get());

	        }
	    }
        Driver.callJ();
	}
	public void pressK(ActionEvent e) {
		helper = "K";
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
      
        TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Enter Student Information");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Enter the date:");

	    Optional<String> result = dialog.showAndWait();
	    if (result.isPresent()) 
	    {
	       Driver.setDate(result.get());
	    }
        Driver.callK();

        // Reset the console output
        System.out.flush();
        System.setOut(originalOut);

        String output = outputStream.toString();

        t.setText(output);
	}
	public void pressL(ActionEvent e) {
		helper = "L";
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
      
        TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Enter Student Information");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Enter the student's first name:");

	    Optional<String> result = dialog.showAndWait();
	    if (result.isPresent()) 
	    {
	       Driver.setfName(result.get());
	
	        
	        dialog.setContentText("Enter the student's last name:");
	        result = dialog.showAndWait();
	        if (result.isPresent()) {
	            Driver.setlName(result.get());

	        }
	    }
        Driver.callL();

        // Reset the console output
        System.out.flush();
        System.setOut(originalOut);

        String output = outputStream.toString();

        t.setText(output);
	}
	public void pressM(ActionEvent e) {
		helper = "M";
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
      
        TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Enter Student Information");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Enter the student's first name:");

	    Optional<String> result = dialog.showAndWait();
	    if (result.isPresent()) 
	    {
	       Driver.setfName(result.get());
	
	        
	        dialog.setContentText("Enter the student's last name:");
	        result = dialog.showAndWait();
	        if (result.isPresent()) {
	            Driver.setlName(result.get());
	            
	            dialog.setContentText("Enter the date:");
		        result = dialog.showAndWait();
		        if (result.isPresent()) {
		            Driver.setDate(result.get());

		        }

	        }
	    }
        Driver.callM();

        // Reset the console output
        System.out.flush();
        System.setOut(originalOut);

        String output = outputStream.toString();

        t.setText(output);
	}
	public void pressN(ActionEvent e) {
		helper = "N";
		TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Enter Student Information");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Enter the date:");

	    Optional<String> result = dialog.showAndWait();
	    if (result.isPresent()) 
	    {
	       Driver.setDate(result.get());
	    }
        Driver.callN();
	}
	public void pressO(ActionEvent e) {
		helper = "O";
		TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Enter Student Information");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Enter the time:");

	    Optional<String> result = dialog.showAndWait();
	    if (result.isPresent()) 
	    {
	       Driver.setTime(result.get());
	
	        
	        dialog.setContentText("Enter the date:");
	        result = dialog.showAndWait();
	        if (result.isPresent()) {
	            Driver.setDate(result.get());

	        }
	    }
        Driver.callO();
	}
	public void pressP(ActionEvent e) {
		helper = "P";
		TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Enter Student Information");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Enter the number of days:");

	    Optional<String> result = dialog.showAndWait();
	    if (result.isPresent()) 
	    {
	       Driver.setDays(Integer.parseInt(result.get()));
	    }
        Driver.callP();
	}
	public void pressQ(ActionEvent e) {
		helper = "Q";
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
      
        TextInputDialog dialog = new TextInputDialog();
	    dialog.setTitle("Enter Student Information");
	    dialog.setHeaderText(null);
	    dialog.setContentText("Enter the date:");

	    Optional<String> result = dialog.showAndWait();
	    if (result.isPresent()) 
	    {
	       Driver.setDate(result.get());
	    }
        Driver.callQ();

        // Reset the console output
        System.out.flush();
        System.setOut(originalOut);

        String output = outputStream.toString();

        t.setText(output);
	}
	
	public void pressR(ActionEvent e) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
      
        Driver.callR(helper);

        // Reset the console output
        System.out.flush();
        System.setOut(originalOut);

        String output = outputStream.toString();

        t.setText(output);
	}
	public void pressS(ActionEvent e) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
      
        Driver.callS(helper);

        // Reset the console output
        System.out.flush();
        System.setOut(originalOut);

        String output = outputStream.toString();

        t.setText(output);
	}
}
