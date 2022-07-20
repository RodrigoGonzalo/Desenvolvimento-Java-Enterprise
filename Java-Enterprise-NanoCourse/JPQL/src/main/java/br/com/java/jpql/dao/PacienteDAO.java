package br.com.java.jpql.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.java.jpql.entidades.Paciente;

public class PacienteDAO extends GenericDAO <Paciente, Integer>{

	public PacienteDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	// Método para buscar na Entidade Paciente, o from ele já entende como SELECT no SQL
	public List<Paciente> ListarPaciente(){
		return em.createQuery("from Paciente", Paciente.class).getResultList();
	}

}
