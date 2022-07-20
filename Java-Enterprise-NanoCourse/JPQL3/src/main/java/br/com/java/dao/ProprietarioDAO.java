package br.com.java.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.java.entidades.Proprietario;

public class ProprietarioDAO extends GenericDAO<Proprietario,Integer> {

	public ProprietarioDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public List<Proprietario> BuscarProprietario(){
		return em.createQuery("from Proprietario", Proprietario.class).getResultList();
	}
	
	public List<Proprietario> BuscarEmOrdem(){
		return em.createQuery("from Proprietario p order by Name", Proprietario.class).getResultList();
	}
}
