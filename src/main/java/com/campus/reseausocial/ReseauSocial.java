package com.campus.reseausocial;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import com.campus.mainmenu.Menu;
import com.campus.submenu.SubMenuUpdateUser;

public class ReseauSocial {

	static private User user;
	static private Moderateur mod;
	static public User currentUser;
	static private Menu menu;
	static private SubMenuUpdateUser subMenu;

	static private int numeroProfil;
	static private int currentUserIndex;
	static private int numeroFriend;

	static private char reponse = 'O';

	static private Scanner scan;

	static private int i = 0; // iteration users

	static private User[] users = new User[10];

	static private String nom;
	static private String prenom;
	static private String pseudo;
	static private String anneeNaissance;

	public ReseauSocial() {

		scan = new Scanner(System.in);

		start();

		subMenu = new SubMenuUpdateUser();
		menu = new Menu();
	}

	public static void main(String[] args) {

		ReseauSocial reseau = new ReseauSocial();

	}

	private static void start() {

		System.out.println("************************* APPLICATION RESEAU SOCIAL *****************************");
		System.out.println("*********************************************************************************");
		System.out.println();

		char rep = ' ';
		while (rep != 'O' && rep != 'N') {
			System.out.println("Vous générer des utilisteurs ? (O/N)");
			rep = scan.nextLine().charAt(0);
			if (rep == 'O') {
				generateUsers();

			} else {
				System.out.println(">>>>>>>>>>>>>>>>>>>>> Créeation de votre 1er utilisateur <<<<<<<<<<<<<<<<<<<<<<<<");
				rep = 'N';
				addUser();
				selectUser();
			}
		}

	}

	private static void list(String args, Optional<Integer> index) {
		Integer userIndex = index.isPresent() ? index.get() : null;

		switch (args) {
		case "ALL":
			for (int i = 0; i < users.length; i++) {
				if (users[i] != null && users[i] != currentUser) {
					System.out.println("Utilisateur [" + i + "] : " + users[i].getNom() + " | " + users[i].getPrenom()
							+ " | " + users[i].getDateDeNaissance() + " | " + users[i].isModerateur() + " | "
							+ users[i].getNiveau());
				}
				if (users[i] != null && users[i] == currentUser) {
					System.out.println("Utilisateur [" + i + "]*: " + users[i].getNom() + " | " + users[i].getPrenom()
							+ " | " + users[i].getDateDeNaissance() + " | " + users[i].isModerateur() + " | "
							+ users[i].getNiveau());
				}
			}
			break;
		case "FULLNAME":
			for (int i = 0; i < users.length; i++) {
				if (users[i] != null && users[i] != currentUser) {
					System.out.println("Utilisateur [" + i + "] : " + users[i].getNom() + " " + users[i].getPrenom());
				}

			}
			break;

		case "FULLNAME+CURRENT":
			for (int i = 0; i < users.length; i++) {
				if (users[i] != null) {
					System.out.println("Utilisateur [" + i + "] : " + users[i].getNom() + " " + users[i].getPrenom());
				}

			}
			break;

		case "MOD":
			for (int i = 0; i < users.length; i++) {
				if (users[i] != null && users[i].isModerateur() && users[i] != currentUser) {
					System.out.println("Utilisateur [" + i + "] : " + users[i].getNom() + " " + users[i].getPrenom()
							+ " | Niveau de modération : " + users[i].getNiveau());
				}
			}
			break;
		case "FULLNAME+NB-MESSAGE":
			for (int i = 0, nbmsg = 0; i < users.length; i++) {
				if (users[i] != null && users[i].getMessages() != null) {

					for (int m = 0; m < users[i].getMessages().length; m++) {
						if (users[i].getMessages()[m] != null) {
							nbmsg++;
						}
					}
					System.out.println("Utilisateur [" + i + "] : " + users[i].getNom() + " " + users[i].getPrenom()
							+ " | Nombre de messages : [" + nbmsg + "]");
					nbmsg = 0;
				}
			}
			break;

		case "MESSAGE":
			if (userIndex != null && users[userIndex] != null) {

				for (int i = 0; i < users[userIndex].getMessages().length; i++) {

					if (users[userIndex].getMessages()[i] != null) {
						System.out.println(" Message  [" + i + "] : \"" + users[userIndex].getMessages()[i] + "\"");
					}
				}
			}

			break;

		case "FRIENDS":
			if (userIndex != null && users[userIndex] != null) {

				for (int i = 0; i < users[userIndex].getFriends().length; i++) {
					if (users[userIndex].getFriends()[i] != null) {

						System.out.println("Ami [" + i + "] : " + users[userIndex].getFriends()[i].getNom() + " "
								+ users[userIndex].getFriends()[i].getPrenom());
					}
				}
			}

			break;
		case "FULLNAME-USER":

			for (int i = 0; i < users.length; i++) {
				if (users[i] != null && users[i] != currentUser && users[i] != users[userIndex]) {
					System.out.println("Utilisateur [" + i + "] : " + users[i].getNom() + " " + users[i].getPrenom());
				}
			}
			break;

		}

	}

	private static int choixClavier() {
		int choixMenu = -1;
		while (true) {
			System.out.print("Entrer un numéro : ");
			try {
				try {
					choixMenu = scan.nextInt();
					scan.nextLine();
					return choixMenu;
				} catch (InputMismatchException err) {
					throw new ErrSaisieExecption();
				}
			} catch (ErrSaisieExecption err) {
				System.out.println(err.getMessage());
				scan.next();
			}

		}

	}

	public static void changeLevel() {
		System.out.println("**************************** CHANGER LEVEL MODERATEUR *****************************");
		System.out.println("***********************************************************************************");
		list("MOD", Optional.empty());

		numeroProfil = choixClavier();

		if (users[numeroProfil] != null && users[numeroProfil] instanceof Moderateur) {

			System.out.println("Entrer le niveau à attribuer : [1] - [2]");

			int level;
			do {
				level = choixClavier();

				if (level == 1 || level == 2) {
					((Moderateur) users[numeroProfil]).setNiveau(level);
					System.out.println(
							"***********************************************************************************");
					System.out.println("Niveau moderateur modifié");
					System.out.println(
							"***********************************************************************************");

				} else {
					System.out.println("Niveau moderateur non valide  | niveau = 1 || niveau = 2");
				}
			} while (level != 1 && level != 2);

		}

	}

	public static void generateUsers() {
		System.out.println("********************* GENERATION >> UTILISATEUR | MODERATEUR **********************");
		System.out.println("***********************************************************************************");
		users = new User[10];
		int g = 0;
		mod = new Moderateur("LE DEVEDEC", "Eric","riko74", "1982");
		mod.setNiveau(2);
		users[g] = mod;
		user = new User("BIAGI", "Alexandre", "BigBoy" , "1968");
		users[g += 1] = user;
		user = new User("DUPON", "Jean", "The Cat","1945");
		users[g += 1] = user;
		user = new User("PIG", "Peppa", "Petit cochon", "1999");
		users[g += 1] = user;
		user = new User("BOND", "Jams", "251Hys", "1765");
		users[g += 1] = user;
		user = new User("PIGNION", "François","PF2008", "2008");
		users[g += 1] = user;
		mod = new Moderateur("FILLION", "Charles","Fcha74", "1972");
		mod.setNiveau(1);
		users[g += 1] = mod;

		currentUser = users[0];
		currentUserIndex = 0;
		System.out.println("Génération terminé");

	}

	public static void addUser() {
		System.out.println("********************* CREATION >> UTILISATEUR | MODERATEUR **********************");
		System.out.println("*********************************************************************************");

		System.out.print("Entrer votre nom:");
		nom = scan.nextLine();
		System.out.print("Entrer votre Prénom:");
		prenom = scan.nextLine();
		System.out.print("Entrer votre date de naissance:");
		anneeNaissance = scan.nextLine();

		System.out.print("Voulez-vous lui attribuer les droits MODERATEUR: [O] ou [N]");
		reponse = scan.nextLine().charAt(0);

		if (reponse == 'O') {

			System.out.print("Niveau de Modération: [1] ou [2]");
			int choix = choixClavier();
			mod = new Moderateur(nom, prenom,pseudo, anneeNaissance);
			mod.setNiveau(choix);

			if (i < 10) {

				users[i] = mod;

				i++;
			} else {
				System.out.println("Trop d'utilisateurs");
			}

			System.out.println("\"Modérateur Créer\"");

		} else if (reponse == 'N') {

			if (i < 10) {
				user = new User(nom, prenom,pseudo, anneeNaissance);

				users[i] = user;

				i++;
			} else {
				System.out.println("Trop d'utilisateurs");
			}
			System.out.println("\"Utilisateur Créer\"");
		}

	}

	public static void showProfil() {
		if (currentUser.isModerateur()) {
			System.out.println("************************* AFFICHER INFOS UTILISATEURS ***************************");
			System.out.println("*********************************************************************************");
			list("FULLNAME", Optional.empty());

			numeroProfil = choixClavier();

			if (users[numeroProfil] != null) {

				System.out.println(">>>>>>>>>>>>>>>>>>>>     Voici les informations    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println("*********************************************************************************");
				System.out.println("* Nom : " + users[numeroProfil].getNom());
				System.out.println("* Prénom : " + users[numeroProfil].getPrenom());
				System.out.println("* Année de naissance : " + users[numeroProfil].getDateDeNaissance());
				System.out.println("*********************************************************************************");
			}

		} else {
			if (users[currentUserIndex] != null) {

				System.out.println(">>>>>>>>>>>>>>>>>>>>     Voici les informations    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println("*********************************************************************************");
				System.out.println("* Nom : " + currentUser.getNom());
				System.out.println("* Prénom : " + currentUser.getPrenom());
				System.out.println("* Année de naissance : " + currentUser.getDateDeNaissance());
				System.out.println("*********************************************************************************");
			}

		}
	}

	public static void updateProfil() {

		String updateInfo;

		if (currentUser.isModerateur()) {

			System.out.println("************************* MODIFIER INFOS UTILISATEURS ***************************");
			System.out.println("*********************************************************************************");
			list("FULLNAME", Optional.empty());

			numeroProfil = choixClavier();

			reponse = 'O';

			System.out.println("*********************************************************************************");
			System.out
					.println("Modification de " + users[numeroProfil].getNom() + " " + users[numeroProfil].getPrenom());
			System.out.println("*********************************************************************************");

			while (reponse == 'O') {


				subMenu.createMenu();				

				switch (subMenu.getChoixUser()) {
				case 0:
					System.out.print("Entrer Nom:");
					updateInfo = scan.nextLine();
					users[numeroProfil].setNom(updateInfo);
					System.out.println("Enregister");
					break;
				case 1:
					System.out.print("Entrer Prénom:");
					updateInfo = scan.nextLine();
					users[numeroProfil].setPrenom(updateInfo);
					System.out.println("Enregister");
					break;
				case 2:
					System.out.print("Entrer Année de naissance:");
					updateInfo = scan.nextLine();
					users[numeroProfil].setDateDeNaissance(updateInfo);
					System.out.println("Enregistrer");
					break;
				case 3:
					reponse = ' ';
				}

				System.out.println(
						">>>>>>>>>>>>>>>>>>>>     Voici les nouvelles informations    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println(
						"*******************************************************************************************");
				System.out.println("* Nom : " + users[numeroProfil].getNom());
				System.out.println("* Prénom : " + users[numeroProfil].getPrenom());
				System.out.println("* Année de naissance : " + users[numeroProfil].getDateDeNaissance());
				System.out.println(
						"*******************************************************************************************");

			}
		} else {
			System.out.println("*********************************************************************************");
			System.out.println("Modification de " + currentUser.getNom() + " " + currentUser.getPrenom());
			System.out.println("*********************************************************************************");

			subMenu.createMenu();				

			switch (subMenu.getChoixUser()) {
			case 0:
				System.out.print("Entrer Nom:");
				updateInfo = scan.nextLine();
				currentUser.setNom(updateInfo);
				System.out.println("Enregister");
				break;
			case 1:
				System.out.print("Entrer Prénom:");
				updateInfo = scan.nextLine();
				currentUser.setPrenom(updateInfo);
				System.out.println("Enregister");
				break;
			case 2:
				System.out.print("Entrer Année de naissance:");
				updateInfo = scan.nextLine();
				currentUser.setDateDeNaissance(updateInfo);
				System.out.println("Enregistrer");
				break;
			case 3:
				reponse = ' ';
			}
			System.out.println(
					">>>>>>>>>>>>>>>>>>>>     Voici les nouvelles informations    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			System.out.println(
					"*******************************************************************************************");
			System.out.println("* Nom : " + currentUser.getNom());
			System.out.println("* Prénom : " + currentUser.getPrenom());
			System.out.println("* Année de naissance : " + currentUser.getDateDeNaissance());
			System.out.println(
					"*******************************************************************************************");

		}
	}

	public static void writeMessage() {
		reponse = 'O';
		System.out.println("****************************** ECRIRE UN MESSAGE ********************************");
		System.out.println("*********************************************************************************");

		while (reponse == 'O') {
			list("FULLNAME", Optional.empty());
			numeroProfil = choixClavier();

			if (users[numeroProfil] != null) {
				System.out.println("Entrer votre message pour " + users[numeroProfil].getNom() + " "
						+ users[numeroProfil].getPrenom() + " :");
				System.out.print(">> ");

				String message = scan.nextLine();

				users[numeroProfil].addMessages(message);
				System.out.println("*********************************************************************************");
				System.out.println("Message Envoyé !");
				System.out.println("*********************************************************************************");
			}

			reponse = ' ';

			while (reponse != 'P' && reponse != 'O') {

				System.out.println("Envoyer un nouveau message O | Retour menu P");
				reponse = scan.nextLine().charAt(0);

			}
		}

	}

	public static void showMessage() {
		if (currentUser.isModerateur()) {
			reponse = 'O';
			System.out.println("************************** MESSAGES DES UTILISATEURS ****************************");
			System.out.println("*********************************************************************************");

			while (reponse == 'O') {
				list("FULLNAME+NB-MESSAGE", Optional.empty());

				numeroProfil = choixClavier();
				System.out.println("*********************************************************************************");
				if (users[numeroProfil] != null) {
					System.out.println("Messages de l'utilisateur : " + users[numeroProfil].getNom() + " "
							+ users[numeroProfil].getPrenom());

					list("MESSAGE", Optional.of(numeroProfil));
				}
				System.out.println("*********************************************************************************");
				reponse = ' ';

				while (reponse != 'P' && reponse != 'O') {

					System.out.print("Lire message autre profil O | Retour menu P");
					reponse = scan.nextLine().charAt(0);
				}
			}
		} else {
			System.out.println("*******************************  MES MESSAGES  **********************************");
			System.out.println("*********************************************************************************");

			list("MESSAGE", Optional.of(currentUserIndex));
			System.out.println("*********************************************************************************");
		}

	}

	public static void addFriend() {
		if (currentUser.isModerateur()) {
			reponse = 'O';
			System.out.println("******************************* AJOUTER UN AMI **********************************");
			System.out.println("*********************************************************************************");

			while (reponse == 'O') {

				list("FULLNAME+CURRENT", Optional.empty());
				System.out.println("Selectionner l'utilisateur pour lequel vous souhaitez ajouter un ami");
				numeroProfil = choixClavier();
				System.out.println(
						"************************************************************************************************");
				list("FULLNAME-USER", Optional.of(numeroProfil));

				System.out
						.println("Voici une liste des différents utilisateur.Entrer son numéro pour l'ajouter en ami");

				numeroFriend = choixClavier();

				users[numeroProfil].addFriends(users[numeroFriend]);
				users[numeroFriend].addFriends(users[numeroProfil]);
				System.out.println(
						"************************************************************************************************");
				System.out.println("Ami : " + users[numeroFriend].getNom() + " " + users[numeroFriend].getPrenom()
						+ " à bien été ajouté au profil de " + users[numeroProfil].getNom() + " "
						+ users[numeroProfil].getPrenom());
				System.out.println(
						"************************************************************************************************");

				reponse = ' ';
				while (reponse != 'P' && reponse != 'O') {

					System.out.println("ajouter un ami O | Retour menu P");
					reponse = scan.nextLine().charAt(0);

				}
			}

		} else {
			System.out.println("******************************* AJOUTER UN AMI **********************************");
			System.out.println("*********************************************************************************");

			list("FULLNAME", Optional.empty());

			System.out.println("Voici une liste des différents utilisateur.Entrer son numéro pour l'ajouter en ami");

			numeroFriend = choixClavier();

			currentUser.addFriends(users[numeroFriend]);
			users[numeroFriend].addFriends(users[currentUserIndex]);
			System.out.println("*********************************************************************************");
			System.out.println("Ami : " + users[numeroFriend].getNom() + " " + users[numeroFriend].getPrenom()
					+ " à bien été ajouté");
			System.out.println("*********************************************************************************");
		}

	}

	public static void showFriend() {
		if (currentUser.isModerateur()) {
			reponse = 'O';
			System.out.println("******************************* AFFICHER AMIS ***********************************");
			System.out.println("*********************************************************************************");

			while (reponse == 'O') {

				list("FULLNAME+CURRENT", Optional.empty());

				numeroProfil = choixClavier();

				if (users[numeroProfil] != null) {

					System.out.println("voici les amis de l'utilisateur " + users[numeroProfil].getNom() + " "
							+ users[numeroProfil].getPrenom());
					System.out.println(
							"*********************************************************************************");
					list("FRIENDS", Optional.of(numeroProfil));
					System.out.println(
							"*********************************************************************************");
				}
				reponse = ' ';

				while (reponse != 'P' && reponse != 'O') {

					System.out.println("voir les amis d'un autre profil O | Retour menu P ");
					reponse = scan.nextLine().charAt(0);

				}
			}

		} else {
			System.out.println("******************************* AFFICHER AMIS ***********************************");
			System.out.println("*********************************************************************************");

			list("FRIENDS", Optional.of(currentUserIndex));
			System.out.println("*********************************************************************************");
		}
	}

	public static void delMessage() {
		if (currentUser.isModerateur()) {
			reponse = 'O';
			System.out.println("******************************* SUPPRIMER MESSAGE ***********************************");
			System.out.println("*************************************************************************************");
			while (reponse == 'O') {
				list("FULLNAME+NB-MESSAGE", Optional.empty());

				numeroProfil = choixClavier();
				System.out.println(
						"*************************************************************************************");
				list("MESSAGE", Optional.of(numeroProfil));
				System.out.println(
						"*************************************************************************************");
				users[numeroProfil].delMessages(choixClavier());
				System.out.println(
						"*************************************************************************************");
				System.out.println("Message supprimé !");
				System.out.println(
						"*************************************************************************************");
				reponse = ' ';

				while (reponse != 'P' && reponse != 'O') {

					System.out.println("Supprimer un autre message O | Retour menu P ");
					reponse = scan.nextLine().charAt(0);
				}
			}
		} else {

			list("MESSAGE", Optional.of(currentUserIndex));
			currentUser.delMessages(choixClavier());
			System.out.println("*************************************************************************************");
			System.out.println("Message supprimé !");
			System.out.println("*************************************************************************************");
		}

	}

	public static void delUser() {
		if (currentUser.isModerateur() && currentUser.getNiveau() == 2) {
			System.out.println(
					"******************************* SUPPRIMER UTILISATEUR ***********************************");
			System.out.println(
					"*****************************************************************************************");

			list("FULLNAME", Optional.empty());
			users[choixClavier()] = null;
			i--;
			System.out.println(
					"*****************************************************************************************");

			System.out.println("Utilisateur Supprimé !");
			System.out.println(
					"*****************************************************************************************");

		} else {

			System.out.println(
					"*****************************************************************************************");
			System.out.println("Vous devez avoir le niveau de droits sur [2] pour pouvoir modifier cette ressource");

			System.out.println(
					"*****************************************************************************************");

		}

	}

	public static void delMessagerie() {
		if (currentUser.isModerateur()) {
			System.out.println(
					"******************************* VIDER MESSAGERIE UTILISATEUR ***********************************");
			System.out.println(
					"************************************************************************************************");
			list("FULLNAME+NB-MESSAGE", Optional.empty());

			numeroProfil = choixClavier();

			users[numeroProfil].viderMessages();
			System.out.println(
					"************************************************************************************************");
			System.out.println("La messagerie de l'utilisateur " + users[numeroProfil].getNom() + " "
					+ users[numeroProfil].getPrenom() + " est vide");
			System.out.println(
					"************************************************************************************************");
		}
	}

	public static void selectUser() {
		System.out.println(
				"**********************************  UTILISATEUR  COURANT  **************************************");
		System.out.println(
				"************************************************************************************************");

		list("FULLNAME", Optional.empty());

		System.out.println(
				"Voici une liste d'utilisateurs. Entrer un numéro pour le choisir comme utilisateur principal");

		int choix = choixClavier();
		currentUser = users[choix];
		currentUserIndex = choix;
		System.out.println(
				"************************************************************************************************");
		System.out.println(
				"Utilisateur >>> " + currentUser.getNom() + " " + currentUser.getPrenom() + " est bien selectionné");
		System.out.println(
				"************************************************************************************************");
	}

	public static void listUser() {
		if (currentUser.isModerateur() && currentUser.getNiveau() == 2) {
			System.out.println(
					"********************************  UTILISATEUR  DU RESEAU  **************************************");
			System.out.println(
					"************************************************************************************************");
			list("ALL", Optional.empty());

			System.out.println(
					"************************************************************************************************");
		} else {
			System.out.println(
					"************************************************************************************************");
			System.out
					.println("vous devez avoir le niveau de droits sur [2] pour pouvoir bénéficier de cette ressource");
			System.out.println(
					"************************************************************************************************");
		}
	}
}
