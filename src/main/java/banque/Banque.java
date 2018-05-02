package banque;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name = "banque")
public class Banque {
	
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name="nom", length=50, nullable=false)
	private String nom;
	
	@OneToMany (mappedBy="banque")
	private Set<Client> clients;

	public int getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Banque(String nom) {
		super();
		this.nom = nom;
	}
	
	public Banque() {
		super();
	}


	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + "]";
	}
	
	
	

}
