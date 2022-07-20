package br.com.java.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.java.entity.Cliente;

public class AtualizarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cliente");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente(1, "Catarina");
		
		System.out.println(cliente.getCodigo() + cliente.getNomeCliente());
		
		try {
			em.merge(cliente);
			em.getTransaction().begin();
			em.getTransaction().commit();
			System.out.println("Cliente atualizar com sucesso");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(em.getTransaction().isActive()) {
				e.printStackTrace();
				em.getTransaction().rollback();
				System.out.println("Não foi possível atualizar o cliente");
			}
		}
		em.close();
		emf.close();
	}

}
