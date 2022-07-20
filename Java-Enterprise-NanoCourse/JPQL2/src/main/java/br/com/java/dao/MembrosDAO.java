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
	 * M�todo que Lista o nome dos Membros
	 * @return
	 */
	public List<Membros> ListarMembros(){
		return em.createQuery("from Membros", Membros.class).getResultList();
	}
	
//***************************************************************************************************
	
	/**
	 * M�todo que Lista os nomes dos membros em ordem alfab�tica
	 * Para colocar de tr�s pra frente coloque "desc" na Query
	 * @return
	 */
	public List<Membros> ListarPorNome(){
		return em.createQuery("from Membros m order by NomeMembro", Membros.class).getResultList();
	}
	
	/**
	 * M�tdodo que permite que voc� liste a quantidade de membros que voc� quiser
	 * Exemplo: Escolhi listar os 3 primeiros nomes da minha base de dados (em ordem alfab�tica)
	 * @return
	 */
	public List<Membros> ListagemPorQtde(){
		return em.createQuery("from Membros m order by NomeMembro", Membros.class).setMaxResults(3).getResultList();
	}
	
	/**
	 * M�todo de Listagem que permite que voc� escolha de que ponto voc� quer que comece e termine
	 * Exemplo: Quero que comece selecionando o dado que est� na posi��o 5 e termine na posi��o 10
	 * @param inicio
	 * @param fim
	 * @return
	 */
	public List<Membros> ListagemSeletiva(int inicio, int fim){
		return em.createQuery("from Membros m order by NomeMembro", Membros.class)
				.setFirstResult(inicio).setMaxResults(fim).getResultList();
	}

//***************************************************************************************************
	//A partir daqui vamos ter m�todos de consultas com par�metros, consultas par�metrizadas!!!
	/**
	 * M�todo para buscar um nome na base de dados
	 * A % podemos colocar um sobrenome ou nome e ele vai buscar na base
	 * O like contrbu� pra isso tamb�m
	 * @param nome
	 * @return
	 */
	public List<Membros> BuscaPorNome(String nome){
		return em.createQuery("from Membros m where m.NomeMembro like :nome", Membros.class)
				.setParameter("nome","%"+ nome + "%").getResultList();
	}
	
	/**
	 * M�todo que busca os membros pela data do nascimento
	 * @param data
	 * @return
	 */
	public List<Membros> BuscaPorDataNascimento(Calendar data){
		return em.createQuery("from Membros m where m.DataNascimento = :datanasc", Membros.class)
				.setParameter("datanasc", data).getResultList();
	}
	
	
}
