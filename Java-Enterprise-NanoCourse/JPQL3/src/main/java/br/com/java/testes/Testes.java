package br.com.java.testes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.java.dao.CarrosDAO;
import br.com.java.dao.ProprietarioDAO;
import br.com.java.entidades.Carros;
import br.com.java.entidades.Estado;
import br.com.java.entidades.Genero;
import br.com.java.entidades.Proprietario;

public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQL3");
		EntityManager em = emf.createEntityManager();
		
		ProprietarioDAO PDao = new ProprietarioDAO(em);
		/*
		Proprietario proprietario = new Proprietario("Isabelly Jesus", "09535467050", "isabellyjesus@gmail.com", 
				new GregorianCalendar(1990, Calendar.JANUARY, 19), new GregorianCalendar(2014, Calendar.AUGUST, 24), Genero.FEMININO, null);	
		
		List<Proprietario> lista = new ArrayList<>();
		lista.add(proprietario);
		
		*/
		CarrosDAO CDao = new CarrosDAO(em);
		/*
		Carros carro = new Carros("March", "Nissan", 2014, new GregorianCalendar(2013, Calendar.DECEMBER, 01), 
				new BigDecimal(36900) ,Estado.SEMINOVO, proprietario);
		
		
		PDao.Cadastrar(proprietario);		
		CDao.Cadastrar(carro);
		try {
			PDao.Commit();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			CDao.Commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		List<Carros> ListarCarros = CDao.BuscarCarros();
		for (Carros carros : ListarCarros) {
			System.out.println(carros.getNomeCarro());
		}
		
		System.out.println("======================================================");
		
		List<Proprietario> ListarProprietario = PDao.BuscarProprietario();
		for (Proprietario proprietario : ListarProprietario) {
			System.out.println(proprietario.getNome());
		}
	}

}
