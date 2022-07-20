package br.com.java.daogenerico.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;


public class GenericDAO <Tabela,Chave>{ // Entre o maior e menor ele recebe a entidade e a chave prim�ria
	
	/*
	 *  Essa classe GenericDAO serve para criar m�todos que podem ser utilizados em mais de uma entidade,
	 *  isso para n�o ficar implementando o mesmo m�todo o tempo todo, podemos fazer tudo aqui.
	 */
	
	// Deixamos o EntityManager protected para que outras classes tenham acesso, com isso evitamos de ficar implementando o em v�rias vezes.
	protected EntityManager em; 
	
	private Class<Tabela> Clazz;
	
	// Construtor
	public GenericDAO(EntityManager em) {
		this.em = em;
		
		// Esse c�digo pega a classe e vai para a superclasse e depois pega os argumentos<Tabela,Chave>
		Clazz = (Class<Tabela>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	// Os m�todos do CRUD tem que receber a entidade
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
			throw new Exception("Entidade n�o encontrada"); // Exce��es checked precisam do thorws Exception
		}
		
		em.remove(entidade);
	}
	
	// Para mostrar o conte�do do banco, vamos colocar a Tabela
	public List<Tabela> Listar(){
		return em.createQuery("from " + Clazz.getName()).getResultList(); // Usamos o JPQL - N�o precisamos do Select pois vamos ver todos os elementos da tabela
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
