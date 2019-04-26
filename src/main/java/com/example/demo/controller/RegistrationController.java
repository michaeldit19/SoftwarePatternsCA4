package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Card;
import com.example.demo.model.Customers;
import com.example.demo.model.MastercardValidation;
import com.example.demo.model.VisaValidation;
import com.example.demo.service.CardService;
import com.example.demo.service.CustomerService;



@RestController
public class RegistrationController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CardService cardService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("customers", new Customers());
		return mav;
	}
	
	@PostMapping("/registerProcess")
	public ModelAndView addUser(HttpServletRequest request, @ModelAttribute("customer") Customers customers,
			@ModelAttribute("card") Card card, HttpSession session) {
		ModelAndView mav = new ModelAndView("paymentDetails");
		addCustomerToSession(customers, session);
		customerService.register(customers);
		return mav;
	}
	
	

	@RequestMapping(value = "/paymentDetails", method = RequestMethod.GET)
	public ModelAndView addCard(HttpServletRequest request, HttpServletResponse response) {
		//ModelAndView mav = new ModelAndView("paymentDetails");
		ModelAndView mav = null;
		
		boolean result = false;
		Card validator = null;
		
		String cardName = request.getParameter("cardName");
		String cardNumber = request.getParameter("cardNumber");
		
		String cardType = request.getParameter("cardType");
		if (cardType.equals("Visa Card")) 
		{
			validator = new VisaValidation( cardName, cardNumber);

		} 
		else if (cardType.equals("MasterCard")) 
		{
			validator = new MastercardValidation( cardName, cardNumber);
			
		}
		
		result = validator.validate();

		if (!result) 
		{
			mav = new ModelAndView("paymentDetails");
			request.setAttribute("error", "Invalid Card Details");
			
		} 
		else
		{
		mav.addObject("card", new Card());
		mav = new ModelAndView("welcome");
		
		}
		return mav;
	}
	
	@PostMapping("/cardProcess")
	public ModelAndView addCard(HttpServletRequest request, @ModelAttribute("card") Card card,
			HttpSession session){
		ModelAndView mav = new ModelAndView("welcome");
		cardService.createCard(card);
		return mav;
	}
	
	private void addCustomerToSession(Customers customers, HttpSession session) {
		session.setAttribute("customers", customers);
		session.setAttribute("id", customers.getId());
	}


}