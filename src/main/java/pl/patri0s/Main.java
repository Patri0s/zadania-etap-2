package pl.patri0s;

import pl.patri0s.documents.Faktura;
import pl.patri0s.documents.Zamowienie;

import static pl.patri0s.utils.Calculate.calculate;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculate("12,34.56;67*"));
        Zamowienie z = new Zamowienie("Patryk", "Infinite", "19.10.2023", "123456", "29.10.2023");
        z.export("HTML");
        Faktura f = new Faktura("Patryk", "Infinite", "19.10.2023", "123456", "VAT");
        f.export("HTML");
    }
}