package levy.daniel.application.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.dao.IListeCoursesDAO;
import levy.daniel.application.metier.Course;
import levy.daniel.application.services.IListeCoursesService;

/**
 * class ListeCoursesService :<br/>
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
@Service
public class ListeCoursesService implements IListeCoursesService {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * dao : IListeCoursesDAO :<br/>
	 * .<br/>
	 */
	@Autowired
	private transient IListeCoursesDAO dao;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ListeCoursesService.class);
	
	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ListeCoursesService() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ListeCoursesService() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly=true)
	public List<Course> rechercherCourses() {
		return this.dao.rechercherCourses();
	} // Fin de rechercherCourses()._______________________________________
	


} // FIN DE LA CLASSE ListeCoursesService.-----------------------------------
