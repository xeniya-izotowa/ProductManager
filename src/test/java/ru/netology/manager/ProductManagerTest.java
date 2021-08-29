package ru.netology.manager;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    private Product one = new Book(1, "Forrest Gump", 200, "Winston Groom");
    private Product two = new Smartphone(2, "iPhone X", 1000, "Apple");
    private Product three = new Smartphone(3, "Galaxy", 1000, "Samsung");
    private Product four = new Book(4, "Fight Club", 190, "Chuck Palahniuk");

    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
    }

    @Test
    void shouldSearchByAuthor() {
        String text = "Chuck Palahniuk";
        manager.searchBy("text");
        Product[] expected = new Product[]{four};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        String text = "Forrest Gump";
        manager.searchBy("text");
        Product[] expected = new Product[]{one};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartPhoneName() {
        String text = "Galaxy";
        manager.searchBy("text");
        Product[] expected = new Product[]{three};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufactured() {
        String text = "Apple";
        manager.searchBy("text");
        Product[] expected = new Product[]{two};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }


}