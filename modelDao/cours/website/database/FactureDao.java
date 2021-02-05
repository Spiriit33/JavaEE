package cours.website.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cours.FactureDaoInterface;
import cours.model.DatabaseManager;
import cours.website.model.Article;
import cours.website.model.Client;
import cours.website.model.Facture;
import cours.website.model.LigneFacture;

public class FactureDao extends DatabaseManager implements FactureDaoInterface {
	public List<Facture> getAll() {
		List<Facture> factures = new ArrayList<Facture>();
		try {
			java.sql.Connection connection = DatabaseManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("SELECT factures.id,c.nom as c_nom,c.addresse as c_addresse,factures.date_creation as f_date,a.prix as a_prix,SUM(l.quantity) as l_quantite,a.nom as a_nom,a.prix as a_prix FROM factures JOIN clients c ON c.id = factures.client_id JOIN ligne_factures l ON l.facture_id = factures.id JOIN articles a ON a.id = l.article_id GROUP BY factures.id");
			while(results.next()) {
				Client client = new Client();
				client.setNom(results.getString("c_nom"));
				client.setAddresse(results.getString("c_addresse");

				Facture facture = new Facture();
			        facture.setId(results.getLong("id"));
						facture.setClient(client);
						facture.setDateCreation(results.getDate("f_date"));

				LigneFacture ligne = new LigneFacture();
				    ligne.setFacture(facture);
				    ligne.setQuantite(results.getInt("l_quantite"));
				    ligne.setPrix(results.getDouble("a_prix"));
				    facture.setLigneFactures(ligne);

				Article article = new Article();
				    article.setNom(results.getString("a_nom"));
				    article.setPrix(results.getLong("a_prix"));
				    ligne.setArticle(article);
				    factures.add(facture);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return factures;
	}
}
