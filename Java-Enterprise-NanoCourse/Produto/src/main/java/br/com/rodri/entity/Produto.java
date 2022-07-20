package br.com.rodri.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

@Entity // É a tabela que será criada no banco
@Table(name = "TB_Produto") // Você pode nomear uma tabela usando os padrões do SQL
public class Produto { // Sem o @Table, a tabela será criada com o nome da classe criada aqui no Java
	
	@Id
	@SequenceGenerator(name = "produto", sequenceName = "sq_tb_produto", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	@Column(name = "cd_produto")
	private int id;
	
	@Column(name = "nm_produto", length = 60, nullable = false)
	private String nome;
	
	@Column(name = "vl_preco")
	private BigDecimal preco;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_data_validade")
	private Calendar dataValidade;
	
	//Usando a anotação Enumerated para usar um enum que criamos
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@Column(name="dt_cadastro")
	@CreationTimestamp
	private Calendar dataCadastro;
	
	@Column(name="dt_modificacao")
	@UpdateTimestamp
	private Calendar dataModificacao;
	
	// Vamos colocar desconto usando a anotação @Formula
	@Formula("vl_preco * 0.9")
	private BigDecimal precoDesconto;
	
}
