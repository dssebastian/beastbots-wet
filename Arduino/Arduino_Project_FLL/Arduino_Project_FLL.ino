#include <SoftwareSerial.h>

byte statusLed    = 13;

byte sensorInterrupt = 0;  // 0 = digital pin 2
byte sensorPin       = 2;

// The hall-effect flow sensor outputs approximately 4.5 pulses per second per
// litre/minute of flow.
float calibrationFactor = 4.5;

volatile byte pulseCount;  

float flowRate;
unsigned int flowMilliLitres;
unsigned long totalMilliLitres;
int _num = 0;
int LEDPin = 13;
String _inputString = " ";
int totalMinutes = 0;

unsigned long oldTime;

SoftwareSerial BTserial(10, 9); // RX | TX
// Connect the HC-05 TX to Arduino pin 10 RX. 
// Connect the HC-05 RX to Arduino pin 9 TX through a voltage divider.


void setup()
{
  
  // Initialize a serial connection for reporting values to the host
  Serial.begin(9600);
  BTserial.begin(9600);
   
  // Set up the status LED line as an output
  pinMode(statusLed, OUTPUT);
  digitalWrite(statusLed, HIGH);  // We have an active-low LED attached
  
  pinMode(sensorPin, INPUT);
  digitalWrite(sensorPin, HIGH);

  pulseCount        = 0;
  flowRate          = 0.0;
  flowMilliLitres   = 0;
  totalMilliLitres  = 0;
  oldTime           = 0;       

  // The Hall-effect sensor is connected to pin 2 which uses interrupt 0.
  // Configured to trigger on a FALLING state change (transition from HIGH
  // state to LOW state)
  attachInterrupt(sensorInterrupt, pulseCounter, FALLING);
}

/**
 * Main program loop
 */
void loop()
{
  //Serial.println("Serial Moniter is available");
   if(BTserial.available())
   {
    Serial.println("Bluetooth is available");
    while(BTserial.available())
    {
    if((millis() - oldTime) > 60,000)    // Process Repeats once per minute
    { 
      // Disable the interrupt while calculating flow rate and sending the value to
      // the host
      detachInterrupt(sensorInterrupt);
        
      // Because this loop may not complete in exactly 1 second intervals we calculate
      // the number of milliseconds that have passed since the last execution and use
      // that to scale the output. We also apply the calibrationFactor to scale the output
      // based on the number of pulses per second per units of measure (litres/minute in
      // this case) coming from the sensor.
      flowRate = ((1000.0 / (millis() - oldTime)) * pulseCount) / calibrationFactor;
    
      // Note the time this processing pass was executed. Note that because we've
      // disabled interrupts the millis() function won't actually be incrementing right
      // at this point, but it will still return the value it was set to just before
      // interrupts went away.
      oldTime = millis();
    
      // Divide the flow rate in litres/minute by 60 to determine how many litres have
      // passed through the sensor in this 1 second interval, then multiply by 1000 to
      // convert to millilitres.
      flowMilliLitres = (flowRate / 60) * 1000;
      totalMinutes = millis() / 60000;
    
      // Add the millilitres passed in this second to the cumulative total
      totalMilliLitres += flowMilliLitres;
      
      unsigned int frac;
    
      // Print the flow rate for this second in litres / minute
      BTserial.print("Flow rate: ");
      BTserial.print(int(flowRate));  // Print the integer part of the variable
      BTserial.print(".");             // Print the decimal point
      // Determine the fractional part. The 10 multiplier gives us 1 decimal place.
      frac = (flowRate - int(flowRate)) * 10;
      BTserial.print(frac, DEC) ;      // Print the fractional part of the variable
      BTserial.print("L/min");
      // Print the number of litres flowed in this second
      BTserial.print("  Current Liquid Flowing: ");             // Output separator
      BTserial.print(flowMilliLitres);
      BTserial.print("mL/Sec");

      // Print the cumulative total of litres flowed since starting
      BTserial.println("  Output Liquid Quantity: ");             // Output separator
      BTserial.print(totalMilliLitres);
      BTserial.print("mL"); 
      BTserial.println("Total time water has been running:");
      BTserial.print(totalMinutes, "minutes");
      


      Serial.print("Flow rate: ");
      Serial.print(int(flowRate));  // Print the integer part of the variable
      Serial.print(".");             // Print the decimal point
      // Determine the fractional part. The 10 multiplier gives us 1 decimal place.
      Serial.print(frac, DEC) ;      // Print the fractional part of the variable
      Serial.print("L/min");
      // Print the number of litres flowed in this second
      Serial.print("  Current Liquid Flowing: ");             // Output separator
      Serial.print(flowMilliLitres);
      Serial.print("mL/Sec");

      // Print the cumulative total of litres flowed since starting
      Serial.println("  Output Liquid Quantity: ");             // Output separator
      Serial.print(totalMilliLitres);
      Serial.print("mL"); 

      // Reset the pulse counter so we can start incrementing again
      pulseCount = 0;
    
      // Enable the interrupt again now that we've finished sending output
      attachInterrupt(sensorInterrupt, pulseCounter, FALLING);
    }
   }
   }
   else {
    Serial.println("Glitch in Bluetooth");
   }
}

/*
Insterrupt Service Routine
 */
void pulseCounter()
{
  // Increment the pulse counter
  pulseCount++;
}
