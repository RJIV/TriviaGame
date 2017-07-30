package edu.gvsu.cis350.triviaGame;


/**
 * 
 * @author Joseph Dubois
 * Question entity class contains all the information associated wiht a single
 * jeopardy style trivia question.
 *
 */
public class Question {
	
	/**The Prompted question. */
	private String que;
	
	/**The single character answer to the question.*/
	private String correctAns;
	
	/**The user's guessed answer to the question.*/
	private String userAns;
	
	/**The A choice.*/
	private String aChoice;
	
	/**The B choice.*/
	private String bChoice;
	
	/**The C choice.*/
	private String cChoice;
	
	/**The D choice.*/
	private String dChoice;
	
	/**The Category of the question.*/
	private int category;
	
	/**The score of the question.*/
	private int score;
	
	/**The score of the question.*/
	private String posterPath;
	
	/** Default constructor.*/
	public Question() {
		this.que = "What is my favorite movie?";
		this.correctAns = "C"; 
		this.userAns = "Null";
		this.aChoice = "Star Wars 4";
		this.bChoice = "Star Wars 2";
		this.cChoice = "Star Wars 7";
		this.dChoice = "Star Wars 1";
		this.category = 1;
		this.posterPath = null;
	}
	
	/**
	 * Constructor where field is parameter defined.
	 * @param question Type: String. Holds question text.
	 * @param ansKey Type: String. Holds correct answer option A,B,C,D 
	 * @param ansA Type: String. A option text.
	 * @param ansB Type: String. B option text.
	 * @param ansC Type: String. C option text.
	 * @param ansD Type: String. D option text.
	 * @param category Type: String. Category of question can be a keyword.
	 * @param score Type: int.
	 */
	public Question(final String question, 
			        final String ansKey, 
			        final String ansA, 
			        final String ansB, 
			        final String ansC, 
			        final String ansD, 
			        final int category, 
			        final int score,
			        final String path) {
		this.que = question;
		this.correctAns = ansKey; 
		this.userAns = null;
		this.aChoice = ansA;
		this.bChoice = ansB;
		this.cChoice = ansC;
		this.dChoice = ansD;
		this.category = category;
		this.score = score;
		this.posterPath = path;

	}
	
	/**Returns posterPath.
	 * @return posterPath Type: String. File path of movie poster image. */
	public String getMoviePoster() {
		return posterPath;
	}

	/**
	 * Sets question text.
	 * @param que Type String. File path of movie poster image.
	 */
	public void setMoviePoster(final String path) {
		this.posterPath = path;
	}

	/**Returns Question.
	 * @return que Type: String. Returns question text. */
	public String getQue() {
		return que;
	}

	/**
	 * Sets question text.
	 * @param que Type String. Question text.
	 */
	public void setQue(final String que) {
		this.que = que;
	}
	
	/**
	 * Returns score of question.
	 * @return score Type: int
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets score of question.
	 * @param score Type: int.
	 */
	public void setScore(final int score) {
		this.score = score;
	}
	
	/**Returns Correct Answer. 
	 * @return correctAns Type: String.
	 */
	public String getCorrectAns() {
		return correctAns;
	}

	/**
	 * Sets correct ans.
	 * @param correctAns Type: String.
	 */
	public void setCorrectAns(final String correctAns) {
		this.correctAns = correctAns;
	}

	/**
	 * Returns users guessed answer..
	 * @return userAns TypeString.
	 */
	public String getUserAns() {
		return userAns;
	}

	/**
	 * Set users guessed answer.
	 * @param userAns Type: String
	 */
	public void setUserAns(final String userAns) {
		this.userAns = userAns;
	}

	/**
	 * Returns text for the A choice.
	 * @return aChoice Type: String.
	 */
	public String getAChoice() {
		return aChoice;
	}

	/**
	 * Sets text for the A choice.
	 * @param aChoice Type: String.
	 */
	public void setAChoice(final String aChoice) {
		this.aChoice = aChoice;
	}
	/**
	 * Returns text for the B choice.
	 * @return bChoice Type: String.
	 */
	public String getBChoice() {
		return bChoice;
	}

	/**
	 * Sets text for the B choice.
	 * @param bChoice Type: String.
	 */
	public void setBChoice(final String bChoice) {
		this.bChoice = bChoice;
	}
	/**
	 * Returns text for the C choice.
	 * @return cChoice Type: String.
	 */
	public String getCChoice() {
		return cChoice;
	}

	/**
	 * Sets text for the C choice.
	 * @param cChoice Type: String.
	 */
	public void setCChoice(final String cChoice) {
		this.cChoice = cChoice;
	}

	/**
	 * Returns text for the D choice.
	 * @return dChoice Type: String.
	 */
	public String getDChoice() {
		return dChoice;
	}

	/**
	 * Sets text for the D choice.
	 * @param dChoice Type: String.
	 */
	public void setDChoice(final String dChoice) {
		this.dChoice = dChoice;
	}

	/**
	 * Returns category text. Could be a keyword or genre.
	 * @return category Type: String.
	 */
	public int getCategory() {
		return category;
	}

	/**
	 * Sets text for the category.
	 * @param category Type: String.
	 */
	public void setCategory(final int category) {
		this.category = category;
	}
	
/**
 * Returns true if the user answer is the same as the correct answer.
 * False if otherwise.
 * @return correct Type: boolean.
 */
	public boolean checkAnswer() {
		boolean correct = false;
		if ((this.getUserAns()).equals(this.getCorrectAns())) {
			correct = true;
		}
		return correct;
	}
	
    @Override
    /**
     * Overridden toString method primarily for testing purposes.
     */
    public String toString() {
    	String str = ("Question: " + que + "\nA:" + aChoice + "\nB: " + bChoice 
    					+ "\nC: " + cChoice + "\nD: " + dChoice 
    					+ "\nAnswer: " + correctAns + "\n\n");
        return str;
    }
	
}
