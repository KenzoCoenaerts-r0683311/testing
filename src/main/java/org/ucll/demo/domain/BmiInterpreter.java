package org.ucll.demo.domain;

public class BmiInterpreter {
	public String getMessage(Person person) {
		String message = "Normal";
		double bmi = person.getBmi();
		if(bmi < 16){
			message = "Severe Undererweight";
		} else if (bmi >= 16 && bmi < 17){
			message = "Moderate Undererweight";
		} else if (bmi >= 17 && bmi < 18){
			message = "Mild Undererweight";
		} else if (bmi >= 18 && bmi < 25){
			message = "Normal";
		} else if (bmi >= 25 && bmi < 30){
			message = "Overweight";
		} else if (bmi > 30 && bmi < 35){
			message = "Obese Class I";
		} else if (bmi >= 30 && bmi < 40){
			message = "Obese Class II";
		}
		return message;
	}
}
