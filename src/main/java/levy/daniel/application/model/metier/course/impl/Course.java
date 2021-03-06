package levy.daniel.application.model.metier.course.impl;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.course.AbstractCourse;


/**
 * class Course :<br/>
 * Modélise une Course effectuée dans un magasin 
 * par un libellé et une quantité.<br/>
 * <ul>
 * <li>Classe persistente grâce à l'annotation Entity 
 * (javax.persistence.Entity).</li>
 * <li>La présente classe est stockée en base 
 * dans la table « COURSES » du schéma PUBLIC
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
 * PrimaryKeyJoinColumn, jointure de clé primaire,<br/>
 * Nommer une jointure de clé primaire, ForeignKey name, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 10 août 2017
 *
 */
@Entity(name="Course")
@Table(name="COURSES", schema="PUBLIC")
@PrimaryKeyJoinColumn(name="ID_COURSE"
, foreignKey=@ForeignKey(name="FK_ABSTRACT_COURSES_COURSES"))
public class Course extends AbstractCourse {

	// ************************ATTRIBUTS************************************/
	

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Course.class);
	

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR Course() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public Course() {
		
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
	public Course(
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
	public Course(
			final Integer pId
				, final String pLibelle
					, final Integer pQuantite) {
		
		super(pId, pLibelle, pQuantite);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
} // FIN DE LA CLASSE Course.------------------------------------------------
