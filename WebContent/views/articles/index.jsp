<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<t:genericpage>
	<jsp:attribute name="content">
	<h3 class="mb-4">Gestion des articles</h3>
	<ul class="nav nav-tabs mb-4">
	<li class="nav-item">
	<a class="nav-link <c:out value="${param.tab ==  1 ? 'active' : null}" /> !" href="/cours/articles?tab=1">Gestion</a>
	</li>
	<li class="nav-item">
	<a class="nav-link <c:out value="${param.tab == 2 ? 'active' : null}" /> !" href="/cours/articles?tab=2">Creation</a>
	</li>
	</ul>
	<c:choose>
	<c:when test="${param.tab == 1}"> 
	<div class="table-responsive">
	<table class="table table-hover table-bordeless">
	<tr>
	<th>ID</th>
	<th>Nom</th>
	<th>Prix</th>
	<th>Action</th>
	</tr>
	<c:forEach var="article" items="${articles }">
	<tr>
	<td>#<c:out value="${article.id}"/></td>
		<td><c:out value="${article.nom}"/></td>
		<td><c:out value="${article.prix}"/></td>
		<td><a href="/cours/articles/edit?id=${article.id}"><button class="btn btn-sm btn-primary">Edit</button></a> <a href="/cours/articles/delete?id=<c:out value="${article.id}"/>"><button class="btn btn-sm btn-secondary">Supprimer</button></a></td>
	</tr>
	</c:forEach>
	</table>
	</div>
	</c:when>
	<c:otherwise>
	<form method="post" action="/cours/articles?tab=2">
	<div class="form-group row">
	<div class="col-md-2">
	<label class="col-form-label">Nom:</label>
	</div>
	<div class="col-md-6">
	<input type="text" class="form-control" name="nom" required>
	</div>
	</div>
	<div class="form-group row">
	<div class="col-md-2">
	<label class="col-form-label">Prix:</label>
	</div>
	<div class="col-md-3">
	<input type="number" class="form-control" name="prix" required>
	</div>
	</div>
	<div class="form-group row">
	<div class="col-md-6 offset-md-2">
	<button type="submit" class="btn btn-primary">Ajouter</button>
	</div>
	</div>	
	</form>
	</c:otherwise>
	</c:choose>
	</jsp:attribute>
</t:genericpage></html>