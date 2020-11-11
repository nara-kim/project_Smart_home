#include <ESP8266WiFi.h>
#include <Servo.h>
 
const char* ssid = "iptime_204";	//wifi ID
const char* password = "hello204";	//wifi 비번

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
  blind.attach(servo);
  blind.write(180);

 
  //wifi 네트워크와 연결
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
 
  //서버 시작
  server.begin();
  Serial.println("Server started");
 
  //IP주소 출력
  Serial.print("Use this URL to connect: ");
  Serial.print("http://");
  Serial.print(WiFi.localIP());
  Serial.println("/");
 
}
 
void loop() {
  //클라이언트와 연결되어있는지 확인
  WiFiClient client = server.available();
  if (!client) {
    return;
  }
 
  //클라이언트가 데이터를 보내기 전까지 기다림
  Serial.println("new client");	//클라이언트가 접근하면 출력
  while(!client.available()){	//클라이언트가 접근했을때 while문 빠져나옴
    delay(1);
  }
 
  //요청을 읽어서 request변수에 저장함
  String request = client.readStringUntil('\r');
  Serial.println(request);
  client.flush();
 
  //요청에 맞는 주소에 따라 실행시키기
 
  int value = LOW;
  if (request.indexOf("/post/air") != -1)  {
    if(air==0){
      digitalWrite(ledPin, HIGH);	//0이면 에어컨 켜짐
      air = 1;
    }else{
      digitalWrite(ledPin, LOW);	//0이 아니면 에어컨 꺼짐
      air = 0;
    }
  }
  
  //빨간전등
  if (request.indexOf("/post/r") != -1)  {
    if(r){
      digitalWrite(led_R, LOW);	//빨간불꺼짐
      r = false;
    }else{
      digitalWrite(led_R, HIGH);	//빨간불켜짐
      r = true;
    }
  }
  
  //초록전등
  if (request.indexOf("/post/g") != -1)  {
    if(g){
      digitalWrite(led_G, LOW);
      g = false;
    }else{
      digitalWrite(led_G,HIGH);
      g = true;
    }
  }

  //파란전등
  if (request.indexOf("/post/b") != -1)  {
    if(b){
      digitalWrite(led_B, LOW);
      b = false;
    }else{
      digitalWrite(led_B,HIGH);
      b = true;
    }
  }

  //전등
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

  //블라인드
  if (request.indexOf("/post/5") != -1)  {
    if(flag==0){
      blind.write(180);	//블라인드 닫힘
      flag = 1;
    }
    else{
      blind.write(80);	//블라인드 켜짐
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
 
