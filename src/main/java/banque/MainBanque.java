package banque;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.hibernate.mapping.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bibliotheque.Livre;

public class MainBanque {
	private static final Logger LOG = LoggerFactory.getLogger(MainBanque.class);
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
	private static final EntityManager em = entityManagerFactory.createEntityManager();
	public static void main(String[] args) {
		 
		 em.getTransaction().begin();

		Banque banque = new Banque("Banque");
		Adresse adresse = new Adresse(5, "rue", 44800, "ville");
		Client client = new Client("nom", "prenom", LocalDate.of(1990, 02, 14), banque, adresse);
		Compte compte1 = new LivretA("001", new Double(0), new Double(10));
		Compte compte2 = new AssuranceVie("001", new Double(0), new Double(5), LocalDate.of(2020, 01, 01));
		compte1.setSolde(new Double(500));
		Operation operation = new Operation(LocalDate.of(2018, 05, 02), new Double(400), "Dette", "Jacque", compte1);
		client.addCompte(compte1);
		client.addCompte(compte2);
		//compte1.addClient(client);
		//compte2.addClient(client);
		//compte1.addOperation(operation);
		em.persist(compte1);
		em.persist(compte2);	
		em.persist(banque);
		em.persist(client);
		em.persist(operation);
		
		em.getTransaction().commit();
		em.clear();
		TypedQuery<Compte> query = em.createQuery("select compte from Compte compte  where compte.id=:id", Compte.class);
		query.setParameter("id", 1);
		Compte compte = query.getSingleResult();
		if(compte != null)
		 {
			LOG.info(compte +" " + compte.getClients().toString());
		 }
		
		TypedQuery<Compte> query1 = em.createQuery("select compte from Compte compte  where compte.id=:id", Compte.class);
		query1.setParameter("id", 2);
		Compte compt = query1.getSingleResult();
		if(compt != null)
		 {
			LOG.info(compt.getClients().toString());
		 }

		
		 em.close();
		 entityManagerFactory.close();

	}

}
