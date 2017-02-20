This project is a proof of concept to see if I can get meaningful data out of a hacked EEG toy (http://www.frontiernerds.com/brain-hack).

## Setup ##
The project interacts with an arduino via a library called RXTX. I've included it in the POM, but if you run into any issues, you can find more information about setting up the library manually here: http://playground.arduino.cc/Interfacing/Java

You will also need to edit SerialInputHandler.java (which will look familiar if you followed that Arduino guide) to add the USB port your EEG is using. Also, if you're using a Raspberry Pi, uncomment the System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0"); line.
