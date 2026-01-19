package dev.padel;

import dev.padel.models.ERole;
import dev.padel.models.Role;
import dev.padel.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PadelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadelApplication.class, args);
	}


	@Bean
	CommandLineRunner initRoles(RoleRepository roleRepository) {
		return args -> {
			for (ERole role : ERole.values()) {
				if (!roleRepository.existsByName(role)) {
					roleRepository.save(new Role(role));
					System.out.println("Role créé : " + role);
				}
			}
		};
	}

}
