package br.com.java.jpql.dao;

import javax.persistence.EntityManager;

import br.com.java.jpql.entidades.Agendamento;

public class AgendamentoDAO extends GenericDAO <Agendamento, Integer>{

	public AgendamentoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
