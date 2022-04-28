package ec.llanes.objrestdatajpa.Service;

import ec.llanes.objrestdatajpa.modelo.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {


    @Test
    void calculatePrice() {
        //configuracin d
        Book book = new Book(1L, "Potter", "JK", "100", 10.0, LocalDate.now(), true);

        BookPriceCalculator bookPriceCalculator = new BookPriceCalculator();


        double price = bookPriceCalculator.calculatePrice(book);
        System.out.println(price);
        assertTrue(price > 0);
    }
}