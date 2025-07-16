package com.scm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.scm.repositories")
public class ScmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScmApplication.class, args);
	}

}


// package com.scm;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.context.annotation.Bean;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import com.scm.entities.*;
// import com.scm.repositories.UserRepository;
// @SpringBootApplication
// @EntityScan("com.scm.entities")
// @EnableJpaRepositories("com.scm.repositories")
// public class ScmApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(ScmApplication.class, args);
// 	}

// 	@Bean
// 	public CommandLineRunner testJpa(UserRepository repo) {
// 		return args -> {
// 			System.out.println("🟢 Users in DB: " + repo.count());
// 		};
// 	}
// }
