package com.home.we.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class restMapController {
	@GetMapping(value = "/GetkobisData")
    public @ResponseBody Object callAPI() {
		System.out.println("map 보러 여기왔습니다");
 
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Object> response = restTemplate.getForEntity("//dapi.kakao.com/v2/maps/sdk.js?appkey=6f837e16900cf27936f5d6e6d420e292", Object.class);
		
		System.out.println("??????????");
		
		try {
			response = new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}

		System.out.println(response);
		
        return response;
 
    }
}
