package com.rbs.repoattestation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RepoAttestationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepoAttestationApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RepoAttestationApplication.class);
	}

}
