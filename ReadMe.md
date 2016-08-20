This project is a proof of concept to see if I can get meaningful data out of a hacked EEG toy (http://www.frontiernerds.com/brain-hack).

## Setup ##
THe project interacts with an arduino via a library called RXTX. If you have an Arduino IDE (which this project assumes you do, otherwise how would you have programmed your Arduino to give you EEG data?), you already have the library installed on your computer, you just need to put it in a place your JRE can access. Follow the instructions here: http://playground.arduino.cc/Interfacing/Java

You will also need to edit SerialInputHandler.java (which will look familiar if you folloed that Arduino guide) to add the USB port your EEG is using. Also, if you're using a Raspberry Pi, uncomment the System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0"); line.