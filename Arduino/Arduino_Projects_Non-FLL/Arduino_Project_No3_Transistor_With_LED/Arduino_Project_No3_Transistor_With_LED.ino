
int LEDPin = 2;
int TransistorPin = 5;
void setup() {
  pinMode(LEDPin, OUTPUT);
  pinMode(TransistorPin, OUTPUT);
  

 

}

void loop() {
  // put your main code here, to run repeatedly:

  digitalWrite(LEDPin, HIGH);
  delay(500);
  analogWrite(TransistorPin, 200);
  delay(500);
  digitalWrite(LEDPin, LOW);
  delay(500);
  analogWrite(TransistorPin, 0);
  delay(500);

}
