package eventgram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
	
	@RequestMapping(value = "/")
	public String index(){
		return "auth/index";
	}
	
	@RequestMapping(value = "/authorized")
	public String showAuthorizedMessage(){
		return "auth/authorized";
	}
}
