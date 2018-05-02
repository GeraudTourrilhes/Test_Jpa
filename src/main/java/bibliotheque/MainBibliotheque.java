package bibliotheque;

import javax.persistence.*;

import org.slf4j.*;

public class MainBibliotheque {
	private static final Logger LOG = LoggerFactory.getLogger(MainBibliotheque.class);

	public static void main(String[] args)
	  {
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		 EntityManager em = entityManagerFactory.createEntityManager();
		 String titre = "Guerre et paix";
		 TypedQuery<Livre> query = em.createQuery("select livre from Livre livre  where livre.titre=:titre", Livre.class);
		 query.setParameter("titre", titre);
		 Livre livre2 = query.getSingleResult();
		 Livre livre = em.find(Livre.class, 1);
		 
		 if(livre != null)
		 {
			LOG.info(livre +"");
		 }
		 if(livre2 != null)
		 {
			 LOG.info(livre2+ "");
		 }
		 
		 int idEmprunt = 2;
		 TypedQuery<Emprunt> query2 = em.createQuery("select emprunt from Emprunt emprunt where emprunt.id=:idEmprunt", Emprunt.class);
		 query2.setParameter("idEmprunt", idEmprunt);
		 Emprunt emprunt = query2.getSingleResult();
		 if(emprunt != null)
		 {
			 LOG.info(emprunt + emprunt.getLivres().toString());
		 }
		 
		 int idClient = 2;
		 TypedQuery<Client> query3 = em.createQuery("select client from Client client where client.id=:idClient", Client.class);
		 query3.setParameter("idClient", idClient);
		 Client client = query3.getSingleResult();
		 if(client != null)
		 {
			 LOG.info(client + client.getEmprunts().toString());
		 }
		 em.close();
		 entityManagerFactory.close();
	  }

}
