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
		try {
			em.persist(cardapio);
		} catch (Exception e) {
			e.printStackTrace();
		}
		;

	}

	public List<Cardapio> consultarTodos() {

		String jpql = "SELECT c FROM Cardapio c";
		try {
			return em.createQuery(jpql, Cardapio.class).getResultList();
		} catch (Exception e) {
			return null;
		}

	}

	public Cardapio consultarPorId(final Long id) {
		try {
			return em.find(Cardapio.class, id);
		} catch (Exception e) {
			return null;
		}

	}

	public List<Cardapio> consultarPorValor(BigDecimal filtroValor) {

		String jqpl = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
		try {
			return em.createQuery(jqpl, Cardapio.class).setParameter("valor", filtroValor).getResultList();
		} catch (Exception e) {
			return null;
		}

	}

	public Cardapio consultaPorNome(String nome) {
		try {
			String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome)";

			return em.createQuery(jpql, Cardapio.class).setParameter("nome", nome).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	public Cardapio atualizar(final Cardapio cardapio) {

		try {
			return em.merge(cardapio);
		} catch (Exception e) {
			return null;
		}

	}

	public void excluir(final Cardapio cardapio) {
		try {
			em.remove(cardapio);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
