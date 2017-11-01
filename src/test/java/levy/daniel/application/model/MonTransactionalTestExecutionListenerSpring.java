package levy.daniel.application.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;


/**
 * class MonTransactionalTestExecutionListenerSpring :<br/>
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
 * @since 31 oct. 2017
 *
 */
public class MonTransactionalTestExecutionListenerSpring 
	extends TransactionalTestExecutionListener {

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
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MonTransactionalTestExecutionListenerSpring.class);

	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR MonTransactionalTestExecutionListenerSpring() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 */
	public MonTransactionalTestExecutionListenerSpring() {
		super();
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afterTestMethod(
			final TestContext pTestContext) throws Exception {
					
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		final String nomClasse 
			= pTestContext.getTestClass().getSimpleName();
		final String nomMethode = pTestContext.getTestMethod().getName();
		
		final Throwable exc = pTestContext.getTestException();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			System.out.println(TIRETS);
			
			final String base 
				= nomClasse 
				+ SEPARATEUR_MOINS_AERE 
				+ nomMethode 
				+ SEPARATEUR_MOINS_AERE;
			
			if (exc != null) {
				System.out.println(base + "EXCEPTION DE TEST JUNIT : " + exc.toString());
			}
			System.out.println();
			System.out.println("CLASSE MonTransactionalTestExecutionListenerSpring "
					+ "- Méthode afterTestMethod(...) - Je ne fais rien dans afterTestMethod");
			System.out.println(TIRETS);
			System.out.println();
			
		}
		
		runAfterTransactionMethods(pTestContext);
		
	} // Fin de afterTestMethod(...).______________________________________
	
	
	
} // FIN DE LA CLASSE MonTransactionalTestExecutionListenerSpring.-----------
