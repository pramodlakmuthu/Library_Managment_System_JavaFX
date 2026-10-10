package Controllers.AddBook;

import Model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookController {

    // Shared in-memory list to store book records
    private static final List<Book> bookList = new ArrayList<>();

    public boolean addBook(Book book) {
        return bookList.add(book);
    }

    public List<Book> getAllBooks() {
        return bookList;
    }
}