package rasfood.restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cardapio")
public class Cardapio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private boolean disponivel;
	private BigDecimal valor;
	
	@ManyToOne
	private Categoria categoria;
	
	@Column(name = "data_de_registro")
	private LocalDateTime dataRegistro;
	
	@ManyToMany(mappedBy = "cardapios")
	private Set<Ordem> ordens = new HashSet<>();
	
	public Cardapio() {
	}

	public Cardapio(String nome, String descricao, boolean disponivel, BigDecimal valor, Categoria categoria,
			LocalDateTime dataRegistro) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.disponivel = disponivel;
		this.valor = valor;
		this.categoria = categoria;
		this.dataRegistro = dataRegistro;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Cardapio [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", disponivel=" + disponivel
				+ ", valor=" + valor + ", dataRegistro=" + dataRegistro + "]";
	}
	
}
