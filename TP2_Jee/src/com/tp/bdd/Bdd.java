package com.tp.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.tp.beans.Annonce;
import com.tp.beans.Client;

public class Bdd {
	
	private Connection connexion;
	
	
	
	
	  public Bdd() {
		  loadDatabase();
	}


	public void addUser( Client utilisateur) {
	        
	        try {
	        	
	            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO clients(nom, prenom, telephone,"
	            		+ " email, mot_de_passe, preferences) VALUES(?, ?, ?, ?, ?,? );");
	            preparedStatement.setString(1, utilisateur.getNom());
	            preparedStatement.setString(2, utilisateur.getPrenom());
	            preparedStatement.setString(3, utilisateur.getTelephone());
	            preparedStatement.setString(4, utilisateur.getEmail());
	            preparedStatement.setString(5, utilisateur.getMot_de_passe());
	            preparedStatement.setString(6, utilisateur.getPreferences());
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	public void addAnnonce( Annonce annonce) {
        
        try {
        	
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO annonces(conducteur ,depart ,arrive"
            		+ "e ,date_depart  ,nbr_places, prix ) VALUES(?, ?, ?, ?, ?, ? );");
            preparedStatement.setString(1, annonce.getConducteur());
            preparedStatement.setString(2, annonce .getDepart());
            preparedStatement.setString(3, annonce.getArrivee());
            preparedStatement.setString(4, annonce.getDate_depart());
            preparedStatement.setInt(5, annonce.getNbr_places());
            preparedStatement.setInt(6, annonce.getPrix());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
public void payement( String id, String somme) {
	Statement instruction;
	String sql = "UPDATE clients SET credit = credit - (5*" + somme +") WHERE id = '"+id+"'";
	
	
        try {
        	
        	instruction = connexion.createStatement();
        	instruction.executeUpdate(sql);
        	
        }catch (SQLException e) {
            e.printStackTrace();
        }
    
}
	
	public void addReservation(String id_client, String id_annonce) {
        
        try {
        	
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO reservations(id_passager, id_annonce ) VALUES(?, ? );");
            preparedStatement.setString(1, id_client);
            preparedStatement.setString(2, id_annonce);
           
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public Vector<Annonce> listeAnnonce()
	{
		Annonce ann = null;
		Statement instruction;
		Vector<Annonce> annonces = new Vector<Annonce>();
		try {
			instruction = connexion.createStatement();
			
			ResultSet resultat = instruction.executeQuery("SELECT * FROM annonces");

			while(resultat.next())
			{
				ann = new Annonce();
				
				String conducteur = resultat.getString("conducteur");
				String depart= resultat.getString("depart");
				String arrivee= resultat.getString("arrivee");
				String date_depart = resultat.getDate("date_depart").toString();
				int nbr_places = resultat.getInt("nbr_places");
				int prix = resultat.getInt("prix");
				
				ann.setConducteur(conducteur);
				ann.setDepart(depart);
				ann.setArrivee(arrivee);
				ann.setDate_depart(date_depart);
				ann.setNbr_places(nbr_places);
				ann.setPrix(prix);
				
				annonces.add(ann);
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return annonces;
	}
	
	
	public Vector<Annonce> rechercheAnnonce(String A_depart, String A_arrivee, String A_date)
	{
		Annonce ann = null;
		Statement instruction;
		Vector<Annonce> annonces = new Vector<Annonce>();
		try {
			instruction = connexion.createStatement();
			
			ResultSet resultat = instruction.executeQuery("SELECT * FROM annonces WHERE depart = '"+A_depart +"' AND arrivee = '" + 
			A_arrivee +"' AND date_depart = '"+A_date+"'");

			while(resultat.next())
			{
				ann = new Annonce();
				int id = resultat.getInt("id");
				String conducteur = resultat.getString("conducteur");
				String depart= resultat.getString("depart");
				String arrivee= resultat.getString("arrivee");
				String date_depart = resultat.getDate("date_depart").toString();
				int nbr_places = resultat.getInt("nbr_places");
				int prix = resultat.getInt("prix");
				ann.setId(id);
				ann.setConducteur(conducteur);
				ann.setDepart(depart);
				ann.setArrivee(arrivee);
				ann.setDate_depart(date_depart);
				ann.setNbr_places(nbr_places);
				ann.setPrix(prix);
				
				annonces.add(ann);
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return annonces;
	}
	
	public Annonce returnAnnonce(String A_id)
	{
		Annonce ann = null;
		Statement instruction;
		
		try {
			instruction = connexion.createStatement();
			
			ResultSet resultat = instruction.executeQuery("SELECT * FROM annonces WHERE id = '"+A_id +"'");

			while(resultat.next())
			{
				ann = new Annonce();
				int id = resultat.getInt("id");
				String conducteur = resultat.getString("conducteur");
				String depart= resultat.getString("depart");
				String arrivee= resultat.getString("arrivee");
				String date_depart = resultat.getDate("date_depart").toString();
				int nbr_places = resultat.getInt("nbr_places");
				int prix = resultat.getInt("prix");
				ann.setId(id);
				ann.setConducteur(conducteur);
				ann.setDepart(depart);
				ann.setArrivee(arrivee);
				ann.setDate_depart(date_depart);
				ann.setNbr_places(nbr_places);
				ann.setPrix(prix);
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ann;
	}
	
	public int returnIdUser(String email)
	{
		Statement instruction;
		try {
			instruction = connexion.createStatement();
			ResultSet resultat = instruction.executeQuery("SELECT id FROM clients where email='"+email+"'");
			if(resultat.next())
			return  resultat.getInt("id");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return 0;
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


	public void updateAnnonce(String id, String nbr) {
		
		Statement instruction;
		String sql = "UPDATE annonces SET nbr_places = nbr_places - '" + nbr +
				"' WHERE id = '"+id+"'";
		
		
	        try {
	        	
	        	instruction = connexion.createStatement();
	        	instruction.executeUpdate(sql);
	        	
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

}
