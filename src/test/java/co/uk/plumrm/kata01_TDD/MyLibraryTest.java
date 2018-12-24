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

        Stream<Book> stream = myLibrary.getStream();
        stream.sorted(p -> p.getRating()).forEach(System.out::println);

    }
}
