package levy.daniel.application.controllers.web.accueil;

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
@RequestMapping(value="/")
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
	 * associe la valeur pPersonne à l'attribut "personne".<br/>
	 * redirige vers la ressource "bonjour".<br/>
	 * <br/>
	 *
	 * @param pModelMap : ModelMap.<br/>
	 * @param pPersonne : String
	 * 
	 * @return : String : "bonjour".<br/>
	 */
	@RequestMapping(value="/afficherBonjour", method = RequestMethod.GET)
	public String afficherBonjour(
			final ModelMap pModelMap
				, @RequestParam(value="personne") final String pPersonne) {
				
		/* la valeur pPersonne est associée à l'attribut « personne » 
		 * grâce à la méthode « addAttribute » de « ModelMap ». */
		pModelMap.addAttribute("personne", pPersonne);
		
		/* le contrôleur redirige vers la ressource 
		 * « /vues/bonjour.jsp ». */
		/* Le ServletDispatcher gère le bean InternalResourceViewResolver 
		 * qui précise que les jsp sont sous /WEB-INF/vues/. 
		 * et ont l'extension .jsp*/
		return "bonjour";
		
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
//	private boolean enumContient(
//			final Enumeration<String> pEnum
//				, final String pString) {
//		
//		/* retourne false si pEnum == null. */
//		if (pEnum == null) {
//			return false;
//		}
//		
//		while (pEnum.hasMoreElements()) {
//			final String stringLue = pEnum.nextElement();
//			if (StringUtils.equalsIgnoreCase(stringLue, pString)) {
//				return true;
//			}
//		}
//		
//		return false;
//		
//	} // Fin de enumContient(...)._________________________________________
	

	
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
