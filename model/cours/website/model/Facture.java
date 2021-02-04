package cours.website.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facture {
	private Long id;
	//Représente la clé etrangere client id.
	private Client client;
	private List<LigneFacture> ligneFactures = new ArrayList<LigneFacture>();
	private int quantite;
	private Date dateCreation;
	private Double prix = 0.00;
	
	public Long getId() {
		return this.id;
	}
	public Client getClient() {
		return this.client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getQuantite() {
		return this.quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public List<LigneFacture>getLigneFactures() {
		return this.ligneFactures;
	}
	 
	public void setLigneFactures(LigneFacture ligneFacture) {
		this.ligneFactures.add(ligneFacture);
	}
	
	public Date getDateCreation() {
		return this.dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public double getPrix() {
		Double prix = this.prix;
		for(LigneFacture ligne : this.ligneFactures) {
			prix=+ligne.getArticle().getPrix()*ligne.getQuantite();
		}
		return prix;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
