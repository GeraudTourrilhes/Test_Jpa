package banque;

import javax.persistence.*;

@Embeddable
public class Adresse {
	
	@Column (name="numero", length=10, nullable=false)
	private int numero;
	
	@Column (name="rue", length=50, nullable=false)
	private String rue;
	
	@Column (name="codePostal", length=5, nullable=false)
	private int codePostal;
	
	@Column (name="ville", length=50, nullable=false)
	private String ville;

	public Adresse(int numero, String rue, int codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public Adresse() {
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	
	
}
