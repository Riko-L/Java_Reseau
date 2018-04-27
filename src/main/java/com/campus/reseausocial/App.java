/**
 * 
 */
package com.campus.reseausocial;

import java.util.Scanner;

/**
 * Classe de démarrage de mon application
 * 
 * @author eric
 *
 */
public class App {

	/**
	 * @see User
	 */
	User user;
	Moderateur mod;
	User currentUser;

	public int choixMenu;

	public char run = 'O';

	public char reponse = 'O';

	private Scanner scan;

	int i = 0; // iteration users
	

	public User[] users = new User[10];

	public String nom;
	public String prenom;
	public String anneeNaissance;

	public int numeroProfil = 0;
	public String updateInfo;
	public String message;
	public String friend;

	public boolean listUsersVide = true;

	public static void main(String[] args) {

		App app = new App();

	}

	public App() {

		this.scan = new Scanner(System.in);

		this.start();

		this.menu();

		System.out.println("Programme TERMINER");
	}

	public void menu() {
		while (run == 'O') {
			// Start

			if (this.currentUser.isModerateur()) {
				System.out.println("[0] Créer un utilisateur");
				System.out.println("[1] Afficher un utilisateur");
				System.out.println("[2] Modifier un utilisateur");
				System.out.println("[3] Ecrire un message");
				System.out.println("[4] Afficher un message d'un utilisateur");
				System.out.println("[5] Supprimer un message d'un utilisateur");
				System.out.println("[6] Ajouter un ami à un utilisateur");
				System.out.println("[7] Afficher un ami d'un utilisateur");
				System.out.println("[8] Supprimer un utilisateur (Poccèder le niveau 2)");
				System.out.println("[9] Vider la messagerie d'un utilisateur");
				System.out.println("[10] Terminer le Programme");
				System.out.println("[11] Choix de l'utilisateur principal");
				System.out.println("[12] Lister les utilisateurs du réseau (Poccèder le niveau 2)");

				choixMenu = scan.nextInt();
				scan.nextLine();

				switch (choixMenu) {
				case 0:
					this.addUser();
					break;
				case 1:
					this.showProfil();
					break;
				case 2:
					this.updateProfil();
					break;
				case 3:
					this.writeMessage();
					break;
				case 4:
					this.showMessage();
					break;
				case 5:
					this.delMessage();
					break;
				case 6:
					this.addFriend();
					break;
				case 7:
					this.showFriend();
					break;
				case 8:
					this.delUser();
					break;
				case 9:
					this.delMessagerie();
					break;
				case 10:
					this.run = ' ';
					break;
				case 11:
					this.chooseUser();
					break;
				case 12:
					this.listUser();
					break;
				}
			} else {

				System.out.println("[0] Créer un utilisateur");
				System.out.println("[1] Afficher votre profil");
				System.out.println("[2] Modifier votre profil");
				System.out.println("[3] Ecrire un message");
				System.out.println("[4] Afficher mes message");
				System.out.println("[5] Supprimer un message");
				System.out.println("[6] Ajouter un ami");
				System.out.println("[7] Afficher mes ami");
				System.out.println("[8] Terminer le Programme");
				System.out.println("[9] Choix de l'utilisateur principal");

				choixMenu = scan.nextInt();
				scan.nextLine();

				switch (choixMenu) {
				case 0:
					this.addUser();
					break;
				case 1:
					this.showProfil();
					break;
				case 2:
					this.updateProfil();
					break;
				case 3:
					this.writeMessage();
					break;
				case 4:
					this.showMessage();
					break;
				case 5:
					this.delMessage();
					break;
				case 6:
					this.addFriend();
					break;
				case 7:
					this.showFriend();
					break;
				case 8:
					this.run = ' ';
					break;
				case 9:
					this.chooseUser();
					break;

				}

			}

		}
	}

	public void start() {

		System.out.println("///////////////////////// APPLICATION RESEAU SOCIAL //////////////////////// \n");
		System.out.println("Créeation de votre 1er utilisateur");
		this.addUser();
		this.chooseUser();
	}

	public void addUser() {
		System.out.println("///////////////////////// CREATION UTILISATEUR | MODERATEUR //////////////////////// \n");

		System.out.println("Entrer votre nom:");
		nom = scan.nextLine();
		System.out.println("Entrer votre Prénom:");
		prenom = scan.nextLine();
		System.out.println("Entrer votre date de naissance:");
		anneeNaissance = scan.nextLine();

		System.out.println("\n Voici vos différentes saisies: ");
		System.out.println("Nom : " + this.nom);
		System.out.println("Prenom : " + this.prenom);
		System.out.println("Année de naissance : " + this.anneeNaissance);
		System.out.println("\n");

		System.out.println("Voulez-vous lui attribuer les droits MODERATEUR: O|N");
		reponse = scan.nextLine().charAt(0);

		if (this.reponse == 'O') {

			System.out.println("Quel niveau de Modération ? :  1 ou 2");
			choixMenu = scan.nextInt();
			scan.nextLine();
			mod = new Moderateur(nom, prenom, anneeNaissance);
			mod.setNiveauDeDroit(choixMenu);

			if (this.i < 10) {

				this.users[i] = mod;

				this.i++;
			} else {
				System.out.println("Trop d'utilisateurs \n");
			}

			System.out.println("Modérateur Créer \n");

		} else if (this.reponse == 'N') {

			if (this.i < 10) {
				user = new User(this.nom, this.prenom, this.anneeNaissance);
				this.users[i] = user;

				this.i++;
			} else {
				System.out.println("Trop d'utilisateurs \n");
			}
			System.out.println("Utilisateur Créer \n");
		}

	}
	public void showProfil() {
		if (this.currentUser.isModerateur()) {
			System.out.println("///////////////////////// AFFICHER PROFILS //////////////////////// \n");
			System.out.println("Entrer le numero du profil entre 0 et 9 (Defaut 0)");
			numeroProfil = this.scan.nextInt();

			
			try {

				System.out.println("\n Voici vos données: ");
				System.out.println("Nom : " + this.users[numeroProfil].getNom());
				System.out.println("Prenom : " + this.users[numeroProfil].getPrenom());
				System.out.println("Année de naissance : " + this.users[numeroProfil].getDateNaissance());
				System.out.println("\n");

				this.reponse = ' ';

				while (this.reponse != 'P' && this.reponse != 'Q') {

					System.out.println("Retour menu P | Quitter le Programme Q");
					scan.nextLine();
					this.reponse = scan.nextLine().charAt(0);
					if (this.reponse == 'Q')
						this.run = 'N';

				}

			} catch (Exception e) {
				System.out.println("//////////////////// User VIDE ///////////////////////////////");

			}
		} else {
			System.out.println("///////////////////////// MON PROFIL //////////////////////// \n");
			System.out.println("\n Voici vos données: ");
			System.out.println("Nom : " + this.currentUser.getNom());
			System.out.println("Prenom : " + this.currentUser.getPrenom());
			System.out.println("Année de naissance : " + this.currentUser.getDateNaissance());
			System.out.println("\n");

		}
	}
	public void updateProfil() {

		if (this.currentUser.isModerateur()) {
			this.reponse = 'O';
			System.out.println("///////////////////////// UPDATE PROFIL //////////////////////// \n");
			System.out.println("Entrer le numero du profil entre 0 et 9 (Defaut 0)");
			numeroProfil = this.scan.nextInt();

			while (this.reponse == 'O') {
				System.out.println("UPDATE de " + this.users[numeroProfil].getNom() + "\n");

				System.out.println("[1] Changer le nom:");
				System.out.println("[2] Changer le prénom:");
				System.out.println("[3] Changer l'année de naissance:");
				System.out.println("[4] Retour au menu");

				choixMenu = this.scan.nextInt();

				this.scan.nextLine();

				switch (choixMenu) {
				case 1:
					System.out.println("Entrer le nom:");
					updateInfo = this.scan.nextLine();
					this.users[numeroProfil].setNom(updateInfo);
					System.out.println("Enregister");
					break;
				case 2:
					System.out.println("Entrer le Prenom:");
					updateInfo = this.scan.nextLine();
					this.users[numeroProfil].setPrenom(updateInfo);
					System.out.println("Enregister");
					break;
				case 3:
					System.out.println("Entrer le Année de Naissnace:");
					updateInfo = this.scan.nextLine();
					this.users[numeroProfil].setDateNaissance(updateInfo);
					System.out.println("Enregistrer");
					break;
				case 4:
					this.reponse = 'P';
					break;
				}

				if (reponse != 'P') {

					this.reponse = ' ';

					while (this.reponse != 'O' && this.reponse != 'Q') {

						System.out.println("Retour menu Précedent O  | Quitter le Programme Q");
						this.reponse = scan.nextLine().charAt(0);
						if (this.reponse == 'Q')
							this.run = 'N';

					}
				}
			}
		} else {

			System.out.println("UPDATE de " + this.currentUser.getNom() + "\n");

			System.out.println("[1] Changer le nom:");
			System.out.println("[2] Changer le prénom:");
			System.out.println("[3] Changer l'année de naissance:");
			System.out.println("[4] Retour au menu");

			choixMenu = this.scan.nextInt();

			this.scan.nextLine();

			switch (choixMenu) {
			case 1:
				System.out.println("Entrer le nom:");
				updateInfo = this.scan.nextLine();
				this.currentUser.setNom(updateInfo);
				System.out.println("Enregister");
				break;
			case 2:
				System.out.println("Entrer le Prenom:");
				updateInfo = this.scan.nextLine();
				this.currentUser.setPrenom(updateInfo);
				System.out.println("Enregister");
				break;
			case 3:
				System.out.println("Entrer le Année de Naissnace:");
				updateInfo = this.scan.nextLine();
				this.currentUser.setDateNaissance(updateInfo);
				System.out.println("Enregistrer");
				break;
			case 4:
				this.reponse = 'P';
				break;
			}

		}
	}
	public void writeMessage() {
		this.reponse = 'O';
		System.out.println("///////////////////////// ECRIRE MESSAGE ////////////////////////// \n");
		while (this.reponse == 'O') {
			System.out.println("Entrer le numero du profil de votre correspondant entre 0 et 9 (Defaut 0)");
			numeroProfil = this.scan.nextInt();
			scan.nextLine();
			System.out.println("Entrer votre message pour " + this.users[numeroProfil].getNom() + " :");
			this.message = scan.nextLine();
			if (this.i < 10) {
				this.users[numeroProfil].addMessages(this.message);
			}
			System.out.println("Message Envoyé !");

			this.reponse = ' ';

			while (this.reponse != 'P' && this.reponse != 'Q' && this.reponse != 'O') {

				System.out.println("Envoyer un Nouveau message O | Retour menu P | Quitter le Programme Q");
				this.reponse = scan.nextLine().charAt(0);
				if (this.reponse == 'Q')
					this.run = 'N';

			}
		}

	}
	public void showMessage() {
		if (this.currentUser.isModerateur()) {
			this.reponse = 'O';
			System.out.println("///////////////////////// AFFICHER LES MESSAGES ////////////////////////// \n");

			while (this.reponse == 'O') {
				System.out.println("Entrer le numero du profil de votre correspondant entre 0 et 9 (Defaut 0)");
				numeroProfil = this.scan.nextInt();
				scan.nextLine();
				System.out.println("voici les messages de l'utilisateur " + this.users[numeroProfil].getNom() + " \n");
				for (int i = 0; i < this.users[numeroProfil].getMessages().length; i++) {
					if (this.users[numeroProfil].getMessages()[i] != null) {
						System.out.println("Message numéro " + i + ":" + this.users[numeroProfil].getMessages()[i]);
					}
				}

				this.reponse = ' ';
				while (this.reponse != 'P' && this.reponse != 'Q' && this.reponse != 'O') {

					System.out.println("Lire message autre profil O | Retour menu P | Quitter le Programme Q");
					this.reponse = scan.nextLine().charAt(0);
					if (this.reponse == 'Q')
						this.run = 'N';

				}
			}
		} else {
			System.out.println("///////////////////////// MES MESSAGES ////////////////////////// \n");
			for (int i = 0; i < this.currentUser.getMessages().length; i++) {
				if (this.currentUser.getMessages()[i] != null) {
					System.out.println("Message numéro [" + i + "]:" + this.currentUser.getMessages()[i]);
				}
			}
		}

	}
	public void addFriend() {
		if (this.currentUser.isModerateur()) {
			this.reponse = 'O';
			System.out.println("///////////////////////// AJOUTER UN AMI////////////////////////// \n");

			while (this.reponse == 'O') {
				System.out.println("Entrer le numero du profil pour lui ajouter des amis entre 0 et 9 (Defaut 0)");
				numeroProfil = this.scan.nextInt();
				scan.nextLine();

				System.out.println("voici une liste de profils entrer son numéro pour l'ajouter en ami");

				for (int i = 0; i < this.users.length; i++) {
					if (this.users[i] != null) {

						if (this.users[i] != this.users[numeroProfil]
								&& this.users[i] != this.users[numeroProfil].getFriends()[i]) {
							this.listUsersVide = false;
							System.out.println("[" + i + "] " + this.users[i].getNom());
						}
					} else {

						this.reponse = ' ';
					}
				}
				if (!this.listUsersVide) {
					System.out.print("Ajouter le numero : ");
					this.friend = this.scan.nextLine();

					this.users[numeroProfil].addFriends(users[Integer.parseInt(this.friend)]);

					System.out.println("Ami : " + users[Integer.parseInt(this.friend)].getNom()
							+ " à été ajouté au profil de " + this.users[numeroProfil].getNom());

					this.reponse = ' ';
					while (this.reponse != 'P' && this.reponse != 'Q' && this.reponse != 'O') {

						System.out.println("ajouter un ami O | Retour menu P | Quitter le Programme Q");
						this.reponse = scan.nextLine().charAt(0);
						if (this.reponse == 'Q')
							this.run = 'N';

					}
				}
			}
		} else {

			System.out.println("Liste de profils - Entrer son numéro pour l'ajouter en ami");

			for (int i = 0; i < this.users.length; i++) {
				if (this.users[i] != null) {

					if (this.users[i] != this.currentUser && this.users[i] != this.currentUser.getFriends()[i]) {
						this.listUsersVide = false;
						System.out.println("[" + i + "] " + this.users[i].getNom());
					}
				} else {

					this.menu();
				}
			}
			if (!this.listUsersVide) {
				System.out.print("Ajouter le numero : ");
				this.friend = this.scan.nextLine();

				this.currentUser.addFriends(users[Integer.parseInt(this.friend)]);

				System.out.println("Ami : " + users[Integer.parseInt(this.friend)].getNom() + " ajouté");
			}

		}

	}

	public void showFriend() {
		if (this.currentUser.isModerateur()) {
			this.reponse = 'O';
			System.out.println("///////////////////////// AFFICHER LISTE AMIS ////////////////////////// \n");
			try {
				while (this.reponse == 'O') {
					System.out.println(
							"Entrer le numero du profil dont vous voulez afficher les amis entre 0 et 9 (Defaut 0)");
					numeroProfil = this.scan.nextInt();
					scan.nextLine();

					System.out.println("voici les amis de l'utilisateur " + this.users[numeroProfil].getNom() + " \n");

					for (int i = 0; i < this.users[numeroProfil].getFriends().length; i++) {
						if (this.users[numeroProfil].getFriends()[i] != null) {

							System.out.println("Ami numéro " + i + ":" + users[numeroProfil].getFriends()[i].getNom());
						}
					}

					this.reponse = ' ';
					while (this.reponse != 'P' && this.reponse != 'Q' && this.reponse != 'O') {

						System.out
								.println("voir les amis d'un autre profil O | Retour menu P | Quitter le Programme Q");
						this.reponse = scan.nextLine().charAt(0);
						if (this.reponse == 'Q')
							this.run = 'N';

					}
				}
			} catch (Exception e) {
				System.out.println("User VIDE" + e);
			}
		} else {
			System.out.println("///////////////////////// AFFICHER MES AMIS ////////////////////////// \n");

			for (int i = 0; i < this.currentUser.getFriends().length; i++) {
				if (this.currentUser.getFriends()[i] != null) {

					System.out.println("Ami numéro [" + i + "] :" + this.currentUser.getFriends()[i].getNom());
				}
			}

		}
	}

	public void delMessage() {
		if (this.currentUser.isModerateur()) {
			this.reponse = 'O';
			System.out.println("///////////////////////// SUPPRIMER MESSAGE ////////////////////////// \n");
			while (this.reponse == 'O') {
				System.out.println("Entrer le numero du profil à qui supprimer le message  entre 0 et 9");
				numeroProfil = this.scan.nextInt();
				scan.nextLine();
				System.out.println(
						"Entrer le numéro du message à supprimer pour " + this.users[numeroProfil].getNom() + " :");
				for (int i = 0; i < users[numeroProfil].getMessages().length; i++) {

					if (users[numeroProfil].getMessages()[i] != null) {
						System.out.println("[" + i + "] Message :: " + users[numeroProfil].getMessages()[i]);
					}

				}
				System.out.print("Votre Choix :");
				this.choixMenu = scan.nextInt();
				scan.nextLine();

				users[numeroProfil].delMessages(choixMenu);

				this.reponse = ' ';

				while (this.reponse != 'P' && this.reponse != 'Q' && this.reponse != 'O') {

					System.out.println("Supprimer un autre message O | Retour menu P | Quitter le Programme Q");
					this.reponse = scan.nextLine().charAt(0);
					if (this.reponse == 'Q')
						this.run = 'N';

				}
			}
		} else {
			System.out.println("Entrer le numéro du message à supprimer");
			for (int i = 0; i < this.currentUser.getMessages().length; i++) {

				if (this.currentUser.getMessages()[i] != null) {
					System.out.println("[" + i + "] Message :: " + this.currentUser.getMessages()[i]);
				}

			}
			System.out.print("Votre Choix :");
			this.choixMenu = scan.nextInt();
			scan.nextLine();

			this.currentUser.delMessages(choixMenu);
		}

	}

	public void delUser() {
		if (this.currentUser.isModerateur() && this.currentUser.getNiveauDeDroit() == 2) {
			System.out.println("///////////////////////// SUPPRIMER UN UTILISATEUR ////////////////////////// \n");

			System.out.println("voici une liste de profils entrer le numéro à supprimer");

			for (int i = 0; i < this.users.length; i++) {
				if (this.users[i] != null) {

					if (this.users[i] != this.currentUser) {
						this.listUsersVide = false;
						System.out.println("[" + i + "] " + this.users[i].getNom());
					}
				}
			}
			if (!this.listUsersVide) {
				System.out.print("Supprimer le numéro : ");
				this.choixMenu = this.scan.nextInt();
				users[choixMenu] = null;
				i--;
				System.out.println("Utilisateur Supprimé !");

			}
		}else {
			System.out.println("vous devez avoir le niveau de droits sur 2 pour pouvoir modifier cette ressource");
		}
	}

	public void delMessagerie() {
		if(this.currentUser.isModerateur()) {
		System.out.println("///////////////////////// VIDER LA MESSAGERIE D'UU UTILISATEUR ////////////////////////// \n");
	
			System.out.println("Entrer le numero de l'utilisateur à qui vider la messagerie  entre 0 et 9");
			numeroProfil = this.scan.nextInt();
			scan.nextLine();
			
			users[numeroProfil].viderMessages();
			System.out.print("La messagerie de l'utilisateur " + users[numeroProfil].getNom() + " est vide");
		}
	}

	public void chooseUser() {

		System.out.println("voici une liste de profils entrer son numéro l'activer");

		for (int i = 0; i < this.users.length; i++) {
			if (this.users[i] != null) {
				System.out.println("[" + i + "] " + this.users[i].getNom());
			}
		}

		System.out.print("Selectionner le numéro : ");
		this.choixMenu = this.scan.nextInt();
		this.scan.nextLine();
		this.currentUser = users[choixMenu];
		System.out.println("Utilisateur " + users[choixMenu].getNom() + " est bien selectionné");

	}
	public void listUser() {
		if (this.currentUser.isModerateur() && this.currentUser.getNiveauDeDroit() == 2) {
			System.out.println("///////////////////////// UTILISATEUR DU RESEAU ////////////////////////// \n \n");

			for (int i = 0; i < users.length; i++) {
				if (users[i] != null) {
					System.out.println("Utilisateur : [" + i + "] " + users[i].getNom() + " | " + users[i].getPrenom()
							+ " | " + users[i].getDateNaissance() + " | " + users[i].isModerateur());

				}
			}
		}else {
			System.out.println("vous devez avoir le niveau de droits sur 2 pour pouvoir modifier cette ressource");
		}
	}
}
