package br.com.hranalytics.HrAnalytics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hranalytics.HrAnalytics.model.Personalidade;

@Repository
public interface PersonalidadeRepository extends CrudRepository<Personalidade, Long>{

}
