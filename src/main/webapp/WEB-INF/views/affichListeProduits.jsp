<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Produit"%>
<%@ page import="pgsql.ConnectionPGSQL"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Liste des produits</title>
</head>
<body>
	<h1>Liste des produits</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prix</th>
		</tr>
		<%
			ConnectionPGSQL connectionPGSQL = new ConnectionPGSQL();
			List<Produit> produits = connectionPGSQL.selectAllFromProduits();
			for (Produit produit : produits) {
		%>
			<tr>
				<td><%= produit.getId() %></td>
				<td><%= produit.getNom() %></td>
				<td><%= produit.getPrix() %></td>
			</tr>
		<%
			}
		%>
	</table>
	
	<br><a href='index.html'>index.html</a>
</body>
</html>
