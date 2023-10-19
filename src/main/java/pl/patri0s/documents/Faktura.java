package pl.patri0s.documents;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Faktura extends Dokument {
    private String typ;

    public Faktura(String wystawca, String odbiorca, String dataWystawienia, String numer, String typ) {
        super(wystawca, odbiorca, dataWystawienia, numer);
        this.typ = typ;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public double getRabat() {
        if (getTyp().equals("VAT")) {
            return 0.23;
        } else if (getTyp().equals("Zaliczkowa")) {
            return 0.18;
        } else {
            return 0;
        }
    }

    @Override
    public void export(String format) {
        ArrayList<String> data = new ArrayList<>();
        String filePath = "src/main/java/pl/patri0s/files/faktura/faktura";
        switch (format) {
            case "HTML":
                filePath = filePath.concat(".html");
                data.add("<!DOCTYPE html>");
                data.add("<html lang=\"pl\">");
                data.add("<head><meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <title> Faktura nr " + getNumer() + "</title></head>");
                data.add("<body>");
                data.add("<h1>Faktura nr: " + getNumer() + "</h1>");
                data.add("<p>Wystawca: " + getWystawca() + "</p>");
                data.add("<p>Odbiorca: " + getOdbiorca() + "</p>");
                data.add("<p>Data: " + getDataWystawienia() + "</p>");
                data.add("<p>Typ: " + getTyp() + "</p>");
                data.add("<p>Rabat: " + getRabat() * 100 + "%</p>");
                data.add("</body>");
                data.add("</html>");
                break;
            case "CSV":
                filePath = filePath.concat(".csv");
                data.add("Faktura nr," + getNumer());
                data.add("Wystawca," + getWystawca());
                data.add("Odbiorca," + getOdbiorca());
                data.add("Data," + getDataWystawienia());
                data.add("Typ," + getTyp());
                data.add("Rabat," + getRabat());
                break;
            case "XML":
                filePath = filePath.concat(".xml");
                data.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                data.add("<faktura numer=\"" + getNumer() + "\">");
                data.add("<wystawca>" + getWystawca() + "</wystawca>");
                data.add("<odbiorca>" + getOdbiorca() + "</odbiorca>");
                data.add("<data>" + getDataWystawienia() + "</data>");
                data.add("<typ>" + getTyp() + "</typ>");
                data.add("<rabat>" + getRabat() + "</rabat>");
                data.add("</faktura>");
                break;
            default:
                System.out.println("Nieobsługiwany format: " + format);
        }
        try {
            Files.write(Paths.get(filePath), data);
        } catch (IOException e) {
            System.out.println("Nieprawidłowa ścieżka do pliku");
        }
    }
}