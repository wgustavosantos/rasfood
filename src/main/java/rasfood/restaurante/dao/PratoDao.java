package rasfood.restaurante.dao;

import javax.persistence.EntityManager;

import rasfood.restaurante.entity.Prato;

public class PratoDao {
	public static void main(String[] args) {
		
	}
	private EntityManager em;
	
	public PratoDao (EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Prato prato) {
		em.persist(prato);
		System.out.println("Nome do prato: " + prato.getNome());
		System.out.println("Descrição do prato: " + prato.getDescricao());
		System.out.println("Registro do prato: " + prato.getDataRegistro());
		System.out.println("Valor do prato: " + prato.getValor());
		System.out.println("Disponivel do prato: " + prato.isDisponivel());
	}

}
