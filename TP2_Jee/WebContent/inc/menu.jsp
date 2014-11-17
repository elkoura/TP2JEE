<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<link type="text/css" rel="stylesheet" href="inc/bootstrap.min.css" />

<ul class="nav nav-tabs" role="tablist">
  <li role="presentation" class="active" ><a href="<c:url value="/creationClient"/>">Accueil</a></li>
  <li role="presentation" ><a href="<c:url value="/recherche"/>">Recherche</a></li>
  <li role="presentation" ><a href="<c:url value="/creerAnnonce"/>">Proposer un trajet</a></li>
  <li role="presentation"><a href="<c:url value="/listeAnnonces"/>">Voir toutes les annonces</a></li>
    <li role="presentation"><a href="<c:url value="/profil"/>">Profil</a></li>
	
</ul>