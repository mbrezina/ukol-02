package cz.czechitas.webapp;

public class Clanek {
    private Long idClanku;
    private String nazev;
    private String autor;

    public Clanek(Long idClanku, String nazev, String autor) {
        this.idClanku = idClanku;
        this.nazev = nazev;
        this.autor = autor;
    }

    public void setIdClanku(Long cislo) {
        this.idClanku = cislo;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getIdClanku() {
        return idClanku;
    }

    public String getNazev() {
        return nazev;
    }

    public String getAutor() {
        return autor;
    }
}
