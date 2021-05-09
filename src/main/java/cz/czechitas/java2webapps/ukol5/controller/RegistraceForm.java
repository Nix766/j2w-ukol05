package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.EnumSet;

public class RegistraceForm {
    @NotBlank
    private String jmeno;
    @NotBlank
    private String prijmeni;
    @NotNull
    private LocalDate datumNarozeni;
    @NotBlank
    private String turnus;
    @NotNull
    private Pohlavi pohlavi;
    @NotNull
    private EnumSet<Sport> sport;
    private String email;
    private String telefon;

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getTurnus() {
        return this.turnus;
    }

    public void setTurnus(String turnus) {
        this.turnus = turnus;
    }

    public Pohlavi getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(Pohlavi pohlavi) {
        this.pohlavi = pohlavi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getVek() {
        Period period = datumNarozeni.until(LocalDate.now());
        return period.getYears();
    }

    public void setSport(EnumSet<Sport> sport) {
        this.sport = sport;
    }

    public EnumSet<Sport> getSport() {
        return this.sport;
    }

    public String getTurnusObdobi() {
        switch(this.turnus) {
            case "1":
                return "5. - 11. července";
            case "2":
                return "12. - 18. července";
            default:
                return "19. - 25. července";
        }
    }

}
