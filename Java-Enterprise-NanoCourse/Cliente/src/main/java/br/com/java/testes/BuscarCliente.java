package br.com.java.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.java.entity.Cliente;

public class BuscarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cliente");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 1);
		
		System.out.println("Código do Cliente: " + cliente.getCodigo() + 
				" Nome do Cliente: " + cliente.getNomeCliente());
		
		em.close();
		emf.close();
	}

}
