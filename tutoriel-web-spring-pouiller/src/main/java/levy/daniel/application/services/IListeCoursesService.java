package levy.daniel.application.services;

import java.util.List;

import levy.daniel.application.metier.Course;

/**
 * class IListeCoursesService :<br/>
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
public interface IListeCoursesService {
	
	/**
	 * method rechercherCourses() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @return : List&lt;Course&gt; : Liste des courses.<br/>
	 */
	List<Course> rechercherCourses();
	

} // FIN DE L'INTERFACE IListeCoursesService.------------------------------
