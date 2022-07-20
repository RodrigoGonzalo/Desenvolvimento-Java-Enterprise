package br.com.java.jpql.dao;

import javax.persistence.EntityManager;

import br.com.java.jpql.entidades.Consulta;

public class ConsultaDAO extends GenericDAO <Consulta, Integer>{

	public ConsultaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	
}
