package banque;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

@Entity
@Table (name = "client")
public class Client {
	
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name="nom", length=50, nullable=false)
	private String nom;
	
	@Column (name="prenom", length=50, nullable=false)
	private String prenom;
	
	@Column (name="dateNaissance", nullable=false)
	private LocalDate dateNaissance;
	
	@ManyToOne
	@JoinColumn(name="id_banque", nullable=false)
	private Banque banque;
	
	@ManyToMany
	@JoinTable(name="client_compte",
	joinColumns= @JoinColumn(name="ID_cli", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_comp", referencedColumnName="ID"))
	private Set<Compte> comptes;
	
	@Embedded
	private Adresse adresse;

	
	
	
	public Client(String nom, String prenom, LocalDate dateNaissance, Banque banque,
			Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.banque = banque;
		this.adresse = adresse;
		this.comptes = new HashSet<Compte>();
	}
	
	public Client(){
		
	}

	public int getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public void addCompte(Compte compte){
		this.comptes.add(compte);
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", banque=" + banque + ", adresse=" + adresse + "]";
	}
	
	
	
	

}
