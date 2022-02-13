package rasfood.restaurante.service.teste;

import javax.persistence.EntityManager;

import rasfood.restaurante.dao.CardapioDao;
import rasfood.restaurante.dao.ClienteDao;
import rasfood.restaurante.dao.OrdemDao;
import rasfood.restaurante.entity.Cardapio;
import rasfood.restaurante.entity.Cliente;
import rasfood.restaurante.entity.Endereco;
import rasfood.restaurante.entity.Ordem;
import rasfood.restaurante.entity.OrdensCardapio;
import rasfood.restaurante.util.CargaDeDadosUtil;
import rasfood.restaurante.util.JpaUtil;

public class CardapioService {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEmf();
		em.getTransaction().begin();

		CargaDeDadosUtil.cadastarCategorias(em);
		CargaDeDadosUtil.cadastrarProdutosCardapio(em);
		
		CardapioDao cardapioDao = new CardapioDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		OrdemDao ordemDao = new OrdemDao(em);
		
		
		
		Cliente cliente1 = new Cliente("04407090243", "Gustavo");
		Endereco endereco = new Endereco("68600-000", "General Gurjao", "N1486", "Bragança", "PA");
		
		cliente1.getEnderecos().add(endereco);
		Ordem ordem = new Ordem(cliente1);
		
		ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(1L), 2));
		//ordem.addOrdensCardapio(new OrdensCardapio(ordem, cardapioDao.consultarPorId(1L), 2));
		
		clienteDao.cadastrar(cliente1);
		ordemDao.cadastrar(ordem);
		
		System.out.println(ordem.getOrdensCardapios());
				
		em.getTransaction().commit();
		JpaUtil.close();
		em.close();

			
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