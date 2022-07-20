package br.com.java.jpql.entidades;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Paciente")
public class Paciente {
	
	@Id
	@SequenceGenerator(name = "paciente", sequenceName = "sq_tb_paciente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente")
	@Column(name = "ID_Paciente")
	private Integer IdPaciente;
	
	@Column(name = "NM_Paciente", length = 80, nullable = false)
	private String NomePaciente;
	
	@Column(name = "DS_EmailPaciente", length = 80, nullable = false)
	private String EmailPaciente;
	
	@Column(name = "DT_Nascimento")
	private Calendar DataNascimento;
	
	@Enumerated(EnumType.STRING)
	private Genero Genero;
	
	@OneToMany(mappedBy = "Pacientes")
	private List <Agendamento> agendamentos;
	
	@OneToMany(mappedBy = "ConsultaPaciente")
	private List <Consulta> consultas;

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(String nomePaciente, String emailPaciente, Calendar dataNascimento, Genero genero) {
		super();
		NomePaciente = nomePaciente;
		EmailPaciente = emailPaciente;
		DataNascimento = dataNascimento;
		Genero = genero;
	
	}

	public Integer getIdPaciente() {
		return IdPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		IdPaciente = idPaciente;
	}

	public String getNomePaciente() {
		return NomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		NomePaciente = nomePaciente;
	}

	public String getEmailPaciente() {
		return EmailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		EmailPaciente = emailPaciente;
	}

	public Calendar getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return Genero;
	}

	public void setGenero(Genero genero) {
		Genero = genero;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DataNascimento == null) ? 0 : DataNascimento.hashCode());
		result = prime * result + ((EmailPaciente == null) ? 0 : EmailPaciente.hashCode());
		result = prime * result + ((Genero == null) ? 0 : Genero.hashCode());
		result = prime * result + ((IdPaciente == null) ? 0 : IdPaciente.hashCode());
		result = prime * result + ((NomePaciente == null) ? 0 : NomePaciente.hashCode());
		result = prime * result + ((agendamentos == null) ? 0 : agendamentos.hashCode());
		result = prime * result + ((consultas == null) ? 0 : consultas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (DataNascimento == null) {
			if (other.DataNascimento != null)
				return false;
		} else if (!DataNascimento.equals(other.DataNascimento))
			return false;
		if (EmailPaciente == null) {
			if (other.EmailPaciente != null)
				return false;
		} else if (!EmailPaciente.equals(other.EmailPaciente))
			return false;
		if (Genero != other.Genero)
			return false;
		if (IdPaciente == null) {
			if (other.IdPaciente != null)
				return false;
		} else if (!IdPaciente.equals(other.IdPaciente))
			return false;
		if (NomePaciente == null) {
			if (other.NomePaciente != null)
				return false;
		} else if (!NomePaciente.equals(other.NomePaciente))
			return false;
		if (agendamentos == null) {
			if (other.agendamentos != null)
				return false;
		} else if (!agendamentos.equals(other.agendamentos))
			return false;
		if (consultas == null) {
			if (other.consultas != null)
				return false;
		} else if (!consultas.equals(other.consultas))
			return false;
		return true;
	}

	
	
}
