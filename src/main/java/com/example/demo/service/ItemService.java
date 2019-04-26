package com.example.demo.service;

import com.example.demo.model.Item;

public interface ItemService {
	
	void create(Item item);
	
	Item update(Item item);
	
	Iterable<Item> findAllItems();
	
	Item findById(int id);

}

