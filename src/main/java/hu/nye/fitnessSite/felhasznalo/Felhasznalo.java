package hu.nye.fitnessSite.felhasznalo;

import jakarta.persistence.*;

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

        public Felhasznalo(){}

        public Felhasznalo(String keresztNev, String vezetekNev, String email, Integer eletkor, Integer testSuly) {
                this.keresztNev = keresztNev;
                this.vezetekNev = vezetekNev;
                this.email = email;
                this.eletkor = eletkor;
                this.testSuly = testSuly;
        }

        public Felhasznalo(Long id, String keresztNev, String vezetekNev, String email, Integer eletkor, Integer testSuly) {
                this.id = id;
                this.keresztNev = keresztNev;
                this.vezetekNev = vezetekNev;
                this.email = email;
                this.eletkor = eletkor;
                this.testSuly = testSuly;
        }

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
}
