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
public class Moderateur extends User implements Salarie{

	private int niveau;

	/**
	 * @param nom
	 *            Nom du mod�rateur
	 * @param prenom
	 *            Pr�nom du Mod�rateur
	 * @param pseudo
	 *            Pseudo du Mod�rateur
	 * @param dateNaissance
	 *            Date de naissance du Mod�rateur
	 */
	public Moderateur(String nom, String prenom, String pseudo, String dateNaissance) {
		super(nom, prenom, pseudo, dateNaissance);

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
	public int getNiveau() {
		return niveau;
	}

	/**
	 * D�finir le niveau de droit mod�rateur
	 * <ul>
	 * <li>1 - modifier/supprimer des messages</li>
	 * <li>2 - a en plus le droit de supprimer des utilisateurs</li>
	 * </ul>
	 * 
	 * @param niveau
	 *            Niveau de droit Mod�rateur un chiffre 1 ou 2
	 */
	public void setNiveau(int niveau) {
		this.niveau = niveau;
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

	@Override
	public void recevoirPaiement() {
		
		
	}

}
