package zad1;

import java.util.ArrayList;

public class Letters{
	
	ArrayList<Thread> tab = new ArrayList<Thread>();
	String ciag;
	
	
	public Letters(String ciag) {
		for(int i = 0 ; i < ciag.length();i++) {
			String letter = ciag.substring(i,i+1);
		
		
		
		Runnable myThreads = () ->{
			while(!Thread.currentThread().isInterrupted()) {
				try {
					System.out.print(letter);
					Thread.sleep(1000);
				}catch(InterruptedException e) {
				
				}
			}
		};
		
	tab.add(new Thread(myThreads, "Thread " + letter));
	}
	}
		
		public ArrayList<Thread> getThreads(){
			return tab;
		}
		
		
		
		
	

}
