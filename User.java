package com.hcl.cs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
@NamedQueries({
	@NamedQuery(name="findUsertByName",query="select u from User u where u.userName= :USERNAME and u.userPassword= :USERPASSWORD")
})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType. AUTO)
	@Column(name="USERID")
	private Long userId;
	
	@Column(name="USERNAME")
	@NotEmpty
	private String userName;
	
	@Column(name="USERPASSWORD")
	@NotEmpty
	private String userPassword;
	
	@Transient
	@NotEmpty
	private String confirmPassword;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="PET_USER",
	joinColumns = @JoinColumn(name="USERID"),inverseJoinColumns = @JoinColumn(name="PETID"))
	private Set<Pet> pets = new HashSet<>();
	
	@Override
	public String toString() {
		return "User (userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", confirmPassword=" + confirmPassword + ", pets=" + pets + ")";
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Set<Pet> getPets() {
		return pets;
	}
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	public User(Long userId, String userName, String userPassword, String confirmPassword, Set<Pet> pets) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.confirmPassword = confirmPassword;
		this.pets = pets;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public  void getUser() {
		this.userId = 1L;;
		this.userName = "pet";
		this.userPassword = "pet";
		this.confirmPassword = "pet";
		this.pets = new HashSet<>();
	}

}
