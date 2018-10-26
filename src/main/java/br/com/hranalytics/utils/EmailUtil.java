package br.com.hranalytics.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailUtil {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	public void enviarMensagem(String para, String assunto, String conteudo) {
        enviarEmail(para, assunto, conteudo, false);
    }
	
	public void enviarHtml(String para, String assunto, String conteudoHtml) {
        enviarEmail(para, assunto, conteudoHtml, true);
    }
	
    private void enviarEmail(String para, String assunto, String texto, Boolean ehHtml) {
        try {
            MimeMessage email = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(email, true);
            helper.setTo(para);
            helper.setSubject(assunto);
            helper.setText(texto, ehHtml);
            mailSender.send(email);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
    public String constroiConteudo() {
		Context context = new Context();
        context.setVariable("message", "Confirmacao de cadastro no HR Analytics");
        return templateEngine.process("email_confirmacao_cadastro", context);
    }

}
