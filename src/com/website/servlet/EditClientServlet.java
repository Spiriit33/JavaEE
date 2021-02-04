package com.website.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cours.website.database.ClientDao;
import cours.website.model.Client;

/**
 * Servlet implementation class EditClientServlet
 */
@WebServlet("/EditClientServlet")
public class EditClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		ClientDao clientDao = new ClientDao();
		request.setAttribute("client", clientDao.findById(id));
		System.out.println(request.getAttribute("client"));
		this.getServletContext().getRequestDispatcher("/views/client/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Client client = new Client();
		client.setId(id);
		client.setNom(request.getParameter("nom"));
		client.setAddresse(request.getParameter("addresse"));
		ClientDao clientDao = new ClientDao();
		clientDao.update(client);
		response.sendRedirect("/cours/clients/edit?id=" + id);
	}

}
