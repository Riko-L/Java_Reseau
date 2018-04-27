/**
 * 
 */
package com.campus.reseausocial;

/**
 * Classe Modérateur
 * @author eric
 *
 */
public class Moderateur extends User {

	private int niveauDeDroit;

	/**
	 * @param nom Nom du modérateur
	 * @param prenom Prénom du Modérateur
	 * @param dateNaissance Date de naissance du Modérateur
	 */
	public Moderateur(String nom, String prenom, String dateNaissance) {
		super(nom, prenom, dateNaissance);

	}

	/**
	 * Obtenir le niveau de droit modérateur
	 * 
	 * @return niveauDeDroit 
	 */
	public int getNiveauDeDroit() {
		return niveauDeDroit;
	}

	/**
	 * Définir le niveau de droit modérateur
	 * <ul>
	 * <li>1 - modifier/supprimer des messages</li>
	 * <li>2 - a en plus le droit de supprimer des utilisateurs</li>
	 * </ul>
	 * @param niveauDeDroit Niveau de droit Modérateur un chiffre 1 ou 2
	 */
	public void setNiveauDeDroit(int niveauDeDroit) {
		this.niveauDeDroit = niveauDeDroit;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean isModerateur() {
		return true;
	}
	
	
}
