package br.com.hranalytics.repository;

import java.util.Calendar;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hranalytics.model.Pagamento;
import br.com.hranalytics.model.Usuario;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {
	
	Pagamento findByUsuarioAndDataPagamentoGreaterThanEqualAndDataPagamentoLessThanEqual(Usuario usuario, Calendar start, Calendar end);
	
}
