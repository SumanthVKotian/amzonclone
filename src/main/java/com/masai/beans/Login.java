package com.masai.beans;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int loginId;
	
	private String apiKey = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
	
	private LocalDateTime keyExpiryDate = LocalDateTime.now().plusHours(4);
	
	private LoginStatus status = LoginStatus.LOGGED_IN;
	
	@JsonIgnoreProperties("login")
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	public void newLogin() {
		this.apiKey = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
		this.keyExpiryDate = LocalDateTime.now().plusHours(4);
		this.status = LoginStatus.LOGGED_IN;
	}
	
	public void revokeLogin() {
		this.apiKey = null;
		this.keyExpiryDate = null;
		this.status = LoginStatus.LOGGED_OUT;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public LocalDateTime getKeyExpiryDate() {
		return keyExpiryDate;
	}

	public void setKeyExpiryDate(LocalDateTime keyExpiryDate) {
		this.keyExpiryDate = keyExpiryDate;
	}

	public LoginStatus getStatus() {
		return status;
	}

	public void setStatus(LoginStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Login(int loginId, String apiKey, LocalDateTime keyExpiryDate, LoginStatus status, User user) {
		super();
		this.loginId = loginId;
		this.apiKey = apiKey;
		this.keyExpiryDate = keyExpiryDate;
		this.status = status;
		this.user = user;
	}

	public Login() {
		super();
	}
	
}
