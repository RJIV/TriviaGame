package project;

public class score {
	private int player1;
	private int player2;
	private int player3;
	
	public void setplayer1(int s){
		this.player1 = s;
	}
	public void setplayer2(int s){
		this.player2 = s;
	}
	public void setplayer3(int s){
		this.player3 = s;
	}
	public int getplayer1(){
		return player1;
	}
	public int getplayer2(){
		return player2;
	}
	public int getplayer3(){
		return player2;
	}
	public score(){
		
		player1 = 0;
		player2 =0;
		player3 =0;
		
	}
}
