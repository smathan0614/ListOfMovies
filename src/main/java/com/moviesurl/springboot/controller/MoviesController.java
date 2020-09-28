package com.moviesurl.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviesurl.springboot.servicelayer.*;

@RestController
@CrossOrigin
@ControllerAdvice
public class MoviesController {
	@Autowired
	private serviceInterface slayer;

	@GetMapping("/GetMovie")
	public ResponseEntity<List<MovieObject>> GetMovie(MovieObject movie) {
		try {
			if (movie.getCrew() == null && movie.getName() == null && movie.getRank() == null && movie.getRating() == null && movie.getYear() == null)
				throw new MovieListException("Bad Request");
			List<MovieObject> mlist = slayer.GetmovieObj(movie);
			return new ResponseEntity<List<MovieObject>>(mlist, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<MovieObject>>(HttpStatus.BAD_REQUEST);
		}
	}
}
