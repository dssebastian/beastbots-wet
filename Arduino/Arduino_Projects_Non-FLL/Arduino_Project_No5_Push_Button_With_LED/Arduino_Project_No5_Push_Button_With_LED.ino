

int pushButtonPin = 7;
int buttonState = LOW;
int LEDPin = 2;

void setup() {
  pinMode(pushButtonPin, INPUT);
  pinMode(LEDPin, OUTPUT);  
}

void loop() {
  // put your main code here, to run repeatedly:
  buttonState = digitalRead(pushButtonPin);
  if(buttonState == HIGH) {

    digitalWrite(LEDPin, HIGH);
  }

    else{
      digitalWrite(LEDPin, LOW);
    }
  

}
