package model;

public class Produit {

	  	int id;
	    String nom;
	    float prix;

	    public Produit(String nom, float prix) {
//	        this.id = id;
	        this.nom = nom;
	        this.prix = prix;
	    }
	    
	    public Produit(int id, String nom, float prix) {
	        this.id = id;
	    	this.nom = nom;
	    	this.prix = prix;
	    }
	    
	    public int getId() {
			return id;
		}
	    
	    public String getNom() {
			return nom;
		}
	    
	    public float getPrix() {
			return prix;
		}
	    
	    public void setNom(String nom) {
			this.nom = nom;
		}
	    
	    public void setPrix(float prix) {
			this.prix = prix;
		}
	    
	    public String toString() {
	    	return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
	    }
	    
}
