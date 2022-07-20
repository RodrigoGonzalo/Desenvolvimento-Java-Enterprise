package br.com.java.daogenerico.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Estabelecimento {

	@Id
	private Integer Id;
	private String NomeEstabelecimento;
	
	public Estabelecimento() {
		
	}

	public Estabelecimento(Integer id, String nomeEstabelecimento) {
		super();
		Id = id;
		NomeEstabelecimento = nomeEstabelecimento;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNomeEstabelecimento() {
		return NomeEstabelecimento;
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		NomeEstabelecimento = nomeEstabelecimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((NomeEstabelecimento == null) ? 0 : NomeEstabelecimento.hashCode());
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
		Estabelecimento other = (Estabelecimento) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (NomeEstabelecimento == null) {
			if (other.NomeEstabelecimento != null)
				return false;
		} else if (!NomeEstabelecimento.equals(other.NomeEstabelecimento))
			return false;
		return true;
	}
	
	
	
	
}
