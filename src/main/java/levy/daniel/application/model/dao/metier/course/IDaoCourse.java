package levy.daniel.application.model.dao.metier.course;

import levy.daniel.application.model.dao.IDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.course.AbstractCourse;


/**
 * class IDaoCourse :<br/>
 * Interface du DAO pour les Course.<br/>
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
public interface IDaoCourse 
	extends IDaoGenericJPASpring<AbstractCourse, Integer> {
	
	
	/**
	 * method retrieveByIdMetier(
	 * AbstractCourse pCourse) :<br/>
	 * <ul>
	 * <li>Recherche un AbstractCourse pCourse en base 
	 * via son identifiant métier.</li>
	 * <li>Retourne l' AbstractCourse trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pCourse : AbstractCourse : 
	 * Course à rechercher en base.<br/>
	 * 
	 * @return : AbstractCourse : La Course recherchée en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	AbstractCourse retrieveByIdMetier(AbstractCourse pCourse) 
									throws AbstractDaoException;
	
	

} // FIN DE L'INTERFACE IDaoCourse.------------------------------------------
