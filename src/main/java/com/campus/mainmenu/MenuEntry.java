package com.campus.mainmenu;

import com.campus.reseausocial.User;

public abstract class MenuEntry {
	
	/**
	 * Defini le droit d'affichage du contenu de l'�l�ment du menu
	 * 
	 * [0] pour utilisateur normale
	 * [1] pour utilisateur mod�rateur
	 */
	protected int display;
	
	/**
	 *  Texte de l'�l�ment du menu
	 */
	protected String msg;
	
	/**
	 * Defini le droit d'affichage d'un �l�ment du menu
	 * 
	 * [0] pour utilisateur normale
	 * [1] pour utilisateur mod�rateur
	 */
	protected int acl = 0;

	/**
	 * 
	 * 
	 * @return Une chaine de caract�re de l'�l�ment du menu demand�
	 */
	abstract String display();
	
	abstract void exec();
	
	abstract boolean isModerator(User user);

	abstract int getAcl();

	abstract void setAcl(int acl);
	
	abstract void setDisplay(int display);

	
}
