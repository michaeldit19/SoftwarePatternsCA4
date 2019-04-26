package com.example.demo.model;


//import com.example.demo.controller.RegistrationController;

public class MastercardValidation extends Card {
	
	public MastercardValidation( String cardName, String cardNumber) {

		super(cardName, cardNumber);

	}
	
	protected boolean validateCardNumberFormat() {

		

		boolean errorInFormat = false;
		
		if (cardNumber.charAt(0) == '5' && (cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5')) {
								
		}
		else {
				
			
			errorInFormat = true;									
											
		}
		
		return !errorInFormat;
			
	}

}
