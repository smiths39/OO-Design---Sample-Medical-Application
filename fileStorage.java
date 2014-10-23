import java.io.*;
import java.util.*;

class fileStorage
{	
	/* Using a resizable array to store files inserted into PMS */
	private ArrayList<String> insertFile(File file) throws FileNotFoundException{
		
		/* Scanner will parse strings using regular expressions */
		Scanner scan;
		ArrayList <String> list = new ArrayList<String>();
		scan = new Scanner(file);
		
		/* Read in all lines within text file */
		while(scan.hasNext())
			list.add(scan.next());

		/* Close scanner */
		scan.close();

		return list;
	}
	
	public void retrieveFile(){
		/* File in which previously entered details where written to */
		File file = new File("C:/Users/Sean/Documents/OO/Code/Patient_Bio_File.txt");
		
		try{
			ArrayList <String> lines = insertFile(file);
			
			for(int index = 0; index < lines.size(); index++){
				
				/* If a full stop occurs, print a new line */
				if(lines.get(index).contains("."))
					System.out.println();
				/* Print word in text file */
				else
					System.out.print(lines.get(index) + " ");
			}
			System.out.println("Patient file is logged...access file is 'Patient_Bio_File'.");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}