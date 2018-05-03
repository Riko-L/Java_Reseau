package com.campus.reseausocial;

/**
 * Class Utilisateur permet de cr�er des utilisateurs
 * 
 * @author eric
 *
 */
public class User extends Personne {

	/**
	 * @see #setPseudo(String)
	 */
	private String pseudo;

	/**
	 * Tableau contenant la liste des amis Maximum 11 Amis
	 */
	private User[] friends = new User[10];

	/**
	 * It�rateur message
	 */
	private int m = 0;

	/**
	 * It�rateur friend
	 */
	private int f = 0;

	/**
	 * Tableau contenant la liste des messages Maximum 11 messages
	 */
	private String[] messages = new String[10];

	/**
	 * Initialisation de d'un utilisateur
	 * 
	 * @param nom
	 *            Nom de l'utilisateur
	 * @param prenom
	 *            Pr�nom de l'utilisateur
	 * @param dateNaissance
	 *            Ann�e de naissance de l'utilisateur
	 */
	public User(String nom, String prenom, String pseudo , String dateDeNaissance) {

		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.pseudo = pseudo;

	}

	/**
	 * Retourne le Nom de l'Utilisateur
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Affecter le Nom de l'utilisateur
	 * 
	 * @param nom
	 *            Nouveau nom de l'utilisateur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Obtenir le Pr�nom de l'utilisateur
	 * 
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Affecter le Pr�nom de l'utilisateur
	 * 
	 * @param prenom
	 *            Nouveau Pr�nom de l'utilisateur
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Obtenir l'ann�e de naissance de l'utilisateur
	 * 
	 * @return dateNaissance
	 */
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * Affecter l'ann�e de naissance de l'utilisateur
	 * 
	 * @param dateNaissance
	 *            Nouvelle ann�e de naissance de l'utilisateur
	 */
	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**
	 * Obtenir le Pseudo de l'utilisateur
	 * 
	 * @return Pseudo de l'utilisateur
	 * 
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Affecter un nouveau pseudo � l'utilisateur
	 * 
	 * @param pseudo
	 *            Nouveau pseudo de l'utilisateur
	 * 
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Obtenir la liste des amis
	 * 
	 * @return friends
	 */
	public User[] getFriends() {
		return friends;
	}

	/**
	 * Ajout d'un ami.
	 *
	 * @param friend
	 *            Ami � ajouter
	 * 
	 */
	public void addFriends(User friend) {
		this.friends[this.f] = friend;
		this.f++;
	}

	/**
	 * Obtenir la liste des messages
	 * 
	 * @return messages
	 */
	public String[] getMessages() {
		return messages;
	}

	/**
	 * Ajoute un message
	 * 
	 * @param message
	 *            Message pour�l'utilisateur
	 * 
	 */
	public void addMessages(String message) {
		this.messages[this.m] = message;
		this.m++;
	}

	/**
	 * @param messages
	 *            Tableau de messages
	 */
	public void setMessages(String[] messages) {
		this.messages = messages;
	}

	/**
	 * Vide la messagerie de l'utilisateur
	 * 
	 */
	public void viderMessages() {
		this.setMessages(new String[10]);
	}

	/**
	 * Supprime un message
	 * 
	 * @param nbre
	 *            Num�ro de l'index �supprimer
	 */
	public void delMessages(int nbre) {
		this.messages[nbre] = null;
		this.m--;
	}

	/**
	 * Savoir si l'utilisateur est un mod�rateur
	 * 
	 * @return false
	 */
	public boolean isModerateur() {
		return false;

	}

	/**
	 * Retourn le niveau de mod�ration 0 pour un utilisateur
	 * 
	 * @return 0
	 */
	public int getNiveau() {
		return 0;
	}

}
