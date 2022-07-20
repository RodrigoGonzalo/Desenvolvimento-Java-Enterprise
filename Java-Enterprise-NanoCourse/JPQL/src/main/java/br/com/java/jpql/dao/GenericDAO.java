package br.com.java.jpql.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
/**
 * Classe GenericDAO
 * @author rodri
 *
 * @param <T>
 * @param <K>
 */
public class GenericDAO <T,K>{
	
	// Criando o EntityManager, ele será protected pois será utilizado como dado de herança
	protected EntityManager em;
	
	// Variável Clazz
	private Class<T> Clazz;
	
	/**
	 * Construtor do GenericDAO
	 * @param em
	 */
	public GenericDAO(EntityManager em) {
		this.em = em;
		
		Clazz = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	/**
	 * Método Cadastrar - Ele persiste os dados que colocamos no objeto, depois tem commitar essa mudança usando o método Commit
	 * @param entidade
	 */
	public void Cadastrar(T entidade) {
		em.persist(entidade);
	}
	
	/**
	 * Método Atualizar - Ele atualiza o dado no banco, depois tem commitar essa mudança usando o método Commit
	 * @param entidade
	 */
	public void Atualizar(T entidade) {
		em.merge(entidade);
	}
	
	/**
	 * Método Buscar - Ele busca o dado com base no ID
	 * @param chave
	 * @return
	 */
	public T Buscar(K chave) {
		return em.find(Clazz, chave);
	}
	
	/**
	 * Método Remover - Ele remove o membro do banco atrvés da chave que é o seu ID.
	 * Depois tem que usar o método Commit para commitar essa remoção
	 * @param chave
	 * @throws Exception
	 */
	public void Remover(K chave) throws Exception{
		T entidade = Buscar(chave);
		if(entidade == null) {
			throw new Exception("AVISO: Chave Não Encontrada");
		}
		
		em.remove(entidade);
	}
	
	/**
	 * Método Commit - vai commitar os dados no banco depois de persistidos.
	 * @throws Exception
	 */
	public void Commit() throws Exception {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				throw new Exception("AVISO: Erro No Commit");
			}
		}
	}
}
