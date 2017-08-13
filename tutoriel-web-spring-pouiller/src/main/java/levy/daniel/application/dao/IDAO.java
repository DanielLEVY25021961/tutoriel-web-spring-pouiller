package levy.daniel.application.dao;

import java.util.List;

/**
 * class IDAO :<br/>
 * Interface paramétrée valable pour les DAO 
 * de tous les Objets métier.<br/>
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
 * @param <T> : Type paramétré : Classe réelle d'un Objet métier.<br/>
 * @since 13 août 2017
 *
 */
public interface IDAO<T> {
	
	
	/**
	 * method create(
	 * T pObject) :<br/>
	 * Crée l'objet métier de Type paramétré T pObject en base.<br/>
	 * <br/>
	 *
	 * @param pObject : T : objet métier de Type paramétré T.<br/>
	 * 
	 * @return : T : objet métier de Type paramétré T créé en base.<br/>
	 */
	T create(T pObject);
	
	
	
	/**
	 * method retrieve(
	 * T pObject) :<br/>
	 * Recherche un objet métier de Type paramétré T pObject en base.<br/>
	 * <br/>
	 *
	 * @param pObject : T : objet métier de Type paramétré T.<br/>
	 * 
	 * @return : T : objet métier de Type paramétré T 
	 * existant en base.<br/>
	 */
	T retrieve(T pObject);
	
	
	
	/**
	 * method update(
	 * T pObject) :<br/>
	 * Modifie un objet métier de Type paramétré T 
	 * pObject existant en base.<br/>
	 * <br/>
	 *
	 * @param pObject : T : objet métier de Type paramétré T.<br/>
	 * 
	 * @return : T : objet métier de Type paramétré T 
	 * modifié en base.<br/>
	 */
	T update(T pObject);
	
	
	
	/**
	 * method delete(
	 * T pObject) :<br/>
	 * Détruit un un objet métier de Type paramétré T 
	 * existant en base.<br/>
	 * <br/>
	 *
	 * @param pObject : T : objet métier de Type paramétré T.<br/>
	 * 
	 * @return : boolean : true si l'objet métier de Type paramétré T 
	 * a été détruit en base.<br/>
	 */
	boolean delete(T pObject);
	
	
	
	/**
	 * method getList() :<br/>
	 * Retourne la liste de tous les objets métier de Type paramétré T 
	 * présents en base.<br/>
	 * <br/>
	 *
	 * @return : List&lt;T&gt; : 
	 * liste de tous les objets métier de Type paramétré T 
	 * présents en base.<br/>
	 */
	List<T> getList();
	
	
	
} // FIN DE L'INTERFACE IDAO.------------------------------------------------
