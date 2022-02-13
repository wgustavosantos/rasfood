package rasfood.restaurante.dao;

import java.util.List;

import javax.persistence.EntityManager;

import rasfood.restaurante.entity.Ordem;

public class OrdemDao {
	
	private static EntityManager em;
	
	public OrdemDao(EntityManager em) {
		OrdemDao.em = em;
	}
	
	public void cadastrar(final Ordem ordem) {
		
		em.persist(ordem);
	}
	
	public Ordem counsultar(final Long id) {
		return em.find(Ordem.class, id);
	}
	
public List<Ordem> consultarTodos (){
		
		String jpql = "SELECT ord FROM Ordem ord";
		
		return em.createQuery(jpql, Ordem.class).getResultList();
	}
	
	public Ordem atualizar(final Ordem ordem) {
		return em.merge(ordem);
	}
	
	public void excluir(final Ordem ordem) {
		em.remove(ordem);
	}

}
