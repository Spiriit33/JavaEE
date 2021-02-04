<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<t:genericpage>
	<jsp:attribute name="content">
	<h3 class="mb-4">Liste des factures</h3>
	<hr/>
	<div class="table-responsive">
	<table class="table table-hover table-bordeless">
	<tr>
	<th>Numero</th>
	<th>Client</th>
	<th>Date</th>
	<th>Prix</th>
	</tr>
	<c:forEach var="facture" items="${factures}">
	<tr>
	<td>#<c:out value="${facture.id}"/></td>
	<td><c:out value="${facture.client.nom}"/></td>
	<td><c:out value="${facture.dateCreation}"/></td>
	<td><c:out value="${facture.prix}"/></td>
	</tr>
	</c:forEach>
	</table>
	</div>
	</jsp:attribute>
</t:genericpage></html>