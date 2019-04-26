package com.example.demo.model;


//import com.example.demo.controller.RegistrationController;

public class VisaValidation extends Card {
	
	public VisaValidation( String cardName, String cardNumber) {

		super(cardName, cardNumber);

	}

	
	protected boolean validateCardNumberFormat() {


		boolean errorInFormat = false;

		if (cardNumber.charAt(0) != '4') {

	
			errorInFormat = true;									

		}
		else {


		}

		return !errorInFormat;

	}

}
