package hu.nye.fitnessSite;

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
	CommandLineRunner futo(){
		return args -> {
				Futas futas = new Futas(1, "Első futás", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 1.3, Helye.KINT);
				log.info("Futás: " + futas);
		};
	}

	@Bean
	CommandLineRunner suly(){
		return args -> {
			SulyEmeles suly = new SulyEmeles(1, 210, 3, 20, Tipusa.EGYKEZES);
			log.info("Sulyok: " + suly);
		};
	}

	@Bean
	CommandLineRunner kaloria(){
		return args -> {
			KaloriaBevitel bevi = new KaloriaBevitel(1, 10, 105, 21, 0);
			log.info("Kalóriák: " + bevi);
		};
	}

}
