package br.com.java.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.java.entity.Cliente;

public class RemoverCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cliente");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 1);
		System.out.println("Código do Cliente: " + cliente.getCodigo() + 
				"Nome do Cliente: " + cliente.getNomeCliente());
		
		try {
			em.remove(cliente);
			em.getTransaction().begin();
			em.getTransaction().commit();
			System.out.println("Cliente removido com sucesso");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(em.getTransaction().isActive()) {
				e.printStackTrace();
				em.getTransaction().rollback();
				System.out.println("Não foi possível remover o cliente");
			}
		}
		em.close();
		emf.close();
	}

}
