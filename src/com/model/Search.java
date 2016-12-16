package com.model;

import java.io.Serializable;

public class Search implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String trip;
    private String from;
    private String to;
    private String depDate;
    private String retDate;
    private String adult;
    private String child;
    private String infant;
    
	public Search() {
	}
	
	public Search(String trip, String from, String to, String depDate, String retDate, String adult, String child,
			String infant) {
		this.trip = trip;
		this.from = from;
		this.to = to;
		this.depDate = depDate;
		this.retDate = retDate;
		this.adult = adult;
		this.child = child;
		this.infant = infant;
	}
	
	/**
	 * @return the trip
	 */
	public String getTrip() {
		return trip;
	}
	/**
	 * @param trip the trip to set
	 */
	public void setTrip(String trip) {
		this.trip = trip;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return the depDate
	 */
	public String getDepDate() {
		return depDate;
	}
	/**
	 * @param depDate the depDate to set
	 */
	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}
	/**
	 * @return the retDate
	 */
	public String getRetDate() {
		return retDate;
	}
	/**
	 * @param retDate the retDate to set
	 */
	public void setRetDate(String retDate) {
		this.retDate = retDate;
	}
	/**
	 * @return the adult
	 */
	public String getAdult() {
		return adult;
	}
	/**
	 * @param adult the adult to set
	 */
	public void setAdult(String adult) {
		this.adult = adult;
	}
	/**
	 * @return the child
	 */
	public String getChild() {
		return child;
	}
	/**
	 * @param child the child to set
	 */
	public void setChild(String child) {
		this.child = child;
	}
	/**
	 * @return the infant
	 */
	public String getInfant() {
		return infant;
	}
	/**
	 * @param infant the infant to set
	 */
	public void setInfant(String infant) {
		this.infant = infant;
	}
	
	@Override
	public String toString() {
		return "Search [trip=" + trip + ", from=" + from + ", to=" + to + ", depDate=" + depDate + ", retDate="
				+ retDate + ", adult=" + adult + ", child=" + child + ", infant=" + infant + "]";
	}


}
