package br.com.java.entidades;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "tb_proprietario")
public class Proprietario {
	
	@Id
	@SequenceGenerator(name = "proprietario", sequenceName = "sq_tb_proprietario", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proprietario")
	@Column(name = "CD_Proprietario")
	private Integer CódigoProprietário;
	
	@Column(name = "NM_Proprietario", length = 80, nullable = false)
	private String Nome;
	
	@Column(name = "DS_CPF", length = 11, nullable = false)
	private String Cpf;
	
	@Column(name = "DS_Email", length = 80, nullable = false)
	private String Email;
	
	@Column(name = "DT_Nascimento", nullable = false)
	private Calendar DataNascmiento;
	
	@Column(name = "DT_Compra", nullable = false)
	private Calendar DataCompra;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "DS_Genero", nullable = false)
	private Genero Genero;
	
	@OneToMany(mappedBy = "Dono", cascade = CascadeType.PERSIST)
	private List <Carros> Carro;

	public Proprietario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Proprietario(String nome, String cpf, String email, Calendar dataNascmiento, Calendar dataCompra,
			br.com.java.entidades.Genero genero, List<Carros> carro) {
		super();
		Nome = nome;
		Cpf = cpf;
		Email = email;
		DataNascmiento = dataNascmiento;
		DataCompra = dataCompra;
		Genero = genero;
		Carro = carro;
	}


	public Integer getCódigoProprietário() {
		return CódigoProprietário;
	}

	public void setCódigoProprietário(Integer códigoProprietário) {
		CódigoProprietário = códigoProprietário;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Calendar getDataNascmiento() {
		return DataNascmiento;
	}

	public void setDataNascmiento(Calendar dataNascmiento) {
		DataNascmiento = dataNascmiento;
	}

	public Calendar getDataCompra() {
		return DataCompra;
	}

	public void setDataCompra(Calendar dataCompra) {
		DataCompra = dataCompra;
	}
	
	public Genero getGenero() {
		return Genero;
		
	}
	
	public void setGenero(Genero Genero) {
		Genero = Genero;
	}

	public List<Carros> getCarro() {
		return Carro;
	}

	public void setCarro(List<Carros> carro) {
		Carro = carro;
	}

	@Override
	public String toString() {
		return "Proprietario [CódigoProprietário=" + CódigoProprietário + ", Nome=" + Nome + ", Cpf=" + Cpf + ", Email="
				+ Email + ", DataNascmiento=" + DataNascmiento + ", DataCompra=" + DataCompra + ", Genero=" + Genero
				+ ", Carro=" + Carro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cpf == null) ? 0 : Cpf.hashCode());
		result = prime * result + ((CódigoProprietário == null) ? 0 : CódigoProprietário.hashCode());
		result = prime * result + ((DataCompra == null) ? 0 : DataCompra.hashCode());
		result = prime * result + ((DataNascmiento == null) ? 0 : DataNascmiento.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Genero == null) ? 0 : Genero.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
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
		Proprietario other = (Proprietario) obj;
		if (Cpf == null) {
			if (other.Cpf != null)
				return false;
		} else if (!Cpf.equals(other.Cpf))
			return false;
		if (CódigoProprietário == null) {
			if (other.CódigoProprietário != null)
				return false;
		} else if (!CódigoProprietário.equals(other.CódigoProprietário))
			return false;
		if (DataCompra == null) {
			if (other.DataCompra != null)
				return false;
		} else if (!DataCompra.equals(other.DataCompra))
			return false;
		if (DataNascmiento == null) {
			if (other.DataNascmiento != null)
				return false;
		} else if (!DataNascmiento.equals(other.DataNascmiento))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Genero != other.Genero)
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		return true;
	}

		
	
}
