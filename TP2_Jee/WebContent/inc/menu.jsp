<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<link type="text/css" rel="stylesheet" href="inc/bootstrap.min.css" />

<ul class="nav nav-tabs" role="tablist">
  <li role="presentation" class="active"><a href="<c:url value="/creationClient"/>">Recherche</a></li>
  <li role="presentation"><a href="<c:url value="/creationCommande"/>">Proposer un trajet</a></li>
  <li role="presentation"><a href="<c:url value="/listeCommandes"/>">Voir toutes les annonces</a></li>
    <li role="presentation"><a href="<c:url value="/listeClients"/>">Profil</a></li>
	
</ul>