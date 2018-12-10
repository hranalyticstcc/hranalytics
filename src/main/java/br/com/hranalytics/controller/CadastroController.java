package br.com.hranalytics.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hranalytics.model.Usuario;
import br.com.hranalytics.service.CadastroService;
import br.com.hranalytics.service.UsuarioService;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
	
	@Autowired
	private CadastroService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/candidato")
	public RedirectView cadastrarCandidato(@RequestParam("idEmpresa") String idEmpresa,
											@RequestParam("idCad") String idCad,
											@RequestParam("nome") String nome,
											@RequestParam("dataNascimento") String dataNasicmento,
											@RequestParam("email") String email,
											@RequestParam("perfilTwitter") String perfilTwitter,
											@RequestParam("termos") boolean termos,
											@RequestParam("questao1") String questao1,
											@RequestParam("questao2") String questao2,
											@RequestParam("questao3") String questao3) {
		
		List<String> listaRespostasQuestionario = new ArrayList<>();
		listaRespostasQuestionario.add(questao1);
		listaRespostasQuestionario.add(questao2);
		listaRespostasQuestionario.add(questao3);
		
		return service.cadastrarCandidato(Long.parseLong(idEmpresa), Long.parseLong(idCad), nome,
									dataNasicmento, email, perfilTwitter, listaRespostasQuestionario, termos);
	}
	
	@GetMapping("/{id}/empresa/{idEmpresa}")
	public ModelAndView validaCadastraTemporario(@PathVariable String id, @PathVariable String idEmpresa) {
		return service.redirecionarParaFormularioCandidato(Long.parseLong(id), Long.parseLong(idEmpresa));
	}
	
	@PostMapping
	public ModelAndView cadastrarEmpresaPendente(@Valid Usuario usuario, BindingResult bindingResult) {
		return service.cadastrarEmpresaPendente(usuario, bindingResult);		
	}
	
	@RequestMapping("/cnpj")
	public ModelAndView validarCnpj(@RequestParam String cnpj) {
		return service.validarCnpj(cnpj);
	}
	
	@GetMapping("/gerenciamento")
	public ModelAndView redirectGerenciamentoContaUsuario() {
		return usuarioService.getUsuarioPorId();
	}
	
	@PostMapping("/gerenciarCadastro")
	public RedirectView atualizarCadastro(Usuario usuario, BindingResult bindingResult) {
		usuarioService.atualizaCadastro(usuario);
		return new RedirectView("/cadastro/gerenciamento");
	}
	
	@GetMapping("/excluir")
	public RedirectView excluirCadastro(Usuario usuario) {
		usuarioService.excluirCadastro();
		return new RedirectView("/logout");
	}
	
	@PostMapping("/redefinir")
	public RedirectView redefinirSenha(@RequestParam("senha") String senha) {
		usuarioService.redefinirSenha(senha);
		return new RedirectView("/");
	}
	
	@GetMapping("/telaRedefinir")
	public String telaRedefinirSenha() {
		return "redefinir-senha";
	}
	
	@GetMapping("/telaTermos")
	public String telaTermos() {
		return "termos";
	}
	
	@GetMapping("/esqueciaSenha")
	public String esqueciSenha() {
		return "esqueci-senha";
	}
	
	@PostMapping("/gerarSenha")
	public RedirectView gerarNovaSenha(@RequestParam("email") String email) {
		RedirectView rv = new RedirectView("/");
		
		if(!usuarioService.gerarNovaSenha(email)) {
			rv.setUrl("/cadastro/naoCadastrado");
		}
		
		return rv;
	}
	
	@GetMapping("/naoCadastrado")
	public String naoCadastrado() {
		return "nao-cadastrado";
	}
	
	@GetMapping("/pagamento")
	public String pagamento() {
		return "pagamento";
	}
}
