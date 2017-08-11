package levy.daniel.application.dao;

import java.util.List;

import levy.daniel.application.metier.Course;

/**
 * class ICourseDAO :<br/>
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
public interface ICourseDAO {
	
	
	/**
	 * method create() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pCourse
	 * @return :  :  .<br/>
	 */
	Course create(Course pCourse);
	
	/**
	 * method retrieve() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pCourse
	 * @return :  :  .<br/>
	 */
	Course retrieve(Course pCourse);
	
	/**
	 * method update() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pCourse
	 * @return :  :  .<br/>
	 */
	Course update(Course pCourse);
	
	/**
	 * method delete() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pCourse
	 * @return :  :  .<br/>
	 */
	boolean delete(Course pCourse);
	
	/**
	 * method getList() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @return :  :  .<br/>
	 */
	List<Course> getList();
	
	

}
