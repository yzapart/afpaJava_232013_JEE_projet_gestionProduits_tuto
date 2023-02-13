package pgsql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Produit;

public class ConnectionPGSQL {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/gestion_produits";
    private static final String USER = "postgres";
    private static final String PASS = "mdp";

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void insertIntoProduitsTable(Produit produit) {
        Connection conn = getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String nom = produit.getNom();
            String prix = String.valueOf(produit.getPrix());
            String sql = "INSERT INTO produits (nom, prix) " + "VALUES ('" + nom + "', " + prix + ")";
            stmt.executeUpdate(sql);
            System.out.println("Insertion into produits table successful.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    public List<Produit> selectAllFromProduits() {
        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        List<Produit> produits = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM produits";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                float prix = rs.getFloat("prix");
                produits.add(new Produit(id, nom, prix));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return produits;
    }
    
    
    
    
    
    
    
    
    
}