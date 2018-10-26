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
		
		Usuario usuario = Optional.ofNullable(usuarioRepository.findByNomeUsuario(username))
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER","ROLE_USER_PEDING");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		List<GrantedAuthority> authorityListUserPending = AuthorityUtils.createAuthorityList("ROLE_USER_PEDING");
		
		List<GrantedAuthority> authorityList = null;
		
		if(usuario.getRole() == RoleEnum.ADMIN) {
			authorityList = authorityListAdmin;
		}else if(usuario.getRole() == RoleEnum.USER) {
			authorityList = authorityListUser;
		}else {
			authorityList = authorityListUserPending;
		}
		
		return new User(usuario.getNomeUsuario(), usuario.getSenha(), authorityList);
	}

}
