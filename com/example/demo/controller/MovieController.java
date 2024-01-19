package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookingHistory;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;


	@PostMapping 
	public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
		movieService.addMovie(movie); 
		return new ResponseEntity<>("Movie Added",
				HttpStatus.CREATED); }


	@GetMapping("/{id}")
	public Movie getMovieById(@PathVariable("id") Integer id) {
		return movieService.getMovieById(id);
	}


	@GetMapping 
	public List<Movie> getMovies() { 
		return
			movieService.getAllMovies(); }


	@PostMapping("/booking")
	public ResponseEntity<?> createBooking(
			@RequestParam("movieId") Integer id,
			@RequestParam("noOfTickets") Integer noOfTickets,
			@RequestParam("totalPrice") Integer totalPrice
			) {
		movieService.bookTickets(id, noOfTickets, totalPrice);
		return new ResponseEntity<>("Booking Done", HttpStatus.CREATED);
	}

	@GetMapping("/booking/history")
	public List<BookingHistory> getBookingHistory(){
		return movieService.getBookingHistory();
	}

}
