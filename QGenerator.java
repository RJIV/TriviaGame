//package edu.gvsu.cis350.triviaGame;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.TmdbMovies.MovieMethod;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Reviews;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.core.SessionToken;
import info.movito.themoviedbapi.model.people.PersonCast;

import java.util.Random;

/**
 * @author Joseph Dubois
 * 
 */
public class QGenerator {	


	/** tmdpApi Type: TmdbApi. Wrapper to interface with online database.*/

	private static TmdbApi tmdbApi = 
			new TmdbApi("658a202fc0f1e7c9d43bdeaadf192bba");

	/** sessionToken Type: SessionToken. 
	 *  SessionToken used to get account information from master user. 
	 */
	private static SessionToken sessionToken = getSessionToken();

	/** qlist Type: ArrayList<Question>. 
	 * List of database generated question objects. 
	 */
	private static  ArrayList<Question> qlist;

	/**QGenerator constructor initializes list, an array list of Questions.*/
	public QGenerator() {
		qlist = new ArrayList<Question>();

	}

	/**
	 * getSessionToken - Private function returns session token.
	 * @return sessionToken Type: SessionToken
	 */
	private static SessionToken getSessionToken() {

		SessionToken sessionToken = 
				new SessionToken("ecf8d70e3b5a6963d39f735f36dd84d1ff5e14c3");
		return sessionToken;
	}

	
	/**
	 * addQue - Inserts Question object at the end of qlist. 
	 * qlist is the ArrayList of questions containing the question set.  
	 * @param que Type: Question
	 */
	public void addQue(final Question que) {
		qlist.add(que);
	}

	/**
	 * getQuestionAt method returns the question at the passed index.
	 * @param index Type: int. The index of the desired question.
	 * @return qlist element Type: Question. 
	 * The question object at the passed index.
	 */
	public Question getQuestionAt(final int index) {
		return qlist.get(index);
	}

	/**
	 * getQlist method returns an ArrayList of type Question. 
	 * @return qlist Type ArrayList<Question>. A list of question objects to 
	 * be accessed by the UI.
	 */
	public static ArrayList<Question> getQlist() {
		return qlist;
	}


	/**
	 * createYearQue - Uses Tmdb to generate a question 
	 * of type year based on the given keyWord.
	 * @param keyWord - key word for searching
	 * @param score - Score 100-400, usually dependent on difficulty.
	 * @param qType - Question type, ie. guess the year, or Movie or Crew.
	 * @return que - Returns generated question.
	 */
	public Question createYearQue(final String keyWord, final int score) {
		//Variables
		Random rand = new Random();
		
		String queText = "N/a";
		String ans = "A";
		String aText = "0";
		String bText = "0";
		String cText = "0";
		String dText = "0";
		int year = 0;
		int pgNum = 0;
		int randInt1;
		int randInt2; 
		int randInt3;
		int randInt4;
		
		MovieDb queMovie;
		int ID;
			MovieResultsPage results = searchViaTitle(pgNum, keyWord, year);
			
			Iterator<MovieDb> iterator = results.iterator();

			String condition = null;
			do {
				if (!iterator.hasNext()) {
					pgNum++;
					results = searchViaTitle(pgNum, keyWord, year);
				}
				MovieDb movie = iterator.next();
				queMovie = movie;
				ID = queMovie.getId();
				
				
				
				condition = movie.getOverview();
				
				queText = ("This movie where: \n" 
				+ condition
				+ "\nwas/will be released?");
				
				ans = "A";
				
				aText = ("" 
				+ (Integer.parseInt(movie.getReleaseDate().substring(0, 4))));
				
				do{
				randInt1 = rand.nextInt(12) - 6;
				randInt2 = rand.nextInt(12) - 6;
				randInt3 = rand.nextInt(12) - 6;
				} while(randInt1 == randInt2 ||
						randInt1 == randInt3 ||
						randInt2 == randInt3 ||
						randInt1 == 0 ||
						randInt2 == 0 ||
						randInt3 == 0);
				
				bText = ("" + (Integer.parseInt(
						movie.getReleaseDate().substring(0, 4)) + randInt1));
				
				cText = ("" + (Integer.parseInt(
						movie.getReleaseDate().substring(0, 4)) + randInt2));
				
				
				dText = ("" + (Integer.parseInt(
						movie.getReleaseDate().substring(0, 4)) + randInt3));
			
			} while ((condition.equals(null)) && (iterator.hasNext()));

			
		Question que = new Question(queText, 
				           ans, aText, bText, cText, dText, 1, score);
		randomizer(que);
		generateStats(que,ID);
		return que;
	}

///////////////////////////////////////////////////////////////////////////////
	
/**
 * createCastQue - Uses Tmdb to generate a question 
 * of type cast based on the given keyWord.
 * @param keyWord Type: String The keyword used to define search.
 * @param score Type: int The score for the given question.
 * @return
 */
public Question createCastQue(final String keyWord, final int score) {
	    TmdbMovies tmdbMovies = tmdbApi.getMovies();
		//Variables
		
		String queText = "N/a";
		String ans = "A";
		String aText = "0";
		String bText = "0";
		String cText = "0";
		String dText = "0";
		int year = 0;
		int pgNum = 0;
		
		String cast1;
		String cast2;
		String cast3;
		String cast4;
		String cast5;
		String cast6;
		
		int ID;
		
		MovieDb queMovie;
		
		List<PersonCast> castList;
		
		MovieResultsPage results = searchViaTitle(pgNum, keyWord, year);
		
		Iterator<MovieDb> iterator = results.iterator();

		boolean castFound = false;
		
		do {
			if (!iterator.hasNext()) {
				pgNum++;
				results = searchViaTitle(pgNum, keyWord, year);
				iterator = results.iterator();
			}

			 queMovie = iterator.next();
			
			MovieDb movie = queMovie;
			
			
			
			ID = queMovie.getId();
			MovieDb Movie = tmdbMovies.getMovie(ID, "en", MovieMethod.credits, MovieMethod.reviews, MovieMethod.videos);
			
			castList = Movie.getCast();
			if(castList != null){
				castFound = true;
				
				Iterator<PersonCast> castIterator = castList.iterator();
				
				PersonCast person1 = castIterator.next();
				PersonCast person2 = castIterator.next();
				PersonCast person3 = castIterator.next();
				PersonCast person4 = castIterator.next();
				PersonCast person5 = castIterator.next();
				PersonCast person6 = castIterator.next();

				cast1 = person1.getName();
				cast2 = person2.getName();
				cast3 = person3.getName();
				cast4 = person4.getName();
				cast5 = person5.getName();
				cast6 = person6.getName();
				
				queText = ("This movie starred: \n" 
						+ cast1 + ", "
						+ cast2 + ",\n "
						+ cast3 + ", "
						+ cast4 + ",\n "
					    + cast5 + ", and "
					    + cast6 + "\n");
						
				ans = "A";
				
				aText = (queMovie.getTitle() + " " + queMovie.getReleaseDate());
				
				try {
				queMovie = iterator.next();
				} catch(NoSuchElementException ref) {
					pgNum++;
					results = searchViaTitle(pgNum, keyWord, year);
					iterator = results.iterator();
					movie = iterator.next();
				} 

				bText = (queMovie.getTitle() + " " + queMovie.getReleaseDate());
				
				try {
				queMovie = iterator.next();
				} catch(NoSuchElementException ref) {
					pgNum++;
					results = searchViaTitle(pgNum, keyWord, year);
					iterator = results.iterator();
					movie = iterator.next();
				} 
				
				cText = (queMovie.getTitle() + " " + queMovie.getReleaseDate());
			
				try {
				queMovie = iterator.next();
				} catch(NoSuchElementException ref) {
					pgNum++;
					results = searchViaTitle(pgNum, keyWord, year);
					iterator = results.iterator();
					movie = iterator.next();
				} 
						
				dText = (queMovie.getTitle() + " " + queMovie.getReleaseDate());
			}
		} while (!castFound);
		Question que = new Question(queText, 
		           ans, aText, bText, cText, dText, 1, score);
        randomizer(que);
        generateStats(que,ID);
return que;
	}
	/**
	 * searchViaTitle - helper method that returns a page of movies
	 * with the same keyword.
	 * @param pgNum Type: int.
	 * @param key Type: String.
	 * @param year Type: Year.
	 * @return results Type: MovieResultsPage. Page of movies for iteration.
	 */
	private MovieResultsPage searchViaTitle(
				final int pgNum, final String key, final int year) {
		 
		TmdbSearch tmdbSearch = tmdbApi.getSearch();
		MovieResultsPage results
		= tmdbSearch.searchMovie(key, year, "en", false, pgNum);
		
		return results;
	}

	/**
	 * createQSet method creates 20 questions and adds them to the qlist
	 * ArrayList.
	 */
	public void createQSet(QGenerator q) {

		q.addQue(q.createYearQue("Iron Man", 100));
		q.addQue(q.createCastQue("Thor", 200));
		q.addQue(q.createCastQue("Spider Man", 300));
		q.addQue(q.createYearQue("Guardians of the Galaxy", 400));

		q.addQue(q.createCastQue("Cars", 100));
		q.addQue(q.createYearQue("Incredibles", 200));
		q.addQue(q.createYearQue("Bambi", 300));
		q.addQue(q.createCastQue("Toy Story", 400));		

		q.addQue(q.createYearQue("Pirates Worlds End", 100));
		q.addQue(q.createCastQue("Dead Man's Chest", 200));
		q.addQue(q.createYearQue("Curse of the Black Pearl", 300));
		q.addQue(q.createCastQue("Dead Men Tell No Tales", 400));	

		q.addQue(q.createCastQue("Star Wars New Hope", 100));
		q.addQue(q.createYearQue("Force Awakens", 200));
		q.addQue(q.createCastQue("Phantom Menace", 300));
		q.addQue(q.createYearQue("Last Jedi", 400));

		q.addQue(q.createCastQue("Princess Bride", 100));
		q.addQue(q.createYearQue("Hobbit", 200));
		q.addQue(q.createCastQue("Narnia", 300));
		q.addQue(q.createCastQue("Robin Hood", 400));			

	}


	/**
	 * randomizer helper method shuffles the 4 multiple choice strings of a
	 * created Question object while retaining the place of the correct answer. 
	 * @param question Type: Question. The question to be randomized.
	 */
	private static void randomizer(final Question question) {
		Random rand = new Random();

		String ans = question.getCorrectAns();
		String aText = question.getAChoice();
		String bText = question.getBChoice();
		String cText = question.getCChoice();
		String dText = question.getDChoice();
		String temp;
		int i = 0;
		while (i < 20) {
			int seed = rand.nextInt(4) + 1;
			boolean moveAns = false;
			boolean moveOtherAns = false;
			if (seed == 1) {
				seed = rand.nextInt(4) + 1;

				if (ans == "A") {
					moveAns = true;
				}
				if (seed == 2) {
					if (ans == "B") {
						moveOtherAns = true;
					}
					temp = bText;
					bText = aText;
					aText = temp;
					if (moveAns) {
						ans = "B";
					}
					if (moveOtherAns) {
						ans = "A";
					}
				} else if (seed == 3) {
					if (ans == "C") {
						moveOtherAns = true;
					}
					temp = cText;
					cText = aText;
					aText = temp;
					if (moveAns) {
						ans = "C";
					}
					if (moveOtherAns) {
						ans = "A";
					}
				} else if (seed == 4) {
					if (ans == "D") {
						moveOtherAns = true;
					}
					temp = dText;
					dText = aText;
					aText = temp;
					if (moveAns) {
						ans = "D";
					}
					if (moveOtherAns) {
						ans = "A";
					}
				}

			} else if (seed == 2) {
				seed = rand.nextInt(4) + 1;

				if (ans == "B") {
					moveAns = true;
				}

				if (seed == 1) {
					if (ans == "A") {
						moveOtherAns = true;
					}
					temp = aText;
					aText = bText;
					bText = temp;
					if (moveAns) {
						ans = "A";
					}
					if (moveOtherAns) {
						ans = "B";
					}
				} else if (seed == 3) {
					if (ans == "C") {
						moveOtherAns = true;
					}
					temp = cText;
					cText = bText;
					bText = temp;
					if (moveAns) {
						ans = "C";
					}
					if (moveOtherAns) {
						ans = "B";
					}
				} else if (seed == 4) {
					if (ans == "D") {
						moveOtherAns = true;
					}
					temp = dText;
					dText = bText;
					bText = temp;
					if (moveAns) {
						ans = "D";
					}
					if (moveOtherAns) {
						ans = "B";
					}
				}

			} else if (seed == 3) {
				seed = rand.nextInt(4) + 1;

				if (ans == "C") {
					moveAns = true;
				}
				if (seed == 1) {
					if (ans == "A") {
						moveOtherAns = true;
					}
					temp = aText;
					aText = cText;
					cText = temp;
					if (moveAns) {
						ans = "A";
					}
					if (moveOtherAns) {
						ans = "C";
					}
				} else if (seed == 2) {
					if (ans == "B") {
						moveOtherAns = true;
					}
					temp = bText;
					bText = cText;
					cText = temp;
					if (moveAns) {
						ans = "B";
					}
					if (moveOtherAns) {
						ans = "C";
					}
				} else if (seed == 4) {
					if (ans == "D") {
						moveOtherAns = true;
					}
					temp = dText;
					dText = cText;
					cText = temp;
					if (moveAns) {
						ans = "D";
					}
					if (moveOtherAns) {
						ans = "C";
					}
				}

			} else if (seed == 4) {
				seed = rand.nextInt(4) + 1;

				if (ans == "D") {
					moveAns = true;
				}

				if (seed == 1) {
					if (ans == "A") {
						moveOtherAns = true;
					}
					temp = aText;
					aText = dText;
					dText = temp;
					if (moveAns) {
						ans = "A";
					}
					if (moveOtherAns) {
						ans = "D";
					}
				} else if (seed == 2) {
					if (ans == "B") {
						moveOtherAns = true;
					}
					temp = bText;
					bText = dText;
					dText = temp;
					if (moveAns) {
						ans = "B";
					}
					if (moveOtherAns) {
						ans = "D";
					}
				} else if (seed == 3) {
					if (ans == "C") {
						moveOtherAns = true;
					}
					temp = cText;
					cText = dText;
					dText = temp;
					if (moveAns) {
						ans = "C";
					}
					if (moveOtherAns) {
						ans = "D";
					}
				}
			}
			i++;	
		} //END WHILE LOOP

		question.setCorrectAns(ans);
		question.setAChoice(aText);
		question.setBChoice(bText);
		question.setCChoice(cText);
		question.setDChoice(dText);

	}
	
	
	/**generateStats - helper method populates MovieStats object
	 * for the primary movie in question.
	 * @param Type: Question q 
	 */
	private static void generateStats(final Question q, final int id) {
		TmdbMovies tmdbMovies = tmdbApi.getMovies();
		MovieDb m = tmdbMovies.getMovie(id, "en", MovieMethod.credits, MovieMethod.reviews, MovieMethod.videos);

		
		MovieStats stats = new MovieStats();
		stats.setMoviePoster(m.getPosterPath());
		stats.setMovieTitle(m.getTitle());
		stats.setMovieOverview(m.getOverview());
		stats.setCast(m.getCast());
		stats.setTrailers(m.getVideos());
		stats.setReleaseDate(m.getReleaseDate());
		q.setStats(stats);
	}
	
	
//	/**
//	 * 
//	 * @param args ignore this.
//	 */
//	public static void main(final String[] args) {
//		QGenerator q = new QGenerator();
//		q.createQSet();
//		int i = 0;
//		
//		while (i< 20) {
//			System.out.print(q.getQuestionAt(i).toString());
//			
//			i++;
//		}
//		
//	}
	
}


