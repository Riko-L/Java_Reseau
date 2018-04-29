package com.campus.mainmenu;

import com.campus.reseausocial.ReseauSocial;
import com.campus.reseausocial.User;

public class UpdateLevel extends MenuEntry {

	private int acl = 1;
	
	@Override
	String display() {
		msg = "Modifier niveau de modération";
		return msg;
	}

	@Override
	void exec() {
		ReseauSocial.changeLevel();
		
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

	@Override
	int getAcl() {
		return acl;
	}

	@Override
	void setAcl(int acl) {
		this.acl = acl;
		
	}

	@Override
	void setDisplay(int display) {
		this.display = display;
		
	}

}
