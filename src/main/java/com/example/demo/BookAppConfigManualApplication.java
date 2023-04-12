package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@SpringBootApplication
public class BookAppConfigManualApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookAppConfigManualApplication.class, args);
	}
		
	@Override
	public void run(String... args) throws Exception {
		bookService.save(new Book("500", "Core Java", 200, "Kathy Sierra", 1065.5));
		bookService.save(new Book("501", "JSP & Servlets", 350, "Kathy Sierra", 1749.0));
	 // mt.save(new Book(501, "JSP & Servlets", 350, "Kathy Sierra", 1749.0),"Book"); // save () with collection name 'Book'
		bookService.save(new Book("502", "Spring in Action", 480, "Craig Walls", 940.75));
		bookService.save(new Book("503", "Pro Angular", 260, "Freeman", 1949.25));
		bookService.save(new Book("504", "HTML CSS", 100, "Thomas Powell", 2317.09));
		bookService.save(new Book("505", "Hibernate in Action", 180, "Gavin King", 889.25));
		bookService.save(new Book("506", "Practical MongoDB", 180, "Shakuntala Gupta", 785.0));
		bookService.save(new Book("507", "Pro Spring Boot", 850, "Felipe Gutierrez", 2167.99));
		bookService.save(new Book("508", "Beginning jQuery", 180, "Franklin", 1500.00));
		bookService.save(new Book("509", "Java Design Patterns", 114, "Devendra Singh", 919.99));

	    System.out.println("------All records has been saved successfully-------");
		
	}

}
