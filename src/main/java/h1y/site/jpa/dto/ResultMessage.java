package h1y.site.jpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultMessage {

	private ResultStatus status;
	private String message;
	private String returnUrl;
	
	public ResultMessage(ResultStatus status, String message, String returnUrl) {
		
		this.status = status;
		this.message = message;
		this.returnUrl = returnUrl;
		
	}
	
}
