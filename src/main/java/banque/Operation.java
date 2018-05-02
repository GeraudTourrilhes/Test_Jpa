package banque;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table (name = "operation")
public class Operation {
	
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name="date", nullable=false)
	private LocalDate date;
	
	@Column (name="montant",  nullable=false)
	private Double montant;
	
	@Column (name="motif", length=150, nullable=false)
	private String motif;
	
	@Column (name="beneficiaire", length=150, nullable=false)
	private String beneficiaire;
	
	@ManyToOne
	@JoinColumn(name="id_compte", nullable=false)
	private Compte compte;

	public Operation(LocalDate date, Double montant, String motif, String beneficiaire, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.beneficiaire = beneficiaire;
		this.compte = compte;
	}
	
	public Operation()
	{
		
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif
				+ ", beneficiaire=" + beneficiaire + "]";
	}
	
	
	
	
	

}
