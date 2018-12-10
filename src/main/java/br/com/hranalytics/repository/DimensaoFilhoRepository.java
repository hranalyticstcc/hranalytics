package br.com.hranalytics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hranalytics.model.Dimensao;

@Repository
public interface DimensaoFilhoRepository extends CrudRepository<Dimensao, Long> {

}
