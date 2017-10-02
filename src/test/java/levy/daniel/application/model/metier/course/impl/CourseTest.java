package levy.daniel.application.model.metier.course.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * class CourseTest :<br/>
 * Test JUnit de la classe Course.<br/>
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
 * @since 2 oct. 2017
 *
 */
public class CourseTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(CourseTest.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR CourseTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CourseTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * method testCourse() :<br/>
	 * <ul>
	 * Teste la création d'une Course.<br/>
	 * </ul>
	 */
	@Test
	public void testCourse() {
		
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************

		final Course course1 = new Course(null, "Bouteilles de Vichy", 3);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("course1.toString() : " + course1.toString());
		}
		
		assertNull("ID de course1 doit être null : ", course1.getId());
		
	} // Fin de testCourse().______________________________________________


	
} // FIN DE LA CLASSE CourseTest.--------------------------------------------
