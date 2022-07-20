package br.com.java.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// Essa classe PF, herda as características da classe Pessoa
// Ela não precisa mapear o id, ele vem por herança

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
