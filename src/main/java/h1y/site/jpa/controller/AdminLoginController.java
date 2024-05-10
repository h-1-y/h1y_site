package h1y.site.jpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import h1y.site.jpa.dto.ResultMessage;
import h1y.site.jpa.dto.ResultStatus;
import h1y.site.jpa.form.AdminForm;
import h1y.site.jpa.service.AdminService;
import jakarta.servlet.RequestDispatcher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminLoginController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final AdminService adminService;
	
	@GetMapping("adm/login")
	public String adminLogin(Model model) {
		
		return "admin/login/login";
		
	}
	
	@GetMapping("adm/join")
	public String adminJoin(Model model) {
		
		model.addAttribute("adminForm", new AdminForm());
		
		return "admin/login/join";
		
	}
	
	@PostMapping("adm/join")
	public String adminJoinProc(@Valid AdminForm adminForm, BindingResult result) {
		
		// validation check
		if ( result.hasErrors() ) {
			
			for ( FieldError error : result.getFieldErrors() ) 
				logger.info("■ JOIN VALIDATION ERROR > : " + error.getDefaultMessage());
				
			return "admin/login/join";
			
		}
		
		ResultMessage resultMsg = adminService.join(adminForm);
		
		if ( resultMsg.getStatus().equals(ResultStatus.SUSSECE) ) {
			
			System.out.println("status ====== " + resultMsg.getStatus());
			System.out.println("message ===== " + resultMsg.getMessage());
			System.out.println("returnUrl === " + resultMsg.getReturnUrl());
			
		} else {
			
			System.out.println("status ====== " + resultMsg.getStatus());
			System.out.println("message ===== " + resultMsg.getMessage());
			System.out.println("returnUrl === " + resultMsg.getReturnUrl());
			
		}
		
		return "redirect:/adm/login";
		
	}
	
}
