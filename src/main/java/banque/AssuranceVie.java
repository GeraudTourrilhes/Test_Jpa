package banque;

import java.time.*;

import javax.persistence.*;

@Entity
@Table (name ="assuranceVie")
public class AssuranceVie extends Compte{
	
	@Column (name="taux",  nullable=false)
	private Double taux;
	
	@Column (name="dateFin",  nullable=false)
	private LocalDate dateFin;
	
	
	public AssuranceVie(String numero, Double solde, Double taux, LocalDate dateFin) {
		super(numero, solde);
		this.taux = taux;
		this.dateFin = dateFin;
	}
	
	public AssuranceVie(){
		super();
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


	@Override
	public String toString() {
		return super.toString() + "AssuranceVie [taux=" + taux + ", dateFin=" + dateFin + "]";
	}
	
	
	
	

}
