package com.tp.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tp.beans.Client;

public class Bdd {
	
	private Connection connexion;
	
	
	
	
	  public Bdd() {
		  loadDatabase();
	}


	public void addUser( Client utilisateur) {
	        
	        try {
	        	
	            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO clients(nom, prenom, telephone, email, mot_de_passe) VALUES(?, ?, ?, ?, ? );");
	            preparedStatement.setString(1, utilisateur.getNom());
	            preparedStatement.setString(2, utilisateur.getPrenom());
	            preparedStatement.setString(3, utilisateur.getTelephone());
	            preparedStatement.setString(4, utilisateur.getEmail());
	            preparedStatement.setString(5, utilisateur.getMot_de_passe());
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	public boolean authentication(Client utilisateur)
	{
		Statement instruction;
		try {
			instruction = connexion.createStatement();
			
			ResultSet resultat = instruction.executeQuery("SELECT * FROM clients");

			while(resultat.next())
			{

			if ((utilisateur.getEmail().equals(resultat.getString("email"))) && (utilisateur.getMot_de_passe().equals(resultat.getString("mot_de_passe"))))
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	
	
	 private void loadDatabase() {
	        // Chargement du driver
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        }

	        try {
	            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_jee", "root", "azert");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}
