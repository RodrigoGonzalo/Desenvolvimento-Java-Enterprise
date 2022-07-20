package br.com.java.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_avaliacao")
@IdClass(AvaliacaoId.class) // Ele fala que as colunas que formam a chave primária estão em outra classe, no caso o AvaliacaoId
public class Avaliacao implements Serializable{
	
	@Id
	@JoinColumn(name = "id_usuario")
	@ManyToOne(optional = false)
	private Usuario Usuario;
	
	@Id
	@JoinColumn(name = "id_estabelecimento")
	@ManyToOne(optional = false)
	private Estabelecimento Estabelecimento;
	
	@Column(name = "valor_nota")
	private int Nota;

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.Usuario = usuario;
	}

	public Estabelecimento getEstabelecimento() {
		return Estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.Estabelecimento = estabelecimento;
	}

	public int getNota() {
		return Nota;
	}

	public void setNota(int nota) {
		Nota = nota;
	}
	
	
}
