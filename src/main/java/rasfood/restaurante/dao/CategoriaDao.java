package rasfood.restaurante.dao;

import java.util.List;

import javax.persistence.EntityManager;

import rasfood.restaurante.entity.Categoria;

public class CategoriaDao {
	
	private static EntityManager em;
	
	public CategoriaDao(EntityManager em) {
		CategoriaDao.em = em;
	}
	
	public void cadastrar(final Categoria categoria) {
		
		em.persist(categoria);
	}
	
	public Categoria counsultar(final Long id) {
		return em.find(Categoria.class, id);
	}
	
public List<Categoria> consultarTodos (){
		
		String jpql = "SELECT cat FROM Categoria cat";
		
		return em.createQuery(jpql, Categoria.class).getResultList();
	}
	
	public Categoria atualizar(final Categoria categoria) {
		return em.merge(categoria);
	}
	
	public void excluir(final Categoria categoria) {
		em.remove(categoria);
	}

}
