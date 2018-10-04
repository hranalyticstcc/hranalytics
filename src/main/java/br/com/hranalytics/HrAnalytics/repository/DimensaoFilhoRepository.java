package br.com.hranalytics.HrAnalytics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hranalytics.HrAnalytics.model.DimensaoFilho;

@Repository
public interface DimensaoFilhoRepository extends CrudRepository<DimensaoFilho, Long> {

}
