package com.moviesurl.springboot.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.moviesurl.springboot.controller.MovieObject;
import com.moviesurl.springboot.dal.MoviesData;

@Service
@CacheConfig(cacheNames={"MovieList"})   
public class serviceClass implements serviceInterface {
	@Autowired
	private MoviesData movieList;

	@Override
	public List<MovieObject> GetmovieObj(MovieObject movie) {
		// TO DO : Cache
		List<MovieObject> mlist = movieList.getList(movie);
		return mlist;
	}
}
