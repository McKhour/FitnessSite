package hu.nye.fitnessSite.kaloriaBevitel;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;

@Entity
@Table(name = "KaloriaBevitel")
public class KaloriaBevitel{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        @JoinColumn(name = "felhsznalo_id", referencedColumnName = "id")
        private Felhasznalo felhasznalo;
        @Positive
        private Integer zsir;
        @Positive
        private Integer szenhidrat;
        @Positive
        private Integer feherje;
        @Positive
        private Integer viz;

        public KaloriaBevitel(){}

        public KaloriaBevitel(Long id, Felhasznalo felhasznalo, Integer zsir, Integer szenhidrat, Integer feherje, Integer viz) {
                this.id = id;
                this.felhasznalo = felhasznalo;
                this.zsir = zsir;
                this.szenhidrat = szenhidrat;
                this.feherje = feherje;
                this.viz = viz;
        }

        public KaloriaBevitel(Felhasznalo felhasznalo, Integer zsir, Integer szenhidrat, Integer feherje, Integer viz) {
                this.felhasznalo = felhasznalo;
                this.zsir = zsir;
                this.szenhidrat = szenhidrat;
                this.feherje = feherje;
                this.viz = viz;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Felhasznalo getFelhasznalo() {
                return felhasznalo;
        }

        public void setFelhasznalo(Felhasznalo felhasznalo) {
                this.felhasznalo = felhasznalo;
        }

        public @Positive Integer getZsir() {
                return zsir;
        }

        public void setZsir(@Positive Integer zsir) {
                this.zsir = zsir;
        }

        public @Positive Integer getSzenhidrat() {
                return szenhidrat;
        }

        public void setSzenhidrat(@Positive Integer szenhidrat) {
                this.szenhidrat = szenhidrat;
        }

        public @Positive Integer getFeherje() {
                return feherje;
        }

        public void setFeherje(@Positive Integer feherje) {
                this.feherje = feherje;
        }

        public @Positive Integer getViz() {
                return viz;
        }

        public void setViz(@Positive Integer viz) {
                this.viz = viz;
        }
}

