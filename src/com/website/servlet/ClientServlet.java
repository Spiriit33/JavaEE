package com.website.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cours.model.DatabaseManager;
import cours.website.database.ClientDao;
import cours.website.model.Client;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientDao clientDao = new ClientDao();
		request.setAttribute("clients", clientDao.getAll());
		this.getServletContext().getRequestDispatcher("/views/client/index.jsp").forward(request,response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String addresse = request.getParameter("addresse");
		Client client = new Client();
		client.setNom(nom);
		client.setAddresse(addresse);
		ClientDao clientDao = new ClientDao();
		clientDao.createClient(client);
		response.sendRedirect("/cours/clients?tab=1");
	}
}
