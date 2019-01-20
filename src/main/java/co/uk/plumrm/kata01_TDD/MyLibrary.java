package co.uk.plumrm.kata01_TDD;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyLibrary {

    private List<Book> library = new ArrayList<Book>();

    private static final MyLibrary INSTANCE = new MyLibrary();

    private  MyLibrary() {
    }

    public static MyLibrary getINSTANCE() {
        return INSTANCE;
    }

    public List<Book> filterByScore(int maxValue) {

        return library.stream()
                .filter( (book)-> book.getRating() > maxValue)
                .collect(Collectors.toList());
    }

    public void addBook(Book book) {

        library.add(book);

    }

    public int getBookCount() {

        return library.size();

    }

    /**
     * This is very powerful and allows the client to filter and use lambdas
     * @return
     */
    public Stream<Book> getStream() {

        return library.stream();

    }

    public List filterByAuthorLamda(String author) {

        List<Book> filteredList = library.stream()
                .filter( (book) -> book.getAuthor().compareTo(author) == 0)
                .collect(Collectors.toList());

        return filteredList;

    }

    public List filterByAuthorForEach(String author) {

        List<Book> filteredList = new ArrayList<>();

        for (Book book:
             library) {

            if (book.getAuthor().compareTo(author) == 0) {

                    filteredList.add(book);

            }

        }

        return filteredList;
    }

    public List<Book> filterByAuthorForI(String author) {

        List<Book> filteredList = new ArrayList<>();

        for (int i = 0; i < library.size(); i++) {

            if (library.get(i).getAuthor().compareTo(author) == 0) {

                filteredList.add(library.get(i));

            }

        }

        return filteredList;
    }
}
