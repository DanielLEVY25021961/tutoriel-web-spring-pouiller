package levy.daniel.application.model.metier.listecourses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.course.impl.Course;

/**
 * class ListeCourses :<br/>
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
 * @since 14 sept. 2017
 *
 */
@Entity
@Table(name="LISTECOURSES", schema="PUBLIC")
public class ListeCourses {

	// ************************ATTRIBUTS************************************/
	
		
	/**
	 * id : Integer :<br/>
	 * ID en base.<br/>
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_LISTECOURSES")
	protected Integer id;
	
	
	/**
	 * libelle : String :<br/>
	 * Libellé du produit acheté.<br/>
	 */
	@Column(name="LIBELLE")
	protected String libelle;
	
	
	/**
	 * quantite : Integer :<br/>
	 * Quantité de produit acheté.<br/>
	 */
	@Column(name="QUANTITE")
	protected Integer quantite;
	


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ListeCourses.class);

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR ListeCourses() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ListeCourses() {
		
		this(null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ListeCourses(COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pLibelle : String : Libellé du produit acheté.<br/>
	 * @param pQuantite : Integer : Quantité de produit acheté.<br/>
	 */
	public ListeCourses(
			final String pLibelle
				, final Integer pQuantite) {
		
		this(null, pLibelle, pQuantite);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ListeCourses(COMPLET_BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Integer : ID en base.<br/>
	 * @param pLibelle : String : Libellé du produit acheté.<br/>
	 * @param pQuantite : Integer : Quantité de produit acheté.<br/>
	 */
	public ListeCourses(
			final Integer pId
				, final String pLibelle
					, final Integer pQuantite) {
		
		super();
		
		this.id = pId;
		this.libelle = pLibelle;
		this.quantite = pQuantite;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result 
				+ ((this.libelle == null) ? 0 : this.libelle.hashCode());
		result = prime * result 
				+ ((this.quantite == null) ? 0 : this.quantite.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(
			final Object pObj) {
		
		if (this == pObj) {
			return true;
		}
			
		if (pObj == null) {
			return false;
		}
			
		if (this.getClass() != pObj.getClass()) {
			return false;
		}
			
		final Course other = (Course) pObj;
		
		if (this.getLibelle() == null) {
			
			if (other.getLibelle() != null) {
				return false;
			}
				
		} else if (!this.getLibelle().equals(other.getLibelle())) {
			return false;
		}
			
		if (this.getQuantite() == null) {
			if (other.getQuantite() != null) {
				return false;
			}
				
		} else if (!this.getQuantite().equals(other.getQuantite())) {
			return false;
		}
			
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("ListeCourses [");
		
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(", ");
		}
		
		if (this.libelle != null) {
			builder.append("libelle=");
			builder.append(this.libelle);
			builder.append(", ");
		}
		
		if (this.quantite != null) {
			builder.append("quantite=");
			builder.append(this.quantite);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * method getId() :<br/>
	 * Getter de ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Integer.<br/>
	 */
	public final Integer getId() {
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	* method setId(
	* Integer pId) :<br/>
	* Setter de ID en base.<br/>
	* <br/>
	*
	* @param pId : Integer : valeur à passer à id.<br/>
	*/
	public final void setId(
			final Integer pId) {
		this.id = pId;
	} // Fin de setId(
	// Integer pId)._______________________________________________________


	
	/**
	 * method getLibelle() :<br/>
	 * Getter du Libellé du produit acheté.<br/>
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
	* Setter du Libellé du produit acheté.<br/>
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
	 * Getter de la Quantité de produit acheté.<br/>
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
	* Setter de la Quantité de produit acheté.<br/>
	* <br/>
	*
	* @param pQuantite : Integer : valeur à passer à quantite.<br/>
	*/
	public final void setQuantite(
			final Integer pQuantite) {
		this.quantite = pQuantite;
	} // Fin de setQuantite(
	// Integer pQuantite)._________________________________________________

	
		
} // FIN DE LA CLASSE ListeCourses.------------------------------------------
