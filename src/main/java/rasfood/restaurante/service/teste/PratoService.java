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
		PratoDao pratoDao = new PratoDao(em);
		//adicionando
		Prato risoto = new Prato();
		risoto.setNome("Risoto de frutos do mar");
		risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
		risoto.setDisponivel(true);
		risoto.setDataRegistro(LocalDateTime.now());
		risoto.setValor(BigDecimal.valueOf(88.50));
		pratoDao.cadastrar(risoto);
		//adicionando
		Prato salmao = new Prato();
		salmao.setNome("Salmao grelhado ao molho de maracujá");
		salmao.setDescricao("Salmao grelhado ao molho de maracuja");
		salmao.setDisponivel(true);
		salmao.setDataRegistro(LocalDateTime.now());
		salmao.setValor(BigDecimal.valueOf(60.99));
		pratoDao.cadastrar(salmao);
		//consultado
		lerInformacoes(em.find(Prato.class, 2L));
		
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.close();
	}
	
	public static void lerInformacoes(Prato prato) {
		System.out.println("Nome do prato: " + prato.getNome());
		System.out.println("Descrição do prato: " + prato.getDescricao());
		System.out.println("Registro do prato: " + prato.getDataRegistro());
		System.out.println("Valor do prato: " + prato.getValor());
		System.out.println("Disponivel do prato: " + prato.isDisponivel());
	}

}
