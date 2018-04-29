package com.campus.mainmenu;

import com.campus.reseausocial.ReseauSocial;
import com.campus.reseausocial.User;

public class AddFriend extends MenuEntry{
	

	@Override
	String display() {
		switch (this.display) {
		case 0:
			msg = "Ajouter un ami";
			break;
		case 1:
			msg = "Ajouter un ami à un des utilisateurs";
			break;
		}
		return msg;
	}

	@Override
	void exec() {
		ReseauSocial.addFriend();
		
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
