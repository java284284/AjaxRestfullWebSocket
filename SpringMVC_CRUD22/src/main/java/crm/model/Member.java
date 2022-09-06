package crm.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Member_CRUD", 
     uniqueConstraints = { @UniqueConstraint(columnNames = "account") })

public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String account;
	String name;
	String email;
	Date birthday;
	Double weight;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hobby_id", nullable = false)
	Hobby hobby;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", nullable = false)
	Category category;
	String gender;
	Blob image;
	String fileName;
	String login;
	Timestamp admissionTime;
	
	@Transient
	MultipartFile productImage;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getId() {
		return id;
	}

	public Hobby getHobby() {
		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Timestamp getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(Timestamp admissionTime) {
		this.admissionTime = admissionTime;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", account=" + account + ", name=" + name + ", email=" + email + ", birthday="
				+ birthday + ", weight=" + weight + ", hobby=" + hobby + ", category=" + category + ", gender=" + gender
				+ ", image=" + image + ", fileName=" + fileName + ", admissionTime=" + admissionTime + ", productImage="
				+ productImage + "]";
	}

}
