package hu.nye.fitnessSite.futas;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Futas")
public class Futas{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "felhasznalo_id", referencedColumnName = "id")
    private Felhasznalo felhasznalo;
    private String futasCim;
    private LocalDateTime futasKezd;
    private LocalDateTime futasVeg;
    private Double kilometer;
    @Enumerated(EnumType.STRING)
    private Helye helye;

    public Futas(){}

    public Futas(Long id, Felhasznalo felhasznalo, String futasCim, LocalDateTime futasKezd, LocalDateTime futasVeg, Double kilometer, Helye helye) {
        this.id = id;
        this.felhasznalo = felhasznalo;
        this.futasCim = futasCim;
        this.futasKezd = futasKezd;
        this.futasVeg = futasVeg;
        this.kilometer = kilometer;
        this.helye = helye;
    }

    public Futas(Felhasznalo felhasznalo, String futasCim, LocalDateTime futasKezd, LocalDateTime futasVeg, Double kilometer, Helye helye) {
        this.felhasznalo = felhasznalo;
        this.futasCim = futasCim;
        this.futasKezd = futasKezd;
        this.futasVeg = futasVeg;
        this.kilometer = kilometer;
        this.helye = helye;
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

    public String getFutasCim() {
        return futasCim;
    }

    public void setFutasCim(String futasCim) {
        this.futasCim = futasCim;
    }

    public LocalDateTime getFutasKezd() {
        return futasKezd;
    }

    public void setFutasKezd(LocalDateTime futasKezd) {
        this.futasKezd = futasKezd;
    }

    public LocalDateTime getFutasVeg() {
        return futasVeg;
    }

    public void setFutasVeg(LocalDateTime futasVeg) {
        this.futasVeg = futasVeg;
    }

    public Double getKilometer() {
        return kilometer;
    }

    public void setKilometer(Double kilometer) {
        this.kilometer = kilometer;
    }

    public Helye getHelye() {
        return helye;
    }

    public void setHelye(Helye helye) {
        this.helye = helye;
    }
}
