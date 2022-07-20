package br.com.java.entidades;

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
@Table(name = "tb_tipo_estabelecimento")
public class TipoEstabelecimento {
	
	@Id
	@SequenceGenerator(name = "tipoEstabelecimento", sequenceName = "sq_tb_tipo_estabelecimento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoEstabelecimento")
	@Column(name = "cd_tipo_estabelecimento")
	private Integer IdTipoEst;
	
	@Column(name = "nm_tipo_estabelecimento")
	private String NomeTipo;
	
	// Um tipo de estabelecimento possuí vários estabelecimentos
	@OneToMany(mappedBy = "tipoEstabelecimento")
	private List<Estabelecimento> estabelecimento;
	
	public TipoEstabelecimento() {
		
	}

	public TipoEstabelecimento(Integer idTipoEst, String nomeTipo, List<Estabelecimento> estabelecimento) {
		super();
		IdTipoEst = idTipoEst;
		NomeTipo = nomeTipo;
		this.estabelecimento = estabelecimento;
	}

	public Integer getIdTipoEst() {
		return IdTipoEst;
	}

	public void setIdTipoEst(Integer idTipoEst) {
		IdTipoEst = idTipoEst;
	}

	public String getNomeTipo() {
		return NomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		NomeTipo = nomeTipo;
	}

	public List<Estabelecimento> getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(List<Estabelecimento> estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	
	
	
	
	
	
	
}
