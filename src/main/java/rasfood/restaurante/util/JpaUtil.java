package rasfood.restaurante.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("rasFood");
	}
	
	public static EntityManager getEmf() {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
	}

}
