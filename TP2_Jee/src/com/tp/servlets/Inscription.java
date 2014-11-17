package com.tp.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tp.bdd.Bdd;
import com.tp.beans.Client;
import com.tp.forms.InscriptionForm;

public class Inscription extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String ATT_USER = "user";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String VUE_INSC = "/WEB-INF/inscription.jsp";
	public static final String VUE_SUCCES = "/WEB-INF/main.jsp";




	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		/* Affichage de la page d'inscription */
		this.getServletContext().getRequestDispatcher( VUE_INSC ).forward( request, response );
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		InscriptionForm form = new InscriptionForm();



		Client user = form.inscrUser(request);
	
		if(form.getErreurs().isEmpty())
		{
			Bdd conBDD = new Bdd();
			HttpSession session = request.getSession();
			session.setAttribute( ATT_SESSION_USER, user );
			conBDD.addUser(user);

			this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
		}


		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_USER, user);

		// rediiger vers la page de formulaire !!!!
		this.getServletContext().getRequestDispatcher( VUE_INSC ).forward( request, response );
	
	}

}

