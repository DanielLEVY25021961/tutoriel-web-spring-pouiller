context.xml    

définition de la datasource pour un serveur Tomcat.
				
il est dans le répertoire de configuration de tomcat : tomcat/conf
				
pour le tuto il est positionné dans webapp/META-INF/. 
C'est une SURCHARGE du context.xml de TOMCAT.
Il est là uniquement pour ne pas à avoir à partager le fichier contexte 
(c'est à dire être obligé d'aller intégrer les paramètres du 
webapp/META-INF/context.xml dans le conf/context.xml de TOMCAT). 
avec le risque de l'oublier lorsque l'on veut faire fonctionner le tuto.

ATTENTION : en production il est obligatoirement dans le conf de tomcat.
Le Centre-Serveur devra donc intégrer les données fournies 
par les développeurs dans leur webapp/META-INF/context.xml 
dans le conf/context.xml du TOMCAT de PRODUCTION.
				
				
				
webapp\WEB-INF\dispatcher-servlet.xml (applicationContext.xml)

- remplacé dans nos application par  webapp\WEB-INF\applicationContext.xml 

- On trouve également beaucoup sur le net webapp\WEB-INF\spring.xml

fichier de configuration de spring. 
il peut être décomposé en plusieurs sous fichiers ou tout 
dans 1 seul et même fichier.

La référence a ce fichier est dans le descripteur 
de déploiement de l'application web.xml
										
Attention on doit définir la datasource (ressource du pool de connexion jdbc) :
* soit dans le fichier applicationContext.xml pour les applications 
standalone qui doivent gérer elle-même le pool de connexion 
à une base de données.
* soit en faisant référence a une ressource jndi gérée par TOMCAT 
et accessibles à toutes les applications hébergées par TOMCAT.
											
ATTENTION - SPRING : La gestion des transactions lors de la persistance 
est à la charge du gestionnaire de transaction de spring.
Il faut donc désactiver le gestionnaire de transaction dans 
le persistence.xml lorsque l'on utilise spring . (transaction-type="JTA")
										


resources\META-INF\persistence.xml		

définition de la persistance JPA (PARAMETRAGE DE L'ORM).

remplace le fichier hibernate hibernate.cfg.mxl 
(dans le cas d'un persistance gérée par Hibernate) 
lorsque l'on utilisait Hibernate "EN DIRECT" sans passer par la couche JPA.
