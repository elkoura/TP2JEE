package com.tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tp.bdd.Bdd;
import com.tp.beans.Annonce;
import com.tp.forms.AnnonceForm;

/**
 * Servlet implementation class CreationAnnonce
 */
@WebServlet("/CreationAnnonce")
public class CreationAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_ANNONCE         = "annonce";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE_FORM            = "/WEB-INF/creerAnnonce.jsp";
    public static final String VUE_SUCCES            = "/WEB-INF/main.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationAnnonce() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Bdd conBDD = new Bdd();
		AnnonceForm form = new AnnonceForm();
		Annonce  ann = form.ajoutAnnonce(request);
		
		conBDD.addAnnonce(ann);
		
		 this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
				
		
	}

}
