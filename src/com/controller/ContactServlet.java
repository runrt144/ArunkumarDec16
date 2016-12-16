package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] flightDetails, flightDetails1;
		String sampleFlight11 = null, sampleFlight21 = null, sampleFlight31 = null, sampleFlight41 = null, sampleFlight51 = null;
		
		String flight = request.getParameter("bookingInfo");
		String sample = "";
		String delimiter = ";";
		flightDetails = flight.split(delimiter);
		for (int i = 0; i < flightDetails.length; i++) {
			sample = sample + " Flight: " + flightDetails[i];
			i++;
			sample = sample + " Flight No: " + flightDetails[i];
			i++;
			sample = sample + " From: " + flightDetails[i];
			i++;
			sample = sample + " To: " + flightDetails[i];
			i++;
			sample = sample + " Dep Date: " + flightDetails[i];
			i++;
			sample = sample + " Arrival Date: " + flightDetails[i];
			i++;
			sample = sample + " Travel Time: " + flightDetails[i];
		}

		System.out.print("Flight sample: " + sample);
		
		String delimiter1 = "Flight:";
		flightDetails1 = sample.split(delimiter1);
		
		sampleFlight11 = flightDetails1[1];
		sampleFlight21 = flightDetails1[2];
		if(3 < flightDetails1.length)
			sampleFlight31 = flightDetails1[3];
		
		if(4 < flightDetails1.length)
			sampleFlight41 = flightDetails1[4];
		
		if(5 < flightDetails1.length)
			sampleFlight51 = flightDetails1[5];

		String tripoptFlight = request.getParameter("tripoptFlight");
		String tripoptFromTo = request.getParameter("tripoptFromTo");
		String tripoptDate = request.getParameter("tripoptDate");
		String tripoptDur = request.getParameter("tripoptDur");
		String tripoptCost = request.getParameter("tripoptCost");

		
		if (flight.equals(null))
			System.out.println("No flight information fetched.");
		else {
			System.out.println(sampleFlight11 +" Arun 1 " +sampleFlight21);
			HttpSession session = request.getSession();
			session.setAttribute("sampleFlight11", sampleFlight11);
			session.setAttribute("sampleFlight21", sampleFlight21);
			session.setAttribute("sampleFlight31", sampleFlight31);
			session.setAttribute("sampleFlight41", sampleFlight41);
			session.setAttribute("sampleFlight51", sampleFlight51);
			
			session.setAttribute("flight", flight);
			session.setAttribute("sample", sample);
			session.setAttribute("tripoptFlight", tripoptFlight);
			session.setAttribute("tripoptFromTo", tripoptFromTo);
			session.setAttribute("tripoptDate", tripoptDate);
			session.setAttribute("tripoptDur", tripoptDur);
			session.setAttribute("tripoptCost", tripoptCost);
			response.sendRedirect("bookingContact.jsp");
		}

		// Logger logger = Logger.getLogger(flight);
		// logger.info("Selected Flight Informations : "+flight);
		// request.setAttribute("flight", flight);
		// request.getRequestDispatcher("bookingContact.jsp").forward(request,
		// response);
	}
}
