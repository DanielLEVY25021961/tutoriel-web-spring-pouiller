package levy.daniel.application.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.dao.ICourseDAO;
import levy.daniel.application.metier.Course;

/**
 * class CourseDao :<br/>
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
public class CourseDao implements ICourseDAO {

	// ************************ATTRIBUTS************************************/

	/**
	 * entityManager : EntityManager :<br/>
	 * DAO « ListeCoursesDAO » utilise le « EntityManager » pour 
	 * lister les entités « Course » contenues dans la base de données.<br/>
	 */
	@PersistenceContext
	private transient EntityManager entityManager;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(CourseDao.class);

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Course create(Course pCourse) {
		// TODO Auto-generated method stub
		this.entityManager.persist(pCourse);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Course retrieve(Course pCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Course update(Course pCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(Course pCourse) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Course> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	// *************************METHODES************************************/
}
