package br.com.hranalytics.HrAnalytics.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hranalytics.HrAnalytics.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query("select u from Usuario u where u.nome = ?1")
	public Usuario buscarPorNome(String usuario);

}
