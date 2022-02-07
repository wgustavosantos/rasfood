package rasfood.restaurante.dao;

import javax.persistence.EntityManager;

import rasfood.restaurante.entity.Cardapio;

public class CardapioDao {
	public static void main(String[] args) {

	}

	private EntityManager em;

	public CardapioDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(final Cardapio cardapio) {
		em.persist(cardapio);
		
	}

	public Cardapio consultar(final Long id) {
		return em.find(Cardapio.class, id);
	}
	
	public Cardapio atualizar(final Cardapio cardapio) {
		return em.merge(cardapio);
	}

	public void excluir(final Cardapio cardapio) {
		em.remove(cardapio);
	}
}
