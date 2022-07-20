package br.com.java.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.java.entidades.Membros;

public class MembrosDAO extends GenericDAO<Membros, Integer>{

	public MembrosDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Método que Lista o nome dos Membros
	 * @return
	 */
	public List<Membros> ListarMembros(){
		return em.createQuery("from Membros", Membros.class).getResultList();
	}
	
//***************************************************************************************************
	
	/**
	 * Método que Lista os nomes dos membros em ordem alfabética
	 * Para colocar de trás pra frente coloque "desc" na Query
	 * @return
	 */
	public List<Membros> ListarPorNome(){
		return em.createQuery("from Membros m order by NomeMembro", Membros.class).getResultList();
	}
	
	/**
	 * Métdodo que permite que você liste a quantidade de membros que você quiser
	 * Exemplo: Escolhi listar os 3 primeiros nomes da minha base de dados (em ordem alfabética)
	 * @return
	 */
	public List<Membros> ListagemPorQtde(){
		return em.createQuery("from Membros m order by NomeMembro", Membros.class).setMaxResults(3).getResultList();
	}
	
	/**
	 * Método de Listagem que permite que você escolha de que ponto você quer que comece e termine
	 * Exemplo: Quero que comece selecionando o dado que está na posição 5 e termine na posição 10
	 * @param inicio
	 * @param fim
	 * @return
	 */
	public List<Membros> ListagemSeletiva(int inicio, int fim){
		return em.createQuery("from Membros m order by NomeMembro", Membros.class)
				.setFirstResult(inicio).setMaxResults(fim).getResultList();
	}

//***************************************************************************************************
	//A partir daqui vamos ter métodos de consultas com parâmetros, consultas parâmetrizadas!!!
	/**
	 * Método para buscar um nome na base de dados
	 * A % podemos colocar um sobrenome ou nome e ele vai buscar na base
	 * O like contrbuí pra isso também
	 * @param nome
	 * @return
	 */
	public List<Membros> BuscaPorNome(String nome){
		return em.createQuery("from Membros m where m.NomeMembro like :nome", Membros.class)
				.setParameter("nome","%"+ nome + "%").getResultList();
	}
	
	/**
	 * Método que busca os membros pela data do nascimento
	 * @param data
	 * @return
	 */
	public List<Membros> BuscaPorDataNascimento(Calendar data){
		return em.createQuery("from Membros m where m.DataNascimento = :datanasc", Membros.class)
				.setParameter("datanasc", data).getResultList();
	}
	
	
}
