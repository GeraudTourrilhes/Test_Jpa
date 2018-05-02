package bibliotheque;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="livre")
public class Livre {
	
	
	
	@Id
	private int id;
	
	@Column (name="titre", length=255, nullable=false)
	private String titre;
	
	@Column (name="auteur", length=50,  nullable=false)
	private String auteur;
	
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt> emprunts;
	
	
	public int getId() {
		return this.id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return this.titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	} 
	
	
	


	public String getAuteur() {
		return this.auteur;
	}



	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}



	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}



	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}



	



	

	
	
}
