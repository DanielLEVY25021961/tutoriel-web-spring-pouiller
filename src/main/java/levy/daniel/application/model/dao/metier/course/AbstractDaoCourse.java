package levy.daniel.application.model.dao.metier.course;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.AbstractDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.course.AbstractCourse;
import levy.daniel.application.model.metier.course.impl.Course;


/**
 * class AbstractDaoCourse :<br/>
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
 * @since 27 oct. 2017
 *
 */
public abstract class AbstractDaoCourse 
	extends AbstractDaoGenericJPASpring<AbstractCourse, Integer> 
												implements IDaoCourse {

	// ************************ATTRIBUTS************************************/

	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';

	
	/**
	 * SELECT_COURSE : String :<br/>
	 * "select course from Course as course ".<br/>
	 */
	public static final String SELECT_COURSE 
		= "select course from Course as course ";
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractDaoCourse.class);

	
	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR AbstractDaoCourse() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractDaoCourse() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Integer createReturnId(
			final AbstractCourse pObject) throws AbstractDaoException {

		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* Crée le AbstractCourse en base. */
		final AbstractCourse coursePersistant = this.create(pObject);
		
		return coursePersistant.getId();
		
	} // Fin de createReturnId(...)._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final AbstractCourse retrieve(
			final AbstractCourse pObject) 
										throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		/* Requête HQL sur le métier. */
		final String requeteHQLString 
		= "select c from Course c where c.libelle = " 
		+ pObject.getLibelle() 
		+ "c.quantite = "
		+ pObject.getQuantite();
		
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
	public final AbstractCourse retrieveByIdMetier(
			final AbstractCourse pCourse) throws AbstractDaoException {
		return this.retrieve(pCourse);
	} // Fin de retrieveByIdMetier(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteById(
			final Integer pId) throws AbstractDaoException {
		
		/* Ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}
		
		AbstractCourse coursePersistante = null;

		/* REQUETE HQL PARMETREE. */
		final String requeteString 
		= SELECT_COURSE 
		+ "where course.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			coursePersistante 
				= (AbstractCourse) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			coursePersistante = null;
		}
		
		try {
			
			if (coursePersistante != null) {
				
				/* merge avant la destruction. */
				this.entityManager.merge(coursePersistante);
				
				/* DESTRUCTION. */
				this.entityManager.remove(coursePersistante);
				
			}

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(e);
		}
		
	} // Fin de deleteById(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteByIdBoolean(
			final Integer pId) throws AbstractDaoException {
		
		/* Ne fait rien et retourne false si pId == null. */
		if (pId == null) {
			return false;
		}

		boolean resultat = false;
		
		AbstractCourse coursePersistante = null;

		/* REQUETE HQL PARMETREE. */
		final String requeteString 
		= SELECT_COURSE 
		+ "where course.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			coursePersistante = (AbstractCourse) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			coursePersistante = null;
			resultat = false;
		}
		
		try {

			if (coursePersistante != null) {

				/* merge avant la destruction. */
				this.entityManager.merge(coursePersistante);
				
				/* DESTRUCTION. */
				this.entityManager.remove(coursePersistante);
				
				resultat = true;

			}

		}
		catch (Exception e) {
			
			resultat = false;
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(e);
			
		}
		
		return resultat;
		
	} // Fin de deleteByIdBoolean(...).____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean exists(
			final AbstractCourse pObject) throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		boolean resultat = false;
		AbstractCourse courseResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_COURSE
				+ "where course.libelle = :libelle and course.quantite = :quantite";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("libelle", pObject.getLibelle());
		requete.setParameter("quantite", pObject.getQuantite());
		
		try {
			
			/* Execution de la requete HQL. */
			courseResultat = (AbstractCourse) requete.getSingleResult();
			
			if (courseResultat != null) {
				resultat = true;
			}
		}
		catch (NoResultException noResultExc) {
			
			/* retourne false si l'Objet métier n'existe pas en base. */
			return false;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(e);
		}
		
		return resultat;
		
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean exists(
			final Integer pId) throws AbstractDaoException {
		
		/* retourne false si pId == null . */
		if (pId == null) {
			return false;
		}
		
		/* retourne true si l'objet métier existe en base. */
		if (this.findById(pId) != null) {
			return true;
		}
		
		return false;
		
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherListe(
			final List<AbstractCourse> pListe) {
		
		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final AbstractCourse course : pListe) {
			stb.append(course.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
				
		return stb.toString();
		
	} // Fin de afficherListe().___________________________________________
	


} // FIN DE LA CLASSE AbstractDaoCourse.-------------------------------------
