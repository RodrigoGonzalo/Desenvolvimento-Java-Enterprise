package br.com.java.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {
	
	@Id
	@SequenceGenerator(name = "estabelecimento", sequenceName = "sq_tb_estabelecimeto", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estabelecimento")
	@Column(name = "id_estabelecimento")
	private Integer IdEstabelecimento;
	
	@Column(name = "nome_estabelecimento", length = 50)
	private String NomeEstabelecimento;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao")
	private Calendar DataCriacao;

	public Integer getIdEstabelecimento() {
		return IdEstabelecimento;
	}

	public void setIdEstabelecimento(Integer idEstabelecimento) {
		IdEstabelecimento = idEstabelecimento;
	}

	public String getNomeEstabelecimento() {
		return NomeEstabelecimento;
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		NomeEstabelecimento = nomeEstabelecimento;
	}

	public Calendar getDataCriacao() {
		return DataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		DataCriacao = dataCriacao;
	}
	
	
}
