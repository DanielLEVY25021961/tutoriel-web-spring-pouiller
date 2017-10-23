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


<html>

	<head>
	
		<%-- Description du contenu de la page (texte HTML) et de son encodage. --%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
				
		<%-- ========================================================================== --%>
		<%-- 			LIENS VERS LES css EN HTML. 									--%>
		<%-- Le lien "href" doit être interprété PAR RAPPORT au contexte (ABSOLU). 		--%>
		<%-- NE PAS METTRE de slash '/' au début de href="static/css/style_index.css" 	--%>
		<%-- permet de préciser que le lien démarre depuis le contexte.  				--%>
		<%-- href="static/css/style_index.css" sera interprété par le serveur web : 	--%>
		<%--  http://host:8080/context/static/css/style_index.css 						--%>
		<%-- * la présente page est située directement sous le contexte. 				--%>
		<%-- ========================================================================== --%>
		<link type="text/css" rel="stylesheet" href="static/css/style_index.css" />
		
		
		<%-- Titre s'affichant dans l'onglet. --%>
		<title>/WEB-INF/vues/web/accueil/accueil.jsp</title>
		
	</head>
	
	<body>
		
		<%--RECUPERATION DU CONTEXTE EN JSTL --%>
		<c:set var="context" value="${pageContext.request.contextPath}" scope="session" />
				
		<%-- MENU EN HAUT --%>	
        <nav class="bordure_fond_bleu">
        
			<table>			
				<tr>
					<td>
						<%-- LIEN (URL) --%>
						<a href="<c:url value="/index.html" />" 
						title="vers indexStatic.html sous static/">
							Vers la page index.html
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
		
				
		<div class="section1">
		
			<!-- TITRE 1 HTML -->
			<h1 class="centre" id="objectif">
				accueil.jsp située à context/WEB-INF/vues/web/accueil/accueil.jsp
			</h1>
	
			<!-- CONTENU DU TITRE 1 HTML -->			
			<p class="centre-encadre">
				<span class="souligne">OBJECTIF</span> : Page d'accueil 
				de l'application gérée par le conteneur SPRING.
			</p>
						
			<div>
								
				<p>
					Cette page jsp <b>${context}/WEB-INF/vues/web/accueil/accueil.jsp
					</b> située <b>
					dans un sous-répertoire sous le WEB-INF</b> ne doit être 
					accessible que <b>via le Controller SPRING</b>.
				</p>
		
				<div>
					Cette page JSP "accueil.jsp" est accessible en tapant 
					dans l'URL du navigateur soit :
					<ul>
						<li><b>http://host:8080${context}/app/</b> si le 
							welcome-file SPRING est <b>activé</b> dans le 
							/WEB-INF/applicationContext.xml</li>
						<li><b>http://host:8080${context}/app/accueil</b> 
							si le welcome-file SPRING est <b>désactivé</b> dans 
							le /WEB-INF/applicationContext.xml</li>
					</ul>
				</div>
		
				<p>l'URL <b>[http://localhost:8080${context}/app/]</b> n'est donc
					équivalente à l' URL <b>[http://localhost:8080${context}/app/accueil]</b>
					que si le welcome-file de SPRING vers 
					<b>${context}/WEB-INF/vues/web/accueil/accueil.jsp</b> est activé 
					dans le applicationContext.xml.
				</p>
		
				<p>
					Le welcome-file de SPRING exécute une <b>redirection</b> vers 
					la première ressource valable 
					(citée dans le &lt;welcome-file-list&gt; et
					présente dans la zone des ressources déclarée
					 WEB-INF/vues/web/) qu'il trouve.
				</p>
		
			</div>
		
			<div>
				<figure class="centre">	
					<!-- IMAGE CENTREE -->
					<img class="image_centree" src="static/images/index_html.png" 
					alt="position de index.html" border="1" align="middle" 
					title="position de index.html par rapport au contexte webapp"/>
					<figcaption>
						<p>
							position de index.html par rapport au contexte webapp
						</p>						
					</figcaption>								
				</figure>				
			</div>

		</div>
		
		<!-- TRAIT HORIZONTAL SUR TOUTE LA PAGE -->
		<hr width="100%"/>
		
			
		<%--VARIABLE PERMETTANT D'ACCEDER AU CONTEXTE EN JSTL. --%>				
		<p>CONTEXTE PAR JSTL (pageContext.request.contextPath) : <c:out value="${context}" /></p>
		
	
	</body>
	
</html>