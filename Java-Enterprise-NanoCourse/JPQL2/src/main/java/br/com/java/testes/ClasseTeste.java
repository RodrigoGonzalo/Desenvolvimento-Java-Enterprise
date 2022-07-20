package br.com.java.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.java.dao.MembrosDAO;
import br.com.java.entidades.GeneroMembro;
import br.com.java.entidades.Membros;

// Classe onde vamos implementar os métodos e objetos.
public class ClasseTeste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQL2");
		EntityManager em = emf.createEntityManager();
		
		// Criando o Objeto DAO que recebe o EntityManager como Parâmetro.
		MembrosDAO Mdao = new MembrosDAO(em);
		
		// Criando o objeto e implementando os valores de acordo com o construtor.
		/*
		Membros entidade = new Membros("Maria Alice Castro", "mariacastrol@email.com", new GregorianCalendar(1990, 04, 15), 
				new GregorianCalendar(2007, 10, 18), GeneroMembro.FEMININO);
		*/
		
//***************************************************************************************************		
		/*
		 */
		/**
		 *  Chamando o método Cadastrar do GenericDAO.
		 */
		//Mdao.Cadastrar(entidade);
		
//***************************************************************************************************
	
		/**
		 * Chamando o método Atualizar do GenericDAO
		 */
		//Mdao.Atualizar(entidade);
		
//***************************************************************************************************
		
		/**
		 * Chamando o método Remover do GenericDAO
		 */
		/*
		try {
			Mdao.Remover(2);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
//***************************************************************************************************
		/**
		 * Método para Listar os Nomes dos Membros Cadastrados no banco
		 * Método criado na classe MembrosDAO
		 */
		/*
		List<Membros> listarMembros = Mdao.ListagemSeletiva(1,2);
		for (Membros entidade : listarMembros) {
			System.out.println(entidade.getNomeMembro());
		}
		*/
		
//***************************************************************************************************
		/**
		 * Buscamos o método BuscaPorNome que criamos na classe MembrosDAO
		 * Ela vai buscar por todas as Alices que existem na base de dados
		 */
		/*
		List<Membros> BuscarMembros = Mdao.BuscaPorNome("Alice");
		for (Membros entidade : BuscarMembros) {
			System.out.println(entidade.getNomeMembro());
		}
		*/
//***************************************************************************************************
		/**
		 * Método de buscar por data de nascimento que criamos na classe membrosDAO
		 */

		List<Membros> BuscarPorDataNascimento = Mdao.BuscaPorDataNascimento(new GregorianCalendar(1976, Calendar.JUNE, 14));
		for (Membros entidade : BuscarPorDataNascimento) {
			System.out.println(entidade.getDataNascimento() + entidade.getNomeMembro());
		}
		
//***************************************************************************************************
		
		// Chamando o método Commit do GenericDAO.
		/*
		try {
			Mdao.Commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		// Fechando a Fábrica e o EntityManager
		em.close();
		emf.close();
	}

}
