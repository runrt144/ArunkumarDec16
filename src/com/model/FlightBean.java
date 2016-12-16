package com.model;

import java.beans.PropertyChangeSupport;
import java.util.Date;

public class FlightBean {
	protected int bookingid = -1;
	protected String airwaysname = null;
	protected int flightno = 0;
	protected String startplace = null;
	protected String destplace = null;
	protected Date deptdate = null;
	protected Date arrdate = null;
	protected int time = -1;
	protected int cost = -1;

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void setbookingid(int bookingid) {
		int oldvalue = this.bookingid;
		this.bookingid = bookingid;
		pcs.firePropertyChange("bookingid", oldvalue, bookingid);
	}

	public int getbookingid() {
		return bookingid;
	}

	public void setairwaysname(String airwaysname) {
		String oldvalue = this.airwaysname;
		this.airwaysname = airwaysname;
		pcs.firePropertyChange("airwaysname", oldvalue, airwaysname);
	}

	public String getairwaysname() {
		return airwaysname;
	}

	public void setflightno(int flightno) {
		int oldvalue = this.flightno;
		this.flightno = flightno;
		pcs.firePropertyChange("flightno", oldvalue, flightno);
	}

	public int getflightno() {
		return flightno;
	}

	public void setstartplace(String startplace) {
		String oldvalue = this.startplace;
		this.startplace = startplace;
		pcs.firePropertyChange("startplace", oldvalue, startplace);
	}

	public String getstartplace() {
		return startplace;
	}

	public void setdestplace(String destplace) {
		String oldvalue = this.destplace;
		this.destplace = destplace;
		pcs.firePropertyChange("destplace", oldvalue, destplace);
	}

	public String getdestplace() {
		return destplace;
	}

	public void setdeptdate(Date deptdate) {
		Date oldvalue = this.deptdate;
		this.deptdate = deptdate;
		pcs.firePropertyChange("deptdate", oldvalue, deptdate);
	}

	public Date getdeptdate() {
		return deptdate;
	}

	public void setarrdate(Date arrdate) {
		Date oldvalue = this.arrdate;
		this.arrdate = arrdate;
		pcs.firePropertyChange("arrdate", oldvalue, arrdate);
	}

	public Date getarrdate() {
		return arrdate;
	}

	public void settime(int time) {
		int oldvalue = this.time;
		this.time = time;
		pcs.firePropertyChange("time", oldvalue, time);
	}

	public int gettime() {
		return time;
	}

	public void setcost(int cost) {
		int oldvalue = this.cost;
		this.cost = cost;
		pcs.firePropertyChange("cost", oldvalue, cost);
	}

	public int getcost() {
		return cost;
	}

}
