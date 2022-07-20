package br.com.java.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.java.entity.PessoaJuridica;

public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Heranca");
		EntityManager em = emf.createEntityManager();
		
		PessoaJuridica pj = new PessoaJuridica();
		pj.setCnpj("92.714.467/0001-11");
		pj.setNome("Lenovo");
		
		em.persist(pj);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
}
