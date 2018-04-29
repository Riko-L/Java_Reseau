package com.campus.mainmenu;

import com.campus.reseausocial.User;

public class StopSoft extends MenuEntry {

	boolean stop = false;

	@Override
	String display() {

		msg = "Arrêt du progamme";
		return msg;
	}

	@Override
	void exec() {
		System.out.println("Programme Arrêté");
		stop = true;

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

	public boolean stop() {
		return stop;

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
