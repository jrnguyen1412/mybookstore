package com.hungnd16.training.mybookstore.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_info")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(generator="my_sq", strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(sequenceName="BOOK_SEQ", name="my_sq", allocationSize=1)
	@Column(name = "BOOK_ID", nullable = false)
	private int bookId;

	@Column(name = "BOOK_NAME")
	private String bookName;

	@Column(name = "BOOK_ISBN")
	private String bookIsbn;

	@Column(name = "REG_DATE")
	private Date regDate;

	@Column(name = "REG_USER_ID")
	private String regUserId;

	@Column(name = "UPD_DATE")
	private Date updDate;

	@Column(name = "UPD_USER_ID")
	private String updUserId;

	@Column(name = "DEL_DATE")
	private Date delDate;

	@Column(name = "DEL_USER_ID")
	private String delUserId;

	@Column(name = "DEL_FLG", nullable = false)
	private boolean delFlg;

	public Book() {
		super();
	}

	public Book(String bookName, String bookIsbn, boolean delFlg) {
		super();
		this.bookName = bookName;
		this.bookIsbn = bookIsbn;
		this.delFlg = delFlg;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRegUserId() {
		return regUserId;
	}

	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public String getUpdUserId() {
		return updUserId;
	}

	public void setUpdUserId(String updUserId) {
		this.updUserId = updUserId;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public String getDelUserId() {
		return delUserId;
	}

	public void setDelUserId(String delUserId) {
		this.delUserId = delUserId;
	}
	
	public boolean isDelFlg() {
		return delFlg;
	}

	public void setDelFlg(boolean delFlg) {
		this.delFlg = delFlg;
	}
}
