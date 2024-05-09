package h1y.site.jpa.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminForm {
	
	@NotEmpty(message = "아이디를 입력해주세요.")
	@Pattern(regexp = "^[a-z0-9]{3,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 3~20자리여야 합니다.")
	private String admId;
	
	@NotEmpty(message = "비밀번호를 입력해주세요.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "비밀번호는 8~16자리수여야 합니다. 영문 소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
	private String admPassword;
	
	@NotEmpty(message = "비밀번호 확인을 입력해주세요.")
	private String admPasswordCheck;
	
	@NotEmpty(message = "이름를 입력해주세요.")
	private String admName;
	
	@NotEmpty(message = "이메일을 입력해주세요.")
	@Email
	private String email;
	
	@NotEmpty(message = "주소를 입력해주세요.")
	private String address;
	
	private String adrsDet;
	
	@NotEmpty(message = "우편번호를 입력해주세요.")
	private String zipcode;
	
}
