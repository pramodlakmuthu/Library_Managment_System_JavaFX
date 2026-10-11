package Controllers.AddBook;

import Model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookController {
    private static final List<Book> bookList = new ArrayList<>();

    public boolean addBook(Book book) {
        return bookList.add(book);
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    // Returns total unique book titles/records or sum of quantities
    public int getTotalBooksCount() {
        int total = 0;
        for (Book b : bookList) {
            total += b.getQuantity();
        }
        return total;
    }
}