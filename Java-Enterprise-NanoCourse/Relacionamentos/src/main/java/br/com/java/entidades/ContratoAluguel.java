package br.com.java.entidades;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_contrato_aluguel")
public class ContratoAluguel {
	
	@Id
	@SequenceGenerator(name = "contrato", sequenceName = "sq_tb_contrato_aluguel", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrato")
	@Column(name = "cd_contrato")
	private Integer IdContrato;
	
	@Column(name = "vl_contrato")
	private float ValorContrato;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_vencimento")
	private Calendar DataVencimento;
	
	@OneToOne // Cada contrato possuí um estabelecimento
	@JoinColumn(name = "cd_estabelecimento") 
	private Estabelecimento estabelecimento;
	
	public ContratoAluguel() {
		
	}

	public ContratoAluguel(Integer idContrato, float valorContrato, Calendar dataVencimento,
			Estabelecimento estabelecimento) {
		super();
		IdContrato = idContrato;
		ValorContrato = valorContrato;
		DataVencimento = dataVencimento;
		this.estabelecimento = estabelecimento;
	}

	public Integer getIdContrato() {
		return IdContrato;
	}

	public void setIdContrato(Integer idContrato) {
		IdContrato = idContrato;
	}

	public float getValorContrato() {
		return ValorContrato;
	}

	public void setValorContrato(float valorContrato) {
		ValorContrato = valorContrato;
	}

	public Calendar getDataVencimento() {
		return DataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		DataVencimento = dataVencimento;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	
	
	
}
