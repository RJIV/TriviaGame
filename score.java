package project;
/**
 * Score entity class contains information regarding the score of a single
 * trivia game. Made into class to pass score between classes. 
 * 
 * @author Zhen Lu
 *
 */
public class Score {
	/**
	 * player1 int holds the score for player 1.
	 */
	private int player1;
	/**
	 * player2 int holds the score for player 2.
	 */
	private int player2;
	/**
	 * player3 int holds the score for player 3.
	 */
	private int player3;
	
	/**
	 * Increments player 1's score by passed amount.
	 * @param s Type: int. Score value from question can be - or +.
	 */
	public void setplayer1(final int s) {
		this.player1 = s + this.player1;
	}
	
	/**
	 * Increments player 2's score by passed amount.
	 * @param s Type: int. Score value from question can be - or +.
	 */
	public void setplayer2(final int s) {
		this.player2 = s + this.player2;
	}
	
	/**
	 * Increments player 3's score by passed amount.
	 * @param s Type: int. Score value from question can be - or +.
	 */
	public void setplayer3(final int s) {
		this.player3 = s + this.player3;
	}
	
	/**
	 * Returns player 1's score.
	 * @return player1 Type: int. Player 1's cumulative score.
	 */
	public int getplayer1() {
		return player1;
	}
	
	/**
	 * Returns player 2's score.
	 * @return player2 Type: int. Player 2's cumulative score.
	 */
	public int getplayer2() {
		return player2;
	}
	
	/**
	 * Returns player 3's score.
	 * @return player1 Type: int. Player 3's cumulative score.
	 */
	public int getplayer3() {
		return player3;
	}
	
	/**
	 * Method resets player scores.
	 */
	public void clearScore() {
		this.player1 = 0;
		this.player2 = 0;
		this.player3 = 0;
	}
	
	/**
	 * Constructor initializes all player scores to zero.
	 */
	public Score() {
		
		player1 = 0;
		player2 = 0;
		player3 = 0;
		
	}
}
