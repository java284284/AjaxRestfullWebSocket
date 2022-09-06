package pk.domain;
import java.util.* ;

public class ShoppingCart implements java.io.Serializable {
   private Collection books = new Vector() ;
   public ShoppingCart() {
   }
   public Collection getBooks() {
      return books;
   }
   public void setBooks(Collection value) {
     books = value;
   }
   public void addBook(Book aBook) {
      books.add(aBook) ;
   }
   
   public Iterator getAllBooks() {
      return  books.iterator();
   }
  
}
