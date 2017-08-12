package levy.daniel.application.vues.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import levy.daniel.application.services.IListeCoursesService;

/**
 * class CreateListeCoursesController :<br/>
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
 * @since 12 août 2017
 *
 */
@Controller
public class CreateListeCoursesController {

	// ************************ATTRIBUTS************************************/

	/**
	 * listeCoursesService : IListeCoursesService :<br/>
	 * Service listant les courses présentes en base.<br/>
	 */
	@Autowired
	private transient IListeCoursesService listeCoursesService;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(CreateListeCoursesController.class);

	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR CreateListeCoursesController() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 */
	public CreateListeCoursesController() {
		super();
	}
	
	
	
	
}
