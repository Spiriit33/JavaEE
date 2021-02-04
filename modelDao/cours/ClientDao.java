package cours.website.da

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cours.website.model.*;
import cours.model.DatabaseManager;

public class ClientDao extends DatabaseManager {
	
	public Client createClient(Client client) {
		try {
			new DatabaseManager();
			Connection connection = DatabaseManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("Insert into clients (nom,addresse) VALUES(?,?)");
			statement.setString(1,client.getNom());
			statement.setString(2,client.getAdresse());
			statement.execute();
			System.out.println(client.getNom()+" sauvegardé en base.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return client;
	}
}
