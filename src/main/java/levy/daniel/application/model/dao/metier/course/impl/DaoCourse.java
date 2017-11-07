package levy.daniel.application.model.dao.metier.course.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.metier.course.AbstractDaoCourse;

/**
 * class DaoCourse :<br/>
 * DAO pour les AbstractCourse.<br/>
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
 * @since 27 oct. 2017
 *
 */
@Repository
public class DaoCourse extends AbstractDaoCourse {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoCourse.class);
	
	

	// *************************METHODES************************************/	
	
	 /**
	 * method CONSTRUCTEUR DaoCourse() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoCourse() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
		
	
} // FIN DE LA CLASSE DaoCourse.---------------------------------------------
