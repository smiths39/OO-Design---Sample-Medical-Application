/* The maximum and minimum values randomly generated are based on actual findings */

import java.util.Random;
import java.io.*;

class sensors
{
	/* Including methods from vitalMonitor class */
	private static vitalMonitor vital = new vitalMonitor();
	
	/* Global variables */
	private Random rand = new Random();
	
	private double [] heartRate = new double[10];
	private	double [] temperature = new double[10];
	private double [] bloodPressure = new double[10];
	private	double [] bloodGlucoseLevel = new double[10];
	
	/* Returns random heart rate 
	   MINIMUM = 36
	   MAXIMUM = 85 */
	public double heartRateGenerator(){
		
		return rand.nextInt(36) + 49;
	}
	
	
	/* Returns random temperature
	   MINIMUM = 20
	   MAXIMUM = 110 */
	public double temperatureGenerator(){
		
		return rand.nextInt(20) + 90;
	}
	
	/* Returns random blood pressure 
	   MINIMUM = 55
	   MAXIMUM = 135 */
	public double bloodPressureGenerator(){
		
		return rand.nextInt(55) + 80;
	}
	
	/* Returns random blood glucose level
	   MINIMUM = 180
	   MAXIMUM = 200 */
	public double bloodGlucoseLevelGenerator(){
			
		return rand.nextInt(180) + 20;
	}
	
	/* Fills each array with random values related to sensor type */
	public void readSensorData(){
		
		for(int index = 0; index < 10; index++){
			heartRate[index] = heartRateGenerator();
			temperature[index] = temperatureGenerator();
			bloodPressure[index] = bloodPressureGenerator();
			bloodGlucoseLevel[index] = bloodGlucoseLevelGenerator();
		}
	}
	
	/* Allows user to apply vital limits manually or by default
	   Inheriting methods from vitalMonitor class (permits password protection to be invoked, warning signs generated)
	   Prints sensor values previously generated to screen */
	public void printSensorData(){
	
			String username, password;
			System.out.print("Would you like to set vital limits manually or by default (m/d): ");
			char answer = Console.readChar();
			
			/* If user wishes to enter values manually */ 
			if(answer == 'm' || answer == 'M'){
				System.out.print('\n' + "Enter username: ");
				username = Console.readToken();
				
				System.out.print("Enter password: ");
				password = Console.readToken();
				
				/* Compare entered username and password against correct username and password */
				if(vital.checkPassword(username, password) == true){
					System.out.println('\n' + "Permission granted..." + '\n');
					vital.setLimitManual();
				}
				else System.out.print("Permission denied...setting default");
				
			}
			
			/* Print sensor values to screen */
			try{		
				System.out.println();
				
				for(int index = 0; index < 10; index++){
					System.out.println("Heart Rate: " + heartRate[index]);
					System.out.println("Temperature: " + temperature[index]);
					System.out.println("Blood Pressure: " + bloodPressure[index]);
					System.out.println("Blood Glucose Level: " + bloodGlucoseLevel[index]);
			
					double h = heartRate[index];
					double t = temperature[index];
					double bp = bloodPressure[index];
					double bg = bloodGlucoseLevel[index];
					
					/* Program waits for 2 seconds before proceeding */
					Thread.sleep(2000);
	
					/* If all vital signs exceed limits, print warning and activate intravenous input */
					if(vital.checkAllLimitExceed(answer, h, t, bp, bg) == true){
						System.out.println('\n' + "WARNING - all vital monitors exceed limit!!");
						activateIntravenousInput();
						System.out.println();
					}
					/* If one vital sign exceeds limits, print warning */
					else if(vital.checkEachLimitExceed(answer, h, t, bp, bg) == true){
						System.out.println('\n' + "WARNING!!");
						System.out.print('\n' + "Press enter if situation is resolved: ");
						String enter = Console.readString();
					}
					System.out.println();
				}
		}
		catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}
	}
	
	private void activateIntravenousInput(){
		
		System.out.print("Activate Intravenous Input (y/n): ");
		char answer = Console.readChar();
		
		/* If yes, activate intravenous input */
		if(answer == 'Y' || answer == 'y')
			System.out.println("Intravenous Input activated...attach to patient");
		/* If no, deactivate intravenous input */
		else if(answer == 'N' || answer == 'n')
			System.out.println("Intavenous Input deactivated");	
	}
}