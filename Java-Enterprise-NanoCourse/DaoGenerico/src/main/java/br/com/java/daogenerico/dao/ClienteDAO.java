package br.com.java.daogenerico.dao;

import javax.persistence.EntityManager;

import br.com.java.daogenerico.entidades.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Integer>{
	// A chave primária não pode ser um tipo primitivo, ou seja, não pode colocar o int

	public ClienteDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	} 
	
}
