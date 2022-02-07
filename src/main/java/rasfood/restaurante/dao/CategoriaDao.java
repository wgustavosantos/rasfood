package rasfood.restaurante.dao;

import javax.persistence.EntityManager;

import rasfood.restaurante.entity.Categoria;
import rasfood.restaurante.util.JpaUtil;

public class CategoriaDao {
	
	private EntityManager em = JpaUtil.getEmf();
	
	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(final Categoria categoria) {
		
		em.persist(categoria);
	}
	
	public Categoria counsultar(final Long id) {
		return em.find(Categoria.class, id);
	}
	
	public Categoria atualizar(final Categoria categoria) {
		return em.merge(categoria);
	}
	
	public void excluir(final Categoria categoria) {
		em.remove(categoria);
	}

}
