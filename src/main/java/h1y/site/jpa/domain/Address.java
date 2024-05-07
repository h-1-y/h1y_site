package h1y.site.jpa.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	private String city;
	private String street;
	private String zipcode;
	
	public Address(String city, String street, String zipcode) {
		
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		
	}
	
}
