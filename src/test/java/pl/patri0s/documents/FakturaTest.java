package pl.patri0s.documents;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class FakturaTest {
    @Test
    void should_return_23_percent_discount_if_type_is_vat() {
        //given
        Faktura f = new Faktura("Patryk", "Infinite", "19.10.2023", "123456", "VAT");
        //when
        double result = f.getRabat();
        //then
        Assertions.assertEquals(0.23, result);
    }

    @Test
    void should_return_18_percent_discount_if_type_is_zaliczkowa() {
        //given
        Faktura f = new Faktura("Patryk", "Infinite", "19.10.2023", "123456", "Zaliczkowa");
        //when
        double result = f.getRabat();
        //then
        Assertions.assertEquals(0.18, result);
    }

    @Test
    void should_return_0_percent_discount_if_type_is_other() {
        //given
        Faktura f = new Faktura("Patryk", "Infinite", "19.10.2023", "123456", "Końcowa");
        //when
        double result = f.getRabat();
        //then
        Assertions.assertEquals(0.0, result);
    }

    @Test
    void should_export_invoice_with_html_extension() {
        //given
        Faktura f = new Faktura("Patryk", "Infinite", "19.10.2023", "123456", "Zaliczkowa");
        File file = new File("src/main/java/pl/patri0s/files/faktura/faktura.html");
        //when
        f.export("HTML");
        file.deleteOnExit();
        //then
        Assertions.assertTrue(file.exists());
    }

    @Test
    void should_export_invoice_with_csv_extension() {
        //given
        Faktura f = new Faktura("Patryk", "Infinite", "19.10.2023", "123456", "Zaliczkowa");
        File file = new File("src/main/java/pl/patri0s/files/faktura/faktura.csv");
        //when
        f.export("CSV");
        file.deleteOnExit();
        //then
        Assertions.assertTrue(file.exists());
    }

    @Test
    void should_export_invoice_with_xml_extension() {
        //given
        Faktura f = new Faktura("Patryk", "Infinite", "19.10.2023", "123456", "Zaliczkowa");
        File file = new File("src/main/java/pl/patri0s/files/faktura/faktura.xml");
        //when
        f.export("XML");
        file.deleteOnExit();
        //then
        Assertions.assertTrue(file.exists());
    }

    @Test
    void should_not_export_invoice_with_different_extension() {
        //given
        Faktura f = new Faktura("Patryk", "Infinite", "19.10.2023", "123456", "Zaliczkowa");
        File file = new File("src/main/java/pl/patri0s/files/faktura/faktura.cpp");
        //when
        f.export("CPP");
        file.deleteOnExit();
        //then
        Assertions.assertFalse(file.exists());
    }
}