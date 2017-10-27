package levy.daniel.application.controllers.web.accueil;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * class BonjourController :<br/>
 * Controller dans le Modele MVC.<br/>
 * <ul>
 * <li>déclarée en tant que contrôleur grâce à 
 * l'annotation Spring @Controller.</li>
 * <li>@RequestMapping("/bonjour") indique que le présent contrôleur 
 * traite les requêtes GET dont l'URI est /bonjour.</li>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 10 août 2017
 *
 */
@Controller
//@RequestMapping(value="/")
public class BonjourController {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(BonjourController.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR BonjourController() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public BonjourController() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method afficherBonjour(
	 * ModelMap pModelMap
	 * , String pPersonne) :<br/>
	 * <ul>
	 * <li>redirige l'URL "/app/bonjour" vers la ressource (jsp) 
	 * sous le WEB-INF "accueil/bonjour" 
	 * (/WEB-INF/vues/web/accueil/bonjour.jsp).</li>
	 * <li>Le RequestMapping ne contient que "/bonjour" car le web.xml 
	 * déclare que les URL interceptées par le Controller SPRING 
	 * (Dispatcher-Servlet) commencent par "/app/".<br/>
	 * Le controller SPRING rajoute automatiquement "/app/" 
	 * au RequestMapping.</li> 
	 * <li>associe la valeur pPersonne à l'attribut "personne" 
	 * dans la Map <b>pModelMap</b> contenant les attributs 
	 * de la requête.</li>
	 * </ul>
	 * - RequestParam(value="personne", required=false, ...) permet
	 * de rendre le paramètre personne dans la requête 
	 * <b>nullable</b>.<br/>
	 * - defaultValue = "l'anonyme" remplacera ?personne=xxx 
	 * dans la requête si xxx est blank comme si ?personne est omis.<br/>
	 * <br/>
	 *
	 * @param pModelMap : ModelMap.<br/>
	 * @param pPersonne : String
	 * @param pRequest  : HttpServletRequest.<br/>
	 * 
	 * @return : String : "accueil/bonjour" traduit par le Controller SPRING 
	 * en "/WEB-INF/vues/web/accueil/bonjour.jsp".<br/>
	 */
	@RequestMapping(value="bonjour", method = RequestMethod.GET)
	public String afficherBonjour(
			final ModelMap pModelMap
				, @RequestParam(value="personne", required=false, defaultValue = "l'anonyme") final String pPersonne
					, final HttpServletRequest pRequest) {
		
		
		final Enumeration<String> enumeration = pRequest.getParameterNames();
		
		/* Vérification de l'existence du paramètre "personne" dans la requête. */
		final boolean parametrePersonneDansRequete 
			= this.enumContient(enumeration, "personne");
		
		String typeRequeteAParametres = null;
		
		if (!parametrePersonneDansRequete) {
			typeRequeteAParametres = "Requête sans paramètres";
		} else {
			typeRequeteAParametres = "Requête avec paramètres";
		}
		
		/* Ajout des attributs à la requête. */
		if (pPersonne != null) {
			/* la valeur pPersonne est associée à l'attribut « personne » 
			 * grâce à la méthode « addAttribute » de « ModelMap ». */
			pModelMap.addAttribute("personne", pPersonne);
		}
		
		pModelMap.addAttribute("typeRequeteAParametres"
				, typeRequeteAParametres);
		
		/* le contrôleur redirige vers la ressource 
		 * « /WEB-INF/vues/web/accueil/bonjour.jsp ». */
		/* Le ServletDispatcher gère le bean InternalResourceViewResolver 
		 * qui précise que les jsp sont sous /WEB-INF/vues/web/. 
		 * et ont l'extension .jsp*/
		return "accueil/bonjour";
		
	} // Fin de afficherBonjour(
	 // ModelMap pModelMap)._______________________________________________
	
	
	
	/**
	 * method enumContient(
	 * Enumeration&lt;String&gt; pEnum
	 * , String pString) :<br/>
	 * <ul>
	 * <li>détermine si l'Enumération pEnum contient pString.</li>
	 * <li>retourne true si si l'Enumération pEnum contient pString.</li>
	 * </ul>
	 * retourne false si pEnum == null.<br/>
	 * <br/>
	 *
	 * @param pEnum : Enumeration&lt;String&gt;.<br/>
	 * @param pString : String : chaine à rechercher dans l'enumération.<br/>
	 * 
	 * @return : boolean : true si l'Enumération pEnum contient pString.<br/>
	 */
	private boolean enumContient(
			final Enumeration<String> pEnum
				, final String pString) {
		
		/* retourne false si pEnum == null. */
		if (pEnum == null) {
			return false;
		}
		
		while (pEnum.hasMoreElements()) {
			final String stringLue = pEnum.nextElement();
			if (StringUtils.equalsIgnoreCase(stringLue, pString)) {
				return true;
			}
		}
		
		return false;
		
	} // Fin de enumContient(...)._________________________________________
	

	
	/**
	 * method enumSize(
	 * Enumeration&lt;String&gt; pEnum) :<br/>
	 * Retourne le nombre d'éléments dans une 
	 * Enumeration&lt;String&gt; pEnum.<br/>
	 * <br/>
	 *
	 * @param pEnum : Enumeration&lt;String&gt;.<br/>
	 * 
	 * @return : Long : nombre d'éléments.<br/>
	 */
//	private Long enumSize(
//			final Enumeration<String> pEnum) {
//		
//		/* retourne 0 si pEnum == null. */
//		if (pEnum == null) {
//			return 0L;
//		}
//		
//		Long resultat = 0L;
//		
//		while (pEnum.hasMoreElements()) {
//			pEnum.nextElement();
//			resultat++;
//		}
//		
//		return resultat;
//		
//	} // Fin de enumSize(...)._____________________________________________

	

	
} // FIN DE LA CLASSE BonjourController.-------------------------------------
