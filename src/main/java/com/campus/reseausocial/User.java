package com.campus.reseausocial;

/**
 * Class Utilisateur Permet d'enregistrer les utilisateurs
 * 
 * @author eric
 *
 */
public class User {

	private int niveauDeDroit = 0;
	/**
	 * @see #setNom(String)
	 */
	private String nom;

	/**
	 * @see #setPrenom(String)
	 */
	private String prenom;

	/**
	 * @see #setDateNaissance(String)
	 */
	private String dateNaissance;

	/**
	 * Tableau contenant la liste des amis Maximum 11 Amis
	 */
	private User[] friends = new User[10];

	/**
	 * Itérateur message
	 */
	private int m = 0;

	/**
	 * Itérateur friend
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
	 *            Prénom de l'utilisateur
	 * @param dateNaissance
	 *            Année de naissance de l'utilisateur
	 */
	public User(String nom, String prenom, String dateNaissance) {

		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;

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
	 * Obtenir le Prénom de l'utilisateur
	 * 
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Affecter le Prénom de l'utilisateur
	 * 
	 * @param prenom
	 *            Nouveau Prénom de l'utilisateur
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Obtenir l'année de naissance de l'utilisateur
	 * 
	 * @return dateNaissance
	 */
	public String getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Affecter l'année de naissance de l'utilisateur
	 * 
	 * @param dateNaissance
	 *            Nouvelle année de naissance de l'utilisateur
	 */
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
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
	 *            Ami à ajouter à l'utilisateur
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
	 *            Message à ajouter à l'utilisateur
	 * 
	 */
	public void addMessages(String message) {
		this.messages[this.m] = message;
		this.m++;
	}

	/**
	 * @param messages
	 *            the messages to set
	 */
	protected void setMessages(String[] messages) {
		this.messages = messages;
	}

	protected void viderMessages() {
		this.setMessages(new String[10]);
	}

	/**
	 * Supprime un message
	 * 
	 * @param nbre
	 *            Numéro de l'index à supprimer
	 */
	public void delMessages(int nbre) {
		this.messages[nbre] = null;
		this.m--;
		System.out.println("Message " + nbre + " à été supprimé !");
	}

	public boolean isModerateur() {
		return false;

	}

	public int getNiveauDeDroit() {
		return niveauDeDroit;
	}

}
