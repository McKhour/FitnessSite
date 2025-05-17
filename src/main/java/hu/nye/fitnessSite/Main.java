package hu.nye.fitnessSite;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import hu.nye.fitnessSite.felhasznalo.FelhasznaloRepository;
import hu.nye.fitnessSite.futas.Futas;
import hu.nye.fitnessSite.futas.Helye;
import hu.nye.fitnessSite.kaloriaBevitel.KaloriaBevitel;
import hu.nye.fitnessSite.sulyEmeles.SulyEmeles;
import hu.nye.fitnessSite.sulyEmeles.Tipusa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner testFelh(FelhasznaloRepository repo){
		return args -> {
			Felhasznalo felhasznalo = new Felhasznalo(
					null, "Péter", "Janklovics", "janklapics@magic.black", 45, 109
			);
			felhasznalo = repo.save(felhasznalo);
			System.out.println("Mentett felhasználó id: " + felhasznalo.getId());

		};
	}
}
