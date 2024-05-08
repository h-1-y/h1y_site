package h1y.site.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import h1y.site.jpa.domain.Address;
import h1y.site.jpa.domain.Admin;
import h1y.site.jpa.form.AdminForm;
import h1y.site.jpa.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminLoginController {

	private final AdminService adminService;
	
	@GetMapping("adm/login")
	public String adminLogin(Model model) {
		
		return "admin/login/login";
		
	}
	
	@GetMapping("adm/join")
	public String adminJoin(Model model) {
		
		return "admin/login/join";
		
	}
	
	@PostMapping("adm/join")
	public String adminJoinProc(@Valid AdminForm adminForm) {
		
		adminService.join(adminForm);
		
		return "redirect:/";
		
	}
	
}
