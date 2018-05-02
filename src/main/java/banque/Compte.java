package banque;

import java.time.LocalDate;
import java.util.*;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name="numero", length=255, nullable=false)
	private String numero;
	
	@Column (name="solde",  nullable=false)
	private Double solde;
	
	@ManyToMany(mappedBy="comptes")
	private Set<Client> clients;
	
	@OneToMany (mappedBy="compte")
	private Set<Operation> operations;

	public Compte(String numero, Double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.clients =  new HashSet<Client>();
		this.operations = new HashSet<Operation>();
	}

	public Compte() {
		// TODO Auto-generated constructor stub
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Integer getId() {
		return id;
	}
	
	public void addClient(Client client){
		this.clients.add(client);
	}
	
	public void addOperation(Operation operation){
		this.operations.add(operation);
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", operations=" + operations + "]";
	}
	
	
	
}

/*
@Entity
@Table (name = "compte")
public class Compte {

	@Id  
	private int id;
	
	@Column (name="numero", length=255, nullable=false)
	private String numero;
	
	@Column (name="solde",  nullable=false)
	private Double solde;
	
	@Column (name="taux",  nullable=false)
	private Double taux;
	
	@Column (name="dateFin", nullable=true)
	private LocalDate dateFin;
	
	@ManyToMany(mappedBy="comptes")
	private Set<Client> clients;
	
	@OneToMany (mappedBy="compte")
	private Set<Operation> operations;

	public Compte(String numero, Double solde, Double taux, LocalDate dateFin) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.taux = taux;
		this.dateFin = dateFin;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public int getId() {
		return id;
	}
	
	
	
	
}*/
