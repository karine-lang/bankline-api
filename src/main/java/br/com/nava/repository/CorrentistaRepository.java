package br.com.nava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nava.model.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

}
