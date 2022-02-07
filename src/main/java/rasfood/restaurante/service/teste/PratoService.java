package rasfood.restaurante.service.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import rasfood.restaurante.entity.Prato;

public class PratoService {

	public static void main(String[] args) {

		Prato risoto = new Prato();
		risoto.setNome("Risoto de frutos do mar");
		risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
		risoto.setDisponivel(true);
		risoto.setDataRegistro(LocalDateTime.now());
		risoto.setValor(BigDecimal.valueOf(88.50));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("rasFood");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(risoto);
		et.commit();
		em.close();
		emf.close();
}

}
