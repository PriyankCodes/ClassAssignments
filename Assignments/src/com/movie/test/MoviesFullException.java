package com.movie.test;

public class MoviesFullException extends RuntimeException {

	public String getMessage() {
		return "Exception !!! You can not add More Movies ";
	}
}
