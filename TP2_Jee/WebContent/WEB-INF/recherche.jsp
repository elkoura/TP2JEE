<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
         <link type="text/css" rel="stylesheet" href="inc/style.css" />
         <link type="text/css" rel="stylesheet" href="inc/bootstrap.min.css" />
        <link type="text/css" rel="stylesheet" href="inc/bootstrap.css" />
    </head>
    <body>
    
    <ul class="nav nav-tabs" role="tablist">
  <li role="presentation" ><a href="<c:url value="/creationClient"/>">Accueil</a></li>
  <li role="presentation" class="active"><a href="<c:url value="/recherche"/>">Recherche</a></li>
  <li role="presentation" ><a href="<c:url value="/creerAnnonce"/>">Proposer un trajet</a></li>
  <li role="presentation"><a href="<c:url value="/listeAnnonces"/>">Voir toutes les annonces</a></li>
    <li role="presentation"><a href="<c:url value="/listeClients"/>">Profil</a></li>
	
</ul>

<form class="form-inline" role="form"  method="post" action="recherche">
  <h3>Trouver un trajet</h3>
  <div class="form-group">
    <div class="input-group">
      <input class="form-control" type="text" placeholder="De" id= "depart" name= "depart">
    </div>
    
    <div class="input-group"> 
      <input class="form-control" type="text" placeholder="à" id= "arrivee"	name="arrivee">
    </div>
  </div>
  
   <div class="form-group">
    <div class="input-group">
       <input class="form-control" type="datetime" id="date_depart" name="date_depart" value="" placeholder="Date: YYYY-MM-DD" size="20" maxlength="60" />
    </div>
    </div>

  
  <button type="submit" class="btn btn-default">Recherche</button>
</form>
</br>
  <c:if test="${ !empty sessionScope.resultat }">
<table class="table table-striped">
                <tr>
                    <th>Conducteur</th>
                    <th>Départ</th>
                    <th>Arrivée</th>
                    <th>Date départ</th>
                    <th>Nombre de places</th>
					<th>Prix</th>
                                       
                </tr>
                <%-- Parcours de le vector des annonces en session, et utilisation de l'objet varStatus. --%>
                <c:forEach items="${sessionScope.resultat}" var="annonce" varStatus="boucle" >
                <%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <%-- Affichage des propriétés du bean Client, qui est stocké en tant que valeur de l'entrée courante de la map --%>
                    <td><c:out value="${ annonce.conducteur }"/></td>
                    <td><c:out value="${ annonce.depart }"/></td>
                    <td><c:out value="${ annonce.arrivee }"/></td>
                    <td><c:out value="${ annonce.date_depart }"/></td>
                    <td><c:out value="${ annonce.nbr_places }"/></td>
                    <td><c:out value="${ annonce.prix} €"/></td>
                    <%-- Lien vers la servlet de suppression, avec passage du nom du client - c'est-à-dire la clé de la Map - en paramètre grâce à la balise <c:param/>. --%>
                   <%--  <td class="action">
                        <a href="<c:url value="/suppressionClient"><c:param name="nomClient" value="${ mapClients.key }" /></c:url>">
                            <img src="<c:url value="/inc/supprimer.png"/>" alt="Supprimer" />
                        </a>
                    </td> --%>
                </tr>
                </c:forEach>
            </table>

</c:if>
 <c:if test="${ empty sessionScope.resultat }">
 <div class="alert alert-danger" role="alert">Désolé, aucune annonce ne correspond aux critères de votre recherche. </div>
 </c:if>
</body>
</html>