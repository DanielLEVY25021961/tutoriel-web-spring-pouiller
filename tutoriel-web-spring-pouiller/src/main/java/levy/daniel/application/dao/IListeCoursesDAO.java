package levy.daniel.application.dao;

import java.util.List;

import levy.daniel.application.metier.Course;

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
	 * Recherche des courses en base.<br/>
	 * <br/>
	 *
	 * @return : List&lt;Course&gt; : Liste des courses en base.<br/>
	 */
	List<Course> rechercherCourses();

} // FIN DE L'INTERFACE IListeCoursesDAO.----------------------------------
