package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Card;

public interface CardRepository extends CrudRepository<Card, String> {

}