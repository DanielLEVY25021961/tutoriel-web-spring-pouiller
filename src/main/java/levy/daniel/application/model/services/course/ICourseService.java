package levy.daniel.application.model.services.course;

import java.util.List;

import levy.daniel.application.model.metier.course.ICourse;

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
	 * ICourse pCourse) :<br/>
	 * Crée la Course pCourse en base.<br/>
	 * <br/>
	 *
	 * @param pCourse : ICourse.<br/>
	 * 
	 * @return : ICourse : La Course créée en base.<br/>
	 */
	ICourse create(ICourse pCourse);
	
	
	
	/**
	 * method retrieve(
	 * ICourse pCourse) :<br/>
	 * Recherche une Course en base.<br/>
	 * <br/>
	 *
	 * @param pCourse : ICourse.<br/>
	 * 
	 * @return : ICourse : La Course existante en base.<br/>
	 */
	ICourse retrieve(ICourse pCourse);
	
	
	
	/**
	 * method update(
	 * ICourse pCourse) :<br/>
	 * Modifie une Course existante en base.<br/>
	 * <br/>
	 *
	 * @param pCourse : ICourse.<br/>
	 * 
	 * @return : ICourse : La Course modifiée en base.<br/>
	 */
	ICourse update(ICourse pCourse);
	
	
	
	/**
	 * method delete(
	 * ICourse pCourse) :<br/>
	 * Détruit une Course existante en base.<br/>
	 * <br/>
	 *
	 * @param pCourse : ICourse.<br/>
	 * 
	 * @return : boolean : true si la course a été détruite.<br/>
	 */
	boolean delete(ICourse pCourse);
	
	
	
	/**
	 * method getList() :<br/>
	 * Retourne la liste de toutes les courses présentes en base.<br/>
	 * <br/>
	 *
	 * @return : List&lt;ICourse&gt; : 
	 * liste de toutes les courses présentes en base.<br/>
	 */
	List<ICourse> getList();
	


} // FIN DE L'INTERFACE ICourseService.------------------------------------
