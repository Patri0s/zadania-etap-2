package pl.patri0s.documents;

abstract public class Dokument {
    private String wystawca;
    private String odbiorca;
    private String dataWystawienia;
    private final String numer;

    public Dokument(String wystawca, String odbiorca, String dataWystawienia, String numer) {
        this.wystawca = wystawca;
        this.odbiorca = odbiorca;
        this.dataWystawienia = dataWystawienia;
        this.numer = numer;
    }

    public String getWystawca() {
        return wystawca;
    }

    public String getOdbiorca() {
        return odbiorca;
    }

    public String getDataWystawienia() {
        return dataWystawienia;
    }

    public String getNumer() {
        return numer;
    }

    public void setWystawca(String wystawca) {
        this.wystawca = wystawca;
    }

    public void setOdbiorca(String odbiorca) {
        this.odbiorca = odbiorca;
    }

    public void setDataWystawienia(String dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    public abstract double getRabat();

    public abstract void export(String format);
}