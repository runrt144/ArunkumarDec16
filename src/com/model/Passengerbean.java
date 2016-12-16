package com.model;

import java.beans.PropertyChangeSupport;
import java.util.Date;

public class Passengerbean {
	protected int passengerid = -1;
	protected String firstname = null;
	protected int passportno = -1;
	protected Date dob = null;
	protected String senior = null;

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void setpassengerid(int passengerid) {
		int oldvalue = this.passengerid;
		this.passengerid = passengerid;
		pcs.firePropertyChange("passengerid", oldvalue, passengerid);
	}

	public int getpassengerid() {
		return passengerid;
	}

	public void setfirstname(String firstname) {
		String oldvalue = this.firstname;
		this.firstname = firstname;
		pcs.firePropertyChange("firstname", oldvalue, firstname);
	}

	public String getfirstname() {
		return firstname;
	}

	public void setpassportno(int passportno) {
		int oldvalue = this.passportno;
		this.passportno = passportno;
		pcs.firePropertyChange("passportno", oldvalue, passportno);
	}

	public int getpassportno() {
		return passportno;
	}

	public void setdob(Date dob) {
		Date oldvalue = this.dob;
		this.dob = oldvalue;
		pcs.firePropertyChange("dob", oldvalue, oldvalue);
	}

	public Date getdob() {
		return dob;
	}

	public void setsenior(String senior) {
		String oldvalue = this.senior;
		this.senior = senior;
		pcs.firePropertyChange("senior", oldvalue, senior);
	}

	public String getsenior() {
		return senior;
	}
}
