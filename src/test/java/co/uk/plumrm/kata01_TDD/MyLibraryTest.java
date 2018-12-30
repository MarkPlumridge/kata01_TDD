package co.uk.plumrm.kata01_TDD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLibraryTest {

    MyLibrary myLibrary;

    @BeforeEach
    void beforeEachMethod() {

        myLibrary = MyLibrary.getINSTANCE();
        myLibrary.add(new Book("Clean Architecture", "Robert C. Martin", 10));
        myLibrary.add(new Book("The Clean Coder", "Robert C. Martin", 10));
        myLibrary.add(new Book("XML Development with Java 2", "O'Reilly", 6));

    }

    @Test
    @DisplayName("TestAddBooks")
    void testAddBooks() {

      Book cleanCode = new Book("Clean Code", "Robert C. Martin", 10);

      myLibrary.add(cleanCode);

      assertAll("Add Books",

              () -> assertEquals("Clean Code", cleanCode.getTitle()),
              () -> assertEquals(3, myLibrary.getBookCount(), "Book Count failed!")

              );

    }

    @Test
    @DisplayName("Test Get Stream")
    void testGetStream() {

        myLibrary.add(new Book("Under Construction", "Robert C. Martin", 0));

        Stream<Book> stream = myLibrary.getStream();
        // stream.sorted(p -> p.getRating()).forEach(System.out::println);

        // Print list of Books with a high rating
        System.out.println("Books with a high rating");
        stream
                .filter(book -> book.getRating() > 7)
                .forEach(book -> System.out.println(book.toString()));

        // Print list of Books written by Robert C. Martin
        stream = myLibrary.getStream();
        System.out.println("Book written by Uncle Bob");
        stream.filter(author -> author.getAuthor().equals("Robert C. Martin"))
                .forEach(book -> System.out.println(book.toString()));

    }
}
