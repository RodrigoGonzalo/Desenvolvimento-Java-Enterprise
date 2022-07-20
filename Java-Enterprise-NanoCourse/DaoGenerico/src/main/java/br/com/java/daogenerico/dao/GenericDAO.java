package br.com.java.daogenerico.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;


public class GenericDAO <Tabela,Chave>{ // Entre o maior e menor ele recebe a entidade e a chave primária
	
	/*
	 *  Essa classe GenericDAO serve para criar métodos que podem ser utilizados em mais de uma entidade,
	 *  isso para não ficar implementando o mesmo método o tempo todo, podemos fazer tudo aqui.
	 */
	
	// Deixamos o EntityManager protected para que outras classes tenham acesso, com isso evitamos de ficar implementando o em várias vezes.
	protected EntityManager em; 
	
	private Class<Tabela> Clazz;
	
	// Construtor
	public GenericDAO(EntityManager em) {
		this.em = em;
		
		// Esse código pega a classe e vai para a superclasse e depois pega os argumentos<Tabela,Chave>
		Clazz = (Class<Tabela>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	// Os métodos do CRUD tem que receber a entidade
	public void Cadastrar(Tabela entidade) {
		em.persist(entidade);
	}
	
	public void Atualizar(Tabela entidade) {
		em.merge(entidade);
	}
	
	public Tabela Buscar(Chave key) {
		return em.find(Clazz, key);
	}
	
	// Vamos remover pela Chave
	public void Remover(Chave key) throws Exception {
		Tabela entidade = Buscar(key);
		
		if(entidade == null) {
			throw new Exception("Entidade não encontrada"); // Exceções checked precisam do thorws Exception
		}
		
		em.remove(entidade);
	}
	
	// Para mostrar o conteúdo do banco, vamos colocar a Tabela
	public List<Tabela> Listar(){
		return em.createQuery("from " + Clazz.getName()).getResultList(); // Usamos o JPQL - Não precisamos do Select pois vamos ver todos os elementos da tabela
	}
	
	public void Commit() throws Exception{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				throw new Exception("Erro no commit");

			}
		}
	}

}
