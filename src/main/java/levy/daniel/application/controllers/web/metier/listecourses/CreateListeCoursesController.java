package levy.daniel.application.controllers.web.metier.listecourses;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import levy.daniel.application.controllers.web.metier.course.forms.CreateCourseFormController;
import levy.daniel.application.model.metier.course.AbstractCourse;
import levy.daniel.application.model.services.listecourses.IListeCoursesService;

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
	 * CREATION : String :<br/>
	 * "creation".<br/>
	 */
	public static final String CREATION = "creation";
	

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
	private static final Log LOG 
		= LogFactory.getLog(CreateListeCoursesController.class);

	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR CreateListeCoursesController() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CreateListeCoursesController() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method creer(CreateCourseFormController pCreation, ) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pCreation : CreateCourseFormController : 
	 * @param pBindingResult
	 * @param pModel : org.springframework.ui.ModelMap: .<br/>
	 * 
	 * @return :  :  .<br/>
	 */
	@RequestMapping(value="/creerCreationListeCourses", method = RequestMethod.POST)
    public String creer(
    	@Valid @ModelAttribute(value=CREATION) 
    	final CreateCourseFormController pCreation
            , final BindingResult pBindingResult
            	, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
            final Integer quantiteInt = Integer.valueOf(pCreation.getQuantite());
            this.listeCoursesService.createCourse(pCreation.getLibelle(), quantiteInt);
        }
        return afficher(pModel);
    }
	
	
	
	/**
	 * method afficher(
	 * ModelMap pModel) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pModel : org.springframework.ui.ModelMap: .<br/>
	 * @return :  :  .<br/>
	 */
	@RequestMapping(value="/afficherCreationListeCourses", method = RequestMethod.GET)
    public String afficher(
    		final ModelMap pModel) {
		
		/* Récupération de la liste des courses présentes en base 
		 * auprès du Service. */
        final List<AbstractCourse> listeCoursesEnBase 
        	= this.listeCoursesService.rechercherCourses();
        
        /* Ajoute listeCoursesEnBase au ModelMap 
         * à transmettre à la vue (clé = "listeCourses"). */
        pModel.addAttribute("listeCourses", listeCoursesEnBase);
        
        
        if (pModel.get(CREATION) == null) {
            pModel.addAttribute(
            		CREATION, new CreateCourseFormController());
        }
        
        return CREATION;
        
    } // Fin de afficher(....).____________________________________________
	
	
	
} // FIN DE LA CLASSE CreateListeCoursesController.--------------------------
