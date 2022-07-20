package br.com.java.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//Essa classe PF, herda as características da classe Pessoa
//Ela não precisa mapear o id, ele vem por herança


@Entity
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa{
	
	@Column(name = "nr_cnpj")
	private String Cnpj;

	public String getCnpj() {
		return Cnpj;
	}

	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}
	
	
}
