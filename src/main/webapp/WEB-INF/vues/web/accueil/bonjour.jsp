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
	
		<%-- Description du contenu de la page (texte HTML) et de son encodage. --%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<meta charset="UTF-8"/>
								
		<%-- ========================================================================== --%>
		<%-- 			LIENS VERS LES css EN HTML. 									--%>
		<%-- Le lien "href" doit être interprété PAR RAPPORT au contexte (ABSOLU). 		--%>
		<%-- NE PAS METTRE de slash '/' au début de href="static/css/style_index.css" 	--%>
		<%-- permet de préciser que le lien démarre depuis le contexte.  				--%>
		<%-- href="static/css/style_index.css" sera interprété par le serveur web : 	--%>
		<%--  http://host:8080/context/static/css/style_index.css 						--%>
		<%-- * la présente page est située directement sous le contexte. 				--%>
		<%-- ========================================================================== --%>
		<link type="text/css" rel="stylesheet" href="static/css/style_index.css"/>

		
		<%-- Titre de l'onglet  --%>
		<%--va chercher les values de clés comme 'titre.bonjour' dans messages.properties --%>
		<%--défini dans le bean id="messageSource" de applicationContext.xml --%>
		<%-- Expressions Languages « ${personne} » afin de restituer la donnée fournie par le controller. --%>
		<title>
			<spring:message code="titre.bonjour"/> : <c:out value="${personne}" default="" escapeXml="true" />
		</title>
	
	</head>

	<body>

		<%--RECUPERATION DU CONTEXTE EN JSTL --%>
		<c:set var="host" value="${pageContext.request.serverName}" scope="session" />
		<c:set var="port" value="${pageContext.request.localPort}" scope="session" />
		<c:set var="context" value="${pageContext.request.contextPath}" scope="session" />
		<c:set var="path_jsp" value="${pageContext.request.servletPath}" scope="session" />
		<c:set var="url_context" value="http://${host}:${port}${context}"/>
		<c:set var="url_jsp" value="http://${host}:${port}${context}${path_jsp}"/>

    	<!-- HEADER -->
    	<header class="bordure">
    	
            <%-- FIL D'ARIANE --%>
			<div class="ariane">
				<p>
					<%-- Image clickable --%>
					<a href="<c:url value="accueil"/> ">
						<img alt="accueil" src="<c:url value="/static/images/home.png"/>" />
					</a>
					<%-- Texte clickable comme l'image. --%>
					<span class="filariane">
						<a href="<c:url value="${ariane}" />">
							<c:out value="${ariane}" />
						</a>
					</span>
				</p>
				<c:set var="ariane" value="${ariane}" scope="session" />
			</div>
        </header>

		<%-- MENU EN HAUT --%>	
        <nav class="bordure_fond_bleu">
        
			<table>			
				<tr>
					<td>
						<%-- LIEN (URL) --%>
						<a href="<c:url value="/index.html" />" 
						title="vers index.html sous le contexte (redirigé vers accueil.jsp)">
							Vers la page index.html (redirigé vers accueil.jsp)
						</a>   
					</td>
					<td>
						<%-- LIEN (URL) --%>
						<a href="<c:url value="/static/indexStatic.html" />" 
						title="vers indexStatic.html sous static/">
							Vers la page static/indexStatic.html
						</a>   
					</td>
					<td>
						<%-- LIEN (URL) --%>
						<a href="<c:url value="/indexTest.html" />" 
						title="vers indexTest.html sous le contexte/">
							Vers la page indexTest.html
						</a>   
					</td>
				</tr>
				
				<tr>
					<td>
						<%-- LIEN (URL) --%>
						<a href="<c:url value="static/photos/armillaria_mellea.jpg" />" 
						title="vers armillaria_mellea.jpg sous /static/photos/">
							Vers armillaria_mellea.jpg
						</a>   
					</td>
					<td>
						<%-- LIEN (URL) --%>
						<a href="<c:url value="static/images/chemins_relatifs.png" />" 
						title="vers chemins_relatifs.png sous /static/images/">
							Vers chemins_relatifs.png
						</a>   
					</td>
					<td>
						<%-- LIEN (URL) --%>
						<a href="<c:url value="static/css/style_index.css"/>" 
						title="vers style_index.css sous /static/css/">
							Vers style_index.css
						</a>   
					</td>
				</tr>
																												
				<tr>				
					<td>
						<%-- LIEN (URL) --%>
						<%-- target="_blank" force l'ouverture dans un nouvel onglet --%>
						<a href="https://openclassrooms.com/courses/apprenez-a-creer-votre-site-web-avec-html5-et-css3" 
						target="_blank">
							Vers la page du tutoriel OpenClassrooms
						</a>   					
					</td>
					<td>
						<%-- LIEN (URL) --%>
						<%-- target="_blank" force l'ouverture dans un nouvel onglet --%>
						<a href="http://resizeimage.net/" 
						title="site de redimensionnement d'images resizeimage.net" 
						target="_blank">
							Vers le site de redimensionnement d'images resizeimage.net
						</a> 					
					</td>
					<td>
						<%-- LIEN (URL) --%>
						<%-- target="_blank" force l'ouverture dans un nouvel onglet --%>
						<a href="https://www.caniuse.com/" 
						title="site de vérification des fonctionnalités des navigateurs caniuse.com" 
						target="_blank">
							Vers le site de vérification des fonctionnalités des navigateurs caniuse.com
						</a> 										
					</td>									
				</tr>								
			</table>													
        </nav>

        
        <h1 class="centre">bonjour.jsp situé à <c:out value="${url_jsp}"/></h1>	
        
        
		<%--va chercher les values de clés comme 'libelle.bonjour.lemonde' dans messages.properties --%>
		<%--défini dans le bean id="messageSource" de applicationContext.xml --%>
		<%-- Expressions Languages « ${personne} » afin de restituer la donnée fournie par le controller. --%>	
	 	<h2><spring:message code="libelle.bonjour.lemonde" arguments="${personne}"/></h2>
	 	
	</body>
	
</html>