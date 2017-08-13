package levy.daniel.application.metier.course;

/**
 * class ICourse :<br/>
 * Interface modélisant les Courses concrètes.<br/>
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
 * @since 12 août 2017
 *
 */
public interface ICourse {


	/**
	 * method getId() :<br/>
	 * Getter de ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Integer.<br/>
	 */
	Integer getId();

	
	
	/**
	* method setId(
	* Integer pId) :<br/>
	* Setter de ID en base.<br/>
	* <br/>
	*
	* @param pId : Integer : valeur à passer à id.<br/>
	*/
	void setId(Integer pId);
	
	

	/**
	 * method getLibelle() :<br/>
	 * Getter du Libellé du produit acheté.<br/>
	 * <br/>
	 *
	 * @return libelle : String.<br/>
	 */
	String getLibelle();
	
	
	
	/**
	* method setLibelle(
	* String pLibelle) :<br/>
	* Setter du Libellé du produit acheté.<br/>
	* <br/>
	*
	* @param pLibelle : String : valeur à passer à libelle.<br/>
	*/
	void setLibelle(String pLibelle); 
	
	

	/**
	 * method getQuantite() :<br/>
	 * Getter de la Quantité de produit acheté.<br/>
	 * <br/>
	 *
	 * @return quantite : Integer.<br/>
	 */
	Integer getQuantite();
	
	

	/**
	* method setQuantite(
	* Integer pQuantite) :<br/>
	* Setter de la Quantité de produit acheté.<br/>
	* <br/>
	*
	* @param pQuantite : Integer : valeur à passer à quantite.<br/>
	*/
	void setQuantite(Integer pQuantite);
	

	
} // FIN DE L'INTERFACE ICourse.---------------------------------------------