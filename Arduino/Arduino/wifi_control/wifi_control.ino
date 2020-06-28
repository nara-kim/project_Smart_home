#include <ESP8266WiFi.h>
#include <Servo.h>
 
const char* ssid = "iptime_204";
const char* password = "hello204";

//Servo myservo;
//int sw = 5; //스위치
//int angle = 0; //서보모터의 회전 각도

int servo = 12; //서보(D6)
int flag =1; //블라인드의 상태를 저장

int air =0;
boolean r = false;
boolean g = false;
boolean b = false;
boolean led = false;

int ledPin = 13; //에어컨
int led_R = 4;
int led_G = 0;
int led_B = 2;
WiFiServer server(80);

Servo blind;

void setup() {
  Serial.begin(115200);
  delay(10);
 
  pinMode(ledPin, OUTPUT);
  pinMode(led_R, OUTPUT);
  pinMode(led_G, OUTPUT);
  pinMode(led_B, OUTPUT);
  digitalWrite(ledPin, LOW);
  digitalWrite(led_R, LOW);
  digitalWrite(led_G, LOW);
  digitalWrite(led_B, LOW);

//  blind.attach(servo)
//  myservo.attach(12); //D6번핀
//  PinMode(sw, INPUT_PULLUP);
  blind.attach(servo);
  blind.write(180);

 
  // Connect to WiFi network
  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
 
  WiFi.begin(ssid, password);
 
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
 
  // Start the server
  server.begin();
  Serial.println("Server started");
 
  // Print the IP address
  Serial.print("Use this URL to connect: ");
  Serial.print("http://");
  Serial.print(WiFi.localIP());
  Serial.println("/");
 
}
 
void loop() {
  // Check if a client has connected
  WiFiClient client = server.available();
  if (!client) {
    return;
  }
 
  // Wait until the client sends some data
  Serial.println("new client");
  while(!client.available()){
    delay(1);
  }
 
  // Read the first line of the request
  String request = client.readStringUntil('\r');
  Serial.println(request);
  client.flush();
 
  // Match the request
 
  int value = LOW;
  if (request.indexOf("/post/air") != -1)  {
    if(air==0){
      digitalWrite(ledPin, HIGH);
      air = 1;
    }else{
      digitalWrite(ledPin, LOW);
      air = 0;
    }
  }
  if (request.indexOf("/post/r") != -1)  {
    if(r){
      digitalWrite(led_R, LOW);
      r = false;
    }else{
      digitalWrite(led_R, HIGH);
      r = true;
    }
  }
  
  if (request.indexOf("/post/g") != -1)  {
    if(g){
      digitalWrite(led_G, LOW);
      g = false;
    }else{
      digitalWrite(led_G,HIGH);
      g = true;
    }
  }

  if (request.indexOf("/post/b") != -1)  {
    if(b){
      digitalWrite(led_B, LOW);
      b = false;
    }else{
      digitalWrite(led_B,HIGH);
      b = true;
    }
  }

  if (request.indexOf("/post/led") != -1)  {
    if(led){
      digitalWrite(led_R, LOW);
      digitalWrite(led_G, LOW);
      digitalWrite(led_B, LOW);
      led = false;
    }else{
      digitalWrite(led_R,HIGH);
      digitalWrite(led_G,HIGH);
      digitalWrite(led_B,HIGH);
      led = true;
    }
  }

  if (request.indexOf("/post/5") != -1)  {
    if(flag==0){
      blind.write(180);
      flag = 1;
    }
    else{
      blind.write(80);
      flag = 0;
    }
  }

 
  // Return the response
  client.println("HTTP/1.1 200 OK");
  client.println("Content-Type: text/html");
  client.println(""); //  do not forget this one
  client.println("<!DOCTYPE HTML>");
  client.println("<html>");
 
  client.print("Led pin is now: ");
 
  if(value == HIGH) {
    client.print("On");
  } else {
    client.print("Off");
  }
  client.println("<br><br>");
  client.println("<a href=\"/LED=ON\"\"><button>Turn On </button></a>");
  client.println("<a href=\"/LED=OFF\"\"><button>Turn Off </button></a><br />");  
  client.println("</html>");
 
  delay(1);
  Serial.println("Client disonnected");
  Serial.println("");
 
}
 
