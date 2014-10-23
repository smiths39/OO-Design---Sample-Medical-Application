import java.io.*;

class patientFile
{
	/* Global variables */
	private String name;
	private String address;
	private int hospitalNumber;
	private String gender;
	private double height;
	private double bmi;
	
	/* Made public for heart rate conversion purposes */
	public double weight;
	public int age;
	
	/* Most relevant details of patient */
	public void identityDetails(){
	
		System.out.print("Enter patient name: ");
		name = Console.readString();
			
		System.out.print("Enter patient address: ");
		address = Console.readString();
			
		System.out.print("Enter patient hospital number: ");
		hospitalNumber = Console.readInt();
	}
	
	/* Additional details of patient */
	public void patientInformation(){
	
		System.out.print("Enter patient age: ");
		age = Console.readInt();
		
		System.out.print("Enter patient gender: ");
		gender = Console.readToken();
		
		System.out.print("Enter patient weight (pounds): ");
		weight = Console.readDouble();
			
		System.out.print("Enter patient height (inches): ");
		height = Console.readDouble();
		
		/* Calculate body mass index */
		bmi = bodyMassIndex(weight, height);
	}
	
	/* Prints all details of registered user to the screen and stores in a txt file for future use */
	public void patientBio(){
		
		try{
			/* Initialise PrintWriter */
			PrintWriter pw = new PrintWriter("Patient_Bio_File.txt");
			
			pw.println("Patient Name: " + name + " .");
			pw.println("Patient Address: " + address + " .");
			pw.println("Patient Hospital Number: " + hospitalNumber + " .");
			pw.println("Patient age: " + age + " .");
			pw.println("Patient gender: " + gender + " .");
			pw.println("Patient body mass index: " + bmi + " .");
			
			/* Close PrintWriter */
			pw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/* Returns body mass index based on weight and height previously supplied */
	private double bodyMassIndex(double weight, double height){
	
		weight *= 703;
		height *= height;
		
		return weight/height;
	}
	
	/* Allow additional notes based on the patient to be entered */
	public void writeBriefNotesLog(){
		try{
			PrintWriter notesLog = new PrintWriter("Patient_notes_log.txt");
			
			String word = "";
			System.out.println('\n' + "Type 'end' to finish writing" + '\n');
			System.out.print("Note: ");
			
			/* Continuously allow words to be entered into the file, until 'end' is inserted */
			while(!word.equals("end")){
				word = Console.readToken();
			
				/* Prevents the word 'end' being included in the file */
				if(!word.equals("end"))
					notesLog.print(word + " ");
			}
			notesLog.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/* Extracts previously entered notes based on patient */
	public void readBriefNotesLog(){
		try{
			/* Supports both synchronous and asynchronous read and write operations */
			FileInputStream fstream = new FileInputStream("Patient_notes_log.txt");
			
			/* Enables the ability to read Java primitives */
			DataInputStream in = new DataInputStream(fstream);
			
			/* Reads text from a character-input stream */
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			/* While pointer has not reached the end of the file, continue */
			while((strLine = br.readLine()) != null)
				System.out.println(strLine);
			
			System.out.println();
			
			fstream.close();
			in.close();
			br.close();
			
		}
		catch(IOException e){
			System.err.println("Error: " + e.getMessage());
		}
	}
}