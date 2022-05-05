package br.com.nava.dtos;






import br.com.nava.model.MovimentacaoTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NovaMovimentacao {

	private String descricao;
	private Double valor;
	private Integer idConta;
	private MovimentacaoTipo tipo;	

}
