package com.campus.submenu;

import com.campus.mainmenu.MenuEntry;
import com.campus.reseausocial.User;

public class RetourMenu extends MenuEntry {


	@Override
	public String display() {
		msg = "Retour au menu :";
		return msg;
	}

	@Override
	public void exec() {

	}
	
	public int exec(int index) {

		return index;
	}

	@Override
	public boolean isModerator(User user) {
		return false;
	}

	@Override
	public int getAcl() {
		return 0;
	}

	@Override
	public void setAcl(int acl) {
		this.acl = acl;
		
	}

	@Override
	public void setDisplay(int display) {
		
	}
	
	

}
