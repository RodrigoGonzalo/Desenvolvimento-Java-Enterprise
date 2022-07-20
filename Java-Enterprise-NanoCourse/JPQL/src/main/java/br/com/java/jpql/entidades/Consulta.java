package br.com.java.jpql.entidades;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Consulta")
public class Consulta {
	
	@Id
	@SequenceGenerator(name = "consulta", sequenceName = "sq_tb_consulta", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulta")
	@Column(name = "ID_Consulta")
	private Integer IdConsulta;
	
	@Column(name = "DT_Consulta")
	private Calendar DataConsulta;
	
	@ManyToOne
	@JoinColumn(name = "ID_Especialidade")
	private Especialidade Especialistas;
	
	@ManyToOne
	@JoinColumn(name = "ID_Paciente")
	private Paciente ConsultaPaciente;
	
	@OneToOne
	@JoinColumn(name = "ID_Agendamento")
	private Agendamento AgendamentoConsulta;

	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consulta(Calendar dataConsulta) {
		super();
		DataConsulta = dataConsulta;
		
	}

	public Integer getIdConsulta() {
		return IdConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		IdConsulta = idConsulta;
	}

	public Calendar getDataConsulta() {
		return DataConsulta;
	}

	public void setDataConsulta(Calendar dataConsulta) {
		DataConsulta = dataConsulta;
	}

	public Especialidade getEspecialistas() {
		return Especialistas;
	}

	public void setEspecialistas(Especialidade especialistas) {
		Especialistas = especialistas;
	}

	public Paciente getConsultaPaciente() {
		return ConsultaPaciente;
	}

	public void setConsultaPaciente(Paciente consultaPaciente) {
		ConsultaPaciente = consultaPaciente;
	}

	public Agendamento getAgendamentoConsulta() {
		return AgendamentoConsulta;
	}

	public void setAgendamentoConsulta(Agendamento agendamentoConsulta) {
		AgendamentoConsulta = agendamentoConsulta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AgendamentoConsulta == null) ? 0 : AgendamentoConsulta.hashCode());
		result = prime * result + ((ConsultaPaciente == null) ? 0 : ConsultaPaciente.hashCode());
		result = prime * result + ((DataConsulta == null) ? 0 : DataConsulta.hashCode());
		result = prime * result + ((Especialistas == null) ? 0 : Especialistas.hashCode());
		result = prime * result + ((IdConsulta == null) ? 0 : IdConsulta.hashCode());
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
		Consulta other = (Consulta) obj;
		if (AgendamentoConsulta == null) {
			if (other.AgendamentoConsulta != null)
				return false;
		} else if (!AgendamentoConsulta.equals(other.AgendamentoConsulta))
			return false;
		if (ConsultaPaciente == null) {
			if (other.ConsultaPaciente != null)
				return false;
		} else if (!ConsultaPaciente.equals(other.ConsultaPaciente))
			return false;
		if (DataConsulta == null) {
			if (other.DataConsulta != null)
				return false;
		} else if (!DataConsulta.equals(other.DataConsulta))
			return false;
		if (Especialistas == null) {
			if (other.Especialistas != null)
				return false;
		} else if (!Especialistas.equals(other.Especialistas))
			return false;
		if (IdConsulta == null) {
			if (other.IdConsulta != null)
				return false;
		} else if (!IdConsulta.equals(other.IdConsulta))
			return false;
		return true;
	}

	
	
	
}
