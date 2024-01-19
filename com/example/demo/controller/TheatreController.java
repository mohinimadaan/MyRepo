package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.model.Movie;
import com.example.demo.model.Theatre;
import com.example.demo.service.MovieService;
import com.example.demo.service.TheatreService;


@RestController
@RequestMapping("/theatres")
public class TheatreController {
	
	@Autowired
	private TheatreService theatreService;
	
	@PostMapping
    public ResponseEntity<?> addTheatre(@RequestBody Theatre theatre) {
		theatreService.addTheatre(theatre);
        return new ResponseEntity<>("Theatre Added", HttpStatus.CREATED);
    }
	
	
  @PostMapping("/{id}/saveMovie") 
  public ResponseEntity<?> addMovie(@PathVariable(name = "id") String id,@RequestBody Movie movie) {
	  theatreService.addMovie(Integer.valueOf(id),movie); 
	  return new ResponseEntity<>("Movie Added", HttpStatus.CREATED); }
 
	
	@GetMapping("/{id}")
    public Theatre getTheatreById(@PathVariable("id") Integer id) {
		System.out.println("TheatreController====getTheatreById");
		//Optional<Theatre> t = theatreService.getTheatreById(id);
		return theatreService.getTheatreById(id);
		/*
		 * if(t.isPresent()) return t.get(); else return null;
		 */
				
    }
	
	
	@GetMapping 
  	public List<Theatre> getTheatres() { 
		return theatreService.getAllTheatres(); 
	}
	 

}
