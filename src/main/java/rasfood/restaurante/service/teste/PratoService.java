package rasfood.restaurante.service.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import rasfood.restaurante.dao.PratoDao;
import rasfood.restaurante.entity.Prato;
import rasfood.restaurante.util.JpaUtil;

public class PratoService {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEmf();
		em.getTransaction().begin();
		
		Prato risoto = new Prato();
		risoto.setNome("Risoto de frutos do mar");
		risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
		risoto.setDisponivel(true);
		risoto.setDataRegistro(LocalDateTime.now());
		risoto.setValor(BigDecimal.valueOf(88.50));

		PratoDao pratoDao = new PratoDao(em);
		pratoDao.cadastrar(risoto);

		
		em.persist(risoto);
		em.getTransaction().commit();
		em.close();
		JpaUtil.close();
	}

}
