/**
 * 
 */
package com.campus.reseausocial;

/**
 * Classe Mod�rateur permet de cr�er des mod�rateurs
 * 
 * @author eric
 *
 */
public class Moderateur extends User {

	private int niveauDeDroit;

	/**
	 * @param nom
	 *            Nom du mod�rateur
	 * @param prenom
	 *            Pr�nom du Mod�rateur
	 * @param dateNaissance
	 *            Date de naissance du Mod�rateur
	 */
	public Moderateur(String nom, String prenom, String dateNaissance) {
		super(nom, prenom, dateNaissance);

	}

	/**
	 * Obtenir le niveau de mod�ration
	 * 
	 * <ul>
	 * <li>[1] - modifier/supprimer des messages</li>
	 * <li>[2] - a en plus le droit de supprimer des utilisateurs</li>
	 * </ul>
	 * 
	 * @return niveauDeDroit
	 */
	public int getNiveauDeDroit() {
		return niveauDeDroit;
	}

	/**
	 * D�finir le niveau de droit mod�rateur
	 * <ul>
	 * <li>1 - modifier/supprimer des messages</li>
	 * <li>2 - a en plus le droit de supprimer des utilisateurs</li>
	 * </ul>
	 * 
	 * @param niveauDeDroit
	 *            Niveau de droit Mod�rateur un chiffre 1 ou 2
	 */
	public void setNiveauDeDroit(int niveauDeDroit) {
		this.niveauDeDroit = niveauDeDroit;
	}

	/**
	 * Savoir si l'utilisateur est un mod�rateur
	 * 
	 * @return true
	 */
	@Override
	public boolean isModerateur() {
		return true;
	}

}
