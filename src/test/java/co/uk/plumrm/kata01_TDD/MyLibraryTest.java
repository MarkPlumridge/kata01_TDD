package co.uk.plumrm.kata01_TDD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLibraryTest {

    MyLibrary myLibrary;

    @BeforeEach
    void beforeEachMethod() {

        myLibrary = MyLibrary.getINSTANCE();
        myLibrary.addBook(new Book("Clean Architecture", "Robert C. Martin", 10));
        myLibrary.addBook(new Book("The Clean Coder", "Robert C. Martin", 10));
        myLibrary.addBook(new Book("XML Development with Java 2", "O'Reilly", 6));

    }

    @Test
    @DisplayName("TestAddBooks")
    void testAddBooks() {

      Book cleanCode = new Book("Clean Code", "Robert C. Martin", 10);

      myLibrary.addBook(cleanCode);

      assertAll("Add Books",

              () -> assertEquals("Clean Code", cleanCode.getTitle()),
              () -> assertEquals(4, myLibrary.getBookCount(), "Book Count failed!")

      );

    }

    @Test
    @DisplayName("Test Get Stream")
    void testGetStream() {

        myLibrary.addBook(new Book("Under Construction", "Robert C. Martin", 0));

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
    @Test
    @DisplayName("Filter By Score")
    void filterByScore() {

        myLibrary.addBook(new Book("Clean Architecture", "Robert C. Martin", 7));
        myLibrary.addBook(new Book("Effective Java", "Joshua Bloch", 10));

        List<Book> filteredBooks = myLibrary.filterByScore(8);

        assertAll("Filter By Score",

                ()-> assertEquals(3, filteredBooks.size(), "Failed to filter books"),
                ()-> assertEquals(true,
                        filteredBooks.stream()
                                .filter( (book)-> book.getTitle().contains("Effective Java"))
                                .findFirst().isPresent(),
                        "Failed to find book in filtered list"
                )

        );

        filteredBooks.stream().forEach( (book -> System.out.println(book.toString())));

    }

    @Test
    @DisplayName("Filter By Author (Lambda)")
    void filterByAuthorLamda() {

        List authorFilterList = myLibrary.filterByAuthorLamda("Robert C. Martin");

        assertEquals(2, authorFilterList.size(), "Count not expected!");

    }

    @Test
    @DisplayName("Filter By Author (For each)")
    void filterByAuthorForEach() {

        List authorFilterList = myLibrary.filterByAuthorForEach("Robert C. Martin");

        assertEquals(2, authorFilterList.size(), "Count not expected!");

    }

    @Test
    @DisplayName("Filter By Author (For i)")
    void filterByAuthorForI() {

        List<Book> authorFilterList = myLibrary.filterByAuthorForI("Robert C. Martin");

        assertEquals(2, authorFilterList.size(), "Count not expected!");

    }
}
