package br.com.java.daogenerico.dao;

import javax.persistence.EntityManager;

import br.com.java.daogenerico.entidades.Estabelecimento;

public class EstabelecimentoDAO extends GenericDAO<Estabelecimento, Integer>{
	// A chave prim�ria n�o pode ser um tipo primitivo, ou seja, n�o pode colocar o int

	public EstabelecimentoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}	
	
}
