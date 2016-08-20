// This entire class was basically cribbed from the Arduino Playground article
// on interactions with Java:
// http://playground.arduino.cc/Interfacing/Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import java.util.Enumeration;

public class SerialInputHandler implements SerialPortEventListener {
	SerialPort serialPort;
	

}