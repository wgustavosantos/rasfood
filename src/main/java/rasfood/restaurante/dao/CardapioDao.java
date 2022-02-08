package rasfood.restaurante.dao;

import java.math.BigDecimal;
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

	public Cardapio consultarPorId(final Long id) {
		return em.find(Cardapio.class, id);
	}
	
	public List<Cardapio> consultarPorValor(BigDecimal filtroValor){
		
		String jqpl = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
		
		return em.createQuery(jqpl, Cardapio.class).setParameter("valor", filtroValor).getResultList();
		
	}
	
	public Cardapio atualizar(final Cardapio cardapio) {
		return em.merge(cardapio);
	}

	public void excluir(final Cardapio cardapio) {
		em.remove(cardapio);
	}
}
