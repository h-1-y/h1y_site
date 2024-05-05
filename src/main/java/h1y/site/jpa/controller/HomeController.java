package h1y.site.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private final String THIS_VIEW = "home/";
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("title", "home");
		
		return THIS_VIEW + "home";
		
	}
	
}
