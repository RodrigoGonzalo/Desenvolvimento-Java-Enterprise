package br.com.java.entidades;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_carros")
public class Carros {
	@Id
	@SequenceGenerator(name = "carros", sequenceName = "sq_tb_carros", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carros")
	@Column(name = "CD_Carro")
	private Integer CodigoCarro;
	
	@Column(name = "NM_Carro", nullable = false, length = 30)
	private String NomeCarro;
	
	@Column(name = "DS_Marca", nullable = false, length = 30)
	private String Marca;
	
	@Column(name = "DS_Modelo", nullable = false, length = 4)
	private int Modelo;
	
	@Column(name = "DT_Lancamento", nullable = false)
	private Calendar DataLancamento;
	
	@Column(name = "DS_Valor", nullable = false)
	private BigDecimal Valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "DS_Estado", nullable = false)
	private Estado Estado;
	
	@ManyToOne
	@JoinColumn(name = "CD_Proprietario")
	private Proprietario Dono;

	public Carros() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Carros(String nomeCarro, String marca, int modelo, Calendar dataLancamento, BigDecimal valor,
			Estado estado, Proprietario dono) {
		super();
		NomeCarro = nomeCarro;
		Marca = marca;
		Modelo = modelo;
		DataLancamento = dataLancamento;
		Valor = valor;
		Estado = estado;
		Dono = dono;
	}



	public Integer getCodigoCarro() {
		return CodigoCarro;
	}

	public void setCodigoCarro(Integer codigoCarro) {
		CodigoCarro = codigoCarro;
	}

	public String getNomeCarro() {
		return NomeCarro;
	}

	public void setNomeCarro(String nomeCarro) {
		NomeCarro = nomeCarro;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public int getModelo() {
		return Modelo;
	}

	public void setModelo(int modelo) {
		Modelo = modelo;
	}

	public Calendar getDataLancamento() {
		return DataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		DataLancamento = dataLancamento;
	}

	public BigDecimal getValor() {
		return Valor;
	}

	public void setValor(BigDecimal valor) {
		Valor = valor;
	}

	public Estado getEstado() {
		return Estado;
	}

	public void setEstado(Estado estado) {
		Estado = estado;
	}

	public Proprietario getDono() {
		return Dono;
	}

	public void setDono(Proprietario dono) {
		Dono = dono;
	}

	@Override
	public String toString() {
		return "Carros [CodigoCarro=" + CodigoCarro + ", NomeCarro=" + NomeCarro + ", Marca=" + Marca + ", Modelo="
				+ Modelo + ", DataLancamento=" + DataLancamento + ", Valor=" + Valor + ", Estado=" + Estado + ", Dono="
				+ Dono + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CodigoCarro == null) ? 0 : CodigoCarro.hashCode());
		result = prime * result + ((DataLancamento == null) ? 0 : DataLancamento.hashCode());
		result = prime * result + ((Estado == null) ? 0 : Estado.hashCode());
		result = prime * result + ((Marca == null) ? 0 : Marca.hashCode());
		result = prime * result + Modelo;
		result = prime * result + ((NomeCarro == null) ? 0 : NomeCarro.hashCode());
		result = prime * result + ((Valor == null) ? 0 : Valor.hashCode());
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
		Carros other = (Carros) obj;
		if (CodigoCarro == null) {
			if (other.CodigoCarro != null)
				return false;
		} else if (!CodigoCarro.equals(other.CodigoCarro))
			return false;
		if (DataLancamento == null) {
			if (other.DataLancamento != null)
				return false;
		} else if (!DataLancamento.equals(other.DataLancamento))
			return false;
		if (Estado != other.Estado)
			return false;
		if (Marca == null) {
			if (other.Marca != null)
				return false;
		} else if (!Marca.equals(other.Marca))
			return false;
		if (Modelo != other.Modelo)
			return false;
		if (NomeCarro == null) {
			if (other.NomeCarro != null)
				return false;
		} else if (!NomeCarro.equals(other.NomeCarro))
			return false;
		if (Valor == null) {
			if (other.Valor != null)
				return false;
		} else if (!Valor.equals(other.Valor))
			return false;
		return true;
	}
	
	
	
}
