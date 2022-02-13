package rasfood.restaurante.dao;

import java.util.List;

import javax.persistence.EntityManager;

import rasfood.restaurante.entity.Cliente;

public class ClienteDao {
	
	private static EntityManager em;
	
	public ClienteDao(EntityManager em) {
		ClienteDao.em = em;
	}
	
	public void cadastrar(final Cliente cliente) {
		
		em.persist(cliente);
	}
	
	public Cliente counsultar(final Long id) {
		return em.find(Cliente.class, id);
	}
	
public List<Cliente> consultarTodos (){
		
		String jpql = "SELECT cli FROM Cliente cli";
		
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public Cliente atualizar(final Cliente cliente) {
		return em.merge(cliente);
	}
	
	public void excluir(final Cliente cliente) {
		em.remove(cliente);
	}

}
