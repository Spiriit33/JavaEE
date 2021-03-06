package com.website.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cours.website.database.ArticleDao;
import cours.website.model.Article;

/**
 * Servlet implementation class EditArticleServlet
 */
@WebServlet("/EditArticleServlet")
public class EditArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		ArticleDao articleDao = new ArticleDao();
		articleDao.findById(id);
		request.setAttribute("article", articleDao.findById(id));
		this.getServletContext().getRequestDispatcher("/views/articles/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Article article = new Article();
		article.setId(id);
		article.setNom(request.getParameter("nom"));
		article.setPrix(Double.parseDouble(request.getParameter("prix")));
		ArticleDao articleDao = new ArticleDao();
		articleDao.update(article);
		response.sendRedirect("/cours/articles?tab=1");
	}

}
