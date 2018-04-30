package com.campus.reseausocial;

import java.util.InputMismatchException;

public class ErrSaisieExecption extends InputMismatchException{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5577054970699161735L;


	public ErrSaisieExecption() {
		super();
	}

	
	@Override
	public String getMessage() {
		
		return "Merci de saisir un Intrégral";
	}
}
