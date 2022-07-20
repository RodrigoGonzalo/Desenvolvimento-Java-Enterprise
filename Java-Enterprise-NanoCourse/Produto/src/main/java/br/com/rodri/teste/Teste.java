package br.com.rodri.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Cria uma factory e precisa o nome da unidade de persistência ou Persistence Unit que está no Persistence.xml7
		// Com ele podemos criar uma EntityManager
		/*EntityManagerFactory emf =*/ Persistence.createEntityManagerFactory("Produto").createEntityManager();
		/*
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		*/
	}

}
