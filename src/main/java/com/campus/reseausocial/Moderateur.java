/**
 * 
 */
package com.campus.reseausocial;

/**
 * @author eric
 *
 */
public class Moderateur extends User {

	private int niveauDeDroit;

	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 */
	public Moderateur(String nom, String prenom, String dateNaissance) {
		super(nom, prenom, dateNaissance);

	}

	/**
	 * Obtenir le niveau de droit modérateur
	 * 
	 * @return
	 */
	public int getNiveauDeDroit() {
		return niveauDeDroit;
	}

	/**
	 * Définir le niveau de droit modérateur
	 * <li>1 - modifier/supprimer des messages</li>
	 * <li>2 - a en plus le droit de supprimer des utilisateurs</li>
	 * 
	 * @param niveauDeDroit
	 */
	public void setNiveauDeDroit(int niveauDeDroit) {
		this.niveauDeDroit = niveauDeDroit;
	}
	
	
	public boolean isModerateur() {
		return true;
	}
	
	
}
