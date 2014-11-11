<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Publier une annonce</title>
    <link type="text/css" rel="stylesheet" href="inc/style.css" />
         <link type="text/css" rel="stylesheet" href="inc/bootstrap.min.css" />
        <link type="text/css" rel="stylesheet" href="inc/bootstrap.css" />
        
    </head>
    <body>
    
<ul class="nav nav-tabs" role="tablist">
  <li role="presentation" ><a href="<c:url value="/creationClient"/>">Accueil</a></li>
  <li role="presentation"><a href="<c:url value="/recherchet"/>">Recherche</a></li>
  <li role="presentation" class="active"><a href="<c:url value="/creerAnnonce"/>">Proposer un trajet</a></li>
  <li role="presentation"><a href="<c:url value="/listeAnnonces"/>">Voir toutes les annonces</a></li>
    <li role="presentation"><a href="<c:url value="/listeClients"/>">Profil</a></li>
	
</ul>

    <div class="container">
    <br>
        <form method="post" action="creerAnnonce">
            <fieldset>
                <legend>Merci d'insérer les information de votre trajet</legend>
                
              <div class="form-group">
              <p> Conducteur</p>
                <label for="nom">E-mail </label>
                <input type="text" id="conducteur" name="conducteur" value="<c:out value="${sessionScope.sessionUtilisateur.email}"/>" size="20" maxlength="20" />
 
                <br />
                </div>
               
                <div class="form-group">
                <p> Itinéraire</p>
                <label for="depart">Départ <span class="requis">*</span></label>
                <input type="text" id="depart" name="depart" value="" size="20" maxlength="20" />
                <br />
                
                <label for="arrivee">Arrivée <span class="requis">*</span></label>
                <input type="text" id="arrivee" name="arrivee" value="" size="20" maxlength="20" />
               
                <br />
                

                <label for="date_depart">Date départ <span class="requis">*</span></label>
                <input type="datetime" id="date_depart" name="date_depart" value="" placeholder="YYYY-MM-DD" size="20" maxlength="60" />
                
                <br />

                <label for="nbr_places">Nombre de places <span class="requis">*</span></label>
                <input type="text" id="nbr_places" name="nbr_places" value="" size="20" maxlength="20" />
                
                <br />
                
                 <label for="nbr_places">Prix <span class="requis">*</span></label>
                <input type="text" id="prix" name="prix" value="" size="20" maxlength="20" />
                
                <br />

               
				</div>
               
	<div class="form-group">
               <button type="submit" class="btn btn-primary">Ajouter</button>
                <br />
                </div>
                
            </fieldset>
        </form>
        </div>
    </body>
</html>