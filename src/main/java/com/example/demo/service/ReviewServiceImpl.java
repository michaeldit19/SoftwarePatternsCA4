package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	public List<Review> getAllCustomers(){
		List<Review> review = new ArrayList<Review>();
		for(Review c: reviewRepository.findAll()) {
			review.add(c);
		}
		return review;
	}
	
	
	public void createReview(Review c) {
		 reviewRepository.save(c);
	}
	
	class UserMapper implements RowMapper<Review> {
		public Review mapRow(ResultSet rs, int arg1) throws SQLException {
			Review review = new Review();

			review.setId(rs.getInt("id"));
			review.setComments(rs.getString("comments"));
			review.setRating(rs.getInt("rating"));
		    

			return review;
		}


}
}
