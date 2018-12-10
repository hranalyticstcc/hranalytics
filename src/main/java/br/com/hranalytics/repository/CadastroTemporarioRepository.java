package br.com.hranalytics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hranalytics.model.CadastroTemporario;

@Repository
public interface CadastroTemporarioRepository extends CrudRepository<CadastroTemporario, Long> {

}
