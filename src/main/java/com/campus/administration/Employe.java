/**
 * 
 */
package com.campus.administration;

import com.campus.reseausocial.Personne;
import com.campus.reseausocial.Salarie;

/**
 * @author eric
 *
 */
public class Employe extends Personne implements Salarie{

	int dureeContrat;
	int salaire;

	
	public Employe(String nom, String prenom,String dateDeNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
	}
	
	
	@Override
	public void recevoirPaiement() {
		
		
	}

	/**
	 * @return the dureeContrat
	 */
	public int getDureeContrat() {
		return dureeContrat;
	}

	/**
	 * @param dureeContrat the dureeContrat to set
	 */
	public void setDureeContrat(int dureeContrat) {
		this.dureeContrat = dureeContrat;
	}

	/**
	 * @return the salaire
	 */
	public int getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire the salaire to set
	 */
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	
	
	
}
