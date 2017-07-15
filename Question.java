package edu.gvsu.cis350.triviaGame;



public class Question {
	
	/**The Prompted question */
	protected String Que;
	
	/**The single character answer to the question*/
	protected String CorrectAns;
	
	/**The user's guessed answer to the question*/
	protected String UserAns;
	
	/**The A choice*/
	protected String AChoice;
	
	/**The B choice*/
	protected String BChoice;
	
	/**The C choice*/
	protected String CChoice;
	
	/**The D choice*/
	protected String DChoice;
	
	/**The Category of the question*/
	protected int Category;
	
	/**The score of the question*/
	protected int Score;
	
	/** Default constructor */
	public Question() {
		this.Que = "What is my favorite movie?";
		this.CorrectAns = "C"; //FIXME: Randomize this answer and therefore the order of answers.
		this.UserAns = "Null";
		this.AChoice = "Star Wars 4";
		this.BChoice = "Star Wars 2";
		this.CChoice = "Star Wars 7";
		this.DChoice = "Star Wars 1";
		this.Category = 1;

	}
	
	/** Definable constructor*/
	public Question(String question, String ansKey, String ansA, String ansB, String ansC, String ansD, int category, int score) {
		this.Que = question;
		this.CorrectAns = ansKey; //FIXME: Randomize this answer and therefore the order of answers.
		this.UserAns = null;
		this.AChoice = ansA;
		this.BChoice = ansB;
		this.CChoice = ansC;
		this.DChoice = ansD;
		this.Category = category;
		this.Score = score;
		

	}

	/**Returns Question */
	public String getQue() {
		return Que;
	}

	public void setQue(String que) {
		Que = que;
	}
	
	/**Returns Question */
	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}
	
	/**Returns Correct Answer */
	public String getCorrectAns() {
		return CorrectAns;
	}

	public void setCorrectAns(String correctAns) {
		CorrectAns = correctAns;
	}

	/**Returns user answer*/
	public String getUserAns() {
		return UserAns;
	}

	public void setUserAns(String userAns) {
		UserAns = userAns;
	}

	public String getAChoice() {
		return AChoice;
	}

	public void setAChoice(String aChoice) {
		AChoice = aChoice;
	}

	public String getBChoice() {
		return BChoice;
	}

	public void setBChoice(String bChoice) {
		BChoice = bChoice;
	}

	public String getCChoice() {
		return CChoice;
	}

	public void setCChoice(String cChoice) {
		CChoice = cChoice;
	}

	public String getDChoice() {
		return DChoice;
	}

	public void setDChoice(String dChoice) {
		DChoice = dChoice;
	}

	public int getCategory() {
		return Category;
	}

	public void setCategory(int category) {
		Category = category;
	}
	
	/** checkAnswer - Returns true if user answer is the same as the correct answer else returns false.*/
	
	public boolean checkAnswer () {
		boolean correct = false;
		if (this.getUserAns() == (this.getCorrectAns())) 
			correct = true;
		
		return correct;
	}
	
    @Override
    public String toString() {
    	String str = ("Question: " + Que + "\nA:" + AChoice + "\nB: " + BChoice 
    			+ "\nC: " + CChoice + "\nD: " + DChoice + "\nAnswer: " + CorrectAns + "\n\n");
        return str;
    }
	
}
