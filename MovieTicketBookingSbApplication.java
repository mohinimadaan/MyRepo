package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Movie;
import com.example.demo.model.Theatre;
import com.example.demo.repo.TheatreRepository;

@SpringBootApplication
public class MovieTicketBookingSbApplication implements CommandLineRunner {

	/*@SpringBootApplication
public class MovieTicketBookingSbApplication {*/

	
	  @Autowired private TheatreRepository theatreRepository;
	 
	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingSbApplication.class, args);
	}


	@Override public void run(String... args) throws Exception { 
		Theatre t = new
				Theatre("theatre1");

		Movie m1 = new Movie("movie1",100,100,400); 
		Movie m2 = new
				Movie("movie2",50,50,200);

		m1.setTheatre(t); 
		m2.setTheatre(t);


		t.getMovies().add(m1); t.getMovies().add(m2);

		theatreRepository.save(t);

		Theatre t2 = new Theatre("theatre2");

		Movie m3 = new Movie("movie3",200,200,200); Movie m4 = new
				Movie("movie4",300,300,300); Movie m5 = new Movie("movie5",400,400,400);


				t2.getMovies().add(m3); t2.getMovies().add(m4); t2.getMovies().add(m5);


				m3.setTheatre(t2); m4.setTheatre(t2); m5.setTheatre(t2);


				theatreRepository.save(t2);

	}


}
