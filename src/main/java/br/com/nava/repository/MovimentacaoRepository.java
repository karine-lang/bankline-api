package br.com.nava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nava.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
	public List<Movimentacao>findByIdConta(Integer idConta);
}
