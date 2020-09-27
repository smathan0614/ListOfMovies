package com.moviesurl.springboot.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.moviesurl.springboot.ListOfMoviesApplication;
import com.moviesurl.springboot.controller.*;

@Component
public class MoviesData implements CommandLineRunner {
	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(ListOfMoviesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		template.update("INSERT INTO Movie(name,rating,rank,year,crew) VALUES('inserttest','6','600','1996','simple test')");
	}

	public List<MovieObject> getList(MovieObject movie) {
		try {
			if (movie != null) {
				String qry = "SELECT name,rating,rank,year,link,crew FROM Movie WHERE 1=1";
				String name, crew, year, rank, rating;
				Boolean criteriaSet = false;
				name = crew = year = rank = rating = "";
				if (movie.getName() != null) {
					name = " AND name LIKE'%" + movie.getName().toString() + "%'";
					qry = qry.concat(name);
					criteriaSet = true;
				}
				if (movie.getRank() != null) {
					rank = " AND rank = '" + movie.getRank().toString() + "'";
					qry = qry.concat(rank);
					criteriaSet = true;
				}
				if (movie.getCrew() != null) {
					crew = " AND crew LIKE '%" + movie.getCrew().toString() + "%'";
					qry = qry.concat(crew);
					criteriaSet = true;
				}
				if (movie.getYear() != null) {
					year = " AND year = '" + movie.getYear() + "'";
					qry = qry.concat(year);
					criteriaSet = true;
				}
				if (movie.getRating() != null) {
					rating = " AND rating >= " + movie.getRating();
					qry = qry.concat(rating);
					criteriaSet = true;
				}
				if (criteriaSet == true) {
					List<MovieObject> movieObj = template.query(qry, new RowMapper<MovieObject>() {
						@Override
						public MovieObject mapRow(ResultSet rs, int rownum) throws SQLException {
							return new MovieObject(rs.getString("name"), rs.getNString("crew"), rs.getString("rating"),
									rs.getString("rank"), rs.getString("year"), rs.getString("link"));
						}
					});
					return movieObj;
				} else
					return null;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
