package h1y.site.jpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import h1y.site.jpa.domain.Admin;
import h1y.site.jpa.dto.ResultMessage;
import h1y.site.jpa.dto.ResultStatus;
import h1y.site.jpa.form.AdminForm;
import h1y.site.jpa.repository.AdminRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminService {

	private final AdminRepository adminRepository;
	
	@Transactional
	public ResultMessage join(AdminForm adminForm) {
		
		ResultMessage result = new ResultMessage(ResultStatus.SUSSECE, "등록되었습니다.", "adm/login");
		
		this.adminIdCheck(adminForm);
		this.adminEmailCheck(adminForm);
		
		Admin admin = Admin.toEntity(adminForm);
		
		adminRepository.save(admin);
		
		return result;
		
	}
	
	private void adminIdCheck(AdminForm adminForm) {
		
		boolean idCheck = adminRepository.existsByAdmId(adminForm.getAdmId());
		if ( idCheck ) throw new IllegalStateException("이미 사용중인 ID 입니다.");
		
	}
	
	private void adminEmailCheck(AdminForm adminForm) {
		
		boolean emailCheck = adminRepository.existsByEmail(adminForm.getEmail());
		if ( emailCheck ) throw new IllegalStateException("이미 사용중인 이메일 입니다.");
		
	}
	
}
