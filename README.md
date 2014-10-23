### Please Note

This application was implemented as part of a group assignment for an Object-Oriented based module in my university.

## Requirements

Set-up process carried out for each new patient.

1. Entering the patients identity
2. Name
3. Address
4. Hospital Patient Number

Entering the relevant information of a patient

1. Age
2. Gender
3. Body Mass Index (evaluating Weight and Height)

Entering brief notes to highlight specific medical conditions (optional)

1. Sensors are attached to the patient. 
2. A means of allowing intravenous input (injection of medication into the veins) is attached to the patient. 

The sensors send the following information to the computer.

1. Heart Rate
2. Temperature
3. Blood Pressure
4. Blood Glucose Level

Continually sending information regularly and frequently is applied to the system. Vital signs may be sent at different timings, depending on their readings.

Some measurements require conversion to useful units of measurement. It is not necessary to have correct conversion formulas. It is acceptable to include (for each type of sensor) a generic conversion formula.

The PMS shall display information on the screen in numeric and/or graphical form. The PMS shall log the information in a file that can be retrieved and displayed by members of hospital staff.

If any four of the vital sign values exceed safe limits, the screen shall flash a warning and an alarm will sound. If all four of the vital sign values exceed safe limits, the PMS will activate intravenous input (injection of medication into the veins) of a set dose to the patient. Safe limit values are given default values in the software. The operator should have the ability to specify patient-specific safe limits. This should be password protected.

If a sensor fails, the screen shall flash a warning and an alarm will sound.

Information for multiple patients, in regards to ‘files’, will be created within the system.
