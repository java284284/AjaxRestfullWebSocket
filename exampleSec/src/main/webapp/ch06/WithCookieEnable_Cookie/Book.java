package pk.domain;
public class Book implements java.io.Serializable {
   private String  bookId;
   private String  type ;
   private String  title;
   private double  price ;
   public Book(String bookId, String type, String title, double price) {
      this.bookId = bookId;
      this.type = type;
      this.title = title;
      this.price = price ;
   }
   public Book() {
   }
   public String getBookId() {
     return bookId;
   }
   public String getType() {
     return type;
   }
   public String getTitle() {
     return title;
   }
   public double  getPrice() {
     return price;
   }
}