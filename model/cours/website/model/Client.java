package cours.website.model;

public class Client {
	private Long id;
	private String nom;
	private String addresse;
	
	
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
	public String getAddresse() {
		return this.addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
}
