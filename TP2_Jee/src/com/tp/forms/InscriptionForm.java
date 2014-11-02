package com.tp.forms;

import java.util.HashMap;







import javax.servlet.http.HttpServletRequest;

import com.tp.beans.*;

public final class InscriptionForm {

	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_PASS = "motdepasse";
	public static final String CHAMP_CONF = "confirmation";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM = "prenom";
	public static final String CHAMP_TEL = "telephone";
	public static final String ATT_ERRORS = "erreurs";
	public static final String ATT_RESULT = "resultat";


	private String              resultat;
	private HashMap<String, String> erreurs      = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public HashMap<String, String> getErreurs() {
		return erreurs;
	}

	public Client inscrUser(HttpServletRequest request) {
		Client user = new Client();
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String telephone = request.getParameter(CHAMP_TEL);
		String email = request.getParameter(CHAMP_EMAIL);
		String motDePasse = request.getParameter(CHAMP_PASS);		
		String confirmation = request.getParameter(CHAMP_CONF);
		
    
    	 
 	    try {
			validationNom(nom,prenom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		user.setNom(nom);
		user.setPrenom(prenom);
		
		  try {
				validationTelephone(telephone);
			} catch (Exception e) {
				setErreur(CHAMP_TEL, e.getMessage());
			}
		user.setTelephone(telephone);
		
		try {
			validationEmail(email);
    	   
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL	, e.getMessage());
		}
		user.setEmail(email);
		
			
    	 try {
			validationMotsDePasse(motDePasse, confirmation);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}
		user.setMot_de_passe(motDePasse);
		

		 if ( erreurs.isEmpty() ) {
		        resultat = "Succès de l'inscription.";
		    } else {
		        resultat = "Échec de l'inscription.";
		    }
		 
		return user;

	}
	
	

	private void validationEmail( String email ) throws Exception {
	    if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}

	private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
	    if ( motDePasse != null && confirmation != null ) {
	        if ( !motDePasse.equals( confirmation ) ) {
	            throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
	        } else if ( motDePasse.length() < 3 ) {
	            throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}

	private void validationNom( String nom, String prenom ) throws Exception {
	    if ( nom != null && nom.length() < 3 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
	    }
	    else  if ( nom != null && prenom.length() < 3 ) {
	        throw new Exception( "Le prénom d'utilisateur doit contenir au moins 3 caractères." );
	    }
	    else if( nom == null || prenom == null)
	    	throw new Exception( "Veuillez saisir un nom." );
	}
	
	private void validationTelephone( String telephone) throws Exception
	{
		if ( telephone != null ) {
			if(telephone.length() < 10 )
	        throw new Exception( "Le N° de téléphone n'est pas valide !" );
	    }
		else
			throw new Exception("Merci de saisir votre numéro");
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
	        return valeur.trim();
	    }
	}
		

}
