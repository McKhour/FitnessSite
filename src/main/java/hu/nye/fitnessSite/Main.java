package hu.nye.fitnessSite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
	/*
	@Bean
	CommandLineRunner testFelh(FelhasznaloRepository felhasznaloRepo, FutasRepository futasRepo, KaloriaBevitelRepository bevitelRepo, SulyEmelesRepository sulyRepo){
		return args -> {
			Felhasznalo felhasznalo = new Felhasznalo();
			//felhasznalo.setId(null);
			felhasznalo.setKeresztNev("Péter");
			felhasznalo.setVezetekNev("Janklovics");
			felhasznalo.setEmail("janklapics@magic.black");
			felhasznalo.setEletkor(45);
			felhasznalo.setTestSuly(109);

			felhasznalo = felhasznaloRepo.save(felhasznalo);
			System.out.println("Mentett felhasználó id: " + felhasznalo.getId());

			Futas futas = new Futas();
			futas.setFelhasznalo(felhasznalo);
			futas.setFutasCim("Reggeli kocogás");
			futas.setFutasKezd(LocalDateTime.now());
			futas.setFutasVeg(LocalDateTime.now().plusMinutes(30));
			futas.setKilometer(1.5);
			futas.setHelye(Helye.KINT);

			futas = futasRepo.save(futas);
			System.out.println("A mentett futás címe: " + futas.getFutasCim());

			KaloriaBevitel bevitel = new KaloriaBevitel();
			bevitel.setFelhasznalo(felhasznalo);
			bevitel.setZsir(12);
			bevitel.setSzenhidrat(132);
			bevitel.setFeherje(78);
			bevitel.setViz(125);

			bevitel = bevitelRepo.save(bevitel);
			System.out.println("Kalória Bevitel feltöltve");

			SulyEmeles suly = new SulyEmeles();
			suly.setFelhasznalo(felhasznalo);
			suly.setSuly(100);
			suly.setSzettek(15);
			suly.setRepek(20);
			suly.setTipusa(Tipusa.KETKEZES);

			suly = sulyRepo.save(suly);
			System.out.println("Súly emelés feltöltve");
		};
	}

	 */
}
