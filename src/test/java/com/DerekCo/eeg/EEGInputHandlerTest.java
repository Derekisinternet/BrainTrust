package com.DerekCo.eeg;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Observer;
import java.util.Observable;


public class EEGInputHandlerTest {

	EEGInputHandler handler;

	// used for testing this class's ObservalbeSubject implementations:
	class MockObserver implements Observer{
		String storage;
		private EEGInputHandler eeg_dealy;

		public void update(Observable observable, Object arg) {
			eeg_dealy = (EEGInputHandler) observable;
			storage = eeg_dealy.getMessage();
		}
	}

	@Before
	public void setup() {
		handler = new EEGInputHandler();
		handler.initialize();
	}

	@Test
	public void testObserverList(){
		//instantiate an object that implements Observer:
		MockObserver observer = new MockObserver();
		handler.addObserver(observer);
		assertEquals(1, handler.countObservers());
	}

	//TODO: mock a SerialPortEvent so that I can complete this test.
//	@Test
//	public void testNotifyUpdatesObservers() {
//		String test = "this is a test";
//		MockObserver observer = new MockObserver();
//		handler.addObserver(observer);
//		handler.serialEvent(uh . . . .);
//		assertEquals(test, observer.storage);
//	}

}
