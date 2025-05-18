package hu.nye.fitnessSite.sulyEmeles;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
public class SulyEmeles{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        @JoinColumn(name = "felhasznalo_id", referencedColumnName = "id", nullable = false)
        private Felhasznalo felhasznalo;
        @Positive
        private Integer suly;
        @Positive
        private Integer szettek;
        @Positive
        private Integer repek;
        @Enumerated(EnumType.STRING)
        private Tipusa tipusa;

        public SulyEmeles(){}

        public SulyEmeles(Long id, Felhasznalo felhasznalo, Integer suly, Integer szettek, Integer repek, Tipusa tipusa) {
                this.id = id;
                this.felhasznalo = felhasznalo;
                this.suly = suly;
                this.szettek = szettek;
                this.repek = repek;
                this.tipusa = tipusa;
        }

        public SulyEmeles(Felhasznalo felhasznalo, Integer suly, Integer szettek, Integer repek, Tipusa tipusa) {
                this.felhasznalo = felhasznalo;
                this.suly = suly;
                this.szettek = szettek;
                this.repek = repek;
                this.tipusa = tipusa;
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

        public @Positive Integer getSuly() {
                return suly;
        }

        public void setSuly(@Positive Integer suly) {
                this.suly = suly;
        }

        public @Positive Integer getSzettek() {
                return szettek;
        }

        public void setSzettek(@Positive Integer szettek) {
                this.szettek = szettek;
        }

        public @Positive Integer getRepek() {
                return repek;
        }

        public void setRepek(@Positive Integer repek) {
                this.repek = repek;
        }

        public Tipusa getTipusa() {
                return tipusa;
        }

        public void setTipusa(Tipusa tipusa) {
                this.tipusa = tipusa;
        }
}
