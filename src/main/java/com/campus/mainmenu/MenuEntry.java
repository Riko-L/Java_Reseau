package com.campus.mainmenu;

import com.campus.reseausocial.User;

public abstract class MenuEntry {
	
	/**
	 * Defini le droit d'affichage du contenu de l'élément du menu
	 * 
	 * [0] pour utilisateur normale
	 * [1] pour utilisateur modérateur
	 */
	protected int display;
	
	/**
	 *  Texte de l'élément du menu
	 */
	protected String msg;
	
	/**
	 * Defini le droit d'affichage d'un élément du menu
	 * 
	 * [0] pour utilisateur normale
	 * [1] pour utilisateur modérateur
	 */
	protected int acl = 0;

	/**
	 * 
	 * 
	 * @return Une chaine de caractère de l'élément du menu demandé
	 */
	abstract String display();
	
	abstract void exec();
	
	abstract boolean isModerator(User user);

	abstract int getAcl();

	abstract void setAcl(int acl);
	
	abstract void setDisplay(int display);

	
}
