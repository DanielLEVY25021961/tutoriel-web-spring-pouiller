package levy.daniel.application.model.dao.course;

import java.util.List;

import levy.daniel.application.model.metier.course.AbstractCourse;
import levy.daniel.application.model.metier.course.ICourse;

/**
 * class IListeCoursesDAO :<br/>
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
 * @since 10 août 2017
 *
 */
public interface IListeCoursesDAO {
	
	/**
	 * method rechercherCourses() :<br/>
	 * Recherche toutes les courses en base.<br/>
	 * <br/>
	 *
	 * @return : List&lt;Course&gt; : Liste des courses en base.<br/>
	 */
	List<AbstractCourse> rechercherCourses();
	

	
	/**
	 * method createCourse(
	 * Course pCourse) :<br/>
	 * Crée la Course pCourse en base.<br/>
	 * <br/>
	 *
	 * @param pCourse : Course.<br/>
	 * 
	 * @return : Course : La Course créée en base.<br/>
	 */
	ICourse createCourse(ICourse pCourse);
	
	

} // FIN DE L'INTERFACE IListeCoursesDAO.----------------------------------
