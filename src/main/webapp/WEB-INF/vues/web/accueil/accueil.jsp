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
		
		
		<%-- Titre s'affichant dans l'onglet. --%>
		<title>accueil.jsp</title>
		
		<!-- REDIRECTION VERS /app/ AU BOUT DE 0 SECONDES -->
<!-- 		<meta http-equiv="refresh" content="0; URL=app/"> -->
		
	</head>
	
	<body>
		
		<%--RECUPERATION DU CONTEXTE EN JSTL --%>
		<c:set var="host" value="${pageContext.request.serverName}" scope="session" />
		<c:set var="port" value="${pageContext.request.localPort}" scope="session" />
		<c:set var="context" value="${pageContext.request.contextPath}" scope="session" />
		<c:set var="path_jsp" value="${pageContext.request.servletPath}" scope="session" />
		<c:set var="url_context" value="http://${host}:${port}${context}"/>
		<c:set var="url_jsp" value="http://${host}:${port}${context}${path_jsp}"/>
		
		<%--ANCRE POUR LE RETOUR EN HAUT --%>
		<div id="sommet"></div>
		
		
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
<%-- 				<c:set var="ariane" value="${ariane}" scope="session" /> --%>
			</div>
        </header>
				
		<%-- MENU EN HAUT --%>	
        <nav class="bordure_fond_bleu">
        
			<table border="1">			
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
						<!-- LIEN (URL) -->
						<a href="<c:url value="/static/types_application.html" />" 
						title="vers types_application.html sous le contexte/static/">
							Vers static/types_application.html
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
					<td>
						<!-- LIEN (URL) -->
						<!-- target="_blank" force l'ouverture dans un nouvel onglet -->
						<a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html" 
						title="Documentation de référence de SPRING 5.0.1" 
						target="_blank">
							Vers DOC SPRING 5.0.1
						</a> 										
					</td>																													
				</tr>								
			</table>													
        </nav>

		<!-- ANCRES -->
		<div class="ancres">
		
		    <p class="souligne">Aller directement à la partie traitant de (ancres) :</p>
		    
		    <table class="ancres">
		    	<tr>
					<td><a href="#objectifs" title="vers OBJECTIFS">OBJECTIFS</a></td>	
			    	<td><a href="#internationalisation" title="vers INTERNATIONALISATION">INTERNATIONALISATION</a></td>
			    	<td><a href="#mise_en_place_bd" title="vers MISE EN PLACE D'UNE BD">MISE EN PLACE D'UNE BD</a></td>
				</tr>
		    </table>
		    
		    
		    		    	
		</div>
				
		<!-- TRAIT HORIZONTAL SUR TOUTE LA PAGE -->
		<hr class="trait_horizontal" width="100%"/>

		
		<div class="tutoriel">
		
			
			<div class="liens">
	        		<ul>
	        			<li><a href='<c:url value="bonjour" />'>vers bonjour.jsp</a></li>
	        		
	        		</ul>
	        </div>
        	
			<!-- TRAIT HORIZONTAL SUR TOUTE LA PAGE -->
			<hr class="trait_horizontal" width="100%"/>
 			
		
			<div class="titre_Tuto">
					
				<h1>TUTORIEL WEB SPRING HIBERNATE de M. Régis Pouiller</h1>
			
				<p>Le tutoriel utilisé est disponible 
					<a href="http://rpouiller.developpez.com/tutoriels/spring/application-web-spring-hibernate/"
					 title="site du tutoriel de Régis Pouiller" 
					 	target="_blank">
						ici
					</a>
				</p>
						
			</div>

		
			<div class="objectifs">
			
				<h2 id="objectifs">
					Objectifs poursuivis dans le tutoriel
					
					<%--Image clickable flèche retour vers le haut --%>
					<span class="a_droite">
						<a href="#sommet">
						<img 
						alt="retour vers le haut" 
						title="retour vers le haut" 
						src='<c:url value="static/images/fleche_vers-haut-icone-5723-16x16.png"/>'>
						</a>
					</span>
					
				</h2>
				
				<ol>
					<li>Déclarer le Controller SPRING dans le descripteur 
					de déploiement d'une application web.xml.</li>
					<li>Utiliser la configuration par annotations de 
					SPRING (context : component-scan dans applicationContext.xml).</li>
					<li>Utiliser l'internationalisation de SPRING 
					(bean ReloadableResourceBundleMessageSource dans 
					le applicationContext.xml).</li>
					<li>Utiliser les taglibs de SPRING dans les jsp.</li>
					<li>Créer un Controller annoté par SPRING interceptant 
					une action et aiguillant vers une ressource (jsp).</li>
					<li>Alimenter les attributs d'une requête dans un 
					Controller annoté SPRING.</li>
					<li>Utiliser des Expression Language (EL) dans une jsp 
					pour restituer les attributs d'une requête.</li>
					<li>Créer une base de données (BD)</li>
					<li></li>
									
				</ol>
			
			</div>
			
			<div class="internationalisation">
			
				<h2 class="internationalisation_avec_spring" id="internationalisation">
					Internationalisation avec Spring (ResourceBundle)
					
					<%--Image clickable flèche retour vers le haut --%>
					<span class="a_droite">
						<a href="#sommet">
						<img 
						alt="retour vers le haut" 
						title="retour vers le haut" 
						src='<c:url value="static/images/fleche_vers-haut-icone-5723-16x16.png"/>'>
						</a>
					</span>

				</h2>
				
				<p>Tâches à réaliser pour l'internationalisation avec SPRING : </p>
				
				<div class="image_taches_internationalisation">
					<figure>	
						<!-- IMAGE CENTREE -->
						<img src="static/images/internationalisation_SPRING.png" 
						alt="tâches à réaliser pour l'internationalisation avec SPRING" border="1" align="middle" 
						title="tâches à réaliser pour l'internationalisation avec SPRING"/>			
					</figure>				
				</div>
				
				<ol>
				
					<li><b>Déclarer le bean ReloadableResourceBundleMessageSource</b> 
					dans applicationContext.xml.<br/>
					C'est ce bean qui se charge de l'internationalisation avec SPRING.</li>
					
					<li><b>Préciser le nom de base</b> des properties contenant 
					les messages SPRING dans applicationContext.xml.<br/>
					Ici : "messages".
					
						<p>
							<code>
								&lt;bean id="messageSource"<br/>
									class="org.springframework.context.support.ReloadableResourceBundleMessageSource"&gt;<br/>
									&lt;property name="basename" value="classpath:messages" /&gt;<br/>
									&lt;property name="defaultEncoding" value="UTF-8" /&gt;<br/>
								&lt;/bean&gt;<br/>
							</code>
						</p>
					</li>
					
					<li>
						<b>Créer les properties</b> contenant les messages SPRING 
						<i>sous le classpath</i>.<br/>
						
						<p>
							Exemples de couples [clé-valeur] contenus dans 
							messages_fr_FR.properties : <br/>
						</p>	
						
						<p>	
							<code>
								titre.bonjour = Bonjour avec Spring<br/>
								libelle.bonjour.lemonde = Bonjour {0} avec Spring<br/>
								<br/>
								titre.listecourses=Liste de courses<br/>
								colonne.identifiant=IDOBJET<br/>
								colonne.libelle=LIBELLE<br/>
								colonne.quantite=QUANTITE<br/>
							</code>
						</p>			
					</li>
					
					<li><b>Incorporer la directive d'inclusion des taglibs SPRING</b> 
					dans les vues jsp affichant les messages SPRING.
					
						<p>
							En haut des vues jsp sous la déclaration de la 
							DTD HTML5 et avant la balise html. :<br/>
						</p>
						
						<p>
							<code>
								&lt;%@taglib uri="http://www.springframework.org/tags" 
								prefix="spring"%&gt;<br/>
							</code>						
						</p>			
					</li>
					
					<li>
						<b>Incorporer les balises &lt;spring:message code="key"/&gt;</b> 
						dans les vues jsp affichant les messages SPRING.<br/>
						
						<p>
							<code>
								&lt;title&gt;<br/>
									&lt;spring:message code="titre.bonjour"/&gt; : 
									&lt;c:out value="${personne}" default
									="" escapeXml="true" /&gt;<br/>
								&lt;/title&gt;<br/>							
							</code>						
						</p>
					</li>
				
				</ol>
				
				<p>
					SPRING va alors rechercher les messages (values) 
					associés au clés (keys)
					dans les properties et les injecter dans les 
					balises spring:message.<br/>
				</p>
				
				<h3>
					Voir le résultat dans <a href='<c:url value="bonjour"/>'>bonjour.jsp</a>
				</h3>
			
			</div>
			
			<!-- TRAIT HORIZONTAL SUR TOUTE LA PAGE -->
			<hr class="trait_horizontal" width="100%"/>
	
			<div class="base_donnees">
			
				<h2 class="mise_en_place_bd" id="mise_en_place_bd">
					Mise en place d'une Base de Données (BD)
					
					<%--Image clickable flèche retour vers le haut --%>
					<span class="a_droite">
						<a href="#sommet">
						<img 
						alt="retour vers le haut" 
						title="retour vers le haut" 
						src='<c:url value="static/images/fleche_vers-haut-icone-5723-16x16.png"/>'>
						</a>
					</span>
					
				</h2>
				
			
			
			</div>
							
		</div>
		
		
				
		<!-- TRAIT HORIZONTAL SUR TOUTE LA PAGE -->
		<hr class="trait_horizontal" width="100%"/>
        							
		<div class="section1">
		
			<!-- TITRE 1 HTML -->
			<h1 class="centre" id="objectif">
				accueil.jsp située à ${url_jsp}
			</h1>
	
			<!-- CONTENU DU TITRE 1 HTML -->			
			<p class="centre-encadre">
				<span class="souligne">OBJECTIF</span> : Page d'accueil 
				de l'application gérée par le Controller SPRING.
			</p>
						
			<div>
								
				<p>
					Cette page jsp <b>${url_jsp} </b>située<b> 
					dans un sous-répertoire sous le WEB-INF</b> ne doit être 
					accessible que <b>via le Controller SPRING</b>.
				</p>
		
				<div>
					Cette page JSP "accueil.jsp" est accessible en tapant 
					dans l'URL du navigateur soit :
					<ul>
						<li>${url_context}<b>/app/</b> si le 
							welcome-file SPRING est <b>activé</b> dans le 
							<b>/WEB-INF/applicationContext.xml</b> et 
							redirige vers <b>${url_jsp}</b></li>
						<li>${url_context}<b>/app/accueil</b> 
							si le welcome-file SPRING est <b>désactivé</b> dans 
							le /WEB-INF/applicationContext.xml</li>
					</ul>
				</div>
		
			</div>
			
			<div class="redirection_spring">
			
				<div class="interception_web_xml">
				
					<h2>Interception par le Controller Spring (web.xml)</h2>
					
					<p>
					L'interception par le Controller SPRING de toutes 
					les URL préfixées par "/app/" est 
					paramétrée dans le <b>/WEB-INF/web.xml</b> : 
					</p>
					
					<code>
						&lt;servlet-mapping&gt;<br/>
        					&lt;servlet-name&gt;servlet-application-context&lt;/servlet-name&gt;<br/>
        					&lt;url-pattern&gt;/app/*&lt;/url-pattern&gt;<br/>
    					&lt;/servlet-mapping&gt;<br/>					
					</code>
					
					<p>
						Ces lignes <b>interceptent</b> toutes les URL 
						de la forme <b>${url_context}/app/*</b> et les
						transmettent au <b>Controller SPRING</b>
					</p>
					
					<div>
						<figure class="centre">	
							<!-- IMAGE CENTREE -->
							<img class="image_centree" src="static/images/cheminement_url.png" 
							alt="cheminement d'une URL dans l'application" border="1" align="middle" 
							title="cheminement d'une URL dans l'application"/>
							<figcaption>
								<p>
									cheminement d'une URL dans l'application
								</p>						
							</figcaption>								
						</figure>				
					</div>
				
				</div>
			
				<div class="redirection_applicationContext_xml">
				
					<h2>Redirection par le Controller Spring (applicationContext.xml)</h2>
					
					<p>
					La redirection par le Controller SPRING de 
					l' URL /app/ est 
					paramétrée dans le <b>/WEB-INF/applicationContext.xml</b> : 
					</p>
					
					<code>
						&lt;mvc:view-controller path="/" view-name="accueil/accueil"/&gt;				
					</code>
					
					<p>
						Cette ligne <b>redirige</b> l'URL <b>http://host:8080${context}/app/</b> 
						vers <b>http://host:8080${context}/WEB-INF/vues/web/accueil/accueil.jsp</b>
					</p>
					
					<div>
						<figure class="centre">	
							<!-- IMAGE CENTREE -->
							<img class="image_centree" src="static/images/redirection_SPRING.png" 
							alt="redirection par SPRING" border="1" align="middle" 
							title="Redirection par SPRING"/>
							<figcaption>
								<p>
									redirection par SPRING
								</p>						
							</figcaption>								
						</figure>				
					</div>
									
				</div>
				
				<div class="prefixage_applicationContext_xml">
				
					<h2>Préfixage et suffixage des vues par le Controller Spring (applicationContext.xml)</h2>
					
					<p>
					Le Préfixage et le suffixage des vues par le Controller SPRING de 
					toutes les URL commençant par /app/ sont 
					paramétrés dans le <b>/WEB-INF/applicationContext.xml</b> : 
					</p>
					
					<code>
						&lt;bean<br/>
					        class="org.springframework.web.servlet.view.InternalResourceViewResolver"&gt;<br/>
					        &lt;property name="prefix"&gt;<br/>
					            &lt;value&gt;/WEB-INF/vues/web/&lt;/value&gt;<br/>
					        &lt;/property&gt;<br/>
					        &lt;property name="suffix"&gt;<br/>
					            &lt;value&gt;.jsp&lt;/value&gt;<br/>
					        &lt;/property&gt;<br/>
					    &lt;/bean&gt;<br/>				
					</code>
					
					<p>
					Ces lignes permettent de ne préciser que le path 
					essentiel des jsp dans les "actions" SPRING.<br/>
					Par exemple, dans l'action SPRING "metier/commande/creerCommande"
					sera remplacé par SPRING par 
					<b>/WEB-INF/vues/web/</b>metier/commande/creerCommande<b>.jsp</b>
					</p>
				
				</div>
				
			
			</div>
		
			<div>
				<figure class="centre">	
					<!-- IMAGE CENTREE -->
					<img class="image_centree" src="static/images/accueil_jsp.png" 
					alt="position de accueil.jsp" border="1" align="middle" 
					title="position de accueil.jsp par rapport au contexte webapp"/>
					<figcaption>
						<p>
							position de accueil.jsp par rapport au contexte webapp
						</p>						
					</figcaption>								
				</figure>				
			</div>

		</div>
		
		<!-- TRAIT HORIZONTAL SUR TOUTE LA PAGE -->
		<hr width="100%"/>
		
			
		<%--VARIABLE PERMETTANT D'ACCEDER AU CONTEXTE EN JSTL. --%>				
		<p>HOST (pageContext.request.serverName) : <c:out value="${host}" /></p>
		<p>PORT (pageContext.request.localPort) : <c:out value="${port}"/></p>
		<p>CONTEXT (pageContext.request.contextPath) : <c:out value="${context}"/></p>
		<p>PATH (pageContext.request.servletPath) : <c:out value="${path_jsp}" /></p>
		<p>URL de la JSP (http://HOST:PORT/CONTEXT/PATH) : <c:out value="${url_jsp}" /></p>
		
	
	</body>
	
</html>