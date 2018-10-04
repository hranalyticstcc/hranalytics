package br.com.hranalytics.HrAnalytics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hranalytics.HrAnalytics.model.Dimensao;

@Repository
public interface DimensaoRepository extends CrudRepository<Dimensao, Long> {

}
