package br.com.hranalytics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hranalytics.model.Candidato;
import br.com.hranalytics.model.Personalidade;

@Repository
public interface PersonalidadeRepository extends CrudRepository<Personalidade, Long>{
	
	Personalidade findByCandidato(Candidato candidato);
	
}
