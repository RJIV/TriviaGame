package project;

import java.util.Timer;
import java.util.TimerTask;

public class Countdown {

	static int sec;
	Timer timer = new Timer();
	private boolean s=false;
	TimerTask task = new TimerTask() {
	

		public void run() {
			
			
			sec--;
			System.out.println(" " + sec);
			if (sec == 0) {
				timer.cancel();
				timer.purge();
				System.out.println("cycle completed");
				s=true;
				return;
			}
		}
	};
	
	public int getsec(){
		return sec;
		
	}
	public void setsec(int s){
		sec = s;
	}
	
	public void start() {

		// timer.scheduleAtFixedRate(task, 1000, 1000);
		timer.schedule(task, 1000, 1000);
		
	}
}
