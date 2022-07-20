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
	
	// Criando o EntityManager, ele ser� protected pois ser� utilizado como dado de heran�a
	protected EntityManager em;
	
	// Vari�vel Clazz
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
	 * M�todo Cadastrar - Ele persiste os dados que colocamos no objeto, depois tem commitar essa mudan�a usando o m�todo Commit
	 * @param entidade
	 */
	public void Cadastrar(T entidade) {
		em.persist(entidade);
	}
	
	/**
	 * M�todo Atualizar - Ele atualiza o dado no banco, depois tem commitar essa mudan�a usando o m�todo Commit
	 * @param entidade
	 */
	public void Atualizar(T entidade) {
		em.merge(entidade);
	}
	
	/**
	 * M�todo Buscar - Ele busca o dado com base no ID
	 * @param chave
	 * @return
	 */
	public T Buscar(K chave) {
		return em.find(Clazz, chave);
	}
	
	/**
	 * M�todo Remover - Ele remove o membro do banco atrv�s da chave que � o seu ID.
	 * Depois tem que usar o m�todo Commit para commitar essa remo��o
	 * @param chave
	 * @throws Exception
	 */
	public void Remover(K chave) throws Exception{
		T entidade = Buscar(chave);
		if(entidade == null) {
			throw new Exception("AVISO: Chave N�o Encontrada");
		}
		
		em.remove(entidade);
	}
	
	/**
	 * M�todo Commit - vai commitar os dados no banco depois de persistidos.
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
