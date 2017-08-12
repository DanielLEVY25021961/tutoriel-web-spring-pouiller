package levy.daniel.application.services;

import java.util.List;

import levy.daniel.application.metier.ICourse;
import levy.daniel.application.metier.impl.Course;

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
	 * Recherche toutes les courses en base.<br/>
	 * <br/>
	 *
	 * @return : List&lt;Course&gt; : Liste des courses en base.<br/>
	 */
	List<Course> rechercherCourses();
	

	
	/**
	 * method createCourse(String pLibelle, Integer pQuantite) :<br/>
	 * Crée une Course [pLibelle, pQuantite] en base.<br/>
	 * <br/>
	 *
	 * @param pLibelle : String : Libellé du produit acheté.<br/>
	 * @param pQuantite : Integer : Quantité de produit achetée.<br/>
	 * 
	 * @return : Course : La Course créée en base.<br/>
	 */
	ICourse createCourse(String pLibelle, Integer pQuantite);
	
	

} // FIN DE L'INTERFACE IListeCoursesService.------------------------------
