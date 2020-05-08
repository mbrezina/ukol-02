package cz.czechitas.webapp;

public class Eten {
    private Integer index;
    private String nazev;
    private String popis;

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public Eten(Integer index, String nazev, String popis) {
        this.index = index;
        this.nazev = nazev;
        this.popis = popis;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }
}
