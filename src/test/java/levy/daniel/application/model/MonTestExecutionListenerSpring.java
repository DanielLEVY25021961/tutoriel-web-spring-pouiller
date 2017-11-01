package levy.daniel.application.model;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.lang.Nullable;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.TestExecutionListener;


/**
 * class MonTestExecutionListenerSpring :<br/>
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
public class MonTestExecutionListenerSpring 
	extends TestContextManager implements TestExecutionListener {

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
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MonTestExecutionListenerSpring.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR MonTestExecutionListenerSpring() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pTestClass
	 */
	public MonTestExecutionListenerSpring(
			final Class<?> pTestClass) {
		super(pTestClass);
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afterTestMethod(
			final Object pTestInstance
				, final Method pTestMethod
					, @Nullable final Throwable pException) 
							throws Exception {
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("CLASSE MonTestExecutionListenerSpring - Méthode afterTestMethod(...)");
		System.out.println(TIRETS);
		System.out.println();
		
	}
	
	
}
