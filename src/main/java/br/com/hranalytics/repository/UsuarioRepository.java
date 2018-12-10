package br.com.hranalytics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hranalytics.model.RoleEnum;
import br.com.hranalytics.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	public Usuario findByNomeUsuario(String nomeUsuario);
	
	public Iterable<Usuario> findAllByRole(RoleEnum role);
	
	Usuario findByEmail(String email);

}
