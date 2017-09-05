package levy.daniel.application.model.dao.course;

import java.util.List;

import levy.daniel.application.model.dao.IDAO;
import levy.daniel.application.model.metier.course.ICourse;

/**
 * class ICourseDAO :<br/>
 * Interface pour les CourseDAO concrets.<br/>
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
public interface ICourseDAO extends IDAO<ICourse> {
	
	
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	boolean delete(ICourse pCourse);
	
	
	
	/**
	 * method getList() :<br/>
	 * Retourne la liste de toutes les courses présentes en base.<br/>
	 * <br/>
	 *
	 * @return : List&lt;ICourse&gt; : 
	 * liste de toutes les courses présentes en base.<br/>
	 */
	@Override
	List<ICourse> getList();
	
	

} // FIN DE L'INTERFACE ICourseDAO.------------------------------------------
