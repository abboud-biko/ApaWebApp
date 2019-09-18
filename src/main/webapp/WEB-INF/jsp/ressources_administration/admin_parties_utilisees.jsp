<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Liste des parties utilisees</title>
</head>
<body>
 <div class="container">
  <h2>Parties utilisees</h2>
  <table class="table table-striped">
   <thead>
    <th scope="row">nom</th>
    <th scope="row">description</th>
    <th scope="row">Update</th>
    <th scope="row">Delete</th>
   </thead>
   <tbody>
    <c:forEach items="${partiesUtilisees }" var="partie" >
     <tr>
      <td>${partie.nom }</td>
      <td>${partie.description }</td>
      <td>
       <spring:url value="/parties-utilisees/administration/${ressourceType}/${id}/edit/${partie.id}" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button" >Modifier</a>
      </td>
      <td>
       <spring:url value="/parties-utilisees/administration/${ressourceType}/${id}/delete/${partie.id}" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button" >Supprimer</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/parties-utilisees/administration/${ressourceType}/${id}/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button" >Ajouter</a>
 </div>
</body>
</html>