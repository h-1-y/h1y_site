package h1y.site.jpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import h1y.site.jpa.domain.Admin;
import h1y.site.jpa.form.AdminForm;
import h1y.site.jpa.repository.AdminRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminService {

	private final AdminRepository adminRepository;
	
	@Transactional
	public Long join(AdminForm adminForm) {
		
		System.out.println("adminForm.getAdmName() ========== " + adminForm.getAdmName());
		
		// 패스워드 입력값이 패스워드체크 입력값이랑동일한지 체크 
		// if
		// else 
		
		Admin admin = Admin.toEntity(adminForm);
		
		System.out.println("admin.getAdmName() ============ " + admin.getAdmName());
		System.out.println("admin.getAddress().getAddress() ======= " + admin.getAddress().getAddress());
		System.out.println("admin.getAddress().getAdrsDet() ======== " + admin.getAddress().getAdrsDet());
		System.out.println("admin.getAddress().getAdrsDet() ========== " + admin.getAddress().getZipcode());
		
		adminRepository.save(admin);
		
		return admin.getIdx();
		
	}
	
}
