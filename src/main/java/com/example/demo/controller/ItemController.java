package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Item;
import com.example.demo.model.Review;
import com.example.demo.service.ItemService;
import com.example.demo.service.ReviewService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	


	@RequestMapping(value = "/add_item", method = RequestMethod.GET)
	public ModelAndView createItem(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("add_item");
		mav.addObject("item", new Item());
		return mav;
	}

	@RequestMapping(value = "/postingProcess", method = RequestMethod.POST)
	public ModelAndView createItem(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("item") Item item) {
		ModelAndView mav = null;
		itemService.create(item);
		mav = new ModelAndView("admin_welcome");
		mav.addObject("message2", "Item has been created");
		return mav;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("item") Item item) {
		ModelAndView mav = null;
		itemService.update(item);
		mav = new ModelAndView("admin_welcome");
		mav.addObject("message3", "Stock has been update");
		return mav;
	}
	
	@RequestMapping(value="/addToCart", method = RequestMethod.GET)
	public ModelAndView addToCart(HttpServletRequest request) {
		ModelAndView mav = null;
		mav = new ModelAndView("welcome");
		mav.addObject("message4","Item has been added to cart");
		return mav;
	}
	
	/*
	@RequestMapping(value="/update_item/{id}")    
    public String update(@PathVariable int id, Item item){    
        Item item = itemService.findById(id);    
        item.addAttribute("item",Item);  
        return "update_item";    
    }    
    */
	
	 @RequestMapping(value="/update_item",method = RequestMethod.POST)    
	    public String updateStock(@ModelAttribute("item") Item item){    
	        itemService.update(item);    
	        return "view_items";    
	    } 
	 


}
