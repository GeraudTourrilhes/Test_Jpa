package banque;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@DiscriminatorValue("virement")
public class Virement extends Operation{
	
	
	@Column (name="beneficiaire", length=150, nullable=false)
	private String beneficiaire;

	public Virement(LocalDate date, Double montant, String motif, Compte compte, String beneficiaire) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

	public Virement(){
		super();
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	@Override
	public String toString() {
		return super.toString() + "Virement [beneficiaire=" + beneficiaire + "]";
	}
	
	
	
	
}
