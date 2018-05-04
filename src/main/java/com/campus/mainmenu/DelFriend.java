package com.campus.mainmenu;

import com.campus.reseausocial.ReseauSocial;
import com.campus.reseausocial.User;

public class DelFriend extends MenuEntry{
	

	@Override
	public String display() {
		switch (this.display) {
		case 0:
			msg = "Supprimer un ami";
			break;
		case 1:
			msg = "Supprimer un ami à un des utilisateurs";
			break;
		}
		return msg;
	}

	@Override
	public void exec() {
		ReseauSocial.delFriend();
		
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
