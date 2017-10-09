context.xml    définition de la datasource pour un serveur Tomcat.
				il est dans le répertoire de configuration de tomcat :    tomcat/conf
				
				pour le tuto il est positionné dans webapp\META-INF\ il est la uniquement pour ne pas à avoir à partager le fichier contexte est l'oublié lorsque l'on veut faire fonctionner le tuto.
				en production il est obligatoirement dans le conf de tomcat.
				
				
				
webapp\WEB-INF\dispatcher-servlet.xml   fichier de configuration de spring. il peut être décomposé en plusieurs sous fichiers ou tout dans 1 seule et même fichier.
										la référence a ce fichier est dans le web.xml
										
										Attention on doit définir la datasource (ressource du pool de connexion jdbc) :
											* soit dans le fichier xml
											* soit en faisant référence a une ressource jndi
											
										La gestion des transaction est à la charge du gestionnaire de transaction de spring, lorsque l'on utilise spring il faut donc désactiver le gestionnaire de transaction.
										

resources\META-INF\persistence.xml		définition de la percistance JPA remplace le fichier hibernate hibernate.cfg.mxl (dans le cas d'un persistance gérée par Hibernate.)
