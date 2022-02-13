package rasfood.restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ordens")
public class Ordem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	@Column(name = "data_de_criacao")
	private LocalDateTime dataDeCriacao = LocalDateTime.now();

	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
	private Set<OrdensCardapio> ordensCardapios = new HashSet<>();
	
	public void addOrdensCardapio(OrdensCardapio ordensCardapio) {
		ordensCardapio.setOrdem(this);
		this.ordensCardapios.add(ordensCardapio);
	}
	

	public Ordem(BigDecimal valorTotal, LocalDateTime dataDeCriacao, Cliente cliente,
			Set<OrdensCardapio> ordensCardapios) {
		this.valorTotal = valorTotal;
		this.dataDeCriacao = dataDeCriacao;
		this.cliente = cliente;
		this.ordensCardapios = ordensCardapios;
	}

	public Ordem() {
	}

	public Ordem(Cliente cliente) {

		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<OrdensCardapio> getOrdensCardapios() {
		return ordensCardapios;
	}


	public void setOrdensCardapios(Set<OrdensCardapio> ordensCardapios) {
		this.ordensCardapios = ordensCardapios;
	}


	@Override
	public String toString() {
		return "Ordem [id=" + id + ", valorTotal=" + valorTotal + ", dataDeCriacao=" + dataDeCriacao + ", cliente="
				+ cliente + "]";
	}

}
