import javax.swing.*;

import java.awt.Component;
import java.util.Timer;
import java.util.*;

public class UnionSqMetronome {
	
//		public static void main ( String [] args ) {
//			Timer timer = new Timer();
//			timer.scheduleAtFixedRate(new TimerTask() {
//				int x = 0;
//				public void run() {
//					System.out.print(x + " \n");
//					x++;
//				}
//			}, 0, 1000);
//				
//		}

    	private final JLabel time = new JLabel();

	    public static void main( String [] args ) {
	        JFrame frame = new JFrame();
	        UnionSqMetronome clock = new UnionSqMetronome();
	        frame.add( clock.time );
	        frame.pack();
	        frame.setVisible( true );
	        clock.start();
	    }

	    public void start(){
	        Timer timer = new Timer();
	        timer.scheduleAtFixedRate(new TimerTask(){
	            public void run(){
	            	
	        		long millisInAnHour = 60*60*1000;
	        		long millisInADay = 24*60*60*1000;  // 86400000;
	        		long millisSinceTodayStartedEST = (System.currentTimeMillis() - (millisInAnHour*4)) % millisInADay; // -4 hours for EST
	        		
	        		int currentMilli = (int)millisSinceTodayStartedEST%1000;
	        		int currentSec = (int)millisSinceTodayStartedEST/1000%60;
	        		int currentMinute = (int)millisSinceTodayStartedEST/1000/60%60;
	        		int currentHour = (int)millisSinceTodayStartedEST/1000/60/60;
	            	
	                time.setText(String.format("%02d%02d%02d%02d%01d%02d%02d%02d", currentHour, currentMinute,
	                		currentSec, currentMilli/10, (999-currentMilli)/100, 59-currentSec, 59-currentMinute, 23-currentHour));
	                
	            }
	        }, 0, 10);
	    }

}






