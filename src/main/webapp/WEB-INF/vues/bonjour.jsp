<%-- DOCTYPE (DTD pour HTML5) --%>
<!doctype html>

<%-- DIRECTIVE PAGE --%>
<%-- Définit le langage éventuellement incorporé dans la page (java) --%>
<%--Si la page est une page d'erreur, l'encodage de la page, ... --%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8" isErrorPage="false" %>
		
<%-- DECLARATION DE LA TagLib JSTL --%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- DECLARATION DE LA TagLib de SPRING --%>	
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	


<html xmlns="http://www.w3.org/1999/xhtml" lang="fr">

	<head>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<%-- Titre de l'onglet  --%>
		<%--va chercher les values de clés comme 'titre.bonjour' dans messages.properties --%>
		<%--défini dans le bean id="messageSource" de dispatcher-servlet.xml --%>
		<%-- Expressions Languages « ${personne} » afin de restituer la donnée fournie par le controller. --%>
		<title><spring:message code="titre.bonjour"/> : <c:out value="${personne}" default="" escapeXml="true" /></title>
	
	</head>

	<body>
	
		<%--va chercher les values de clés comme 'libelle.bonjour.lemonde' dans messages.properties --%>
		<%--défini dans le bean id="messageSource" de dispatcher-servlet.xml --%>
		<%-- Expressions Languages « ${personne} » afin de restituer la donnée fournie par le controller. --%>	
	 	<h1><spring:message code="libelle.bonjour.lemonde" arguments="${personne}"/></h1>
	 	
	</body>
	
</html>