package com.model;

import java.beans.PropertyChangeSupport;

public class ContactBean {
	protected String email = null;
	protected int phoneno = 0;

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void setemail(String email) {
		String oldvalue = this.email;
		this.email = email;
		pcs.firePropertyChange("email", oldvalue, email);
	}

	public String getemail() {
		return email;
	}

	public void setphoneno(int phoneno) {
		int oldvalue = this.phoneno;
		this.phoneno = phoneno;
		pcs.firePropertyChange("phoneno", oldvalue, phoneno);
	}

	public int getphoneno() {
		return phoneno;
	}
}
