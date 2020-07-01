## Arduino를 활용한 스마트홈 프로젝트
    Arduino를 wifi 통신을 이용하여 스마트홈 제어  
    -> 이를 통해 모바일에서 스마트홈 제어 가능  
    -> 센서를 통해 측정된 데이터(온습도 및 조도)를 가공 가능  

### back_end에서 가상환경에 접속 
        
    back_end 폴더를 spring에서 import 
    File -> import -> General -> Existiong Projects into Workspace -> 
    Select root directory -> back_end 폴더 등록
    
    오른쪽 아래 다운로드 대기
    
    back_end or test 오른쪽 클릭 -> Run As -> Spring Boot App 실행
    
    src/main/java
        com.test.web
            restHomeController.java 확인

### front_end 

    visual studio code실행
    
    터미널
    ->npm install
    -> npm run dev
        
    src
        components
            main.vue 확인
    
