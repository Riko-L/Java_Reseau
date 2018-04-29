package com.campus.mainmenu;

import java.util.Scanner;

import com.campus.reseausocial.ReseauSocial;

public class Menu {

	private MenuEntry[] menu;
	private MenuEntry[] menuGenerate;
	private Scanner clavier;
	private CreateUser createUser;
	private ShowUser showUser;
	private SelectUser selectUser;
	private UpdateUser updateUser;
	private DelUser delUser;
	private ListAllUser listAllUser;
	private WriteMessage writeMessage;
	private ShowMessage showMessage;
	private DelMessage delMessage;
	private DelAllMessage delAllMessage;
	private AddFriend addFriend;
	private ShowFriend showFriend;
	private StopSoft stopSoft;
	private UpdateLevel updateLevel;

	private int choixInputClavier;

	public Menu() {

		menu = new MenuEntry[15];
		menuGenerate = new MenuEntry[15];
		clavier = new Scanner(System.in);
		createUser = new CreateUser();
		showUser = new ShowUser();
		selectUser = new SelectUser();
		updateUser = new UpdateUser();
		delUser = new DelUser();
		listAllUser = new ListAllUser();
		writeMessage = new WriteMessage();
		showMessage = new ShowMessage();
		delMessage = new DelMessage();
		delAllMessage = new DelAllMessage();
		addFriend = new AddFriend();
		showFriend = new ShowFriend();
		stopSoft = new StopSoft();
		updateLevel = new UpdateLevel();

		int i = 0;
		this.menu[i += 1] = createUser;
		this.menu[i += 1] = showUser;
		this.menu[i += 1] = selectUser;
		this.menu[i += 1] = updateUser;
		this.menu[i += 1] = delUser;
		this.menu[i += 1] = listAllUser;
		this.menu[i += 1] = writeMessage;
		this.menu[i += 1] = showMessage;
		this.menu[i += 1] = delMessage;
		this.menu[i += 1] = delAllMessage;
		this.menu[i += 1] = addFriend;
		this.menu[i += 1] = showFriend;
		this.menu[i += 1] = updateLevel;
		this.menu[i += 1] = stopSoft;

		createMenu();

	}

	private void createMenu() {
		while (!stopSoft.stop()) {
			int g = 0;
			for (int i = 0; i < menu.length; i++) {
				if (menu[i] != null) {
					if (menu[i].isModerator(ReseauSocial.currentUser)
							&& (menu[i].getAcl() == 1 || menu[i].getAcl() == 0)) {
						menuGenerate[g] = menu[i];
						System.out.println("[" + g + "] " + menuGenerate[g].display());
						g++;
					} else if (!menu[i].isModerator(ReseauSocial.currentUser) && menu[i].getAcl() == 0) {
						menuGenerate[g] = menu[i];
						System.out.println("[" + g + "] " + menuGenerate[g].display());
						g++;
					}
				}

			}
			System.out.print("Votre Choix :");
			try {

				choixInputClavier = clavier.nextInt();
				menuGenerate[choixInputClavier].exec();

			} catch (Exception err) {

				System.out.println("ATTENTION >> Entrer un chiffre correspondant au menu");
				clavier.nextLine();
				choixInputClavier = clavier.nextInt();
				menuGenerate[choixInputClavier].exec();

			}
		}
	}
}
