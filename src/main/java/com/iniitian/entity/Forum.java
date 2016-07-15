package com.iniitian.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Forum {
	
	@Id
	@Column(name = "forum_id")
	private String id;
	
	
	@NotBlank(message = "Please enter the title!")
	private String title;
	
	@NotBlank(message = "Please enter the description!")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)	
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)	
	private Date modifiedAt;
	
	public Forum() {
		this.id = "FRM" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
	
	@Column(name = "category_id")
	private String categoryId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
			
	
}
