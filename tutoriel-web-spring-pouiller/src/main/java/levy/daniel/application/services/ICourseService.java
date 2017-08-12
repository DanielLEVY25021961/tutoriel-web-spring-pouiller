package levy.daniel.application.services;

import java.util.List;

import levy.daniel.application.metier.ICourse;
import levy.daniel.application.metier.impl.Course;

/**
 * class ICourseService :<br/>
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
public interface ICourseService {
	
	
	/**
	 * method create(
	 * Course pCourse) :<br/>
	 * Crée la Course pCourse en base.<br/>
	 * <br/>
	 *
	 * @param pCourse : Course.<br/>
	 * 
	 * @return : Course : La Course créée en base.<br/>
	 */
	ICourse create(ICourse pCourse);
	
	
	
	/**
	 * method retrieve(
	 * Course pCourse) :<br/>
	 * Recherche une Course en base.<br/>
	 * <br/>
	 *
	 * @param pCourse : Course.<br/>
	 * 
	 * @return : Course : La Course existante en base.<br/>
	 */
	ICourse retrieve(ICourse pCourse);
	
	
	
	/**
	 * method update(
	 * Course pCourse) :<br/>
	 * Modifie une Course existante en base.<br/>
	 * <br/>
	 *
	 * @param pCourse : Course.<br/>
	 * 
	 * @return : Course : La Course modifiée en base.<br/>
	 */
	ICourse update(ICourse pCourse);
	
	
	
	/**
	 * method delete(
	 * Course pCourse) :<br/>
	 * Détruit une Course existante en base.<br/>
	 * <br/>
	 *
	 * @param pCourse : Course.<br/>
	 * 
	 * @return : boolean : true si la course a été détruite.<br/>
	 */
	boolean delete(ICourse pCourse);
	
	
	
	/**
	 * method getList() :<br/>
	 * Retourne la liste de toutes les courses présentes en base.<br/>
	 * <br/>
	 *
	 * @return : List&lt;Course&gt; : 
	 * liste de toutes les courses présentes en base.<br/>
	 */
	List<Course> getList();
	


} // FIN DE L'INTERFACE ICourseService.------------------------------------
