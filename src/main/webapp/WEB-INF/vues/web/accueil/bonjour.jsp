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

		<!-- ANCRES -->
		<div class="ancres">
		    <p class="souligne">Aller directement à la partie traitant de (ancres) :</p>
		
		    <a href="#internationalisation">INTERNATIONALISATION</a><br />	
		    <a href="#remplacement_el">REMPLACEMENT DES EL PAR LES ATTRIBUTS</a><br />		
		</div>
		
		<!-- TRAIT HORIZONTAL SUR TOUTE LA PAGE -->
		<hr class="trait_horizontal" width="100%"/>
 	
        <div class="contenu">
        
        	<div class="liens">
        		<ul>
        			<li><a href='<c:url value="accueil" />'>vers accueil</a></li>
        		
        		</ul>
        	</div>
        	
 		<!-- TRAIT HORIZONTAL SUR TOUTE LA PAGE -->
		<hr class="trait_horizontal" width="100%"/>
        
	        <h1 class="centre">bonjour.jsp situé à <c:out value="${url_jsp}"/></h1>

			<div class="internationalisation">
	
				<h2 class="souligne" id="internationalisation">INTERNATIONALISATION</h2>
	
				<div class="internationalisation_titre">
	
					<p>Cette VUE jsp "bonjour.jsp" utilise les messages contenus
						dans messages.properties (situé sous le classpath) et
						l'internationalisation par SPRING (ResourceBundle).</p>
	
					<h3 class="souligne">Dans le titre de l'onglet :</h3>
	
					<p>
						Le titre de l'onglet restitue un message contenu dans
						message.properties et associé à la clé (code) code="titre.bonjour".<br />
						Le message délivré par le properties associé à cette clé est
						"Bonjour avec Spring".
					</p>
	
					<div class="explication_titre">
						Le code dans le titre de l'onglet de la JSP utilise :
						<ul>
							<li><span class="couleur_bleu_intense"> du HTML, </span></li>
							<li><span class="couleur_orange_intense"> des tags
									SPRING, </span></li>
							<li><span class="couleur_vert_intense"> des tags JSTL,
							</span></li>
							<li>des Expression Language (EL) - "l'anonyme" est en réalité
								une valeur par défaut passée à l'Expression Language {personne}<br />
							</li>
						</ul>
					</div>
	
					<p>
						<code>
							<span class="couleur_bleu_intense">&lt;title&gt;</span><br /> <span
								class="couleur_orange_intense"> &lt;spring:message
								code="titre.bonjour"/&gt; </span> <span class="couleur_vert_intense">
								: &lt;c:out value=<span class="couleur_noir_intense">"${personne}"</span> 
								default="" escapeXml="true" /&gt;<br />
							</span> <span class="couleur_bleu_intense">&lt;/title&gt;</span><br />
						</code>
					</p>
	
	
				</div>
	
	
				<div class="internationalisation_message_el">
	
					<h3 class="souligne">Dans le corps du texte :</h3>
	
					<p>
						Le bloc ci-dessous restitue un message contenu dans
						message.properties sous le classpath et associé à la <b>clé</b>
						(code) code="libelle.bonjour.lemonde".<br />
					</p>
					<p>
						Le message <b>(value)</b> délivré par le properties associé à cette
						clé est "Bonjour {0} avec Spring".<br />
					</p>
					<p>
						{0} est un <b>PLACEHOLDER</b> alimenté par les paramètres de la
						requête (le paramètre "personne" doit être le premier (index
						0-based) dans les paramètres passés à la requête pour se substituer
						à {0}).
					</p>
					<p>
						Il suffit de <b>taper</b>
						"http://localhost:8080/tutoriel-web-spring-pouiller/ app/bonjour<b>?personne=Zorro</b>"
						dans l'URL du navigateur pour que le message devienne "Bonjour
						Zorro avec Spring".<br /> Le premier paramètre passé dans la
						requête est en effet "personne" et sa valeur est "Zorro".
					</p>
	
					<%--va chercher les values de clés comme 'libelle.bonjour.lemonde' dans messages.properties --%>
					<%--défini dans le bean id="messageSource" de applicationContext.xml --%>
					<%-- Expressions Languages « ${personne} » afin de restituer la donnée fournie par le controller. --%>
					<h4 id="fonte14gras">
						<spring:message code="libelle.bonjour.lemonde"
							arguments="${personne}" />
					</h4>
	
				</div>
	
			</div>

 		<!-- TRAIT HORIZONTAL SUR TOUTE LA PAGE -->
		<hr class="trait_horizontal" width="100%"/>
			
			<div class="remplacement_el" >
			
				<h2 class="souligne" id="remplacement_el">
					REMPLACEMENT DES EL PAR LES ATTRIBUTS ET 
					DES PLACEHOLDERS PAR LES PARAMETRES
				</h2>
				
				<div class="images_display_flex">
							
					<figure class="image_gauche">
					
									<!-- IMAGE GAUCHE -->
						<img 
						src="static/images/Utilisation_placeholders_EL.png" 
						alt="Utilisation des EL et placeholders" border="1" align="middle" 
						title="Utilisation des EL et placeholders"/>
						<figcaption>
							<p class="centre">
								Utilisation des EL et placeholders
							</p>						
						</figcaption>
						
					</figure>
					
									<!-- IMAGE DROITE -->
					<figure>
						<img src="static/images/sequence_EL_placeholders.png" 
						alt="diagramme de séquence lors de la substitution des EL et placeholders" border="1" align="middle" 
						title="diagramme de séquence lors de la substitution des EL et placeholders"/>
						<figcaption>
							<p class="centre">
								diagramme de séquence lors de la substitution des EL et placeholders
							</p>						
						</figcaption>
					</figure>	
												
				</div>
							
			</div>
	
		</div>
 	 	
	</body>
	
</html>