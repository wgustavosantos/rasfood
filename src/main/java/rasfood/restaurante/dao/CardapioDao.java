package rasfood.restaurante.dao;

import java.util.List;

import javax.persistence.EntityManager;

import rasfood.restaurante.entity.Cardapio;

public class CardapioDao {
	
	private EntityManager em;

	public CardapioDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(final Cardapio cardapio) {
		em.persist(cardapio);
		
	}
	
	public List<Cardapio> consultarTodos (){
		
		String jpql = "SELECT c FROM Cardapio c";
		
		return em.createQuery(jpql, Cardapio.class).getResultList();
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
