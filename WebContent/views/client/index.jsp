<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<t:genericpage>
	<jsp:attribute name="content">
	<h3 class="mb-4">Gestion des clients</h3>
	<ul class="nav nav-tabs mb-4">
	<li class="nav-item">
	<a class="nav-link <c:out value="${param.tab ==  1 ? 'active' : null}" /> !" href="/cours/clients?tab=1">Gestion</a>
	</li>
	<li class="nav-item">
	<a class="nav-link <c:out value="${param.tab == 2 ? 'active' : null}" /> !" href="/cours/clients?tab=2">Creation</a>
	</li>
	</ul>
	<c:choose>
	<c:when test="${param.tab == 1}"> 
	<div class="table-responsive">
	<table class="table table-hover table-bordeless">
	<tr>
	<th>ID</th>
	<th>Nom complet</th>
	<th>Adresse</th>
	<th>Action</th>
	</tr>
	<c:forEach var="client" items="${clients}">
	<tr>
	<td>#<c:out value="${client.id}"/></td>
	<td><c:out value="${client.nom}"/></td>
	<td><c:out value="${client.addresse}"/></td>
	<td><a href="/cours/clients/edit?id=${client.id}"><button class="btn btn-sm btn-primary">Edit</button></a> <a href="/cours/clients/delete?id=<c:out value="${client.id}"/>"><button class="btn btn-sm btn-secondary">Supprimer</button></a></td>
	</tr>
	</c:forEach>
	</table>
	</div>
	</c:when>
	<c:otherwise>
	<form method="post" action="/cours/clients?tab=2">
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
	<label class="col-form-label">Adresse:</label>
	</div>
	<div class="col-md-6">
	<input type="text" class="form-control" name="addresse" required>
	</div>
	</div>
	<div class="form-group row">
	<div class="col-md-6 offset-md-2">
	<button type="submit" class="btn btn-primary">Ajouter Client</button>
	</div>
	</div>	
	</form>
	</c:otherwise>
	</c:choose>
	</jsp:attribute>
</t:genericpage></html>