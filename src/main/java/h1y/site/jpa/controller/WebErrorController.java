package h1y.site.jpa.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class WebErrorController implements ErrorController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		String error_code = status.toString();
		HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));
		String error_message = httpStatus.getReasonPhrase() + " - ";
		
		
		if ( status != null ) {
			
			logger.error("■ ERROR > SERVLET_NAME 	: " + request.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME));
			logger.error("■ ERROR > REQUEST_URI 	: " + request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
			logger.error("■ ERROR > STATUS_CODE 	: " + request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
			logger.error("■ ERROR > EXCEPTION 		: " + request.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
			logger.error("■ ERROR > EXCEPTION_TYPE	: " + request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE));
			logger.error("■ ERROR > MESSAGE 		: " + request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
			
			// Client Error
			if ( error_code.startsWith("4") ) {
				
				if ( error_code.equals("400") ) error_message = error_message + "잘못된 요청 입니다.";
				else if ( error_code.equals("403") ) error_message = error_message + "접근이 금지 되었습니다.";
				else if ( error_code.equals("404") ) error_message = error_message + "요청하신 페이지를 찾을 수 없습니다.";
				else error_message = error_message + "잘못된 요청 입니다.";
				
			}
			
			// Server Error
			else if ( error_code.startsWith("5") ) {
				
				if ( error_code.equals("500") ) error_message = error_message + "일시적인 오류가 발생했습니다.";
				else if ( error_code.equals("502") ) error_message = error_message + "게이트웨이 오류가 발생했습니다.";
				else if ( error_code.equals("503") ) error_message = error_message + "현재 서비스를 이용할 수 없습니다.";
				else error_message = error_message + "일시적인 오류가 발생했습니다.";
				
			}
			
			model.addAttribute("code", status.toString());
			model.addAttribute("msg", error_message);
			model.addAttribute("timestamp", new Date());
			
		}
		
		return "error/error";
		
	}
	
}
