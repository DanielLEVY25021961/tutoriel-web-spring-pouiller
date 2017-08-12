package levy.daniel.application.vues.controllers.formulaires;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class CreateCourseFormController :<br/>
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
public class CreateCourseFormController {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * libelle : String :<br/>
	 * Libellé du produit acheté provenant de la vue.<br/>
	 * Doit être non null.<br/>
	 */
	@NotEmpty
	private String libelle;
	
	
	/**
	 * quantite : Integer :<br/>
	 * Quantité de produit acheté provenant de la vue.<br/>
	 * Doit être non null, numérique et positif.<br/>
	 */
	@NotEmpty
	@Pattern(regexp = "\\d")
	private Integer quantite;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(CreateCourseFormController.class);
	

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR CreateCourseFormController() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CreateCourseFormController() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * method getLibelle() :<br/>
	 * Getter du Libellé du produit acheté provenant de la vue.<br/>
	 * Doit être non null.<br/>
	 * <br/>
	 *
	 * @return libelle : String.<br/>
	 */
	public final String getLibelle() {
		return this.libelle;
	} // Fin de getLibelle().______________________________________________


	
	/**
	* method setLibelle(
	* String pLibelle) :<br/>
	* Setter du Libellé du produit acheté provenant de la vue.<br/>
	* Doit être non null.<br/>
	* <br/>
	*
	* @param pLibelle : String : valeur à passer à libelle.<br/>
	*/
	public final void setLibelle(
			final String pLibelle) {
		this.libelle = pLibelle;
	} // Fin de setLibelle(
	// String pLibelle).___________________________________________________


	
	/**
	 * method getQuantite() :<br/>
	 * Getter de la Quantité de produit acheté provenant de la vue.<br/>
	 * Doit être non null, numérique et positif.<br/>
	 * <br/>
	 *
	 * @return quantite : Integer.<br/>
	 */
	public final Integer getQuantite() {
		return this.quantite;
	} // Fin de getQuantite()._____________________________________________


	
	/**
	* method setQuantite(
	* Integer pQuantite) :<br/>
	* Setter de la Quantité de produit acheté provenant de la vue.<br/>
	* Doit être non null, numérique et positif.<br/>
	* <br/>
	*
	* @param pQuantite : Integer : valeur à passer à quantite.<br/>
	*/
	public final void setQuantite(
			final Integer pQuantite) {
		this.quantite = pQuantite;
	} // Fin de setQuantite(
	// Integer pQuantite)._________________________________________________
	
	
		
} // FIN DE LA CLASSE CreateCourseFormController.----------------------------
