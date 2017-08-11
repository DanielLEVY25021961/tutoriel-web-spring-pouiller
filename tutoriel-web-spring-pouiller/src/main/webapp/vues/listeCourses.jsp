<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
    
<!-- DECLARATION DE LA TagLib de SPRING -->	
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- DECLARATION DE LA TagLib JSTL -->	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><spring:message code="titre.listecourses"/></title>
	</head>
	
	<body>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="colonne.identifiant"/></th>
                    <th><spring:message code="colonne.libelle"/></th>
                    <th><spring:message code="colonne.quantite"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listeCourses}" var="course">
                    <tr>
                        <td><c:out value="${course.id}"/></td>
                        <td><c:out value="${course.libelle}"/></td>
                        <td><c:out value="${course.quantite}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>	
	</body>
	
</html>