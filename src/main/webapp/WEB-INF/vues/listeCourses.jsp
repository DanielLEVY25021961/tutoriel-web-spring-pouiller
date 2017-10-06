<%-- DOCTYPE (DTD pour HTML5) --%>
<!doctype html>

<%-- DIRECTIVE PAGE --%>
<%-- Définit le langage éventuellement incorporé dans la page (java) --%>
<%--Si la page est une page d'erreur, l'encodage de la page, ... --%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8" isErrorPage="false" %>
	    
<%-- DECLARATION DE LA TagLib de SPRING --%>	
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%-- DECLARATION DE LA TagLib JSTL --%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

<html xmlns="http://www.w3.org/1999/xhtml" lang="fr">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%--va chercher les values de clés comme 'titre.listecourses' dans messages.properties --%>
		<%--défini dans le bean id="messageSource" de dispatcher-servlet.xml --%>		
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
                        <td><c:out value="${course.id}" default="" escapeXml="true"/></td>
                        <td><c:out value="${course.libelle}" default="" escapeXml="true"/></td>
                        <td><c:out value="${course.quantite}" default="" escapeXml="true"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>	
	</body>
	
</html>