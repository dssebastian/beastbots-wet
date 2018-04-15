//www.elegoo.com
//2016.12.08

void setup()
{
pinMode(7, OUTPUT);
pinMode(5, OUTPUT);
pinMode(3, OUTPUT);
}

void loop()
{

digitalWrite(3, HIGH);
delay(200);
digitalWrite(3, LOW); 

digitalWrite(5, HIGH);
delay(200);
digitalWrite(5, LOW);

digitalWrite(7, HIGH);
delay(200);
digitalWrite(7, LOW);

delay(1000);
}


