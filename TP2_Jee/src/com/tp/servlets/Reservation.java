package com.tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.tp.bdd.Bdd;
import com.tp.beans.Annonce;
import com.tp.beans.Client;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String idAnnonce;
	private String idClient;
	private Bdd conn = new Bdd();
	
	public static final String VUE_RESA = "/WEB-INF/reservation.jsp";
	public static final String VUE_RECAP = "/WEB-INF/recap.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    conn = new Bdd();
	    idAnnonce = request.getParameter("idAnnonce");
		Annonce annonce = conn.returnAnnonce(idAnnonce);
		
		request.setAttribute("annonce", annonce);

		this.getServletContext().getRequestDispatcher(VUE_RESA).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Client user =  (Client) session.getAttribute("sessionUtilisateur");
		idClient = String.valueOf(conn.returnIdUser(user.getEmail()));
		
		String nbr_places = request.getParameter("nbr_places");
		// ajouter la réservation dans la table des réservations 
		conn.addReservation(idClient, idAnnonce);
		// effectuer le payment 
		conn.payement(idClient, nbr_places);
		// mettre a jour le nombre de places
		conn.updateAnnonce(idAnnonce, nbr_places);
		this.getServletContext().getRequestDispatcher(VUE_RECAP).forward(request, response);
	}

}
