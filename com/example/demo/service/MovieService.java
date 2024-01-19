package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.MovieException;
import com.example.demo.model.BookingHistory;
import com.example.demo.model.Movie;
import com.example.demo.repo.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public void addMovie(Movie request) {
		Movie movie = new Movie();
		movie.setTitle(request.getTitle());
		movie.setTotalSeats(request.getTotalSeats());
		movie.setAvailableSeats(request.getAvailableSeats());
		movie.setPrice(request.getPrice());

		movieRepository.save(movie);
	}

	public Movie getMovieById(Integer id) {
		return movieRepository.findById(id)
				.orElseThrow(() -> new MovieException("Invalid movie ID: " + id));
	}


	public List<Movie> getAllMovies() { return movieRepository.findAll(); }


	public void bookTickets(Integer id, Integer noOfTickets, Integer totalPrice) {

		Movie movie = getMovieById(id);

		int availableSeats = movie.getAvailableSeats();
		if (noOfTickets > availableSeats) {
			throw new MovieException("No seats available at this time.");
		}

		int calculatedTotalPrice = noOfTickets * movie.getPrice();

		if (!totalPrice.equals(calculatedTotalPrice)) {
			throw new MovieException("Invalid total price.");
		}

		availableSeats -= noOfTickets;
		movie.setAvailableSeats(availableSeats);

		movieRepository.save(movie);

	}

	public List<BookingHistory> getBookingHistory() {
		List<Movie> movies = movieRepository.findAll();
		List<BookingHistory> bookingHistory = new ArrayList<>();

		for (Movie movie : movies) {
			int bookedTickets = movie.getTotalSeats() - movie.getAvailableSeats();

			if (bookedTickets > 0) {
				// int totalPrice = bookedTickets * movie.getPrice();

				BookingHistory booking = new BookingHistory();
				booking.setId(movie.getId());
				booking.setTitle(movie.getTitle());
				booking.setBookedTickets(bookedTickets);
				booking.setAvailableTickets(movie.getAvailableSeats());
				bookingHistory.add(booking);
			}
		}
		return bookingHistory;
	}



}
