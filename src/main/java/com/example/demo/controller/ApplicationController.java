package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Customers;
import com.example.demo.model.Review;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ReviewService;

@Controller
public class ApplicationController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public String welcome(HttpServletRequest request) {
		// request.setAttribute("mode", "MODE_REGISTER");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
	    request.setAttribute("mode", "MODE_LOGIN");
		return "login";
	}
	
	@RequestMapping("/welcome")
	public String welcome1(HttpServletRequest request) {
	    request.setAttribute("mode", "MODE_WELCOME");
		return "welcome";
	}
	
	@RequestMapping("/admin_welcome")
	public String admin_welcome(HttpServletRequest request) {
	    request.setAttribute("mode", "MODE_AWELCOME");
		return "admin_welcome";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
	    request.setAttribute("mode", "MODE_REGISTER");
		return "register";
	}
	
	@RequestMapping("/paymentDetails")
	public String paymentDetails(HttpServletRequest request) {
	    request.setAttribute("mode", "MODE_PAYDETAILS");
		return "paymentDetails";
	}
	
	@RequestMapping("/add_item")
	public String add_item(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_ITEM");
		return "add_item";
	}
	
	@RequestMapping("/view_items")
	public String view_item(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_VIEW_ITEM");
		return "view_items";
	}
	
	@RequestMapping("/view_items_cust")
	public String view_items_cust(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_VIEW_ITEMC");
		return "view_items_cust";
	}
	
	@RequestMapping("/review")
	public String review(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REVIEW");
		return "review";
	}
	
	@RequestMapping("/addToCart")
	public String addToCart(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_ADDCART");
		return "addToCart";
	}
	
	 @RequestMapping(value = "/review", method = RequestMethod.GET)
		public ModelAndView createReview(HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mav = new ModelAndView("review");
			mav.addObject("review", new Review());
			return mav;
		}
	 
	 @RequestMapping(value = "/reviewPosting", method = RequestMethod.POST)
		public ModelAndView createReview(HttpServletRequest request, HttpServletResponse response, HttpSession session,
				@SessionAttribute("customers") Customers customers) {
		    ModelAndView mav = null;
		 
		    String comment = request.getParameter("comment");
			int rating = Integer.parseInt(request.getParameter("rating"));
			
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			
			Review r = new Review(comment, rating);
			reviewService.createReview(r);
			
			int id = customers.getId();
			customers = customerService.getCustomerById(id);
			customers.getReview().add(r);
			customerService.updateCustomer(id, customers);
			
			
			//reviewService.createReview(review);
			mav = new ModelAndView("view_items_cust");
			mav.addObject("message4", "Review has been posted");
			return mav;
		}

}