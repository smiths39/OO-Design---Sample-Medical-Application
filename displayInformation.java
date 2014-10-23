class displayInformation
{
	/* Inheriting all classes */
	private static patientFile patient = new patientFile();
	private static sensors sensor = new sensors();
	private static measurementConversion convert = new measurementConversion();
	private static vitalMonitor vital = new vitalMonitor();
	private static fileStorage storage = new fileStorage();
	
	/* Clear the command line prompt for readability purposes */
	private static void clearScreen(){
	
		int numRowsInConsole = 60;
	
		for (int i =0; i < numRowsInConsole; i++) 
			System.out.println("");	
	}
	
	/* Invokes all methods to run application */
	public static void displayOnScreen(){
		
		try{
			/* Login screen */
			clearScreen();
			System.out.println('\n' + "WELCOME TO PMS SYSTEM...." + '\n');
			
			System.out.println("Please create your username and password for login purposes");
			vital.createPassword();
			System.out.println('\n' + "...login information registered.");
			
			/* Pause for 4 seconds, for desired effect */
			Thread.sleep(4000);

			/* Patient registration */
			clearScreen();
			System.out.println("*************************************");
			System.out.print('\t' + "Register Patient" +'\n');
			System.out.println("*************************************");
			
			System.out.println('\n' + "Please register the patient details." + '\n');
			patient.identityDetails();
			patient.patientInformation();
			System.out.println('\n' + "....registration successful.");
			System.out.println("Registration information has been logged in 'Patient_Bio_File.txt'");
			patient.patientBio();
			
			Thread.sleep(4000);
			
			System.out.print('\n' + "Do you wish to include brief notes in regards to patient (y/n): ");
			char answer = Console.readChar();
			
			if(answer == 'y' || answer == 'Y')
				patient.writeBriefNotesLog();
			
			String decision = "y";
			clearScreen();
			System.out.println('\n' + "Patient is connect to PMS...");
			
			/* PMS functionalities listed */
			do{
				System.out.println('\n' + "Please enter one of the following options" + '\n');
				System.out.println("a." + '\t' + "Read patient's vital signs");
				System.out.println("b." + '\t' + "Convert patient's vital signs to measurements");
				System.out.println("c." + '\t' + "Log patient's file in system");
				System.out.println("d." + '\t' + "Read brief notes related to patient");
				
				System.out.print('\n' + "Please select option: ");
				String select = Console.readToken();
				clearScreen();
				readData(select);
				
				System.out.print('\n' + "Do you wish to end the PMS system (y/n): ");
				decision = Console.readToken();
				clearScreen();
			}
			/* While user does not wish to end PMS, continuously run */
			while(decision.equals("n") || decision.equals("N"));
			
			/* Application ending */
			System.out.println('\n' + "PMS system shutting down....");
		}
		catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}
	}
	
	private static void readData(String answer){
	
		/* Invoke sensor functionalities */
		if(answer.equals("a")){
			System.out.println("*************************************");
			System.out.print('\t' + "Patient Sensors" +'\n');
			System.out.println("*************************************" +'\n');
			sensor.readSensorData();
			sensor.printSensorData();
		}
		/* Invoke measurement functionalities */
		else if(answer.equals("b")){
			System.out.println("*************************************");
			System.out.print('\t' + "Measurement Conversion" +'\n');
			System.out.println("*************************************");
			convert.convertCalculator();
		}
		/* Invoke file functionalities */
		else if(answer.equals("c")){
			System.out.println("*************************************");
			System.out.print('\t' + "Patient File" +'\n');
			System.out.println("*************************************" +'\n');
			storage.retrieveFile();
		}
		/* Display brief notes previously entered in PMS */
		else if(answer.equals("d")){
			System.out.println("*************************************");
			System.out.print('\t' + "Brief Notes on Patient" +'\n');
			System.out.println("*************************************" + '\n');
			patient.readBriefNotesLog();
		}
		else
			System.out.println("Error: selection is invalid.");
	}
	
	public static void main(String [] args){
	
		displayOnScreen();
	}
}
		
		