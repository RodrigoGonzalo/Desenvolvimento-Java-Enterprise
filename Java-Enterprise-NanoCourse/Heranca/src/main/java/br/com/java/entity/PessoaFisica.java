package br.com.java.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// Essa classe PF, herda as caracter�sticas da classe Pessoa
// Ela n�o precisa mapear o id, ele vem por heran�a

@Entity
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa{
	
	@Column(name = "nr_cpf")
	private String Cpf;

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	
	

}
