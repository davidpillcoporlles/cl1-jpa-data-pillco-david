package pe.edu.i202221115.cl1_jpa_data_pillco_david;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import pe.edu.i202221115.cl1_jpa_data_pillco_david.entity.CountryLanguage;
import pe.edu.i202221115.cl1_jpa_data_pillco_david.entity.CountryLanguageId;
import pe.edu.i202221115.cl1_jpa_data_pillco_david.repository.CountryRepository;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataPillcoDavidApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataPillcoDavidApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CountryLanguageId peruId = new CountryLanguageId("PER", "Español");

// Buscar por el ID compuesto de Perú
		Optional<CountryLanguageId> optionalPeru = countryRepository.findById("Peru");

		optionalPeru.ifPresentOrElse(
				(peruItem) -> {
					// Si se encuentra, imprimir los lenguajes
					System.out.println("Lenguajes hablados en Perú:");
					System.out.println(peruItem.getLanguage());
				},
				() -> {
					// Si no se encuentra, buscar el país "ARG" (Argentina) de manera similar
					CountryLanguageId argentinaId = new CountryLanguageId("ARG", "Español");
					Optional<CountryLanguageId> optionalArgentina = countryRepository.findById("ARG");

					optionalArgentina.ifPresentOrElse(
							(argentinaItem) -> {
								System.out.println("Lenguajes hablados en Argentina:");
								System.out.println(argentinaItem.getLanguage());
							},
							() -> {
								// Si no se encuentra ni "ARG" ni "PER", imprimir mensaje
								System.out.println("Lenguajes no encontrados para Argentina ni Perú.");
							}
					);
				}
		);
	}
}