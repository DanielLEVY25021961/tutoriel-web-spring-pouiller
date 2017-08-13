package levy.daniel.application.dao.course;

import java.util.List;

import levy.daniel.application.metier.ICourse;
import levy.daniel.application.metier.impl.Course;

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
	List<Course> rechercherCourses();
	

	
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
