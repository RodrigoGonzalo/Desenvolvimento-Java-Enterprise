package br.com.java.jpql.dao;

import javax.persistence.EntityManager;

import br.com.java.jpql.entidades.Especialidade;

public class EspecialidadeDAO extends GenericDAO <Especialidade, Integer>{

	public EspecialidadeDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
