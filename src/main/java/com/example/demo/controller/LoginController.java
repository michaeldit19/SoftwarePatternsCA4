package com.example.demo.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Customers;
import com.example.demo.model.Login;
import com.example.demo.service.CustomerService;




@WebServlet("/loginProcess")
@RestController
public class LoginController extends HttpServlet {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
        return mav;
	}

	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@ModelAttribute("login") Login login, BindingResult result) {
		
		
		ModelAndView mav = null;

		Customers customers = customerService.validateCustomer(login);

		if (null != customers) {
			mav = new ModelAndView("welcome");
			addCustomerToSession(customers, session);
			
		} else if (login.getUsername().equals("admin")&&login.getPassword().equals("root")) {
			mav = new ModelAndView("admin_welcome");
		}
		
		else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is invalid....");
		}
		return mav;
	}
	
	private void addCustomerToSession(Customers customers, HttpSession session) {
		session.setAttribute("customers", customers);
		session.setAttribute("id", customers.getId());
	}
		
	}
	
	
