package edu.gvsu.cis350.triviaGame;

import java.util.List;

import info.movito.themoviedbapi.model.Video;
import info.movito.themoviedbapi.model.people.PersonCast;

/**
 * Class that will hold stats and attributes of a given movie.
 * Will be passed as a pararmeter of the question class to be used by
 * the movie stats panel class.
 * @author Joseph Dubois
 *
 */
public class MovieStats {

	/** Movie Title.*/
	String movieTitle;
	
	/** Movie Overview.*/
	String movieOverview;
	
	/** Movie filePath.*/
	String moviePoster;
	
	/**List of Videos.*/
	List<Video> trailers;
	
	/**Cast List.*/
	List<PersonCast> cast;
	
	/**Release Date*/
	String releaseDate;
	
	/**
	 * Default constructor.
	 */
	MovieStats() {
		movieTitle = "not found";
		movieOverview = "not found";
		moviePoster = "not found";
		releaseDate = "not found";
		trailers = null;
		cast = null;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieOverview() {
		return movieOverview;
	}

	public void setMovieOverview(String movieOverview) {
		this.movieOverview = movieOverview;
	}

	public String getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	public List<Video> getTrailers() {
		return trailers;
	}

	public void setTrailers(List<Video> trailers) {
		this.trailers = trailers;
	}

	public List<PersonCast> getCast() {
		return cast;
	}

	public void setCast(List<PersonCast> cast) {
		this.cast = cast;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	
	
	
	
	
	
	
}
