package org.howard.edu.lsp.midterm.crccards;
/** Book in a lending catalog. */
public class Book {
 private final String isbn,title,author;
 private boolean available=true;
 /** Constructs a book. */
 public Book(String isbn,String title,String author){this.isbn=isbn;this.title=title;this.author=author;}
 /** @return ISBN */ public String getIsbn(){return isbn;}
 /** @return title */ public String getTitle(){return title;}
 /** @return author */ public String getAuthor(){return author;}
 /** @return whether available */ public boolean isAvailable(){return available;}
 /** Borrows this book. @throws IllegalStateException when unavailable */
 public void borrowBook(){if(!available)throw new IllegalStateException(); available=false;}
 /** Returns this book. @throws IllegalStateException when already available */
 public void returnBook(){if(available)throw new IllegalStateException(); available=true;}
 /** @return formatted book description */
 public String toString(){return isbn+" "+title+" by "+author+(available?" [AVAILABLE]":" [BORROWED]");}
}
