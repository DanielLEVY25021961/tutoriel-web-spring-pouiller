package levy.daniel.application.model.metier.course;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * class AbstractCourse :<br/>
 * Classe abstraite modélisant toutes les Courses concrètes.<br/>
 * Modélise une Course Abstraite effectuée dans un magasin 
 * par un libellé et une quantité.<br/>
 * <ul>
 * <li>Classe persistente grâce à l'annotation Entity 
 * (javax.persistence.Entity).</li>
 * <li>La présente classe est stockée en base 
 * dans la table « ABSTRACT_COURSES » du schéma PUBLIC
 * (annotation Table (javax.persistence.Table)).</li>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Entity, javax.persistence.Entity, nommer Entity,<br/>
 * Table, nommer table, nom table, <br/>
 * Contrainte d'unicité, nommer contrainte d'unicité,<br/>
 * nom contrainte d'unicité, schéma, public, stratégie héritage, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 13 août 2017
 *
 */
@Entity(name="AbstractCourse")
@Table(name="ABSTRACT_COURSES", schema="PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_LIBELLE_QUANTITE"
, columnNames={"LIBELLE", "QUANTITE"})
, indexes={@Index(name="INDEX_LIBELLE_QUANTITE", columnList="LIBELLE, QUANTITE")})
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractCourse implements ICourse, Serializable {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

		
	/**
	 * id : Integer :<br/>
	 * ID en base.<br/>
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COURSE")
	protected Integer id;
	
	
	/**
	 * libelle : String :<br/>
	 * Libellé du produit acheté.<br/>
	 */
	@Column(name="LIBELLE"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	protected String libelle;
	
	
	/**
	 * quantite : Integer :<br/>
	 * Quantité de produit acheté.<br/>
	 */
	@Column(name="QUANTITE"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	protected Integer quantite;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractCourse.class);

	
	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR Course() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractCourse() {
		
		this(null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Course(COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pLibelle : String : Libellé du produit acheté.<br/>
	 * @param pQuantite : Integer : Quantité de produit acheté.<br/>
	 */
	public AbstractCourse(
			final String pLibelle
				, final Integer pQuantite) {
		
		this(null, pLibelle, pQuantite);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Course(COMPLET_BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Integer : ID en base.<br/>
	 * @param pLibelle : String : Libellé du produit acheté.<br/>
	 * @param pQuantite : Integer : Quantité de produit acheté.<br/>
	 */
	public AbstractCourse(
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
			
		final AbstractCourse other = (AbstractCourse) pObj;
		
		if (this.libelle == null) {
			
			if (other.libelle != null) {
				return false;
			}
				
		} else if (!this.libelle.equals(other.libelle)) {
			return false;
		}
			
		if (this.quantite == null) {
			if (other.quantite != null) {
				return false;
			}
				
		} else if (!this.quantite.equals(other.quantite)) {
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
		
		builder.append("Course [");
		
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
	 * {@inheritDoc}
	 */
	@Override
	public final Integer getId() {
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setId(
			final Integer pId) {
		this.id = pId;
	} // Fin de setId(
	// Integer pId)._______________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getLibelle() {
		return this.libelle;
	} // Fin de getLibelle().______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setLibelle(
			final String pLibelle) {
		this.libelle = pLibelle;
	} // Fin de setLibelle(
	// String pLibelle).___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Integer getQuantite() {
		return this.quantite;
	} // Fin de getQuantite()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setQuantite(
			final Integer pQuantite) {
		this.quantite = pQuantite;
	} // Fin de setQuantite(
	// Integer pQuantite)._________________________________________________

	

} // FIN DE LA CLASSE AbstractCourse.----------------------------------------
