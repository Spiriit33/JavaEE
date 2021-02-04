package cours.website.model;
import cours.website.model.Article;
import cours.website.model.Facture;

public class LigneFacture {
	private Long id;
	private Facture facture;
	private int quantite;
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
	
	public Article getArticle() {
		return this.article;
	}
	
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public Double getPrix() {
		return this.prix;
	}
	
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public int getQuantite() {
		return this.quantite;
	}
	
	
	
}
