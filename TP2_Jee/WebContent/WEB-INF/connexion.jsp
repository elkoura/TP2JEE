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
    <body >
    
    <h2> Bienvenu sur votre site TravelExpress ! </h2>
    
   <!--  <div class = "image">
    <img src="inc/discover.jpg" alt="Mountain" style="width:90%;height:228px;" >
    </div> -->
    
   
    <div class="container">
   
        <form role= form class = "form-signin" method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>
 <div class="form-group">
                <label for="nom">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
                </div>
                
<div class="form-group">
                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                </div>
 <div class="form-group">
				<button type="submit" class="btn btn-primary">Connexion</button>
               </div>
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
           
             <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
                </c:if>
                </fieldset> 
        </form>
         <p>Nouveau client ? <a href="<c:url value="/inscription"/>">Inscrivez-vous !</a></p>
        
        
        </div>
        
   
    </body>
</html>