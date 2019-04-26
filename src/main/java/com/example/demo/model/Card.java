package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.controller.RegistrationController;

@Entity
@Table(name="card")
public class Card {

	
	//protected RegistrationController reg;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	protected int id;
	@Column
	protected String cardNumber;
	@Column
	protected String cardType;
	@Column
	protected int expiryDate;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(int expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Card(int id, String cardNumber, String cardType, int expiryDate) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expiryDate = expiryDate;
	}
	
	public Card( String cardNumber, String cardType) {
		
		this.cardNumber = cardNumber;
		this.cardType = cardType;
	}
	
	public Card() {
		
	}
	
	public boolean validate() {


					boolean cardNumberLengthValidated = validateCardNumberLength();

					if (cardNumberLengthValidated) {
						
						boolean cardNumberFormatValidated = validateCardNumberFormat();

						if (cardNumberLengthValidated)
							return true;
						else
							return false;

					}
		return false;

	}
	
	
	protected boolean validateCardNumberLength() {

		boolean errorInNumber = false;

		if (cardNumber.length() != 16) {

			errorInNumber = true;

		} else {

			for (int i = 0; i < 16; i++) {

				if (cardNumber.charAt(i) > '9' || cardNumber.charAt(i) < '0') {

					errorInNumber = true;

				}
			}
		}

		return !errorInNumber;

	}
	
	protected boolean validateCardNumberFormat() {

		return false;

	}
	

}
