package com.tp.forms;

import javax.servlet.http.HttpServletRequest;

import com.tp.beans.Annonce;


public final class AnnonceForm {
	
	public static final String CHAMP_COND = "conducteur";
	public static final String CHAMP_DEPART= "depart";
	public static final String CHAMP_ARRIVEE= "arrivee";
	public static final String CHAMP_DATE_D= "date_depart";
	public static final String CHAMP_PLACES= "nbr_places";
	public static final String CHAMP_PRIX= "prix";
	
	public Annonce ajoutAnnonce(HttpServletRequest request) {
		Annonce annonce = new Annonce();
		
		
		String conducteur = request.getParameter(CHAMP_COND);
		String depart = request.getParameter(CHAMP_DEPART);
		String arrivee = request.getParameter(CHAMP_ARRIVEE);
		String date_depart = request.getParameter(CHAMP_DATE_D);
		int nbr_places = Integer.parseInt(request.getParameter(CHAMP_PLACES));	
		int prix = Integer.parseInt(request.getParameter(CHAMP_PRIX));	
		
		annonce.setConducteur(conducteur);
		annonce.setDepart(depart);
		annonce.setArrivee(arrivee);
		annonce.setDate_depart(date_depart);
		annonce.setNbr_places(nbr_places);
		annonce.setPrix(prix);
		
		annonce.setComplet(false);
		
		return annonce;
		
	}
		

}
