package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.MovieException;
import com.example.demo.model.BookingHistory;
import com.example.demo.model.Movie;
import com.example.demo.model.Theatre;
import com.example.demo.repo.MovieRepository;
import com.example.demo.repo.TheatreRepository;

@Service
public class TheatreService {
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	/*
	 * @Autowired private MovieRepository movieRepository;
	 */
	
	public void addTheatre(Theatre request) {
		Theatre theatre = new Theatre();

		theatre.setName(request.getName());
		
		List<Movie> movies = new ArrayList<>();
		
		for(Movie movieR:request.getMovies()) {
			
			Movie movie = new Movie(movieR.getTitle(),movieR.getTotalSeats(),movieR.getAvailableSeats(),movieR.getPrice());
			movie.setTheatre(theatre);
			
			movies.add(movie);
		}
		
		theatre.setMovies(movies);

		theatreRepository.save(theatre);
    }
	
	
	  public void addMovie(int theatreId, Movie movieR) {
	  
	  Theatre t = getTheatreById(theatreId);
	  
	 // if(t.isPresent()) {
		  
		  Movie m = new Movie(movieR.getTitle(),movieR.getTotalSeats(),movieR.getAvailableSeats(),movieR.getPrice()); 
		  
		 // Theatre theatre = t.get();
		  m.setTheatre(t);
		  
		  t.getMovies().add(m);
		  
		  theatreRepository.save(t);
	  //}
	  
	  
	  }
	 
	public Theatre getTheatreById(Integer id) {
		/*
		 * Optional<Theatre> t = theatreRepository.findById(id);
		 * //theatreRepository.findAll() return t;
		 */
		  System.out.println("TheatreService====getTheatreById");
		  //return theatreRepository.findById(id);
		  return theatreRepository.findById(id) .orElseThrow(() -> new MovieException("Invalid theatre ID: " + id));
		 
	}
	
	
	
	  public List<Theatre> getAllTheatres() { return theatreRepository.findAll(); }
	 

	
	

}
