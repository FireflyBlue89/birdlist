package app.birdlist;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.awt.Desktop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BirdlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirdlistApplication.class, args);
	}	
}
