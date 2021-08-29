package ru.netology.manager;


import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {


    @Test
    void shouldSearchByAuthor() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product[] items = new Product[]{new Smartphone(3, "Galaxy", 1000, "Samsung"),
                new Book(1, "Forrest Gump", 200, "Winston Groom"),
                new Smartphone(2, "iPhone X", 1000, "Apple"),
                new Book(4, "Fight Club", 190, "Chuck Palahniuk")};
        Product[] actual = manager.searchBy("Chuck Palahniuk");
        Product[] expected = {new Book(4, "Fight Club", 190, "Chuck Palahniuk")};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product[] items = new Product[]{new Smartphone(3, "Galaxy", 1000, "Samsung"),
                new Book(1, "Forrest Gump", 200, "Winston Groom"),
                new Smartphone(2, "iPhone X", 1000, "Apple"),
                new Book(4, "Fight Club", 190, "Chuck Palahniuk")};
        Product[] actual = manager.searchBy("Forrest Gump");
        Product[] expected = {new Book(1, "Forrest Gump", 200, "Winston Groom")};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartPhoneName() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product[] items = new Product[]{new Smartphone(3, "Galaxy", 1000, "Samsung"),
                new Book(1, "Forrest Gump", 200, "Winston Groom"),
                new Smartphone(2, "iPhone X", 1000, "Apple"),
                new Book(4, "Fight Club", 190, "Chuck Palahniuk")};
        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = {new Smartphone(3, "Galaxy", 1000, "Samsung")};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufactured() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product[] items = new Product[]{new Smartphone(3, "Galaxy", 1000, "Samsung"),
                new Book(1, "Forrest Gump", 200, "Winston Groom"),
                new Smartphone(2, "iPhone X", 1000, "Apple"),
                new Book(4, "Fight Club", 190, "Chuck Palahniuk")};
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = {new Smartphone(2, "iPhone X", 1000, "Apple")};

        assertArrayEquals(expected, actual);
    }


}