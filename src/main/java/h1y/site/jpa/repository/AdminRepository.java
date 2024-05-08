package h1y.site.jpa.repository;

import org.springframework.stereotype.Repository;

import h1y.site.jpa.domain.Admin;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminRepository {

	private final EntityManager em;
	
	public void save(Admin admin) {
		
		em.persist(admin);
		
	}
	
}