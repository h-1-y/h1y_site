package h1y.site.jpa.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

	private String address;
	private String adrsDet;
	private String zipcode;
	
	protected Address() {}
	
	public Address(String address, String adrsDet, String zipcode) {
		
		this.address = address;
		this.adrsDet = adrsDet;
		this.zipcode = zipcode;
		
	}
	
}
