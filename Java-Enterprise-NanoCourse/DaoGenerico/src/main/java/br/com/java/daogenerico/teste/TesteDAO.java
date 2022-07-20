package br.com.java.daogenerico.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.java.daogenerico.dao.ClienteDAO;
import br.com.java.daogenerico.entidades.Cliente;

public class TesteDAO {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DaoGenerico");
		EntityManager em = emf.createEntityManager();
		
		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		Cliente entidade = new Cliente(0, "Arnaldo");
		clienteDAO.Cadastrar(entidade);
		
		try {
			clienteDAO.Commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		List<Cliente> lista = clienteDAO.Listar();
		for (Cliente cliente : lista) {
			System.out.println(cliente.getId()+ " " + cliente.getNomeCliente());
		}
		
		System.out.println("------------------------------------------------------");
		
		try {
			clienteDAO.Buscar(1);
			System.out.println(entidade.getId() + " " + entidade.getNomeCliente());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("------------------------------------------------------");
		
		try {
			clienteDAO.Buscar(0);
			clienteDAO.Remover(0);
			System.out.println("Cliente removido com sucesso!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
