package ec.llanes.objrestdatajpa.Service;

import ec.llanes.objrestdatajpa.modelo.Book;

public class BookPriceCalculator {

    public double calculatePrice(Book book){
        double price = book.getCosto();
        price += 5;
        return price;
    }
}
