package com.campus.submenu;

import com.campus.mainmenu.MenuEntry;
import com.campus.reseausocial.User;

public class AnneeNaissance extends MenuEntry{

	public AnneeNaissance() {
		
	}

	@Override
	public String display() {
		msg = "Année de Naissance :";
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
