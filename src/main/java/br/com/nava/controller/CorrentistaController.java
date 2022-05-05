package br.com.nava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nava.dtos.NovoCorrentista;
import br.com.nava.model.Correntista;
import br.com.nava.repository.CorrentistaRepository;
import br.com.nava.services.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
	@Autowired
	private CorrentistaRepository correntistaRepository;
	@Autowired
	private CorrentistaService correntistaService;
	
	@GetMapping
	public List<Correntista> findAll() { 
		return correntistaRepository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovoCorrentista correntista) {
		correntistaService.save(correntista);
	}

}
