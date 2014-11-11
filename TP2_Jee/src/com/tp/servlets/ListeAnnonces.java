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
 * Servlet implementation class ListeAnnonces
 */
@WebServlet("/ListeAnnonces")
public class ListeAnnonces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String ATT_ANNONCE         = "listeAnnonces";
    
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE_FORM            = "/WEB-INF/listeAnnonces.jsp";
    public static final String VUE_SUCCES            = "/WEB-INF/main.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeAnnonces() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Bdd conn = new Bdd();
		
		Vector<Annonce> listeAnnonces = conn.listeAnnonce();
		
		HttpSession session = request.getSession();
		
		session.setAttribute(ATT_ANNONCE, listeAnnonces);
		
		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
