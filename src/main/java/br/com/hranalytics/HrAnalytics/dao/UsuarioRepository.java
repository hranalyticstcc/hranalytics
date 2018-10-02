package br.com.hranalytics.HrAnalytics.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.hranalytics.HrAnalytics.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
