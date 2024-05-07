package h1y.site.jpa.domain;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Admin {

	@Id
	@GeneratedValue
	@Column(name = "adm_idx")
	private Long idx;
	
	@Column(unique = true)
	private String admId;
	
	@NotNull
	private String admPassword;
	
	@NotNull
	private String admName;
	
	@NotNull
	private String email;
	
	@ColumnDefault("'N'")
	@NotNull
	private String authYn;
	
	@Embedded
	private Address address;
	
}
