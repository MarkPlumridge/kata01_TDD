package co.uk.plumrm.kata01_TDD;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyLibrary {

    private List<Book> library = new ArrayList<Book>();

    private static final MyLibrary INSTANCE = new MyLibrary();

    private  MyLibrary() {
    }

    public static MyLibrary getINSTANCE() {
        return INSTANCE;
    }

    public void add(Book book) {

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

}
