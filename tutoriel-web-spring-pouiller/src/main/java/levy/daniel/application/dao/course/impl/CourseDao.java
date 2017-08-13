package levy.daniel.application.dao.course.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.dao.course.ICourseDAO;
import levy.daniel.application.metier.ICourse;
import levy.daniel.application.metier.impl.Course;

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
@Repository
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
	

	// *************************METHODES************************************/	
	
	 /**
	 * method CONSTRUCTEUR CourseDao() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CourseDao() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICourse create(
			final ICourse pCourse) {
		
		this.entityManager.persist(pCourse);
		return pCourse;
		
	} // Fin de create(...)._______________________________________________

	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICourse retrieve(
			final ICourse pCourse) {
		
		/* Requête HQL sur le métier. */
		final String requeteHQLString 
		= "select c from Course c where c.libelle = " 
		+ pCourse.getLibelle() 
		+ "c.quantite = "
		+ pCourse.getQuantite();
		
		/* Création de la requête par l'EntityManager. */
		final Query requeteHQL 
			= this.entityManager.createQuery(requeteHQLString);
		
		/* Exécution de la requête. */
		final List<Course> courses = requeteHQL.getResultList();
		
		if (courses != null && courses.size() == 1) {
			return courses.get(0);
		}
		
		return null;
		
	} // Fin de retrieve(...)._____________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICourse update(
			final Course pCourse) {
		this.entityManager.merge(pCourse);
		return pCourse;
	} // Fin de update(...)._______________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final Course pCourse) {
		this.entityManager.merge(pCourse);
		this.entityManager.remove(pCourse);
		return false;
	} // Fin de delete(...)._______________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Course> getList() {
		final List<Course> courses = this.entityManager.createQuery("select c from Course c").getResultList();
		return courses;
	}


} // FIN DE LA CLASSE CourseDao.---------------------------------------------
