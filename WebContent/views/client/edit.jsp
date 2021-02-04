<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<t:genericpage>
	<jsp:attribute name="content">
	<h3 class="pull-right">Modifier client <a class="text-info" style="float:right;" href="/cours/clients?tab=1">← Retour liste clients</a></h3>
	<hr/>
	<form method="post" action="">
	<div class="form-group row">
	<div class="col-md-2">
	<label class="col-form-label">Nom:</label>
	</div>
	<div class="col-md-6">
	<input type="text" class="form-control" name="nom" value="${client.nom}">
	</div>
	</div>
	<div class="form-group row">
	<div class="col-md-2">
	<label class="col-form-label">Adresse:</label>
	</div>
	<div class="col-md-6">
	<input type="text" class="form-control" name="addresse" value="<c:out value="${client.addresse}" />">
	</div>
	</div>
	<div class="form-group row">
	<div class="col-md-6 offset-md-2">
	<button type="submit" class="btn btn-primary">Mettre à jour</button>
	</div>
	</div>	
	</form>
	</jsp:attribute>
	</t:genericpage>