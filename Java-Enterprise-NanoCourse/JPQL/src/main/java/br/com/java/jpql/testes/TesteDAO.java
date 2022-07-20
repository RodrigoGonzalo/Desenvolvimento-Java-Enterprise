package br.com.java.jpql.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.java.jpql.dao.PacienteDAO;
import br.com.java.jpql.entidades.Genero;
import br.com.java.jpql.entidades.Paciente;

public class TesteDAO {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQL");
		EntityManager em = emf.createEntityManager();
		
		PacienteDAO PDao = new PacienteDAO(em);
		//Paciente entidade = new Paciente("Julia", "julia@email.com", new GregorianCalendar(2000, Calendar.JULY, 04), Genero.F);
		//PDao.Cadastrar(entidade);
		
		List<Paciente> listarPaciente = PDao.ListarPaciente();
		for (Paciente paciente : listarPaciente) {
			System.out.println(paciente.getNomePaciente());
		}
		
		/*
		try {
			PDao.Commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		em.close();
		emf.close();
	}
}
