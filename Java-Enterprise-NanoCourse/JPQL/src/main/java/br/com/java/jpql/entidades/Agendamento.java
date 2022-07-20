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
@Table(name = "TBL_Agendamento")
public class Agendamento {
	
	@Id
	@SequenceGenerator(name = "agendamento", sequenceName = "sq_tb_agendamento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendamento")
	@Column(name = "ID_Agendamento")
	private Integer IdAgendamento;
	
	@Column(name = "DT_Agendamento")
	private Calendar DataAgendamento;
	
	@Column(name = "DT_ConsultaPrevista")
	private Calendar ConsultaPrevista;
	
	@ManyToOne
	@JoinColumn(name = "ID_Especialidade")
	private Especialidade Especialidades;
	
	@ManyToOne
	@JoinColumn(name = "ID_Paciente")
	private Paciente Pacientes;
	
	@OneToOne(mappedBy = "AgendamentoConsulta")
	private Consulta Consultas;
		
	public Agendamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agendamento(Calendar dataAgendamento, Calendar consultaPrevista){
		super();
		DataAgendamento = dataAgendamento;
		ConsultaPrevista = consultaPrevista;
		
		
	}

	public Integer getIdAgendamento() {
		return IdAgendamento;
	}

	public void setIdAgendamento(Integer idAgendamento) {
		IdAgendamento = idAgendamento;
	}

	public Calendar getDataAgendamento() {
		return DataAgendamento;
	}

	public void setDataAgendamento(Calendar dataAgendamento) {
		DataAgendamento = dataAgendamento;
	}

	public Calendar getConsultaPrevista() {
		return ConsultaPrevista;
	}

	public void setConsultaPrevista(Calendar consultaPrevista) {
		ConsultaPrevista = consultaPrevista;
	}

	public Especialidade getEspecialidades() {
		return Especialidades;
	}

	public void setEspecialidades(Especialidade especialidades) {
		Especialidades = especialidades;
	}

	public Paciente getPacientes() {
		return Pacientes;
	}

	public void setPacientes(Paciente pacientes) {
		Pacientes = pacientes;
	}

	public Consulta getConsultas() {
		return Consultas;
	}

	public void setConsultas(Consulta consultas) {
		Consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ConsultaPrevista == null) ? 0 : ConsultaPrevista.hashCode());
		result = prime * result + ((Consultas == null) ? 0 : Consultas.hashCode());
		result = prime * result + ((DataAgendamento == null) ? 0 : DataAgendamento.hashCode());
		result = prime * result + ((Especialidades == null) ? 0 : Especialidades.hashCode());
		result = prime * result + ((IdAgendamento == null) ? 0 : IdAgendamento.hashCode());
		result = prime * result + ((Pacientes == null) ? 0 : Pacientes.hashCode());
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
		Agendamento other = (Agendamento) obj;
		if (ConsultaPrevista == null) {
			if (other.ConsultaPrevista != null)
				return false;
		} else if (!ConsultaPrevista.equals(other.ConsultaPrevista))
			return false;
		if (Consultas == null) {
			if (other.Consultas != null)
				return false;
		} else if (!Consultas.equals(other.Consultas))
			return false;
		if (DataAgendamento == null) {
			if (other.DataAgendamento != null)
				return false;
		} else if (!DataAgendamento.equals(other.DataAgendamento))
			return false;
		if (Especialidades == null) {
			if (other.Especialidades != null)
				return false;
		} else if (!Especialidades.equals(other.Especialidades))
			return false;
		if (IdAgendamento == null) {
			if (other.IdAgendamento != null)
				return false;
		} else if (!IdAgendamento.equals(other.IdAgendamento))
			return false;
		if (Pacientes == null) {
			if (other.Pacientes != null)
				return false;
		} else if (!Pacientes.equals(other.Pacientes))
			return false;
		return true;
	}

	
	
	
}
