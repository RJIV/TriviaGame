package edu.gvsu.cis350.triviaGame;

import java.util.ArrayList;
import java.util.Iterator;
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
	private String movieTitle;
	
	/** Movie Overview.*/
	private String movieOverview;
	
	/** Movie filePath.*/
	private String moviePoster;
	
	/**List of Videos.*/
	private List<Video> trailers;
	
	/**Cast List.*/
	private List<PersonCast> cast;
	
	/**Release Date*/
	private String releaseDate;
	
	/**
	 * Default constructor.
	 */
	public MovieStats() {
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

	public List<String> getCast() {
		return formatCastStrings();
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
	
	private List<String> formatCastStrings() {
		List<String> list = new ArrayList<String>();
		PersonCast person = new PersonCast();
		
		Iterator<PersonCast> iterator = cast.iterator();
		String str = "Cast \t\t\t\t\t Role";
		list.add(str);
		
		while(iterator.hasNext()) {
			person = iterator.next();
			
			str = person.getName() + " \t\t\t " + person.getCharacter();
			
			list.add(str);
		}
		
		
		return list;
	}
	
	
	
	
	
	
	
	
	
}
