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
    <br>
    <div class="container">
        <form method="post" action="inscription">
            <fieldset>
                <legend>Merci d'insérer les information de votre trajet</legend>
                
              <div class="form-group">
                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="<c:out value="${sessionScope.sessionUtilisateur.nom}"/>" size="20" maxlength="20" />
                
                <br />
                
                <label for="nom">Prénom </label>
                <input type="text" id="prenom" name="prenom" value="<c:out value="${sessionScope.sessionUtilisateur.prenom}}"/>" size="20" maxlength="20" />
               
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
                <input type="datetime" id="date" name="date" value="" size="20" maxlength="60" />
                
                <br />

                <label for="nbr_places">Nombre de places <span class="requis">*</span></label>
                <input type="text" id="nbr_places" name="nbr_places" value="" size="20" maxlength="20" />
                
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