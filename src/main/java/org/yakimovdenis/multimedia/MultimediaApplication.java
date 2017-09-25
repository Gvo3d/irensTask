package org.yakimovdenis.multimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yakimovdenis.multimedia.service.CommandsService;


@SpringBootApplication
public class MultimediaApplication implements CommandLineRunner {

	@Autowired
	private CommandsService commandsService;

	public static void main(String[] args) {
		SpringApplication.run(MultimediaApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

	}
}
