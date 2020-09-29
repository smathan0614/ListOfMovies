package com.moviesurl.springboot.servicelayer;

import java.util.List;

import com.moviesurl.springboot.controller.*;

public interface serviceInterface {

	public abstract List<MovieObject> GetmovieObj(MovieObject movie);
}