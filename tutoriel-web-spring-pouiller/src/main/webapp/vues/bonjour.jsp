<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>

<!-- DECLARATION DE LA TagLib de SPRING -->	
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<!-- Titre de l'onglet  -->
		<!-- Expressions Languages « ${personne} » afin de restituer la donnée fournie par le controller. -->
		<title><spring:message code="titre.bonjour"/> : ${personne}</title>
	
	</head>

	<body>
	 	<h1><spring:message code="libelle.bonjour.lemonde" arguments="${personne}"/></h1>
	</body>
	
</html>