#include <nRF24L01.h>
#include <RF24.h>
#include <RF24_config.h>
#include <SPI.h>

float msg[1];
RF24 radio(8,7); //CE, CSN
const uint64_t pipe = 0xE8E8F0F0E1LL;


void setup() {
  // put your setup code here, to run once:
  radio.begin();
  radio.openWritingPipe(pipe);

}

void loop(void) {
  // put your main code here, to run repeatedly:
  msg[0] = 2.0;
  radio.write(msg, 1);

}
