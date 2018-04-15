#include <nRF24L01.h>
#include <RF24.h>
#include <RF24_config.h>
#include <SPI.h>

int msg[1];
RF24 radio(53, 48); //CE, CSN
const uint64_t pipe = 0xE8E8F0F0E1LL;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  radio.begin();
   radio.openReadingPipe(1,pipe);
   radio.startListening();

}

void loop() {
  if (radio.available()) {
    bool endOfMsg = false;
    while (!endOfMsg)
    {
      endOfMsg = radio.read(msg, 1);
      Serial.println (msg[0]);
    }
  }


}
