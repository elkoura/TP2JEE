<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
    <link type="text/css" rel="stylesheet" href="inc/style.css" />
         <link type="text/css" rel="stylesheet" href="inc/bootstrap.min.css" />
        <link type="text/css" rel="stylesheet" href="inc/bootstrap.css" />
        
    </head>
    <body>
    <br>
    <div class="container">
        <form method="post" action="inscription">
            <fieldset>
                <legend>Creation du compte client</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                <div class="form-group">
                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="<c:out value="${user.nom}"/>" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['nom']}</span>
                <br />
                
                <label for="nom">Prénom </label>
                <input type="text" id="prenom" name="prenom" value="<c:out value="${user.prenom}"/>" size="20" maxlength="20" />
               
                <br />
                
                <label for="nom">Téléphone </label>
                <input type="text" id="telephone" name="telephone" value="<c:out value="${user.telephone}"/>" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['telephone']}</span>
                <br />

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${user.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />

                <label for="confirmation">Confirmation <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['confirmation']}</span>
                <br />
                
                 <br />
                <br />
                 <label for="nbr_places">Préferences </label>
<!--                 <TEXTAREA rows="3" cols="35" name="preferences" id= "preferences" placeholder="Tapez vos préferences"  ></TEXTAREA>
 -->               
                  <input type="text" id="preferences" name="preferences" value="" size="20" maxlength="20" />
  
				</div>
				
				
               
	<div class="form-group">
               <button type="submit" class="btn btn-primary">Valider</button>
                <br />
                </div>
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
        </div>
    </body>
</html>