package com.home.we.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class restWeatherController {
	@GetMapping(value = "/weather/{latitude}/{longitude}")
	public @ResponseBody Object weather(@PathVariable String latitude, @PathVariable String longitude) {
		System.out.println("controller??");
		System.out.println(latitude + " " + longitude);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Object> response = restTemplate.getForEntity("https://api.openweathermap.org/data/2.5/weather?lat="
				+ latitude + "&lon=" + longitude + "&appid=a3d201de2306c85110831ef13b2d5ffb&units=metric", Object.class);

		try {
			response = new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		                                                     
		System.out.println(response);
		System.out.println("??");
		
		return response;
	}
	@GetMapping(value = "/getdata")
	public ResponseEntity<String> click() {
		System.out.println("여기??");
		ResponseEntity<String> re = null;
		String lines = "";
		try {
		File file = new File("C:\\Final\\s02p31c111\\back_end\\data\\온습도.txt");
		
		FileReader filereader = new FileReader(file);
        //입력 버퍼 생성
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = "";
        while((line = bufReader.readLine()) != null){
            System.out.println(line);
            lines+=line+" ";
        }
        System.out.println(lines);
        //.readLine()은 끝에 개행문자를 읽지 않는다.            
        bufReader.close();
		}catch (FileNotFoundException e) {
			
		}catch(IOException e) {
			System.out.println(e);
		}
		try {
			re = new ResponseEntity<String>(lines, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("bad", HttpStatus.OK);
		}
		return re;
	}
}
