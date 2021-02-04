package cours;

import java.util.List;

import cours.website.model.Article;

public interface ArticleDaoInterface {
	public List<Article>getAll();
	public Article findById(Long id);
	public Article create(Article article);
	public Article update(Article article);
	public void delete(Article article);
}
