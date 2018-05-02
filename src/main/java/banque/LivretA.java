package banque;

import javax.persistence.*;

@Entity
@Table (name ="livretA")
public class LivretA extends Compte{
	
	@Column (name="taux",  nullable=false)
	private Double taux;
	
	
	public LivretA(String numero, Double solde, Double taux) {
		super(numero, solde);
		this.taux = taux;
		// TODO Auto-generated constructor stub
	}
	
	public LivretA(){
		super();
	}


	public Double getTaux() {
		return taux;
	}


	public void setTaux(Double taux) {
		this.taux = taux;
	}


	@Override
	public String toString() {
		return super.toString() + "LivretA [taux=" + taux + "]";
	}
	
	

}
