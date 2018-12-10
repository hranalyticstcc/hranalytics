package br.com.hranalytics.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hranalytics.model.Candidato;
import br.com.hranalytics.model.Usuario;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Long> {
	
	List<Candidato> findByUsuario(Usuario usuario);
	
	Candidato findByPerfilTwitter(String perfilTwitter);
	
}
