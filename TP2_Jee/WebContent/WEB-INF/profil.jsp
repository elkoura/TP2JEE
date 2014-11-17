<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>liste des annonces</title>
    <link type="text/css" rel="stylesheet" href="inc/style.css" />
         <link type="text/css" rel="stylesheet" href="inc/bootstrap.min.css" />
        <link type="text/css" rel="stylesheet" href="inc/bootstrap.css" />
        
    </head>
    <body>
    
<ul class="nav nav-tabs" role="tablist">
  <li role="presentation" ><a href="<c:url value="/creationClient"/>">Accueil</a></li>
  <li role="presentation"><a href="<c:url value="/recherche"/>">Recherche</a></li>
  <li role="presentation"><a href="<c:url value="/creerAnnonce"/>">Proposer un trajet</a></li>
  <li role="presentation"  class="active"><a href="<c:url value="/listeAnnonces"/>">Voir toutes les annonces</a></li>
    <li role="presentation"><a href="<c:url value="/profil"/>">Profil</a></li>
	
</ul>





</body>
</html>