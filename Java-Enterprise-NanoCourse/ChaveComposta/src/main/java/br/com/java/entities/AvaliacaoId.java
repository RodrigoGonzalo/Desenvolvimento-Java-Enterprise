package br.com.java.entities;

import java.io.Serializable;


// Essa é uma classe que armazena as chaves primárias das tabelas Usuario e Estabelecimento
public class AvaliacaoId implements Serializable{
	
	private Integer Usuario;
	
	private Integer Estabelecimento;
	
	
	public AvaliacaoId() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AvaliacaoId(Integer usuario, Integer estabelecimento) {
		super();
		Usuario = usuario;
		Estabelecimento = estabelecimento;
	}


	public Integer getUsuario() {
		return Usuario;
	}


	public void setUsuario(Integer usuario) {
		Usuario = usuario;
	}


	public Integer getEstabelecimento() {
		return Estabelecimento;
	}


	public void setEstabelecimento(Integer estabelecimento) {
		Estabelecimento = estabelecimento;
	}

	//O hashcode e o Equals ele precisa estar aqui pra saber se os valores dos atributos são iguais
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Estabelecimento == null) ? 0 : Estabelecimento.hashCode());
		result = prime * result + ((Usuario == null) ? 0 : Usuario.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoId other = (AvaliacaoId) obj;
		if (Estabelecimento == null) {
			if (other.Estabelecimento != null)
				return false;
		} else if (!Estabelecimento.equals(other.Estabelecimento))
			return false;
		if (Usuario == null) {
			if (other.Usuario != null)
				return false;
		} else if (!Usuario.equals(other.Usuario))
			return false;
		return true;
	}
	
	
	
	
}
