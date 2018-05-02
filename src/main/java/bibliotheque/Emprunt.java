package bibliotheque;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="emprunt")
public class Emprunt {
	
	@Id
	private int id;
	
	@Column (name="date_debut", nullable=false)
	private LocalDateTime date_debut;
	
	@Column (name="delai", length=10, nullable=true)
	private int delai;
	
	@Column (name="date_fin", nullable=true)
	private LocalDateTime date_fin;
	
	@ManyToOne
	@JoinColumn(name="id_client", nullable=true)
	private Client client;
	
	@ManyToMany
	@JoinTable(name="compo",
	joinColumns= @JoinColumn(name="ID_emp", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_liv", referencedColumnName="ID"))
	private Set<Livre> livres;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(LocalDateTime date_debut) {
		this.date_debut = date_debut;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public LocalDateTime getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(LocalDateTime date_fin) {
		this.date_fin = date_fin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", date_debut=" + date_debut + ", delai=" + delai + ", date_fin=" + date_fin
				+ "]";
	}

	
	
}
