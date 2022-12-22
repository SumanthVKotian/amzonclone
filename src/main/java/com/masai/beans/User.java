package com.masai.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="users")
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_name")
	@NotNull
	@Pattern(regexp="[a-z]{6,12}", message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.")
	private String userName;
	
	@Column(name = "user_password")
	@NotNull
	@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	private String userPassword;
	
	@NotNull
	@Pattern(regexp="[a-z]{3,12}", message = "First Name must not contains numbers or special characters")
	private String firstName;
	
	@NotNull
	@Pattern(regexp="[a-z]{3,12}", message = "Last Name must not contains numbers or special characters")
	private String lastName;
	
	@NotNull
	@Pattern(regexp="[0-9]{10}", message = "Mobile number must have 10 digits")
	private String mobileNumber;
	
	@Email
	@NotNull
	private String email;

	@JsonIgnoreProperties("user")
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user") 
	@JsonIgnoreProperties("user")
	private List<Address> addresses = new ArrayList<>();

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public User(
			@NotNull @Pattern(regexp = "[a-z]{6,12}", message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.") String userName,
			@NotNull @Pattern(regexp = "[a-zA-Z0-9]{6,12}", message = "Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.") String userPassword,
			@NotNull @Pattern(regexp = "[a-z]{3,12}", message = "First Name must not contains numbers or special characters") String firstName,
			@NotNull @Pattern(regexp = "[a-z]{3,12}", message = "Last Name must not contains numbers or special characters") String lastName,
			@NotNull @Pattern(regexp = "[0-9]{10}", message = "Mobile number must have 10 digits") String mobileNumber,
			@Email @NotNull String email, Login login, List<Address> addresses) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.login = login;
		this.addresses = addresses;
	}

	public User() {
		super();
	}
	
	
 
}
