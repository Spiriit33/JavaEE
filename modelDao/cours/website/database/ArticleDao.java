package cours.website.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cours.ArticleDaoInterface;
import cours.model.DatabaseManager;
import cours.website.model.Article;

public class ArticleDao extends DatabaseManager implements ArticleDaoInterface {
	
	public List<Article> getAll() {
		List<Article> articles = new ArrayList<Article>();
		try {
			Connection connection = DatabaseManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("SELECT * FROM articles;");
			while(results.next()) {
				Article article = new Article();
				article.setId(results.getLong("id"));
				article.setNom(results.getString("nom"));
				article.setPrix(results.getDouble("prix"));
				articles.add(article);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	public Article findById(Long id) {
		Article article = new Article();
		try {
			Connection con = DatabaseManager.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM articles WHERE id = ?;");
			statement.setLong(1, id);
			statement.execute();
			ResultSet results = statement.getResultSet();
			while(results.next()) {
				article.setId(results.getLong("id"));
				article.setNom(results.getString("nom"));
				article.setPrix(results.getDouble("prix"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public Article create(Article article) {
		try {
			Connection connection = DatabaseManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("Insert into articles (nom,prix) VALUES(?,?);");
			statement.setString(1,article.getNom());
			statement.setDouble(2,article.getPrix());
			statement.execute();
			System.out.println(article.getNom()+" sauvegardé en base.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public Article update(Article article) {
		try {
			Connection connection = DatabaseManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("update articles SET nom = ?, prix = ? WHERE id = ?");
			statement.setString(1,article.getNom());
			statement.setDouble(2, article.getPrix());
			statement.setLong(3,article.getId());
			statement.execute();
			System.out.println(article.getNom()+" mis à jour.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public void delete(Article article) {
		try {
			Connection con = DatabaseManager.getConnection();
			PreparedStatement statement = con.prepareStatement("DELETE FROM articles WHERE id = ?;");
			statement.setLong(1,article.getId());
			statement.execute();
			System.out.println(article.getNom()+" supprimé avec succés!");
		}
		catch(SQLException e) {
			e.printStackTrace();
			;
		}
	}
}
