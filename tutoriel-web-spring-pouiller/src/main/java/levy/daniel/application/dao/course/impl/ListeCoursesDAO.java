package levy.daniel.application.dao.course.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.dao.course.IListeCoursesDAO;
import levy.daniel.application.metier.ICourse;
import levy.daniel.application.metier.impl.Course;

/**
 * class ListeCoursesDAO :<br/>
 * DAO pour l'ensemble des courses en base.<br/>
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
public class ListeCoursesDAO implements IListeCoursesDAO {

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
	private static final Log LOG = LogFactory.getLog(ListeCoursesDAO.class);
	

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR ListeCoursesDAO() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ListeCoursesDAO() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Course> rechercherCourses() {

		/* Récupération d'un CriteriaBuilder auprès de entityManager. */
		final CriteriaBuilder lCriteriaBuilder 
			= this.entityManager.getCriteriaBuilder();

		/* Création d'une requête sur la table course. */
		final CriteriaQuery<Course> lCriteriaQuery 
			= lCriteriaBuilder.createQuery(Course.class);
		
		final Root<Course> lRoot 
			= lCriteriaQuery.from(Course.class);
		
		lCriteriaQuery.select(lRoot);
		
		final TypedQuery<Course> lTypedQuery 
			= this.entityManager.createQuery(lCriteriaQuery);

		return lTypedQuery.getResultList();
		
	} // Fin de rechercherCourses()._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICourse createCourse(
			final ICourse pCourse) {
		
		this.entityManager.persist(pCourse);
		
		return pCourse;
		
	} // Fin de createCourse(....).________________________________________
	
	


} // FIN DE LA CLASSE ListeCoursesDAO.---------------------------------------
