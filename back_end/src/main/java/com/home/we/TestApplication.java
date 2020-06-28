package com.home.we;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(TestApplication.class, args); 
	}
}
