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
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleDao articleDao = new ArticleDao();
		request.setAttribute("articles", articleDao.getAll());
		this.getServletContext().getRequestDispatcher("/views/articles/index.jsp").forward(request,response );
		System.out.println(request.getAttribute("articles"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article article = new Article();
		article.setNom(request.getParameter("nom"));
		article.setPrix(Double.parseDouble(request.getParameter("prix")));
		ArticleDao articleDao = new ArticleDao();
		articleDao.create(article);
		response.sendRedirect("/cours/articles?tab=1");
	}

}
