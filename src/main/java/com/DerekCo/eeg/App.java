package com.DerekCo.eeg;


/**
 * Hello world!
 *
 */
public class App {
  public static void main( String[] args ) throws Exception {
//    EEGInputHandler input = new EEGInputHandler();
//    input.initialize();
//    System.out.println( "Initializing . . ." );
//    Thread thread = new Thread() {
//    	public void run() {
//    		//the following line will keep this app alive for 1000 seconds,
//				//waiting for events to occur and responding to them (printing incoming messages to console).
//				try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
//			}
//		};
//		thread.start();
//		System.out.println("Started");
      GuiMain window = new GuiMain();
      window.go();

  }
}
