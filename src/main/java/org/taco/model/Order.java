package org.taco.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
public class Order {
	
	@NotBlank(message="Name is required!")
	private String name;
	
	@NotBlank(message="Street is required!")
	private String street;
	
	@NotBlank(message="City is required!")
	private String city;
	
	@NotBlank(message="State is required!")
	private String state;
	
	@NotBlank(message="Zip is required!")
	private String zip;
	
	@CreditCardNumber(message="Not a valid credit card number")
	private String ccNumber;
														   //(0[1-9]|1[0-2])([\\/])([1-9][0-9])$
	@Pattern(message="Must be formatted MM / YY", regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])")
	private String ccExpiration;
	
	@Digits(message="Invalid CVV", integer=3, fraction=0)
	private String ccCVV;
	

	@Override
	public String toString() {
		return super.toString() + ": " + this.getClass() + "; "  + this.getName() + "; " + this.getCity() ;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpiration() {
		return ccExpiration;
	}

	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}

	public String getCcCVV() {
		return ccCVV;
	}

	public void setCcCVV(String ccCvv) {
		this.ccCVV = ccCvv;
	}
	
}

