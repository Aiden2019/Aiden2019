package com.JC.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer customerId;	
	
	@NotNull
	@Size(min = 3, message = "Invalid Customer name [ cotains at least 3 characters ]")
	private String customerName;
	
	@NotNull
	@Size(min = 12, max = 12, message = "Invalid Mobile Number [ 12 Digit Only ] ")
	private String mobileNumber;

	@NotNull
	@Email(message = "Invalid email format")
	private String email;

	@NotNull
	@Size(min = 4, max = 4, message = "Invalid PIN [ must be 4 digits ]")
	@Pattern(regexp = "^[0-9]{4}$", message = "Invalid PIN [ must contain only digits ]")
	private String pin;

	// Confirm PIN field
	@Transient // Exclude from persistence
	@NotNull
	@Size(min = 4, max = 4, message = "Invalid Confirm PIN [ must be 4 digits ]")
	private String confirmPin;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "wallet_Id")
	private Wallet wallet;
	
}
