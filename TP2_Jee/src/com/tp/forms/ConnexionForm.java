package com.tp.forms;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.tp.beans.*;

public final class ConnexionForm {
	private static final String CHAMP_EMAIL  = "email";
	private static final String CHAMP_PASS   = "motdepasse";
	private static final String CHAMP_AUTH   = "auth";

	private boolean valide;
	private String              resultat;
	private Map<String, String> erreurs      = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Client connecterUtilisateur( HttpServletRequest request ) {
		/* Récupération des champs du formulaire */
		String email = getValeurChamp( request, CHAMP_EMAIL );
		String motDePasse = getValeurChamp( request, CHAMP_PASS );

		Client user = new Client();

		/* Validation du champ email. */
		try {
			validationEmail( email );
		} catch ( Exception e ) {
			setErreur( CHAMP_EMAIL, e.getMessage() );
		}
		user.setEmail( email );

		/* Validation du champ mot de passe. */
		try {
			validationMotDePasse( motDePasse );
		} catch ( Exception e ) {
			setErreur( CHAMP_PASS, e.getMessage() );
		}
		user.setMot_de_passe(motDePasse);
		
		

		/* Initialisation du résultat global de la validation. */
		if ( erreurs.isEmpty() && isValide()  ) {
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Échec de la connexion, Email ou mot de passe incorrect !";
		}

		return user;
	}
	
	public void setValide(boolean state)
	{
		this.valide = state;
		if(!isValide())
		{
			setErreur( CHAMP_AUTH, "error auth" );	
		}
		
	}
	
	public boolean isValide() {
		return this.valide;
		
	}
	

	/**
	 * Valide l'adresse email saisie.
	 */
	private void validationEmail( String email ) throws Exception {
		if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
			throw new Exception( "Merci de saisir une adresse mail valide." );
		}
	}

	/**
	 * Valide le mot de passe saisi.
	 */
	private void validationMotDePasse( String motDePasse ) throws Exception {
		if ( motDePasse != null ) {
			if ( motDePasse.length() < 3 ) {
				throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
			}
		} else {
			throw new Exception( "Merci de saisir votre mot de passe." );
		}
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur( String champ, String message ) {
		erreurs.put( champ, message );
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {
			return null;
		} else {
			return valeur;
		}
	}


}
