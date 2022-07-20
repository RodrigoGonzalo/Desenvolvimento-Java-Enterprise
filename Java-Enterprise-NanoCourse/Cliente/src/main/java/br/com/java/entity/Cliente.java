package br.com.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// Criando a entidade e nomeando a tabela que vai aparecer no SQL
@Entity
@Table(name = "tbl_cliente")
public class Cliente {
	/*
	 * Criando as colunas, a chave primária da tabela e colocando para gerar id´s em sequência.
	 */
	
	@Id
	@SequenceGenerator(name = "cliente", sequenceName = "sq_tbl_cliente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	@Column(name = "cd_cliente")
	private Integer Codigo;
	
	@Column(name = "nm_cliente")
	private String NomeCliente;
	
	// Cosntrutores
	
	public Cliente() {
		
	}
	

	public Cliente(Integer codigo, String nomeCliente) {
		super();
		Codigo = codigo;
		NomeCliente = nomeCliente;
	}

	// Getters and Setters
	public Integer getCodigo() {
		return Codigo;
	}

	public void setCodigo(Integer codigo) {
		Codigo = codigo;
	}

	public String getNomeCliente() {
		return NomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		NomeCliente = nomeCliente;
	}
	

	
	
}
