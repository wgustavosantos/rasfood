package rasfood.restaurante.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordens_cardapio")
public class OrdensCardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Ordem ordem;

	@ManyToOne
	private Cardapio cardapio;

	@Column(name = "valor_de_registros")
	private BigDecimal valorDeRegistro;

	private Integer quantidade;

	public OrdensCardapio() {
	}

	public OrdensCardapio(Cardapio cardapio, Integer quantidade) {
		this.cardapio = cardapio;
		this.quantidade = quantidade;
		this.valorDeRegistro = cardapio.getValor();
	}

	public Ordem getOrdem() {
		return ordem;
	}

	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public BigDecimal getValorDeRegistro() {
		return valorDeRegistro;
	}

	public void setValorDeRegistro(BigDecimal valorDeRegistro) {
		this.valorDeRegistro = valorDeRegistro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

	@Override
	public String toString() {
		return "OrdensCardapio [id=" + id + ", cardapio=" + cardapio + ", valorDeRegistro=" + valorDeRegistro
				+ ", quantidade=" + quantidade + "]";
	}

}
