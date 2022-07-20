package br.com.java.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.java.entidades.Client;
import br.com.java.entidades.ContratoAluguel;
import br.com.java.entidades.Estabelecimento;
import br.com.java.entidades.TipoEstabelecimento;


public class Cadastro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Relacionamentos");
		EntityManager em = emf.createEntityManager();
		
		// Vamos Persistir tudo em CASCATA, 
		TipoEstabelecimento tipo = new TipoEstabelecimento(0, "PetShop", null);
		
		Client client = new Client(0,"Rodrigo", null);
		Client client2 = new Client(0,"Catarina", null);
		
		ContratoAluguel contrato = new ContratoAluguel(0, 1000, new GregorianCalendar(2022, Calendar.JUNE, 03), null);

		
		List<Client> ListaClientes = new ArrayList<>();
		ListaClientes.add(client);
		ListaClientes.add(client2);
		
		// O Estabelecimento é o principal, pois temos tudo aqui, contrato, tipo e os Clientes que criamos e adicionamos em uma lista
		// Ele é o último elemento da nossa Cascata
		Estabelecimento est1 = new Estabelecimento(0, "Lola´s PetShop", null, tipo, ListaClientes);
		Estabelecimento est2 = new Estabelecimento(0, "Happy Pet", contrato, tipo, ListaClientes);
		
		// Aqui setamos em qual estabelecimento está destinado esse contrato
		contrato.setEstabelecimento(est2);
		
		// Por último persistimos tudo
		// Vamos persistir o Estabelecimento pois ele tem todos os atributos que precisamos
		try {
			em.persist(est1);
			em.persist(est2);
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(em.getTransaction().isActive()) {
				e.printStackTrace();
				em.getTransaction().rollback();
			}
		}

		em.close();
		emf.close();
	}

}
