/**
 * 
 */
package com.campus.reseausocial;

import java.util.Scanner;

/**
 * @author eric
 *
 */
public class App {

	public int choixMenu;
	public char run = 'O';

	public String nom;
	public String prenom;
	public String anneeNaissance;
	public char reponse = 'O';

	private Scanner scan;

	int i = 0; // iteration users
	int m = 0; // iteration messages
	int f = 0; // iteration friends
	public String[][] users = new String[10][4];
	public String[][] messages = new String[10][10];
	public String[][] friends = new String[10][10];

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
		while (run == 'O') {
			// Start
			System.out.println("///////////////////////// APPLICATION RESEAU SOCIAL //////////////////////// \n");
			System.out.println("Choisir une action en entrant le munéro:\n");
			System.out.println("0) Créer un utilisateur");
			System.out.println("1) Afficher votre profil");
			System.out.println("2) Modifier votre profil");
			System.out.println("3) Ecrire un message");
			System.out.println("4) Afficher un message");
			System.out.println("5) Ajouter un ami");
			System.out.println("6) Afficher un ami");
			System.out.println("7) Terminer le Programme");

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
				this.addFriend();
				break;
			case 6:
				this.showFriend();
				break;
			case 7:
				this.run = ' ';

			}
		}
		System.out.println("Programme TERMINER");
	}

	public void addUser() {

		System.out.println("///////////////////////// CREATION UTILISATEUR //////////////////////// \n");
		while (reponse == 'O') {

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

			if (this.i < 10) {
				this.users[i][0] = this.nom;
				this.users[i][1] = this.prenom;
				this.users[i][2] = this.anneeNaissance;
				this.i++;
			} else {
				System.out.println("Trop d'utilisateurs \n");
			}

			System.out.println("Votre Utilisateur à été enregistré \n");

			this.reponse = ' ';

			while (this.reponse != 'O' && this.reponse != 'N') {

				System.out.println("Ajouter un autre Utilisateur ? O | N");
				this.reponse = scan.nextLine().charAt(0);

			}

		}

	}

	public void showProfil() {
		System.out.println("///////////////////////// AFFICHER PROFIL //////////////////////// \n");
		System.out.println("Entrer le numero du profil entre 0 et 9 (Defaut 0)");
		numeroProfil = this.scan.nextInt();

		System.out.println("\n Voici vos données: ");
		System.out.println("Nom : " + this.users[numeroProfil][0]);
		System.out.println("Prenom : " + this.users[numeroProfil][1]);
		System.out.println("Année de naissance : " + this.users[numeroProfil][2]);
		System.out.println("\n");

		this.reponse = ' ';

		while (this.reponse != 'P' && this.reponse != 'Q') {

			System.out.println("Retour menu P | Quitter le Programme Q");
			scan.nextLine();
			this.reponse = scan.nextLine().charAt(0);
			if (this.reponse == 'Q')
				this.run = 'N';

		}

	}

	public void updateProfil() {
		this.reponse = 'O';
		System.out.println("///////////////////////// UPDATE PROFIL //////////////////////// \n");
		System.out.println("Entrer le numero du profil entre 0 et 9 (Defaut 0)");
		numeroProfil = this.scan.nextInt();

		while (this.reponse == 'O') {
			System.out.println("UPDATE de " + this.users[numeroProfil][0] + "\n");

			System.out.println("1) Changer le nom:");
			System.out.println("2) Changer le prénom:");
			System.out.println("3) Changer l'année de naissance:");
			System.out.println("4) Retour au menu");

			choixMenu = this.scan.nextInt();

			this.scan.nextLine();

			switch (choixMenu) {
			case 1:
				System.out.println("Entrer le nom:");
				updateInfo = this.scan.nextLine();
				this.users[numeroProfil][0] = updateInfo;
				System.out.println("Enregister");
				break;
			case 2:
				System.out.println("Entrer le Prenom:");
				updateInfo = this.scan.nextLine();
				this.users[numeroProfil][1] = updateInfo;
				System.out.println("Enregister");
				break;
			case 3:
				System.out.println("Entrer le Année de Naissnace:");
				updateInfo = this.scan.nextLine();
				this.users[numeroProfil][2] = updateInfo;
				System.out.println("Enregistrer");
				break;
			case 4:
				this.reponse = 'P';
				break;
			}

			this.reponse = ' ';

			while (this.reponse != 'O' && this.reponse != 'P' && this.reponse != 'Q') {

				System.out.println("Retour menu Précedent O | Retour menu Principal P | Quitter le Programme Q");
				this.reponse = scan.nextLine().charAt(0);
				if (this.reponse == 'Q')
					this.run = 'N';

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
			System.out.println("Entrer votre message pour " + this.users[numeroProfil][0] + " :");
			this.message = scan.nextLine();
			if (this.i < 10 & this.m < 10) {
				this.messages[numeroProfil][m] = this.message;
				this.m++;
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
		this.reponse = 'O';
		System.out.println("///////////////////////// AFFICHER MES MESSAGES ////////////////////////// \n");

		while (this.reponse == 'O') {
			System.out.println("Entrer le numero du profil de votre correspondant entre 0 et 9 (Defaut 0)");
			numeroProfil = this.scan.nextInt();
			scan.nextLine();
			System.out.println("voici les messages de l'utilisateur " + this.users[numeroProfil][0] + " \n");
			for (int i = 0; i < messages[numeroProfil].length; i++) {
				if (messages[numeroProfil][i] != null) {
					System.out.println("Message numéro " + i + ":" + messages[numeroProfil][i]);
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
	}

	public void addFriend() {
		this.reponse = 'O';
		System.out.println("///////////////////////// AJOUTER UN AMI////////////////////////// \n");

		while (this.reponse == 'O') {
			System.out.println("Entrer le numero du profil pour lui ajouter des amis entre 0 et 9 (Defaut 0)");
			numeroProfil = this.scan.nextInt();
			scan.nextLine();

			System.out.println("voici une liste de profils entrer son numéro pour l'ajouter en ami");

			for (int i = 0; i < this.users.length; i++) {
				if (this.users[i][0] != null) {
					
					if (this.users[i] != this.users[numeroProfil]) {
						this.listUsersVide = false;
						System.out.println("[" + i + "] " + this.users[i][0]);
					}
				} else {

					this.reponse = ' ';
				}
			}
			if (!this.listUsersVide) {
				System.out.print("Ajouter le numero : ");
				this.friend = this.scan.nextLine();
				if (f < 10) {
					this.friends[numeroProfil][f] = this.friend;
					this.f++;
					System.out.println("Ami ajouté");
				}

				this.reponse = ' ';
				while (this.reponse != 'P' && this.reponse != 'Q' && this.reponse != 'O') {

					System.out.println("ajouter un ami O | Retour menu P | Quitter le Programme Q");
					this.reponse = scan.nextLine().charAt(0);
					if (this.reponse == 'Q')
						this.run = 'N';

				}
			}
		}

	}

	public void showFriend() {
		this.reponse = 'O';
		System.out.println("///////////////////////// AFFICHER LISTE AMIS ////////////////////////// \n");

		while (this.reponse == 'O') {
			System.out.println("Entrer le numero du profil dont vous voulez afficher les amis entre 0 et 9 (Defaut 0)");
			numeroProfil = this.scan.nextInt();
			scan.nextLine();
			
			System.out.println("voici les amis de l'utilisateur " + this.users[numeroProfil][0] + " \n");
			
			for (int i = 0; i < this.friends[numeroProfil].length; i++) {
				if (friends[numeroProfil][i] != null) {
					System.out.println("Ami numéro " + i + ":" + users[Integer.parseInt(friends[numeroProfil][i])][0]);
				}
			}

			this.reponse = ' ';
			while (this.reponse != 'P' && this.reponse != 'Q' && this.reponse != 'O') {

				System.out.println("voir les amis d'un autre profil O | Retour menu P | Quitter le Programme Q");
				this.reponse = scan.nextLine().charAt(0);
				if (this.reponse == 'Q')
					this.run = 'N';

			}
		}
	}
	

}
