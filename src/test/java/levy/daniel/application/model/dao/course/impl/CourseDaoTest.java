package levy.daniel.application.model.dao.course.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.daoexceptions.technical.impl.DaoDoublonException;
import levy.daniel.application.model.dao.metier.course.impl.DaoCourse;
import levy.daniel.application.model.metier.course.AbstractCourse;
import levy.daniel.application.model.metier.course.impl.Course;


/**
 * class CourseDaoTest :<br/>
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
 * @since 1 nov. 2017
 *
 */
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CourseDaoTest {

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
	private static final Log LOG = LogFactory.getLog(CourseDaoTest.class);
	
	
	// *************************METHODES************************************/	
	
	 /**
	 * method CONSTRUCTEUR CourseDaoTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CourseDaoTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



	/**
	 * method testCreate() :<br/>
	 * .<br/>
	 * <br/>
	 * :  :  .<br/>
	 */
	@Transactional(rollbackFor={AbstractDaoException.class})
	@Commit
	@Test
	public void testCreateUnSeulObjet() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************

		AbstractCourse course1Persistante = null;
		
		final AbstractCourse course1 = new Course(null, "Bouteilles de Vichy", 3);
		
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

	

} // FIN DE LA CLASSE CourseDaoTest/-----------------------------------------
