package com.iniitian.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "user_profile")
public class UserProfile {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(generator = "newGen")
	@GenericGenerator(name = "newGen", strategy = "foreign", parameters = @Parameter(name = "property", value="user"))
	private String id;
	
	@NotBlank(message = "Please enter first name!")
	private String firstName;
	
	@NotBlank(message = "Please enter last name!")
	private String lastName;
	
	@NotBlank(message = "Please enter email address!")
	@Column(unique = true)
	private String emailAddress;
	
	@Column(unique = true)
	private String nickname;
	
	private String avatar;
	
	private char gender = 'M';
	
	
	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedAt;
	
	private Long noOfFriends;
	
	private Long noOfBlogs;
	
	private Long noOfPosts;
	
	private String contactNumber;
	
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Transient
	private String registerPassword;
	
	@Transient
	private String confirmPassword;

	
	
	public String getRegisterPassword() {
		return registerPassword;
	}

	public void setRegisterPassword(String registerPassword) {
		this.registerPassword = registerPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

			
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
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

	public Long getNoOfFriends() {
		return noOfFriends;
	}

	public void setNoOfFriends(Long noOfFriends) {
		this.noOfFriends = noOfFriends;
	}

	public Long getNoOfBlogs() {
		return noOfBlogs;
	}

	public void setNoOfBlogs(Long noOfBlogs) {
		this.noOfBlogs = noOfBlogs;
	}

	public Long getNoOfPosts() {
		return noOfPosts;
	}

	public void setNoOfPosts(Long noOfPosts) {
		this.noOfPosts = noOfPosts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", nickname=" + nickname + ", avatar=" + avatar + ", createdAt=" + createdAt
				+ ", modifiedAt=" + modifiedAt + ", noOfFriends=" + noOfFriends + ", noOfBlogs=" + noOfBlogs
				+ ", noOfMessages=" + noOfPosts + "]";
	}
		
	
}
