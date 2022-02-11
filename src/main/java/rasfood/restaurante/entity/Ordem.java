package rasfood.restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private LocalDateTime dataDeCriacao;

	@ManyToOne
	private Cliente cliente;

	public Ordem() {
	}

	public Ordem(Long id, BigDecimal valorTotal, LocalDateTime dataDeCriacao, Cliente cliente) {
		this.id = id;
		this.valorTotal = valorTotal;
		this.dataDeCriacao = dataDeCriacao;
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

	@Override
	public String toString() {
		return "Ordem [id=" + id + ", valorTotal=" + valorTotal + ", dataDeCriacao=" + dataDeCriacao + ", cliente="
				+ cliente + "]";
	}

}
