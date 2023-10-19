package pl.patri0s.documents;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Zamowienie extends Dokument {
    private String terminRealizacji;

    public Zamowienie(String wystawca, String odbiorca, String dataWystawienia, String numer, String terminRealizacji) {
        super(wystawca, odbiorca, dataWystawienia, numer);
        this.terminRealizacji = terminRealizacji;
    }

    String getTerminRealizacji() {
        return terminRealizacji;
    }

    public void setTerminRealizacji(String terminRealizacji) {
        this.terminRealizacji = terminRealizacji;
    }

    @Override
    public double getRabat() {
        if (getOdbiorca().equals("Infinite")) {
            return 0.1;
        } else if (getOdbiorca().equals("Firma B")) {
            return 0.05;
        } else {
            return 0;
        }
    }

    @Override
    public void export(String format) {
        ArrayList<String> data = new ArrayList<>();
        String filePath = "src/main/java/pl/patri0s/files/zamowienie/";
        switch (format) {
            case "HTML":
                filePath = filePath.concat("zamowienie.html");
                data.add("<!DOCTYPE html>");
                data.add("<html lang=\"pl\">");
                data.add("<head><meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <title>Zamowienie nr " + getNumer() + "</title></head>");
                data.add("<body>");
                data.add("<h1>Zamowienie nr: " + getNumer() + "</h1>");
                data.add("<p>Wystawca: " + getWystawca() + "</p>");
                data.add("<p>Odbiorca: " + getOdbiorca() + "</p>");
                data.add("<p>Data: " + getDataWystawienia() + "</p>");
                data.add("<p>Termin: " + getTerminRealizacji() + "</p>");
                data.add("<p>Rabat: " + getRabat() * 100 + "%</p>");
                data.add("</body>");
                data.add("</html>");
                break;
            case "CSV":
                filePath = filePath.concat("zamowienie.csv");
                data.add("Zamowienie nr," + getNumer());
                data.add("Wystawca," + getWystawca());
                data.add("Odbiorca," + getOdbiorca());
                data.add("Data," + getDataWystawienia());
                data.add("Termin," + getTerminRealizacji());
                data.add("Rabat," + getRabat());
                break;
            case "XML":
                filePath = filePath.concat("zamowienie.xml");
                data.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                data.add("<zamowienie numer=\"" + getNumer() + "\">");
                data.add("<wystawca>" + getWystawca() + "</wystawca>");
                data.add("<odbiorca>" + getOdbiorca() + "</odbiorca>");
                data.add("<data>" + getDataWystawienia() + "</data>");
                data.add("<termin>" + getTerminRealizacji() + "</termin>");
                data.add("<rabat>" + getRabat() + "</rabat>");
                data.add("</zamowienie>");
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