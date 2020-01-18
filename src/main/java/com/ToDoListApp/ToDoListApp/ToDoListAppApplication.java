package com.ToDoListApp.ToDoListApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ToDoListAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListAppApplication.class, args);
		//System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}
