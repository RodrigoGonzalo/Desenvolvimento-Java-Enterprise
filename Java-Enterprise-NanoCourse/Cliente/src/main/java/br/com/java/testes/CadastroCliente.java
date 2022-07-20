package br.com.java.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.java.entity.Cliente;

public class CadastroCliente {
	public static void main(String[] args) {
		
		// Criando a fábrica e o Enitity Manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cliente");
		EntityManager em = emf.createEntityManager();
		
		// Criando o Objeto
		Cliente cliente = new Cliente();
		cliente.setNomeCliente("Eduardo");
		
		try {
			em.persist(cliente);
			em.getTransaction().begin();
			em.getTransaction().commit();
			System.out.println("Cliente cadastrado com sucesso");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(em.getTransaction().isActive()) {
				e.printStackTrace();
				em.getTransaction().rollback();
				System.out.println("Não foi possível cadastrar o cliente");
			}
		}
		em.close();
		emf.close();
	}
}
