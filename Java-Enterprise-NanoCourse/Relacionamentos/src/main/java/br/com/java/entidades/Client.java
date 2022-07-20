package br.com.java.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client {
	
	@Id
	@SequenceGenerator(name = "client", sequenceName = "sq_tb_client", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client")
	@Column(name = "cd_client")
	private Integer IdClient;
	
	@Column(name = "nm_client", length = 60, nullable = false)
	private String NomeClient;
	
	@ManyToMany(mappedBy = "clients")
	private List<Estabelecimento> estabelecimentos;
	
	public Client() {
		
	}

	public Client(Integer idClient, String nomeClient, List<Estabelecimento> estabelecimentos) {
		super();
		this.IdClient = idClient;
		this.NomeClient = nomeClient;
		this.estabelecimentos = estabelecimentos;
	}

	public Integer getIdClient() {
		return IdClient;
	}

	public void setIdClient(Integer idClient) {
		IdClient = idClient;
	}

	public String getNomeCliente() {
		return NomeClient;
	}

	public void setNomeCliente(String nomeClient) {
		NomeClient = nomeClient;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}
	
	
	
	
	
	
}
