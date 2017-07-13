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
	protected String Category;
	
	/** Default constructor */
	public Question() {
		this.Que = "What is my favorite movie?";
		this.CorrectAns = "C"; //FIXME: Randomize this answer and therefore the order of answers.
		this.UserAns = "Null";
		this.AChoice = "Star Wars 4";
		this.BChoice = "Star Wars 2";
		this.CChoice = "Star Wars 7";
		this.DChoice = "Star Wars 1";
		this.Category = "Star Wars";

	}

	/**Returns Question */
	public String getQue() {
		return Que;
	}

	public void setQue(String que) {
		Que = que;
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

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}
	
	/** checkAnswer - Returns true if user answer is the same as the correct answer*/
	
	public boolean checkAnswer () {
		boolean correct = false;
		if (this.getUserAns() == (this.getCorrectAns())) 
			correct = true;
		
		return correct;
	}
	
}
