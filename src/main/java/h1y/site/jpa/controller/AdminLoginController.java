package h1y.site.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController {

	@GetMapping("adm/login")
	public String adminLogin(Model model) {
		
		return "admin/login/login";
		
	}
	
}
