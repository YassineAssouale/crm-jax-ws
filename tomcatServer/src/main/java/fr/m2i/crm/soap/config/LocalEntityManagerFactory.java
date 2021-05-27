package fr.m2i.crm.soap.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LocalEntityManagerFactory implements ServletContextListener {
	
	private static EntityManagerFactory emf;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		emf = Persistence.createEntityManagerFactory("crm");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		emf.close();
	}
	
	/**
	 * Récupération d'un gestionnaire d'entités
	 * @return
	 */
	public static EntityManager createEntityManager() {
		if (emf == null) {
			throw new IllegalStateException("Context is not initialized yet.");
		}
        return emf.createEntityManager();
    }

}