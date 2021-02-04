import cours.website.model.Article;
import cours.website.model.Facture;

public class LigneFacture {
	private Long id;
	private Facture facture;
	private int quantte;
	private Double prix;
	private Article article;
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Facture getFacture() {
		return this.facture;
	}
	
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	
}
