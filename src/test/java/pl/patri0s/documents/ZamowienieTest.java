package pl.patri0s.documents;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class ZamowienieTest {
    @Test
    void should_return_10_percent_discount_if_recipient_is_infinite() {
        //given
        Zamowienie z = new Zamowienie("Patryk", "Infinite", "19.10.2023", "123456", "29.10.2023");
        //when
        double result = z.getRabat();
        //then
        Assertions.assertEquals(0.1, result);
    }

    @Test
    void should_return_5_percent_discount_if_recipient_is_firma_b() {
        //given
        Zamowienie z = new Zamowienie("Patryk", "Firma B", "19.10.2023", "123456", "29.10.2023");
        //when
        double result = z.getRabat();
        //then
        Assertions.assertEquals(0.05, result);
    }

    @Test
    void should_return_0_percent_discount_if_recipient_is_other_company() {
        //given
        Zamowienie z = new Zamowienie("Patryk", "Facebook", "19.10.2023", "123456", "29.10.2023");
        //when
        double result = z.getRabat();
        //then
        Assertions.assertEquals(0.0, result);
    }

    @Test
    void should_export_order_with_html_extension() {
        //given
        Zamowienie z = new Zamowienie("Patryk", "Facebook", "19.10.2023", "123456", "29.10.2023");
        File file = new File("src/main/java/pl/patri0s/files/zamowienie/zamowienie.html");
        //when
        z.export("HTML");
        file.deleteOnExit();
        //then
        Assertions.assertTrue(file.exists());
    }

    @Test
    void should_export_order_with_csv_extension() {
        //given
        Zamowienie z = new Zamowienie("Patryk", "Facebook", "19.10.2023", "123456", "29.10.2023");
        File file = new File("src/main/java/pl/patri0s/files/zamowienie/zamowienie.csv");
        //when
        z.export("CSV");
        file.deleteOnExit();
        //then
        Assertions.assertTrue(file.exists());
    }

    @Test
    void should_export_order_with_xml_extension() {
        //given
        Zamowienie z = new Zamowienie("Patryk", "Facebook", "19.10.2023", "123456", "29.10.2023");
        File file = new File("src/main/java/pl/patri0s/files/zamowienie/zamowienie.xml");
        //when
        z.export("XML");
        file.deleteOnExit();
        //then
        Assertions.assertTrue(file.exists());
    }

    @Test
    void should_not_export_order_with_different_extension() {
        //given
        Zamowienie z = new Zamowienie("Patryk", "Facebook", "19.10.2023", "123456", "29.10.2023");
        File file = new File("src/main/java/pl/patri0s/files/zamowienie/zamowienie.java");
        //when
        z.export("JAVA");
        file.deleteOnExit();
        //then
        Assertions.assertFalse(file.exists());
    }
}