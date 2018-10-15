package br.com.hranalytics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.hranalytics.model.RoleEnum;
import br.com.hranalytics.model.Usuario;
import br.com.hranalytics.repository.UsuarioRepository;

@Component
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public CustomUserDetailService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		Usuario usuario = Optional.ofNullable(usuarioRepository.buscarPorNome(username))
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		
		return new User(usuario.getUsuario(), usuario.getSenha(), 
				usuario.getAdmin() == RoleEnum.ADMIN ? authorityListAdmin : authorityListUser);
	}

}
