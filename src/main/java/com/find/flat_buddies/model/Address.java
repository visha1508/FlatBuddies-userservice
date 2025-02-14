package com.find.flat_buddies.model;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.List;

import com.find.flat_buddies.model.PropertyDetails.property_Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@Table(name = "Addresses")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private long addressId;
	
	@Column
	@NotNull(message = "Address must not be empty")
	private String addressLineOne;

	@Column
	@NotNull(message = "City must not be empty")
	private String city;

	@Column
	@NotNull(message = "State must not be empty")
	private String state;

	@Column
	@NotNull(message = "Country must not be empty")
	private String country;

	@Column
	@NotNull(message = "Zipcode must not be empty")
	private String zipCode;

	public Address() {
		super();
	}

	public Address(long addressId, 
			@NotBlank(message = "The address is required.") String addressLineOne,
			@NotBlank(message = "The city is required.") String city,
			@NotBlank(message = "The state is required.") String state,
			@NotBlank(message = "The country is required.") String country,
			@NotNull(message = "The Zip code is required.") String zipCode) {
		super();
		this.addressLineOne = addressLineOne;
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}
	
	

	/**
	 * @return the addressLineOne
	 */
	public String getAddressLineOne() {
		return addressLineOne;
	}

	/**
	 * @param addressLineOne the addressLineOne to set
	 */
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	/**
	 * @return the addressId
	 */
	public long getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId
	 *            the addressId to set
	 */
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the pinCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param pinCode
	 *            the pinCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ",address=" + addressLineOne + ", city=" + city + ", state=" + state + ", Country=" + country
				+ ", zipCode=" + zipCode + "]";
	}

}