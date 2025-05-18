package hu.nye.fitnessSite.felhasznalo;

import hu.nye.fitnessSite.futas.Futas;
import hu.nye.fitnessSite.kaloriaBevitel.KaloriaBevitel;
import hu.nye.fitnessSite.sulyEmeles.SulyEmeles;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Felhasznalok")
public class Felhasznalo{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String keresztNev;
        private String vezetekNev;
        private String email;
        private Integer eletkor;
        private Integer testSuly;

        //Mivel ezt használom fő kulcsként a táblázatban be kellet importálnom ezeket is
        @OneToMany(mappedBy = "felhasznalo", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Futas> futasok = new ArrayList<>();

        @OneToMany(mappedBy = "felhasznalo", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<SulyEmeles> sulyemelesek = new ArrayList<>();

        @OneToMany(mappedBy = "felhasznalo", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<KaloriaBevitel> kaloriaBevitelek = new ArrayList<>();

        //külön üres konstruktór hogy JPA tudjon mivel dolgozni
        public Felhasznalo(){}

        //Konstruktor ha nem kell ID-t megadni (Bean-elés)
        public Felhasznalo(String keresztNev, String vezetekNev, String email, Integer eletkor, Integer testSuly) {
                this.keresztNev = keresztNev;
                this.vezetekNev = vezetekNev;
                this.email = email;
                this.eletkor = eletkor;
                this.testSuly = testSuly;
        }

        //Konstruktor ha meg kell adni (szintén bean-elés)
        public Felhasznalo(Long id, String keresztNev, String vezetekNev, String email, Integer eletkor, Integer testSuly) {
                this.id = id;
                this.keresztNev = keresztNev;
                this.vezetekNev = vezetekNev;
                this.email = email;
                this.eletkor = eletkor;
                this.testSuly = testSuly;
        }

        //get set
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getKeresztNev() {
                return keresztNev;
        }

        public void setKeresztNev(String keresztNev) {
                this.keresztNev = keresztNev;
        }

        public String getVezetekNev() {
                return vezetekNev;
        }

        public void setVezetekNev(String vezetekNev) {
                this.vezetekNev = vezetekNev;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Integer getEletkor() {
                return eletkor;
        }

        public void setEletkor(Integer eletkor) {
                this.eletkor = eletkor;
        }

        public Integer getTestSuly() {
                return testSuly;
        }

        public void setTestSuly(Integer testSuly) {
                this.testSuly = testSuly;
        }

        public List<Futas> getFutasok() {
                return futasok;
        }

        public void setFutasok(List<Futas> futasok) {
                this.futasok = futasok;
        }

        public List<SulyEmeles> getSulyemelesek() {
                return sulyemelesek;
        }

        public void setSulyemelesek(List<SulyEmeles> sulyemelesek) {
                this.sulyemelesek = sulyemelesek;
        }

        public List<KaloriaBevitel> getKaloriaBevitelek() {
                return kaloriaBevitelek;
        }

        public void setKaloriaBevitelek(List<KaloriaBevitel> kaloriaBevitelek) {
                this.kaloriaBevitelek = kaloriaBevitelek;
        }
}
