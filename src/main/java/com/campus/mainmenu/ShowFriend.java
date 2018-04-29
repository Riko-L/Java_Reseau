package com.campus.mainmenu;

import com.campus.reseausocial.ReseauSocial;
import com.campus.reseausocial.User;


public class ShowFriend extends MenuEntry {


	@Override
	String display() {
		switch (this.display) {
		case 0:
			msg = "Afficher mes amis";
			break;
		case 1:
			msg = "Afficher les amis d'un utilisateur";
			break;
		}
		return msg;
	}

	@Override
	void exec() {
		ReseauSocial.showFriend();
		
	}


	@Override
	boolean isModerator(User user) {
		if (user.isModerateur()) {
			setDisplay(1);
		} else {
			setDisplay(0);
		}

		return user.isModerateur();
	}

	public int getAcl() {
		return acl;
	}

	public void setAcl(int acl) {
		this.acl = acl;
	}
	
	public void setDisplay(int display) {
		this.display = display;
	}
}
