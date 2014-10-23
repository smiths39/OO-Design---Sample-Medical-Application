class vitalMonitor
{
	/* Including methods from sensor class */
	private sensors sensor = new sensors();
	
	/* Global Variables */
	private double heart_Rate_Manual_Limit, temperature_Manual_Limit, blood_Pressure_Manual_Limit, blood_Glucose_Manual_Limit;
	private double heart_Rate_Default_Limit, temperature_Default_Limit, blood_Pressure_Default_Limit, blood_Glucose_Default_Limit;
	
	private double heartSensor = sensor.heartRateGenerator();
	private double temperatureSensor = sensor.temperatureGenerator();
	private double bloodPressureSensor = sensor.bloodPressureGenerator();
	private double bloodGlucoseSensor = sensor.bloodGlucoseLevelGenerator();
	
	/* Returns a default Heart Rate limit genertated by the PMS */
	private double default_Heart_Rate_Limit(){
	
		return heart_Rate_Default_Limit = 85;
	}
	
	/* Returns a default Temperature limit genertated by the PMS */
	private double default_Temperature_Limit(){
	
		return temperature_Default_Limit = 110;
	}
	
	
	/* Returns a default Blood Pressure limit genertated by the PMS */
	private double default_Blood_Pressure_Limit(){
		
		return blood_Pressure_Default_Limit = 135;
	}
	
	/* Returns a default Blood Glucose Level limit genertated by the PMS */
	private double default_Blood_Glucose_Limit(){
		
		return blood_Glucose_Default_Limit = 200;
	}
	
	/* User enters manual limits */
	public void setLimitManual(){
	
		System.out.print("Please enter Heart Rate limit: ");
		heart_Rate_Manual_Limit = Console.readDouble();
		
		System.out.print("Please enter Temperature limit: ");
		temperature_Manual_Limit = Console.readDouble();
		
		System.out.print("Please enter Blood Pressure limit: ");
		blood_Pressure_Manual_Limit = Console.readDouble();
		
		System.out.print("Please enter Blood Glucose Level limit: ");
		blood_Glucose_Manual_Limit = Console.readDouble();
		
		System.out.println();
	}
	
	/* Checks if sensors generated exceed all sensor limits */
	public boolean checkAllLimitExceed(char option, double heart_Rate_Vital, double temperature_Vital, double blood_Pressure_Vital, double blood_Glucose_Vital){
		
		/* Compares sensors with default limits */
		if(option == 'd' || option == 'D'){		
			if(heart_Rate_Vital >= default_Heart_Rate_Limit() && temperature_Vital >= default_Temperature_Limit() && 
			   blood_Pressure_Vital >= default_Blood_Pressure_Limit() && blood_Glucose_Vital >= default_Blood_Glucose_Limit())
				return true;
			else return false;
		}
		/* Compares sensors with manual limits */
		else if(option == 'm' || option == 'M'){
			if(heart_Rate_Vital >= heart_Rate_Manual_Limit && temperature_Vital >= temperature_Manual_Limit && 
			   blood_Pressure_Vital >= blood_Pressure_Manual_Limit && blood_Glucose_Vital >= blood_Glucose_Manual_Limit)
				return true;
			else return false;
		}	
		else return false;
	}
	
	/* Checks if any sensors generated exceed a specific sensor limit */
	public boolean checkEachLimitExceed(char option, double heart_Rate_Vital, double temperature_Vital, double blood_Pressure_Vital, double blood_Glucose_Vital){
		
		/* Compares sensors with default limits */
		if(option == 'd' || option == 'D'){		
			if(heart_Rate_Vital >= default_Heart_Rate_Limit())
				return true;
			else if(temperature_Vital >= default_Temperature_Limit())
				return true;
			else if(blood_Pressure_Vital >= default_Blood_Pressure_Limit())
				return true;
			else if(blood_Glucose_Vital >= default_Blood_Glucose_Limit())
				return true;
			else return false;
		}
		/* Compares sensors with manual limits */
		else if(option == 'm' || option == 'M'){
			if(heart_Rate_Vital >= heart_Rate_Manual_Limit)
				return true;
			else if(temperature_Vital >= temperature_Manual_Limit)
				return true;
			else if(blood_Pressure_Vital >= blood_Pressure_Manual_Limit)
				return true;
			else if(blood_Glucose_Vital >= blood_Glucose_Manual_Limit)
				return true;
			else return false;
		}
		else return false;
	}
	
	/* Create a password to set limits manually */
	public void createPassword(){
		
		String username, password;
		
		System.out.print("Username: ");
		username = Console.readToken();
		
		System.out.print("Password: ");
		password = Console.readToken();
	}
	
	/* Returns true if entered login details equals the set login details */
	public boolean checkPassword(String user, String pass){
		
		if(user.equals("student") && pass.equals("computing"))
			return true;
		else return false;
	}
}
	
	
		
		