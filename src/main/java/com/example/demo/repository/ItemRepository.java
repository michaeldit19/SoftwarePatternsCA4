package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Item;

public interface ItemRepository extends CrudRepository<Item, String>{
	
	public Item findById(int id);

}
