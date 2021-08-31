package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repo = new ProductRepository();
    private Product one = new Book(1, "Forrest Gump", 200, "Winston Groom");
    private Product two = new Smartphone(2, "iPhone X", 1000, "Apple");
    private Product three = new Smartphone(3, "Galaxy", 1000, "Samsung");
    private Product four = new Book(4, "Fight Club", 190, "Chuck Palahniuk");

    @BeforeEach
    public void setUp() {
        repo.save(one);
        repo.save(two);
        repo.save(three);
        repo.save(four);
    }

    @Test
    public void shouldRemoveByIdIfExist() {
        repo.removeById(2);
        Product[] expected = new Product[]{one, three, four};

        assertArrayEquals(expected, repo.getAll());
    }

    @Test
    public void shouldThrowExceptionIfIdDoesNotExist() {
        assertThrows(NotFoundException.class, () -> repo.removeById(7));
    }


}