package edu.gvsu.cis350.triviaGame;

import java.lang.reflect.Array;
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

	public String[][] getCastArray() {
		return formatCastStrings(this.cast);
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
	
	private String[][] formatCastStrings(List<PersonCast> cast) {
		
		
			PersonCast person;
			ArrayList<PersonCast> castList = new ArrayList<PersonCast>(getCast());
			int size = castList.size();
			
			String[][] castArray = new String[size][size];
			int i = 0;
			while(i<size) {
				person = castList.get(i);
				castArray[i][0] = person.getName();
				castArray[i][1] = person.getCharacter();
				i++;
			}
		return castArray;
	}
	
	
	
	
	
	
	
	
	
}
