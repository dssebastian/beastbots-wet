#include "DHT.h"

#define DHTPIN 2

#define DHTTYPE DHT11

DHT dht(DHTPIN, DHTTYPE);

void setup() {

  Serial.begin(9600);

  while (!Serial) { }
  Serial.println("Starting Temperature Moniter");
  dht.begin();
 
}

void loop() {
  delay(5000);

  float t = dht.readTemperature();
  float h = dht.readHumidity();


  Serial.print("Temperature:");
  Serial.print(t);
  Serial.println(" *C");
  Serial.print("Humidity:");
  Serial.print(h);
  Serial.println("%");
  

}
