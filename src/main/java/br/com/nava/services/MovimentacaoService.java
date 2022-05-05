package br.com.nava.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.dtos.NovaMovimentacao;
import br.com.nava.model.Correntista;
import br.com.nava.model.Movimentacao;
import br.com.nava.model.MovimentacaoTipo;
import br.com.nava.repository.CorrentistaRepository;
import br.com.nava.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		Double valor = novaMovimentacao.getTipo()==MovimentacaoTipo.RECEITAS ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		
		if (correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		
		
		movimentacaoRepository.save(movimentacao);
		
		
	}
}
