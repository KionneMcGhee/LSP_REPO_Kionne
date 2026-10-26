package org.howard.edu.lsp.midterm.crccards;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/** Coordinates the catalog and enforces a library-wide three-book borrowing limit.
 * @author Kionne L. McGhee II
 */
public class Library {
    private final Map<String, Book> books = new LinkedHashMap<>();
    private int borrowedCount = 0;
    /** Adds a book by its unique ISBN.
     * @param book book to add
     * @throws IllegalArgumentException if book is null or ISBN already exists
     */
    public void addBook(Book book) {
        if (book == null || books.containsKey(book.getIsbn()))
            throw new IllegalArgumentException("Null book or duplicate ISBN");
        books.put(book.getIsbn(), book);
        if (!book.isAvailable()) borrowedCount++;
    }
    /** Finds a book by ISBN.
     * @param isbn identifier to search
     * @return the original book object, or null when absent
     */
    public Book findBook(String isbn) { return books.get(isbn); }
    /** Borrows a book if it is available and the library has capacity.
     * @param isbn identifier to borrow
     * @throws IllegalArgumentException if ISBN is missing
     * @throws IllegalStateException if borrowed already or borrowing limit reached
     */
    public void borrowBook(String isbn) {
        Book book = requiredBook(isbn);
        if (!book.isAvailable()) throw new IllegalStateException("Already borrowed");
        if (borrowedCount >= 3) throw new IllegalStateException("Library borrowing limit reached");
        book.borrowBook();
        borrowedCount++;
    }
    /** Returns a borrowed book.
     * @param isbn identifier to return
     * @throws IllegalArgumentException if ISBN is missing
     * @throws IllegalStateException if the book is available
     */
    public void returnBook(String isbn) {
        Book book = requiredBook(isbn);
        book.returnBook();
        borrowedCount--;
    }
    private Book requiredBook(String isbn) {
        Book book = findBook(isbn);
        if (book == null) throw new IllegalArgumentException("Unknown ISBN: " + isbn);
        return book;
    }
    /** @return all currently available books, or an empty list */
    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) if (book.isAvailable()) result.add(book);
        return result;
    }
    /** Gets books whose author matches exactly, case-sensitively.
     * @param author author name to match
     * @return matching books, or an empty list
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) if (java.util.Objects.equals(author, book.getAuthor())) result.add(book);
        return result;
    }
    /** @return all books sorted lexicographically by ISBN without changing the catalog */
    public List<Book> getBooksSortedByIsbn() {
        List<Book> result = new ArrayList<>(books.values());
        result.sort(Comparator.comparing(Book::getIsbn));
        return result;
    }
    /** @return current number of borrowed books */
    public int getBorrowedBookCount() { return borrowedCount; }
}
