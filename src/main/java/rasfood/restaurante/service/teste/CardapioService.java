package rasfood.restaurante.service.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import rasfood.restaurante.dao.CardapioDao;
import rasfood.restaurante.entity.Cardapio;
import rasfood.restaurante.util.CargaDeDadosUtil;
import rasfood.restaurante.util.JpaUtil;

public class CardapioService {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEmf();
		em.getTransaction().begin();

		CargaDeDadosUtil.cadastarCategorias(em);
		CargaDeDadosUtil.cadastrarProdutosCardapio(em);

		CardapioDao cardapioDao = new CardapioDao(em);

		cardapioDao.consultarTodos().forEach(elemento -> System.out
				.println("O prato consultado foi: " + elemento.getNome() + " Id: " + elemento.getId()));
		lerInformacoes(cardapioDao.consultarPorId(5L));
		
		cardapioDao.consultarPorValor(BigDecimal.valueOf(25L)).forEach( e -> System.out.printf("O prato consultado foi: %s\nR$Preço: %.2f\nTipo: %s",e.getNome(), e.getValor(), e.getCategoria()));
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