package levy.daniel.application.model.dao.metier.course.impl;

import static org.junit.Assert.assertNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
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
public class DaoCourseTest {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
	/**
	 * daoCourse : DaoCourse :<br/>
	 * Dao pour les Course.<br/>
	 */
	@Autowired
	public final DaoCourse daoCourse = new DaoCourse();
	
	
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
	 * <li></li>
	 * </ul>
	 */
	@Test
	@Transactional
    @Rollback(true)
	public void testCreate() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************

		AbstractCourse courseNullPersistante = null;
		AbstractCourse course1Persistante = null;
		AbstractCourse course1DoublonPersistante = null;
		AbstractCourse course2Persistante = null;
		
		final AbstractCourse courseNull = null;
		final AbstractCourse course1 = new Course(null, "Bouteilles de Vichy", 3);
		final AbstractCourse course1Doublon = new Course(null, "Bouteilles de Vichy", 3);
		final AbstractCourse course2 = new Course(null, "Saucisses", 13);
		
		try {
			
			courseNullPersistante = this.daoCourse.create(courseNull);
			
			/* garantit que create(null) retourne null. */
			assertNull("create(null) doit retourner null : ", courseNullPersistante);
			
			course1Persistante = this.daoCourse.create(course1);
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println("COURSE1 (Non PERSISTANTE : " 
						+ course1.toString());
				
				if (course1Persistante != null) {
					System.out.println(
							"course1Persistante.toString() : " 
									+ course1Persistante.toString());
				}
				else {
					System.out.println("course1Persistante est null");
				}
				
			}
			
		}
		catch (AbstractDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


} // FIN DE LA CLASSE DaoCourseTest.-----------------------------------------
