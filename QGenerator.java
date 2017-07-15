package edu.gvsu.cis350.triviaGame;

import java.util.Iterator;
import java.util.ArrayList;
import info.movito.themoviedbapi.TmdbAccount;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbGenre;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbMovies.MovieMethod;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Reviews;
import info.movito.themoviedbapi.model.Video;
import info.movito.themoviedbapi.model.config.Account;
import info.movito.themoviedbapi.model.core.AccountID;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.core.SessionToken;
import info.movito.themoviedbapi.model.people.PersonCast;
import info.movito.themoviedbapi.model.people.PersonCrew;
import java.util.Random;

public class QGenerator {	
	
	/**
	 * 
	 */
	private static TmdbApi tmdbApi = new TmdbApi("658a202fc0f1e7c9d43bdeaadf192bba");
	
	/**
	 * 
	 */
	private static SessionToken sessionToken = getSessionToken();

	private static  ArrayList<Question> qlist;
	
	/**
	 * Default constructor
	 */
	public QGenerator() {
	   qlist = new ArrayList<Question>();
	    
	}
	
	/**
	 * 
	 * @return
	 */
	public static SessionToken getSessionToken() {
		
		SessionToken sessionToken = new SessionToken("ecf8d70e3b5a6963d39f735f36dd84d1ff5e14c3");
		return sessionToken;
	}
	
	public void addQue(Question que){
		qlist.add(que);
	}
	
	public Question getQuestionAt(int index){
		return qlist.get(index);
	}
	
	public static ArrayList<Question> getQlist() {
		return qlist;
	}
		
	
	public Question createQue (String category, String QType) {
		TmdbSearch tmdbSearch = tmdbApi.getSearch();
		
		//Variables
		
		String queText = "N/a";
		String ans = "A";
		String aText = "0";
		String bText = "0";
		String cText = "0";
		String dText = "0";
		int year = 0;
		
		
		if (QType == "year"){
			
			int pgNum = 0;
			
			
			MovieResultsPage results = tmdbSearch.searchMovie(category,year, "en", false, pgNum);
			Iterator<MovieDb> iterator = results.iterator();
			
			String condition = null;
			do
			{
				if(!iterator.hasNext()) {
					 pgNum++;
					 results = tmdbSearch.searchMovie(category,year, "en", false, pgNum);
				}

				MovieDb movie = iterator.next();
				 condition = movie.getOverview();
				 queText = ("This movie where: \n" + movie.getOverview() + "\nwas/will be released in?");
				 ans = "A";
				 aText = ("" + (Integer.parseInt(movie.getReleaseDate().substring(0,4))));
				 bText = ("" + (Integer.parseInt(movie.getReleaseDate().substring(0,4))+1));
				 cText = ("" + (Integer.parseInt(movie.getReleaseDate().substring(0,4))-1));
				 dText = ("" + (Integer.parseInt(movie.getReleaseDate().substring(0,4))-2));
			} while ((condition == null) && (iterator.hasNext())) ;
			
		}
		Question que = new Question(queText, ans, aText, bText, cText, dText,1);
		randomizer(que);
		return que;
	}
	
	public void createQSet() {
		QGenerator q = new QGenerator();
		
		q.addQue(q.createQue("Iron Man", "year"));
		q.addQue(q.createQue("Thor", "year"));
		q.addQue(q.createQue("Spider Man", "year"));
		q.addQue(q.createQue("Guardians of the Galaxy", "year"));
		
		q.addQue(q.createQue("Cars", "year"));
		q.addQue(q.createQue("Incredibles", "year"));
		q.addQue(q.createQue("Bambi", "year"));
		q.addQue(q.createQue("Toy Story", "year"));		
		
		q.addQue(q.createQue("Worlds End", "year"));
		q.addQue(q.createQue("Dead Man's Chest", "year"));
		q.addQue(q.createQue("Curse of the Black Pearl", "year"));
		q.addQue(q.createQue("Dead Men Tell No Tales", "year"));	
		
		q.addQue(q.createQue("New Hope", "year"));
		q.addQue(q.createQue("Force Awakens", "year"));
		q.addQue(q.createQue("Phantom Menace", "year"));
		q.addQue(q.createQue("Last Jedi", "year"));
		
		q.addQue(q.createQue("Princess Bride", "year"));
		q.addQue(q.createQue("Hobbit", "year"));
		q.addQue(q.createQue("Narnia", "year"));
		q.addQue(q.createQue("Toy Story", "year"));			
		
	}
	
	
	
	private static void randomizer (Question question) {
        Random rand = new Random();
		
		String ans = question.getCorrectAns();
		String aText = question.getAChoice();
		String bText = question.getBChoice();
		String cText = question.getCChoice();
		String dText = question.getDChoice();
		String temp;
		int i = 0;
		while (i < 10) {
			int seed = rand.nextInt(4) + 1;
			boolean moveAns = false;
			boolean moveOtherAns = false;
			if (seed == 1) {
				seed = rand.nextInt(4) + 1;

				if (ans == "A")
					moveAns = true;

				if (seed == 2) {
					if(ans == "B")
						moveOtherAns = true;
					temp = bText;
					bText = aText;
					aText = temp;
					if (moveAns) {
						ans = "B";
					}
					if (moveOtherAns){
						ans = "A";
					}
				} else if (seed == 3) {
					if(ans == "C")
						moveOtherAns = true;
					temp = cText;
					cText = aText;
					aText = temp;
					if (moveAns) {
						ans = "C";
					}
					if (moveOtherAns){
						ans = "A";
					}
				} else if (seed == 4) {
					if(ans == "D")
						moveOtherAns = true;
					temp = dText;
					dText = aText;
					aText = temp;
					if (moveAns) {
						ans = "D";
					}
					if (moveOtherAns){
						ans = "A";
					}
				}

			} else if (seed == 2) {
				seed = rand.nextInt(4) + 1;

				if (ans == "B")
					moveAns = true;

				if (seed == 1) {
					if(ans == "A")
						moveOtherAns = true;
					temp = aText;
					aText = bText;
					bText = temp;
					if (moveAns) {
						ans = "A";
					}
					if (moveOtherAns){
						ans = "B";
					}
				} else if (seed == 3) {
					if(ans == "C")
						moveOtherAns = true;
					temp = cText;
					cText = bText;
					bText = temp;
					if (moveAns) {
						ans = "C";
					}
					if (moveOtherAns){
						ans = "B";
					}
				} else if (seed == 4) {
					if(ans == "D")
						moveOtherAns = true;
					temp = dText;
					dText = bText;
					bText = temp;
					if (moveAns) {
						ans = "D";
					}
					if (moveOtherAns){
						ans = "B";
					}
				}

			} else if (seed == 3) {
				seed = rand.nextInt(4) + 1;

				if (ans == "C")
					moveAns = true;

				if (seed == 1) {
					if(ans == "A")
						moveOtherAns = true;
					temp = aText;
					aText = cText;
					cText = temp;
					if (moveAns) {
						ans = "A";
					}
					if (moveOtherAns){
						ans = "C";
					}
				} else if (seed == 2) {
					if(ans == "B")
						moveOtherAns = true;
					temp = bText;
					bText = cText;
					cText = temp;
					if (moveAns) {
						ans = "B";
					}
					if (moveOtherAns){
						ans = "C";
					}
				} else if (seed == 4) {
					if(ans == "D")
						moveOtherAns = true;
					temp = dText;
					dText = cText;
					cText = temp;
					if (moveAns) {
						ans = "D";
					}
					if (moveOtherAns){
						ans = "C";
					}
				}

			} else if (seed == 4) {
				seed = rand.nextInt(4) + 1;

				if (ans == "D")
					moveAns = true;

				if (seed == 1) {
					if(ans == "A")
						moveOtherAns = true;
					temp = aText;
					aText = dText;
					dText = temp;
					if (moveAns) {
						ans = "A";
					}
					if (moveOtherAns){
						ans = "D";
					}
				} else if (seed == 2) {
					if(ans == "B")
						moveOtherAns = true;
					temp = bText;
					bText = dText;
					dText = temp;
					if (moveAns) {
						ans = "B";
					}
					if (moveOtherAns){
						ans = "D";
					}
				} else if (seed == 3) {
					if(ans == "C")
						moveOtherAns = true;
					temp = cText;
					cText = dText;
					dText = temp;
					if (moveAns) {
						ans = "C";
					}
					if (moveOtherAns){
						ans = "D";
					}
				}
			}
		  i++;	
		}//END WHILE LOOP
		
		 question.setCorrectAns(ans);
		 question.setAChoice(aText);
		 question.setBChoice(bText);
		 question.setCChoice(cText);
		 question.setDChoice(dText);
		
	}
	
	public static void main(final String[] args) {	
		QGenerator q = new QGenerator();
		
		q.addQue(q.createQue("Cars", "year"));
		q.addQue(q.createQue("Star Wars", "year"));
		q.addQue(q.createQue("Spider Man", "year"));
		
		System.out.println(q.getQuestionAt(0).toString());
		System.out.println(q.getQuestionAt(1).toString());
		System.out.println(q.getQuestionAt(2).toString());
		
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


