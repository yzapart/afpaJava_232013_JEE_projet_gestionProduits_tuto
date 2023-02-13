package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Produit;
import pgsql.ConnectionPGSQL;

/**
 * Servlet implementation class CrudProduits
 */
@WebServlet("/CrudProduits")
public class CrudProduits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudProduits() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String choix = request.getParameter("submit");
		
		if (choix.equals("Ajouter un produit") == true) {
			// =============   on ajoute une ligne dans la DB ==================
			
			// création de l'obbjet 'produit' avec les paramètres 'nom' et 'prix' reçus.
	        String nom = request.getParameter("nomProduit");
	        float prix = Float.parseFloat(request.getParameter("prixProduit"));
	        Produit produit = new Produit(nom, prix);

	        // on insère le produit dans la base
	        ConnectionPGSQL connection = new ConnectionPGSQL();
	        connection.insertIntoProduitsTable(produit);
	        
	        // affichage de la vue suivante
	        request.getRequestDispatcher("/WEB-INF/views/confirmInsertProduit.jsp").forward(request, response);
	        
		}
		
		
		if (choix.equals("Liste des produits") == true) {
			// =============   on affiche la liste des produits ==================
			
			ConnectionPGSQL connection = new ConnectionPGSQL();
	        List<Produit> produits = connection.selectAllFromProduits();

	        request.setAttribute("produits", produits);
	        request.getRequestDispatcher("/WEB-INF/views/affichListeProduits.jsp").forward(request, response);
		}
		
	}

}
