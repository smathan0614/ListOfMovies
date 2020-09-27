package com.moviesurl.springboot.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.moviesurl.springboot.controller.MovieObject;
import com.moviesurl.springboot.dal.MoviesData;

@Service
public class serviceClass implements serviceInterface {
	@Autowired
	private MoviesData movieList;

	@Override
	@Cacheable("cacheMovieList")
	public List<MovieObject> GetmovieObj(MovieObject movie) {
		try {
			List<MovieObject> mlist = movieList.getList(movie);
			return mlist;
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return null;
	}
}
