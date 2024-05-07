package h1y.site.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("adm")
	public String adminHome(Model model) {
		
		return "admin/home/home";
		
	}
	
}
