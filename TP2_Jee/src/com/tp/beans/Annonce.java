package com.tp.beans;

public class Annonce {
	
	private String conducteur;
	private String depart;
	private String arrivee;
	private String date_depart;
	private int nbr_places;
	private int prix;
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	private boolean complet;
	
	public String getConducteur() {
		return conducteur;
	}
	public void setConducteur(String conducteur) {
		this.conducteur = conducteur;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getArrivee() {
		return arrivee;
	}
	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}
	public String getDate_depart() {
		return date_depart;
	}
	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}
	public int getNbr_places() {
		return nbr_places;
	}
	public void setNbr_places(int nbr_places) {
		this.nbr_places = nbr_places;
	}
	public boolean isComplet() {
		return complet;
	}
	public void setComplet(boolean complet) {
		this.complet = complet;
	}
	
	
	
	
}
