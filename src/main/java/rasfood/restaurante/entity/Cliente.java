package rasfood.restaurante.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	private Long id;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cpf;
	private String nome;
	private String cep;

	public Cliente(Long id, String cpf, String nome, String cep) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.cep = cep;
	}

	public Cliente() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Clientes [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", cep=" + cep + "]";
	}

}
