package _01.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement(name="member")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="Members")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute(name="pk_cnvr")
	Integer pk;
	@XmlElement(name = "id")
	String id;
	@XmlElement(name = "name")
	String name;
	@XmlElement(name = "balance")
	Double balance;
	@XmlElement(name = "birthday")
	@XmlJavaTypeAdapter(SQLDateAdapter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Asia/Taipei")
//	@JsonFormat(pattern="yyyy-MM-dd")
	Date birthday;
	
	
	public Member() {
		super();
	}
	
	public Member(String id, String name, Double balance, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.birthday = birthday;
	}
	
	public Member(Integer pk, String id, String name, Double balance, Date birthday) {
		super();
		this.pk = pk;
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.birthday = birthday;
	}


	public Member(Integer ipk) {
		this.pk = ipk;
	}


	public Integer getPk() {
		return pk;
	}


	public void setPk(Integer pk) {
		this.pk = pk;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	@Override
	public String toString() {
		return "Member [pk=" + pk + ", id=" + id + ", name=" + name + ", balance=" + balance + ", birthday=" + birthday
				+ "]";
	}
	

	
}
