package com.hungnd16.training.mybookstore.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "AUTHOR")
public class Author implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTHOR_ID")
	private int authorId;

	@Column(name = "AUTHOR_NAME")
	private String authorName;

	@Column(name = "AUTHOR_SEX")
	private boolean authorSex;

	@Column(name = "AUTHOR_DOB")
	private Date authorDob;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "REG_DATE")
	private Date regDate;

	@Column(name = "REG_USER_ID")
	private String regUserId;

	@Column(name = "UPD_DATE")
	private Date updDate;

	@Column(name = "UPD_USER_ID")
	private String upduserId;

	@Column(name = "DEL_DATE")
	private Date deldate;

	@Column(name = "DEL_USER_ID")
	private String delUserId;

	@Column(name = "DEL_FLG")
	private int delFlg;
}
