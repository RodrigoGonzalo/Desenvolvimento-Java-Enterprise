package br.com.java.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {
	
	@Id
	@SequenceGenerator(name = "estabelecimento", sequenceName = "sq_tb_estabelecimento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estabelecimento")
	@Column(name = "cd_estabelecimento")
	private Integer IdEstabelecimento;
	
	@Column(name = "nm_estabelecimento", length = 50, nullable = false)
	private String NomeEstabelecimento;
	
	@OneToOne(mappedBy = "estabelecimento", cascade = CascadeType.PERSIST) // Vamos mapear a relação assim formando uma relação bidirecional, ou seja
	private ContratoAluguel contratoAluguel; // Um contrato possuí um estabelecimento e vice versa, se for fazer o que fizemos na classe ContratoAluguel, 
											//ele vai criar mais uma chave estrangeira
	
	
	// Um estabelecimento tem vários tipos
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_tipo_estabelecimento")
	private TipoEstabelecimento tipoEstabelecimento;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name = "cd_estabelecimento"),
	inverseJoinColumns = @JoinColumn(name = "cd_client"),
	name = "tb_client_estabelecimento")
	private List<Client> clients; 
	
	public Estabelecimento() {
		
	}

	public Estabelecimento(Integer idEstabelecimento, String nomeEstabelecimento, ContratoAluguel contratoAluguel,
			TipoEstabelecimento tipoEstabelecimento, List<Client> clients) {
		super();
		IdEstabelecimento = idEstabelecimento;
		NomeEstabelecimento = nomeEstabelecimento;
		this.contratoAluguel = contratoAluguel;
		this.tipoEstabelecimento = tipoEstabelecimento;
		this.clients = clients;
	}

	public Integer getIdEstabelecimento() {
		return IdEstabelecimento;
	}

	public void setIdEstabelecimento(Integer idEstabelecimento) {
		IdEstabelecimento = idEstabelecimento;
	}

	public String getNomeEstabelecimento() {
		return NomeEstabelecimento;
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		NomeEstabelecimento = nomeEstabelecimento;
	}

	public ContratoAluguel getContratoAluguel() {
		return contratoAluguel;
	}

	public void setContratoAluguel(ContratoAluguel contratoAluguel) {
		this.contratoAluguel = contratoAluguel;
	}

	public TipoEstabelecimento getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	
	
	
}
