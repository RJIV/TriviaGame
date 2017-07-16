
package edu.gvsu.cis350.triviaGame;
//Zhen's: package project;

public class score {
	private int player1;
	private int player2;
	private int player3;
	
	public void setplayer1(int s){
		this.player1 = s + this.player1;
	}
	public void setplayer2(int s){
		this.player2 = s + this.player2;
	}
	public void setplayer3(int s){
		this.player3 = s + this.player3;
	}
	public int getplayer1(){
		return player1;
	}
	public int getplayer2(){
		return player2;
	}
	public int getplayer3(){
		return player3;
	}
	
	public void clearScore() {
		this.player1 = 0;
		this.player2 =0;
		this.player3 =0;
	}
	public score(){
		
		player1 = 0;
		player2 =0;
		player3 =0;
		
	}
}
