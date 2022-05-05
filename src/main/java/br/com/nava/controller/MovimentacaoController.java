package br.com.nava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nava.dtos.NovaMovimentacao;

import br.com.nava.model.Movimentacao;

import br.com.nava.repository.MovimentacaoRepository;

import br.com.nava.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private MovimentacaoService movimentacaoService;

	
	@GetMapping
	public List<Movimentacao> findAll() { 
		return movimentacaoRepository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovaMovimentacao movimentacao) {
		movimentacaoService.save(movimentacao);
	}
	
	 @GetMapping("/{idConta}")
		public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
			return movimentacaoRepository.findByIdConta(idConta);
		}

}