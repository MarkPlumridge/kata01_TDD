package co.uk.plumrm.kata01_TDD;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    @DisplayName("Test Book Properties")
    void testBookProperties() {

        Book book = new Book();
        book.setTitle("Clean Code");
        book.setAuthor("Robert C. Martin");
        book.setRating(10);

        assertAll("First Test",

                () -> assertEquals("Clean Code", book.getTitle(), "Book name does not match"),
                () -> assertEquals("Robert C. Martin", book.getAuthor()),
                () -> assertEquals(10, book.getRating())

                );


    }


}
