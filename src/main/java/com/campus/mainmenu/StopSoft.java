package com.campus.mainmenu;

import com.campus.reseausocial.User;

public class StopSoft extends MenuEntry {

	
	@Override
	public String display() {

		msg = "Arr�t du progamme";
		return msg;
	}

	@Override
	public void exec() {
		System.out.println("Arr�t du Programme");
		System.exit(-1);

	}

	@Override
	public boolean isModerator(User user) {
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
