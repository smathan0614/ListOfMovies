package com.moviesurl.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<MovieObject> GetMovie(MovieObject movie) {
			List<MovieObject> mlist = slayer.GetmovieObj(movie);
			return mlist;		
	}
}
