package br.com.hranalytics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Teste {
	
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("teste"));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar c = Calendar.getInstance();
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
	    System.out.println(sdf.format(c.getTime()));
	}

}
