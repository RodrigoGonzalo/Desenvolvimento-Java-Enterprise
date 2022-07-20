package br.com.java.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

public class GenericDAO <T,K>{
	
	protected EntityManager em;
	
	private Class<T> Clazz;
	
	public GenericDAO(EntityManager em) {
		this.em = em;
		
		Clazz = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void Cadastrar(T entidade) {
		em.persist(entidade);
	}
	
	public void Atualizar(T entidade) {
		em.merge(entidade);
	}
	
	public T Buscar(K chave) {
		return em.find(Clazz, chave);
	}
	
	public void Remover(K chave) throws Exception{
		T entidade = Buscar(chave);
		
		if(entidade == null) {
			throw new Exception("ALERT: Chave Não Encontrada/ Key Not Found");
		}
		
		em.remove(entidade);
	}
	
	public void Commit() throws Exception{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				throw new Exception("ALERT: Erro No Commit/ Commit Error");
			}
		}
	}
	
}