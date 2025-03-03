package com.example.pastebin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication()
public class PastebinApplication {

	public static void main(String[] args)  {
		ApplicationContext ctx = SpringApplication.run(PastebinApplication.class, args);
	}
}
