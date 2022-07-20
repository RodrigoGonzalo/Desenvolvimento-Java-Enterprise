package br.com.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;

// Aqui vamos fazer a Heran�a Joined
@Entity
/*@Inheritance(strategy = InheritanceType.JOINED)*/ // Tipo da Heran�a -> JOINED
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Table per class -> Vai criar todas as tabelas herdadas com todos os artributos e eles n�o se relacionam
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)// Ele pega os atributos de todas as entidades e cria em uma �nica tabela
public class Pessoa {
	@Id
	@SequenceGenerator(name = "pessoa", sequenceName = "sq_tb_pessoa", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa")
	private Integer Id;
	
	@Column(length = 60, nullable = false)
	private String Nome;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	
	
}
