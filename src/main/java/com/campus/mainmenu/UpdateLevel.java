package com.campus.mainmenu;

import com.campus.reseausocial.ReseauSocial;
import com.campus.reseausocial.User;

public class UpdateLevel extends MenuEntry {

	private int acl = 1;
	
	@Override
	public String display() {
		msg = "Modifier niveau de modération";
		return msg;
	}

	@Override
	public void exec() {
		ReseauSocial.changeLevel();
		
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

	@Override
	public int getAcl() {
		return acl;
	}

	@Override
	public void setAcl(int acl) {
		this.acl = acl;
		
	}

	@Override
	public void setDisplay(int display) {
		this.display = display;
		
	}

}
