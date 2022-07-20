package br.com.java.entidades;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// Criando a Entidade Membros.
@Entity
@Table(name = "TB_Membros")
public class Membros {
	
	// Atributos e seus tipos.
	@Id
	@SequenceGenerator(name = "CodigoMembro", sequenceName = "sq_tb_membros", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CodigoMembro")
	@Column(name = "CD_Membro")
	private Integer CódigoMembro;
	
	@Column(name = "NM_Membro", length = 80, nullable = false)
	private String NomeMembro;
	
	@Column(name = "DS_Email", length = 80, nullable = false)
	private String EmailMembro;
	
	@Column(name = "DT_Nascimento")
	private Calendar DataNascimento;
	
	@Column(name = "DT_Admissao")
	private Calendar DataAdmissao;
	
	@Column(name = "DS_Genero")
	@Enumerated(EnumType.STRING)
	private GeneroMembro GeneroMembro;
	
	// Construtores
	public Membros() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Membros(String nomeMembro, String emailMembro, Calendar dataNascimento,
			Calendar dataAdmissao, GeneroMembro generoMembro) {
		super();
		NomeMembro = nomeMembro;
		EmailMembro = emailMembro;
		DataNascimento = dataNascimento;
		DataAdmissao = dataAdmissao;
		GeneroMembro = generoMembro;
	}
	
	// Getters and Setters
	public Integer getCódigoMembro() {
		return CódigoMembro;
	}

	public void setCódigoMembro(Integer códigoMembro) {
		CódigoMembro = códigoMembro;
	}

	public String getNomeMembro() {
		return NomeMembro;
	}

	public void setNomeMembro(String nomeMembro) {
		NomeMembro = nomeMembro;
	}

	public String getEmailMembro() {
		return EmailMembro;
	}

	public void setEmailMembro(String emailMembro) {
		EmailMembro = emailMembro;
	}

	public Calendar getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public Calendar getDataAdmissao() {
		return DataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		DataAdmissao = dataAdmissao;
	}

	public GeneroMembro getGeneroMembro() {
		return GeneroMembro;
	}

	public void setGeneroMembro(GeneroMembro generoMembro) {
		GeneroMembro = generoMembro;
	}
	
	// Hashcode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CódigoMembro == null) ? 0 : CódigoMembro.hashCode());
		result = prime * result + ((DataAdmissao == null) ? 0 : DataAdmissao.hashCode());
		result = prime * result + ((DataNascimento == null) ? 0 : DataNascimento.hashCode());
		result = prime * result + ((EmailMembro == null) ? 0 : EmailMembro.hashCode());
		result = prime * result + ((GeneroMembro == null) ? 0 : GeneroMembro.hashCode());
		result = prime * result + ((NomeMembro == null) ? 0 : NomeMembro.hashCode());
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
		Membros other = (Membros) obj;
		if (CódigoMembro == null) {
			if (other.CódigoMembro != null)
				return false;
		} else if (!CódigoMembro.equals(other.CódigoMembro))
			return false;
		if (DataAdmissao == null) {
			if (other.DataAdmissao != null)
				return false;
		} else if (!DataAdmissao.equals(other.DataAdmissao))
			return false;
		if (DataNascimento == null) {
			if (other.DataNascimento != null)
				return false;
		} else if (!DataNascimento.equals(other.DataNascimento))
			return false;
		if (EmailMembro == null) {
			if (other.EmailMembro != null)
				return false;
		} else if (!EmailMembro.equals(other.EmailMembro))
			return false;
		if (GeneroMembro != other.GeneroMembro)
			return false;
		if (NomeMembro == null) {
			if (other.NomeMembro != null)
				return false;
		} else if (!NomeMembro.equals(other.NomeMembro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Membros [CódigoMembro=" + CódigoMembro + ", NomeMembro=" + NomeMembro + ", EmailMembro=" + EmailMembro
				+ ", DataNascimento=" + DataNascimento + ", DataAdmissao=" + DataAdmissao + ", GeneroMembro="
				+ GeneroMembro + "]";
	}
	
	
	
	
	
	
}
