package br.com.java.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.java.entidades.Carros;

public class CarrosDAO extends GenericDAO<Carros,Integer>{

	public CarrosDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public List <Carros> BuscarCarros(){
		return em.createQuery("from Carros", Carros.class).getResultList();
	}
	
	public List<Carros> BuscarEmOrdem(){
		return em.createQuery("from Carros c order by NomeCarro", Carros.class).getResultList();
	}
	
	public List<Carros> BuscarPorQtde(){
		return em.createQuery("from Carros c order by Marca", Carros.class).setMaxResults(3).getResultList();
	}
}
