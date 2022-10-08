package br.com.cotiinformatica.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Contato {

	private Integer idContato;
	private String nome;
	private String telefone;
	private String email;
	private Date dataNasc;
	private Usuario usuario; // associação a tabela usuario relação 1 para muitos

}
