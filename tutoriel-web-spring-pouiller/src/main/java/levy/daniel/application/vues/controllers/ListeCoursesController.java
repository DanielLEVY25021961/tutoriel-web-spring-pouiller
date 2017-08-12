package levy.daniel.application.vues.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import levy.daniel.application.metier.impl.Course;
import levy.daniel.application.services.IListeCoursesService;

/**
 * class ListeCoursesController :<br/>
 * .<br/>
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
 * @since 11 août 2017
 *
 */
@Controller
@RequestMapping(value="/afficherListeCourses")
public class ListeCoursesController {

	// ************************ATTRIBUTS************************************/

	/**
	 * listeCoursesService : IListeCoursesService :<br/>
	 * .<br/>
	 */
	@Autowired
	private transient IListeCoursesService listeCoursesService;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ListeCoursesController.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ListeCoursesController() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ListeCoursesController() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method afficherListeCourses(
	 * ModelMap pModel) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pModel
	 * @return :  :  .<br/>
	 */
	@RequestMapping(method = RequestMethod.GET)
    public String afficherListeCourses(
    		final ModelMap pModel) {
		
		/* Récupération de la liste des courses auprès du Service. */
        final List<Course> lListeCourses 
        	= this.listeCoursesService.rechercherCourses();
        
        /* la valeur lListeCourses est associée 
         * à l'attribut « listeCourses » 
		 * grâce à la méthode « addAttribute » de « ModelMap ». */
        pModel.addAttribute("listeCourses", lListeCourses);
        
        /* le contrôleur redirige vers la ressource 
         * « /vues/listeCourses.jsp ». */
        /* Le ServletDispatcher gère le bean 
         * InternalResourceViewResolver 
		 * qui précise que les jsp sont sous /WEB-INF/vues/. 
		 * et ont l'extension .jsp*/
        return "listeCourses";
        
    } // Fin de afficherListeCourses(
	 // ModelMap pModel).___________________________________________________

	
	
} // FIN DE LA CLASSE ListeCoursesController.--------------------------------
