package com.library.apiLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ApiLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiLibraryApplication.class, Arrays.toString(args));
	}

}
