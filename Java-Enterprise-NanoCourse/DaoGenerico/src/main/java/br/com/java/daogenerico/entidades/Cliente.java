package br.com.java.daogenerico.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente {
	
	@Id
	private Integer Id;
	private String NomeCliente;
	
	public Cliente() {
		
	}
	
	public Cliente(Integer id, String nomeCliente) {
		super();
		Id = id;
		NomeCliente = nomeCliente;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNomeCliente() {
		return NomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		NomeCliente = nomeCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((NomeCliente == null) ? 0 : NomeCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (NomeCliente == null) {
			if (other.NomeCliente != null)
				return false;
		} else if (!NomeCliente.equals(other.NomeCliente))
			return false;
		return true;
	}
	
	
	
	
}
