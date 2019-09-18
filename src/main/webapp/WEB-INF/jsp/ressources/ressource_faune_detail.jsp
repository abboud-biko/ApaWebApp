<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Ressource</title>
</head>
<body>
 <div class="container">
  <h2>${ressourceDetail.nom_scientifique }</h2>
  <table class="table table-striped">
   <thead>
    <th scope="row">alt</th>
    <th scope="row">url</th>
   </thead>
   <tbody>
    <c:forEach items="${images }" var="image" >
     <tr>
      <td>${image.alt }</td>
      <td>${image.url }</td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
 </div>
</body>
</html>