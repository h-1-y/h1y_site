package h1y.site.jpa.domain;

import org.hibernate.annotations.ColumnDefault;

import h1y.site.jpa.form.AdminForm;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Admin {

	@Id
	@GeneratedValue
	@Column(name = "adm_idx")
	private Long idx;
	
	@Column(unique = true)
	@NotNull
	private String admId;
	
	@NotNull
	private String admPassword;
	
	@NotNull
	private String admName;
	
	@NotNull
	private String email;
	
	@ColumnDefault("'N'")
//	@NotNull
	private String authYn;
	
	@Embedded
	private Address address;
	
	public static Admin toEntity(AdminForm form) {
		
		return Admin.builder()
				.admId(form.getAdmId())
				.admPassword(form.getAdmPassword())
				.admName(form.getAdmName())
				.email(form.getEmail())
//				.authYn("N")
				.address(new Address(form.getAddress(), form.getAdrsDet(), form.getZipcode()))
				.build();
		
	}
	
}
