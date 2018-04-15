#include <SoftwareSerial.h>


String _inputString = " ";
int _num = 0;
int LEDPin = 13;


SoftwareSerial BTserial(10, 9); // RX | TX
// Connect the HC-05 TX to Arduino pin 2 RX. 
// Connect the HC-05 RX to Arduino pin 3 TX through a voltage divider.


void setup() {
  Serial.begin(9600);
  pinMode(LEDPin, OUTPUT);
  BTserial.begin(9600);

}

void loop() {
  if(BTserial.available())
  {
      //Serial.println("Testing");
      //BTserial.println("Testing");

    while(BTserial.available()) 
    {
      char _ch = (char)BTserial.read();
      _inputString += _ch;
    }

    _num = _inputString.toInt();
    if(_num > 0 && _num < 3)
    {
      for (int i = 0; i< _num; i++)
      {
        digitalWrite(LEDPin, HIGH);
        delay(500);
        digitalWrite(LEDPin, LOW);
        delay(500);
      }
      Serial.println("ComputerReceived");
      BTserial.println("PhoneReceived");
      
    }
   
  }

  _inputString = " ";
  _num = 0;
  

}
