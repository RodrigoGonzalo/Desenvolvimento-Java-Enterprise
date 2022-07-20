package br.com.java.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//Essa classe PF, herda as caracter�sticas da classe Pessoa
//Ela n�o precisa mapear o id, ele vem por heran�a


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
