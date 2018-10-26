package br.com.hranalytics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hranalytics.model.RoleEnum;
import br.com.hranalytics.model.Usuario;
import br.com.hranalytics.repository.UsuarioRepository;
import br.com.hranalytics.utils.EmailUtil;

@Service
public class AdminService {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private EmailUtil email;

	public ModelAndView consultarTodosUsuarios() {
		Iterable<Usuario> usuarios = usuarioRepo.findAllByRole(RoleEnum.PENDING);

		ModelAndView mv = new ModelAndView("gerenciar-cadastros");
		mv.addObject("usuarios", usuarios);

		return mv;
	}

	public RedirectView ativarCadastroPendente(String id) {
		Usuario usuario = usuarioRepo.findById(Long.parseLong(id)).get();
		usuario.setRole(RoleEnum.USER);

		usuarioRepo.save(usuario);
		
		email.enviarHtml(usuario.getEmail(), "HR Analytics", email.constroiConteudo());

		RedirectView rv = new RedirectView("/admin/cadastro/pendentes");
		return rv;
	}

}
