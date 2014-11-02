package com.tp.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tp.beans.Client;
import com.tp.forms.InscriptionForm;

public class Inscription extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/WEB-INF/inscription.jsp";
	 	
	  

	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
    	
    	InscriptionForm form = new InscriptionForm();
    	
    	Client user = form.inscrUser(request);
    	
    	request.setAttribute(ATT_FORM, form);
    	request.setAttribute(ATT_USER, user);
 	    
        // rediiger vers la page de formulaire !!!!
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
}