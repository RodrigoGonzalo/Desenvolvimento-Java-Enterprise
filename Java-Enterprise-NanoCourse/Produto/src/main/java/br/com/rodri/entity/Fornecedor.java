package br.com.rodri.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="tb_fornecedor")
public class Fornecedor {
	
	@Id
	@Column(name="cd_fornecedor")
	@SequenceGenerator(name = "fornecedor", sequenceName = "sq_tb_fornecedor", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor")
	private int id;
	
	@Column(name="nm_fornecedor", length = 50, nullable = false)
	private String nome;
	
	@Column(name="dt_cadastro")
	@CreationTimestamp // Ele coloca a data e hora atual e coloca no banco como um INSERT
	private Calendar dataCadastro;
	
	@Column(name="dt_modificacao")
	@UpdateTimestamp // Mostra a última data em que esse registro foi modificado
	private Calendar dataModificacao;
	
	// Construtores - Vazio e Com Parâmetros
	public Fornecedor() {
		
	}

	public Fornecedor(int id, String nome, Calendar dataCadastro, Calendar dataModificacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.dataModificacao = dataModificacao;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Calendar dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
	
}
