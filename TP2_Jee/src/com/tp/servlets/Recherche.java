package com.tp.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tp.bdd.Bdd;
import com.tp.beans.Annonce;

/**
 * Servlet implementation class Recherche
 */
@WebServlet("/Recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE_RECH = "/WEB-INF/recherche.jsp";

    
    public Recherche() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_RECH).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Bdd conn = new Bdd();

		String depart = request.getParameter("depart");
		String arrivee = request.getParameter("arrivee");
		String date = request.getParameter("date_depart");
		
		
		Vector<Annonce> listeResultat = conn.rechercheAnnonce(depart, arrivee,date);

		HttpSession session = request.getSession();
		
	session.setAttribute("resultat", listeResultat);

	this.getServletContext().getRequestDispatcher(VUE_RECH).forward(request, response);
	}

}
