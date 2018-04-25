package com.campus.reseausocial;

public class User {

	private String nom;
	private String prenom;
	private String dateNaissance;
	public User[] friends = new User[10];
	public int m = 0;
	public int f = 0;
	public String[] messages = new String[10];
	
	public User(String nom, String prenom, String dateNaissance) {

		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public User[] getFriends() {
		return friends;
	}

	public void addFriends(User friend) {
		this.friends[this.f] = friend;
		this.f++;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String message) {
		this.messages[this.m] = message;
		this.m++;
	}
	
	

}
