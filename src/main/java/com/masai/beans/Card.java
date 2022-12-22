package com.masai.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Card {
	
	//this regular expression will accept master card & VISA  example : 4155279860457
	@Id
	@Pattern(regexp="^4[0-9]{12}(?:[0-9]{3})?$")
	private String cardNumber;
	
	//this regular will accept MM/DD
	@Pattern(regexp= "^(0[1-9]|1[0-2])\\/?([0-9]{2})$" )
	private String validDate;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public Card(@Pattern(regexp = "^4[0-9]{12}(?:[0-9]{3})?$") String cardNumber,
			@Pattern(regexp = "^(0[1-9]|1[0-2])\\/?([0-9]{2})$") String validDate) {
		super();
		this.cardNumber = cardNumber;
		this.validDate = validDate;
	}

	public Card() {
		super();
	}
	
	
}
