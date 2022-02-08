package rasfood.restaurante.service.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import rasfood.restaurante.dao.CardapioDao;
import rasfood.restaurante.dao.CategoriaDao;
import rasfood.restaurante.entity.Cardapio;
import rasfood.restaurante.entity.Categoria;
import rasfood.restaurante.util.JpaUtil;

public class CardapioService {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEmf();
		
		cadastrarProdutoCardapio(em, cadastrarCategoria(em));
	}
	
	private static Categoria cadastrarCategoria (EntityManager em) {
		CategoriaDao categoriaDao = new CategoriaDao(em);
		Categoria categoria = new Categoria();
		
		categoria.setNome("PratoPrincipal");
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(categoria);
		
		em.getTransaction().commit();
		em.clear();
		
		return categoria;
	}
	
	public static void cadastrarProdutoCardapio(EntityManager em, Categoria categoria) {
		
		em.getTransaction().begin();
		
		CardapioDao cardapioDao = new CardapioDao(em);
		//adicionando
		
		Cardapio risoto = new Cardapio();
		risoto.setNome("Risoto de frutos do mar");
		risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
		risoto.setDisponivel(true);
		risoto.setDataRegistro(LocalDateTime.now());
		risoto.setValor(BigDecimal.valueOf(88.50));
		risoto.setCategoria(categoria);
		cardapioDao.cadastrar(risoto);
		
		Cardapio salmao = new Cardapio();
		salmao.setNome("Salmao grelhado ao molho de maracujá");
		salmao.setDescricao("Salmao grelhado ao molho de maracuja");
		salmao.setDisponivel(true);
		salmao.setDataRegistro(LocalDateTime.now());
		salmao.setValor(BigDecimal.valueOf(60.99));
		salmao.setCategoria(categoria);
		cardapioDao.cadastrar(salmao);
		
		//consultado
		
		//lerInformacoes(em.find(Cardapio.class, 2L));
		
		//consultando todos
		cardapioDao.consultarTodos().forEach(elemento->System.out.println("O prato consultado foi: " + elemento.getNome()));
		
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
		System.out.println("Categoria do produto: " + cardapio.getCategoria().getNome());
	}

}
