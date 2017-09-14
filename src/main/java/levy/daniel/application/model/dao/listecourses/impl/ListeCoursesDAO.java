package levy.daniel.application.model.dao.listecourses.impl;

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

import levy.daniel.application.model.dao.listecourses.IListeCoursesDAO;
import levy.daniel.application.model.metier.course.AbstractCourse;
import levy.daniel.application.model.metier.course.ICourse;

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
	public List<AbstractCourse> rechercherCourses() {

		/* Récupération d'un CriteriaBuilder auprès de entityManager. */
		final CriteriaBuilder criteriaBuilder 
			= this.entityManager.getCriteriaBuilder();

		/* Création d'une requête sur la table course. */
		final CriteriaQuery<AbstractCourse> criteriaQuery 
			= criteriaBuilder.createQuery(AbstractCourse.class);
		
		final Root<AbstractCourse> root 
			= criteriaQuery.from(AbstractCourse.class);
		
		criteriaQuery.select(root);
		
		final TypedQuery<AbstractCourse> typedQuery 
			= this.entityManager.createQuery(criteriaQuery);

		return typedQuery.getResultList();
		
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
