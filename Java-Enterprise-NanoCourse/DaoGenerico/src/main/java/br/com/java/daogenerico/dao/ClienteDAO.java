package br.com.java.daogenerico.dao;

import javax.persistence.EntityManager;

import br.com.java.daogenerico.entidades.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Integer>{
	// A chave prim�ria n�o pode ser um tipo primitivo, ou seja, n�o pode colocar o int

	public ClienteDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	} 
	
}
