package rasfood.restaurante.service.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import rasfood.restaurante.dao.CardapioDao;
import rasfood.restaurante.entity.Cardapio;
import rasfood.restaurante.util.CargaDeDadosUtil;
import rasfood.restaurante.util.JpaUtil;

public class OrdemService {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEmf();
		em.getTransaction().begin();

		CargaDeDadosUtil.cadastarCategorias(em);
		CargaDeDadosUtil.cadastrarProdutosCardapio(em);

		CardapioDao cardapioDao = new CardapioDao(em);
		//consultando todos
		cardapioDao.consultarTodos().forEach(elemento -> System.out
				.println("O prato consultado foi: " + elemento.getNome() + " Id: " + elemento.getId()));
		//consultado por id
		lerInformacoes(cardapioDao.consultarPorId(5L));
		//consultando por preço
		cardapioDao.consultarPorValor(BigDecimal.valueOf(25L))
		.forEach( e -> 
		System.out.printf("O prato consultado foi: %s\nPreço: R$%.2f\nTipo: %s",e.getNome(), e.getValor(), e.getCategoria().getNome()));
		//consulta por nome
		Cardapio cardapio = cardapioDao.consultaPorNome("CHevRe");
		if(cardapio != null) {
			System.out.printf("O prato consultado por nome foi: %s Id: %d", cardapio.getNome(),cardapio.getId());
		}else {
			System.out.println("Cardapio não encontrado");
		}
		
		
	}
	

	public static void lerInformacoes(Cardapio cardapio) {
		System.out.println("Nome do prato: " + cardapio.getNome());
		System.out.println("Descrição do prato: " + cardapio.getDescricao());
		System.out.println("Registro do prato: " + cardapio.getDataRegistro());
		System.out.println("Valor do prato: " + cardapio.getValor());
		System.out.println("Disponivel do prato: " + cardapio.isDisponivel());
		System.out.println("Categoria do produto: " + cardapio.getCategoria().getNome());
	}
}