package levy.daniel.application.model.dao.metier.course.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.PersistenceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.TransactionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.daoexceptions.technical.impl.DaoDoublonException;
import levy.daniel.application.model.metier.course.AbstractCourse;
import levy.daniel.application.model.metier.course.impl.Course;


/**
 * class DaoCourseTest :<br/>
 * Test JUnit de la classe DaoCourse.<br/>
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
 * @since 30 oct. 2017
 *
 */
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	ServletTestExecutionListener.class
    , DirtiesContextBeforeModesTestExecutionListener.class
    , DependencyInjectionTestExecutionListener.class
    , DirtiesContextTestExecutionListener.class
    , TransactionalTestExecutionListener.class
    , SqlScriptsTestExecutionListener.class})
//@TestExecutionListeners(value=MonTestExecutionListenerSpring.class, mergeMode=MergeMode.MERGE_WITH_DEFAULTS)
//@Transactional
//@Commit
public class DaoCourseTest {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
	/**
	 * TIRETS : String :<br/>
	 * "--------------------------------------------------------".<br/>
	 */
	public static final String TIRETS 
	= "--------------------------------------------------------";

	
	/**
	 * daoCourse : DaoCourse :<br/>
	 * Dao pour les Course.<br/>
	 */
	@Autowired
	public transient DaoCourse daoCourse = new DaoCourse();

	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoCourseTest.class);
	

	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR DaoCourseTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoCourseTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method testCreate() :<br/>
	 * Teste la méthode create(T pObject) :<br/>
	 * <ul>
	 * <li>garantit que create(null) retourne null.</li>
	 * <li>garantit que create(Object) met en base l'Object.</li>
	 * <li>garantit que create(Object) retourne l'objet persistant (ID non null).</li>
	 * <li>garantit que la base n'accepte pas les doublons.</li>
	 * <li>garantit qu'un doublon lève une DaoDoublonException.</li>
	 * </ul>
	 * Rollback(true) permet d'annuler les effets du test 
	 * (Rollback de la transaction).<br/>
	 * Commit permet de committer la transaction à la fin du test.<br/>
	 */
	@Test
	@Commit
	@Transactional(
			readOnly = false
			, isolation=Isolation.DEFAULT
			, propagation=Propagation.REQUIRES_NEW
			, rollbackFor={DaoDoublonException.class}
			, noRollbackFor={JpaSystemException.class, PersistenceException.class, TransactionException.class})
//	@Transactional(rollbackFor={
//			DaoDoublonException.class
//			, JpaSystemException.class
//			, TransactionException.class
//			, PersistenceException.class
//			, SQLIntegrityConstraintViolationException.class}
//		, propagation=Propagation.REQUIRES_NEW)
	public void testCreate() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************

		AbstractCourse courseNullPersistante = null;
		AbstractCourse course1Persistante = null;
		AbstractCourse course2Persistante = null;
		
		final AbstractCourse courseNull = null;
		final AbstractCourse course1 = new Course("Bouteilles de Vichy", 3);
		final AbstractCourse course1Doublon = new Course("Bouteilles de Vichy", 3);
		final AbstractCourse course2 = new Course("Saucisses", 13);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {			
			System.out.println();
			System.out.println(TIRETS);		
			System.out.println("COURSE1 (Non PERSISTANTE) : " 
					+ course1.toString());			
			System.out.println(TIRETS);
			System.out.println();
		}


		try {
			
			final Long nombreEnregistrementsInitial = this.daoCourse.count();
			
			/* PERSISTANCE. **************/
			/* tentative de CREATION DE LA COURSENULL. */
			courseNullPersistante = this.daoCourse.create(courseNull);
			
			/* garantit que create(null) retourne null. */
			assertNull("create(null) doit retourner null : "
					, courseNullPersistante);
			final Long nombreEnregistrementsApresNull = this.daoCourse.count();
			assertEquals("Le nombre d'enregistrements doit rester inchangé : "
					, nombreEnregistrementsInitial
						, nombreEnregistrementsApresNull);
			
			/* PERSISTANCE. **************/
			/* CREATION DE LA COURSE1. */
			course1Persistante = this.daoCourse.create(course1);
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {								
				System.out.println(TIRETS);
				System.out.println("COURSE1 (PERSISTANTE) : " 
						+ course1Persistante.toString());			
				System.out.println(TIRETS);
				System.out.println();				
			}

			
			final Long nombreEnregistrements = this.daoCourse.count();
			
			/* garantit que create(Object) met en base l'Object. */
			assertNotNull("course1Persistante ne doit pas être null : "
					, course1Persistante);
			/* garantit que create(Object) retourne l'objet persistant (ID non null). */
			assertNotNull("ID en base de course1Persistante ne doit pas être null : "
					, course1Persistante.getId());
			
			assertEquals("Le nombre d'entregistrements doit avoir augmenté de 1 : "
					, Long.valueOf(nombreEnregistrementsInitial + 1)
						, nombreEnregistrements);

//***********************************************************************************
			/* Création d'un doublon. */
			try {
				
				/* PERSISTANCE. **************/
				/* tentative de CREATION DE DOUBLON. */
				this.daoCourse.create(course1Doublon);
				
			} catch (AbstractDaoException daoExc) {
				
				/* garantit qu'un doublon lève une DaoDoublonException. */
				assertTrue("L'exception doit être une DaoDoublonException : "
						, daoExc instanceof DaoDoublonException);
				
				/* AFFICHAGE A LA CONSOLE. */
				if (AFFICHAGE_GENERAL && affichage) {									
					System.out.println(TIRETS);
					System.out.println(daoExc.toString());
					System.out.println();
					System.out.println("MESSAGE UTILISATEUR : " 
							+ daoExc.getMessageUtilisateur());
					System.out.println("MESSAGE TECHNIQUE : " 
							+ daoExc.getMessageTechnique());
					System.out.println(TIRETS);
					System.out.println();					
				}
			}
			
			
			/* garantit que la base n'accepte pas les doublons. */
			final Long nombreEnregistrementsApresDoublon = this.daoCourse.count();
			
			assertEquals("Le nombre d'enregistrements doit rester inchangé : "
					, nombreEnregistrements, nombreEnregistrementsApresDoublon);

//***********************************************************************************

			
			/* PERSISTANCE. **************/
			/* CREATION DE LA COURSE2. */
			course2Persistante = this.daoCourse.create(course2);
			
			final Long nombreEnregistrementsFinal = this.daoCourse.count();
			
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {

				System.out.println();
				System.out.println(TIRETS);
				
				System.out.println("NOMBRE D'ENREGISTREMENTS INITIAL : " 
						+ nombreEnregistrementsInitial);
				
				System.out.println(
						"course1Persistante.toString() : " 
								+ course1Persistante.toString());
				
				System.out.println(
						"course2Persistante.toString() : " 
								+ course2Persistante.toString());
				
				System.out.println("NOMBRE D'ENREGISTREMENTS FINAL : " 
						+ nombreEnregistrementsFinal);
				
				System.out.println(TIRETS);
				System.out.println();
								
			} // Fin de AFFICHAGE A LA CONSOLE.______________________
			
			/* Vide la table. */
			this.daoCourse.deleteAll();
			
		}
		catch (TransactionException transactionExc) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
								
				System.out.println();
				System.out.println(TIRETS);
				System.out.println(transactionExc.toString());
				System.out.println(TIRETS);
				System.out.println();
				
			}
		}
		catch (PersistenceException persistenceExc) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
								
				System.out.println();
				System.out.println(TIRETS);
				System.out.println(persistenceExc.toString());
				System.out.println(TIRETS);
				System.out.println();
				
			}
		}
		catch (JpaSystemException jpaSystemException) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
								
				System.out.println();
				System.out.println(TIRETS);
				System.out.println(jpaSystemException.toString());
				System.out.println(TIRETS);
				System.out.println();				
			}
			
		}
		catch (AbstractDaoException abstractDaoExc) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
								
				System.out.println();
				System.out.println(TIRETS);
				System.out.println(abstractDaoExc.toString());
				System.out.println();
				System.out.println("MESSAGE UTILISATEUR : " 
						+ abstractDaoExc.getMessageUtilisateur());
				System.out.println("MESSAGE TECHNIQUE : " 
						+ abstractDaoExc.getMessageTechnique());
				System.out.println(TIRETS);
				System.out.println();
				
			}
						
		}
		catch (Exception e) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
								
				System.out.println();
				System.out.println(TIRETS);
				System.out.println(e.toString());
				System.out.println(TIRETS);
				System.out.println();
				
			}
		}
						
	} // Fin de testCreate().______________________________________________

	
	
	/**
	 * method testCreateUnSeulObjet() :<br/>
	 * .<br/>
	 * <br/>
	 * :  :  .<br/>
	 */
	@Transactional(rollbackFor={AbstractDaoException.class})
	@Rollback(false)
	@Test
	public void testCreateUnSeulObjet() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************

		AbstractCourse course1Persistante = null;
		
		final AbstractCourse course1 = new Course("Bouteilles de Vichy", 3);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {			
			System.out.println();
			System.out.println(TIRETS);		
			System.out.println("COURSE1 (Non PERSISTANTE) : " 
					+ course1.toString());			
			System.out.println(TIRETS);
			System.out.println();
		}

		try {
			
			final Long nombreEnregistrementsInitial = this.daoCourse.count();
			
			/* PERSISTANCE. **************/
			/* CREATION DE LA COURSE1. */
			course1Persistante = this.daoCourse.create(course1);
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {								
				System.out.println(TIRETS);
				System.out.println("COURSE1 (PERSISTANTE) : " 
						+ course1Persistante.toString());			
				System.out.println(TIRETS);
				System.out.println();				
			}

			
			final Long nombreEnregistrements = this.daoCourse.count();
			
			/* garantit que create(Object) met en base l'Object. */
			assertNotNull("course1Persistante ne doit pas être null : "
					, course1Persistante);
			/* garantit que create(Object) retourne l'objet persistant (ID non null). */
			assertNotNull("ID en base de course1Persistante ne doit pas être null : "
					, course1Persistante.getId());
			
			assertEquals("Le nombre d'entregistrements doit avoir augmenté de 1 : "
					, Long.valueOf(nombreEnregistrementsInitial + 1)
						, nombreEnregistrements);
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {

				System.out.println();
				System.out.println(TIRETS);				
				System.out.println("NOMBRE D'ENREGISTREMENTS INITIAL : " 
						+ nombreEnregistrementsInitial);				
				System.out.println(
						"course1Persistante.toString() : " 
								+ course1Persistante.toString());				
				System.out.println("NOMBRE D'ENREGISTREMENTS FINAL : " 
						+ nombreEnregistrements);				
				System.out.println(TIRETS);
				System.out.println();
								
			} // Fin de AFFICHAGE A LA CONSOLE.______________________


			
		}
		catch (AbstractDaoException daoExc) {
			
			/* garantit qu'un doublon lève une DaoDoublonException. */
			assertTrue("L'exception doit être une DaoDoublonException : "
					, daoExc instanceof DaoDoublonException);
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {									
				System.out.println(TIRETS);
				System.out.println("        DOUBLON          ");
				System.out.println(daoExc.toString());
				System.out.println();
				System.out.println("MESSAGE UTILISATEUR : " 
						+ daoExc.getMessageUtilisateur());
				System.out.println("MESSAGE TECHNIQUE : " 
						+ daoExc.getMessageTechnique());
				System.out.println(TIRETS);
				System.out.println();					
			}

		}
				
	} // Fin de testCreateUnSeulObjet().___________________________________


} // FIN DE LA CLASSE DaoCourseTest.-----------------------------------------
