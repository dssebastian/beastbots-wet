
int LEDPin = 5;

int PhotoResistorPin = A3;

void setup() {
  Serial.begin(9600);

  pinMode(LEDPin, OUTPUT);

}

void loop() {
  int Value = analogRead(PhotoResistorPin);

  float Voltage = (Value / 1024.0) * 5.0;

  Serial.print("Sampled Voltage: ");

  Serial.println(Voltage);

  float Darkness = 5.0 - Voltage;

  //analogWrite(LEDPin, (1023 - Value) / 15);
 

  
}
