package com.campus.mainmenu;

import com.campus.reseausocial.ReseauSocial;
import com.campus.reseausocial.User;

public class SelectUser extends MenuEntry {


	@Override
	String display() {
		msg = "Selection de l'utilisateur courrant";
		return msg;
	}

	@Override
	void exec() {
		ReseauSocial.selectUser();

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