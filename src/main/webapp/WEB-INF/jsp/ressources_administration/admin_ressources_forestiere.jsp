<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Liste des ressources</title>
</head>
<body>
 <div class="container">
  <h2>Ressources</h2>
  <table class="table table-striped">
   <thead>
    <th scope="row">Nom scientifique</th>
    <th scope="row">Nom commun</th>
    <th scope="row">Update</th>
    <th scope="row">Delete</th>
   </thead>
   <tbody>
    <c:forEach items="${ressourceList }" var="ressource" >
     <tr>
      <td>${ressource.nom_scientifique }</td>
      <td>${ressource.nom_commun }</td>
      <td>
       <spring:url value="/ressource/administration/forestiere/edit/${ressource.id }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button" >Modifier</a>
      </td>
      <td>
       <spring:url value="/ressource/administration/forestiere/delete/${ressource.id }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button" >Supprimer</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/ressource/administration/forestiere/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button" >Ajouter</a>
 </div>
</body>
</html>