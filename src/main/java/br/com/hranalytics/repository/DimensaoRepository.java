package br.com.hranalytics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hranalytics.model.Fator;

@Repository
public interface DimensaoRepository extends CrudRepository<Fator, Long> {

}
