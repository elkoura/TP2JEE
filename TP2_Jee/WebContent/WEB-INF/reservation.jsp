<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Connexion</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<link type="text/css" rel="stylesheet" href="inc/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="inc/bootstrap.css" />

<script type="text/javascript">

function confirm() {
	
   alert("Félicitations ! votre réservation a été bien efféctuée.")
}

</script>
</head>
<body>


	<ul class="nav nav-tabs" role="tablist">
		<li role="presentation"><a
			href="<c:url value="/creationClient"/>">Accueil</a></li>
		<li role="presentation" class="active"><a
			href="<c:url value="/recherche"/>">Recherche</a></li>
		<li role="presentation"><a href="<c:url value="/creerAnnonce"/>">Proposer
				un trajet</a></li>
		<li role="presentation"><a href="<c:url value="/listeAnnonces"/>">Voir
				toutes les annonces</a></li>
		<li role="presentation"><a href="<c:url value="/profil"/>">Profil</a></li>

	</ul>


	<br>

	<h3>Détail de votre trajet</h3>

	<table class="table table-striped">
		<tr>
			<th>Conducteur</th>
			<th>Départ</th>
			<th>Arrivée</th>
			<th>Date départ</th>
			<th>Nombre de places</th>
			<th>Prix</th>

		</tr>

		<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
			<%-- Affichage des propriétés du bean Client, qui est stocké en tant que valeur de l'entrée courante de la map --%>
			<td><c:out value="${ annonce.conducteur }" /></td>
			<td><c:out value="${ annonce.depart }" /></td>
			<td><c:out value="${ annonce.arrivee }" /></td>
			<td><c:out value="${ annonce.date_depart }" /></td>
			<td><c:out value="${ annonce.nbr_places }" /></td>
			<td><c:out value="${ annonce.prix} €" /></td>
			<%-- Lien vers la servlet de reservation, avec passage du id de annonce -  --%>
		</tr>

	</table>

	<div class="col-xs-4">
		<h4>Veuillez entrer le nombre de places</h4>
		<form class="form-inline" role="form" method="post"
			action="reservation">

			<select class="form-control" name="nbr_places">
				<c:forEach var="i" begin="1" end="${annonce.nbr_places }" step="1">
					<option value="${i}"><c:out value="${i} place" /></option>
				</c:forEach>
			</select>


			<button type="submit" class="btn btn-success" onclick="confirm()">Reserver</button>
		</form>


	</div>
	


</body>
</html>