package ch04._03.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// 本類別封裝單筆書籍資料
@Entity
@Table(name="BookAjax")
public class BookBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId ;
	private String  title;
	private String  author;
	private Double  price   ;
	@Column(precision=10, scale=2)
	private Double  discount;
	@Transient
	@JsonIgnore
	private Integer companyId	;
	@JsonIgnore
	@Transient
	private String  companyName	;
	private String  fileName;
	private String  bookNo;
	// 加入修飾字防止Gson轉換此欄位
	@JsonIgnore
	private Blob    coverImage;

	@ManyToOne
	@JoinColumn(name="companyId")
	@JsonIgnoreProperties("books")
	PublisherBean publisherBean;
	
	@Transient
	String dataUri;
	
	@Transient
	private String  discountStr;
	
	public void setDiscountStr(String discountStr) {
		this.discountStr = discountStr;
	}

	public BookBean(Integer bookId, String title, String author, Double price,
			Double discount, Integer companyId, String companyName, 
			String fileName, String bookNo, Blob coverImage) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
		this.discount = discount;
		this.companyId = companyId;
		this.companyName = companyName;
		this.fileName = fileName;
		this.bookNo = bookNo;
		this.coverImage = coverImage;
	}

	public BookBean() {
	}
		
	public Integer getBookId() {   // bookId
		return bookId;
	}

	public void setBookId(Integer bookID) {
		this.bookId = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	private String  priceStr = null;
	public String getPriceStr() {
		return priceStr;
	}

	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
		if (priceStr == null) {
			priceStr = String.valueOf(price);
		}
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
		if (discount == 1) {
			discountStr = "";
		} else {
			Integer dnt = (int)(discount * 100);
			if (dnt % 10 == 0) {
				discountStr = (dnt / 10) + "折";
			} else {
				discountStr = " "  + dnt + "折";
			} 
		}
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyID) {
		this.companyId = companyID;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDiscountStr() {
		return discountStr;
	}	
	
	public Blob getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(Blob coverImage) {
		this.coverImage = coverImage;
	}

	public PublisherBean getPublisherBean() {
		return publisherBean;
	}

	public void setPublisherBean(PublisherBean publisherBean) {
		this.publisherBean = publisherBean;
	}

	public String getDataUri() {
		return dataUri;
	}

	public void setDataUri(String dataUri) {
		this.dataUri = dataUri;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookBean [bookId=");
		builder.append(bookId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", price=");
		builder.append(price);
		builder.append(", discount=");
		builder.append(discount);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", coverImage=" + coverImage);
		builder.append(", bookNo=");
		builder.append(bookNo);
		builder.append(", publisherBean=");
		builder.append(publisherBean);
		builder.append(", discountStr=");
		builder.append(discountStr);
		builder.append(", priceStr=");
		builder.append(priceStr);
		builder.append("]");
		return builder.toString();
	}
    
}



