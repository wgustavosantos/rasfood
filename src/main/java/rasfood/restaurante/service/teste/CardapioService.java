package rasfood.restaurante.service.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import rasfood.restaurante.dao.CardapioDao;
import rasfood.restaurante.entity.Cardapio;
import rasfood.restaurante.util.JpaUtil;

public class CardapioService {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEmf();
		em.getTransaction().begin();
		CardapioDao cardapioDao = new CardapioDao(em);
		//adicionando
		Cardapio risoto = new Cardapio();
		risoto.setNome("Risoto de frutos do mar");
		risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
		risoto.setDisponivel(true);
		risoto.setDataRegistro(LocalDateTime.now());
		risoto.setValor(BigDecimal.valueOf(88.50));
		cardapioDao.cadastrar(risoto);
		//adicionando
		Cardapio salmao = new Cardapio();
		salmao.setNome("Salmao grelhado ao molho de maracujá");
		salmao.setDescricao("Salmao grelhado ao molho de maracuja");
		salmao.setDisponivel(true);
		salmao.setDataRegistro(LocalDateTime.now());
		salmao.setValor(BigDecimal.valueOf(60.99));
		cardapioDao.cadastrar(salmao);
		//consultado
		lerInformacoes(em.find(Cardapio.class, 2L));
		//excluindo
		
		
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.close();
	}
	
	public static void lerInformacoes(Cardapio cardapio) {
		System.out.println("Nome do prato: " + cardapio.getNome());
		System.out.println("Descrição do prato: " + cardapio.getDescricao());
		System.out.println("Registro do prato: " + cardapio.getDataRegistro());
		System.out.println("Valor do prato: " + cardapio.getValor());
		System.out.println("Disponivel do prato: " + cardapio.isDisponivel());
	}

}
