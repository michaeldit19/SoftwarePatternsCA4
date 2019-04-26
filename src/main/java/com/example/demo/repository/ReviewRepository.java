package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

}
