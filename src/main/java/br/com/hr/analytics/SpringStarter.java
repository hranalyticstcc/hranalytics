package br.com.hr.analytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class SpringStarter {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Olá";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringStarter.class, args);
	}

}
