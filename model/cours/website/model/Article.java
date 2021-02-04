package cours.website.model;

public class Article {
	private Long id;
	private String nom;
	private double prix;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return this.prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
}
