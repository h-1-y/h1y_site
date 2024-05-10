package h1y.site.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import h1y.site.jpa.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	boolean existsByAdmId(String admId);
	
	boolean existsByEmail(String email);
	
}
