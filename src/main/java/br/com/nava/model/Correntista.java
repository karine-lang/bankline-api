package br.com.nava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Correntista {
private Integer id;
private String cpf;
private String nome;
private Conta conta;
}
