package br.com.java.jpql.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Especialidade")
public class Especialidade {
	
	@Id
	@SequenceGenerator(name = "especialidade", sequenceName = "sq_tb_especialidade", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "especialidade")
	@Column(name = "ID_Especialidade")
	private Integer IdEspecialidade;
	
	@Column(name = "NM_Especialidade")
	private String NomeEspecialidade;
	
	@OneToMany(mappedBy = "Especialidades")
	private List <Agendamento> Agendamentos;
	
	@OneToMany(mappedBy = "Especialistas")
	private List <Consulta> Consultas;
	
	public Especialidade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Especialidade(String nomeEspecialidade) {
		super();
		NomeEspecialidade = nomeEspecialidade;
		
	}

	public Integer getIdEspecialidade() {
		return IdEspecialidade;
	}

	public void setIdEspecialidade(Integer idEspecialidade) {
		IdEspecialidade = idEspecialidade;
	}

	public String getNomeEspecialidade() {
		return NomeEspecialidade;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		NomeEspecialidade = nomeEspecialidade;
	}

	public List<Agendamento> getAgendamentos() {
		return Agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		Agendamentos = agendamentos;
	}

	public List<Consulta> getConsultas() {
		return Consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		Consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Agendamentos == null) ? 0 : Agendamentos.hashCode());
		result = prime * result + ((Consultas == null) ? 0 : Consultas.hashCode());
		result = prime * result + ((IdEspecialidade == null) ? 0 : IdEspecialidade.hashCode());
		result = prime * result + ((NomeEspecialidade == null) ? 0 : NomeEspecialidade.hashCode());
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
		Especialidade other = (Especialidade) obj;
		if (Agendamentos == null) {
			if (other.Agendamentos != null)
				return false;
		} else if (!Agendamentos.equals(other.Agendamentos))
			return false;
		if (Consultas == null) {
			if (other.Consultas != null)
				return false;
		} else if (!Consultas.equals(other.Consultas))
			return false;
		if (IdEspecialidade == null) {
			if (other.IdEspecialidade != null)
				return false;
		} else if (!IdEspecialidade.equals(other.IdEspecialidade))
			return false;
		if (NomeEspecialidade == null) {
			if (other.NomeEspecialidade != null)
				return false;
		} else if (!NomeEspecialidade.equals(other.NomeEspecialidade))
			return false;
		return true;
	}

	
	
	
}
