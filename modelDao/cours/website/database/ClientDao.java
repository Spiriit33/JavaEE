package cours.website.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cours.website.model.*;
import cours.ClientDaoInterface;
import cours.model.DatabaseManager;

public class ClientDao extends DatabaseManager implements ClientDaoInterface {

	//Get collection of all clients
	public List<Client> getAll() {
		List<Client> clients = new ArrayList<Client>();
		try {
			Connection connection = DatabaseManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM clients;");
			while(resultat.next()) {
				Client client = new Client();
				client.setId(resultat.getLong("id"));
				client.setNom(resultat.getString("nom"));
				client.setAddresse(resultat.getString("addresse"));
				clients.add(client);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

    //
	public Client findById(Long id) {
		Client client = new Client();
		try {
			Connection con = DatabaseManager.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM clients WHERE id = ?;");
			statement.setLong(1, id);
			statement.execute();
			ResultSet results = statement.getResultSet();		
			while(results.next()) {
				client.setId(results.getLong("id"));
				client.setNom(results.getString("nom"));
				client.setAddresse(results.getString("addresse"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return client;
	}
	
	public Client createClient(Client client) {
		try {
			Connection connection = DatabaseManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("Insert into clients (nom,addresse) VALUES(?,?)");
			statement.setString(1,client.getNom());
			statement.setString(2,client.getAddresse());
			statement.execute();
			System.out.println(client.getNom()+" sauvegardé en base.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
	
	public Client update(Client client) {
		try {
			Connection connection = DatabaseManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("update clients set nom = ?, addresse = ? WHERE id = ? ");
			statement.setString(1, client.getNom());
			statement.setString(2, client.getAddresse());
			statement.setLong(3, client.getId());
			statement.execute();
			System.out.println(client.getNom()+" mis a jour");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
	
	public void delete(Client client) {
		try {
			Connection connection = DatabaseManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM clients WHERE id = ?");
			statement.setLong(1, client.getId());
			statement.execute();
			System.out.println(client.getNom()+" supprimé.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
