package cours;

import java.util.List;

import cours.website.model.Client;

public interface ClientDaoInterface {
	public List<Client> getAll();
	public Client findById(Long id);
	public Client createClient(Client client);
	public Client update(Client client);
	public void delete(Client client);
}
