package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.flight.TripSearch;
import com.model.User;
import com.service.RegisterService;
import com.model.Search;
import com.service.SearchService;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

public class SearchServlet extends HttpServlet { 

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		 response.setContentType("text/plain;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 String trip = request.getParameter("trip");
		 String from = request.getParameter("from");
		 String to   = request.getParameter("to");
		 String depDate = request.getParameter("depDate");
		 String retDate = request.getParameter("retDate");
		 String adult = request.getParameter("adult");
		 String child = request.getParameter("child");
		 String infant = request.getParameter("infant");
	
		 Search search = new Search(trip, from, to , depDate, retDate, adult, child, infant);
		 //System.out.println("Search is : " +search);
		 try {	
			 SearchService seachService = new SearchService();
			 TripSearch result = seachService.search(search);
			 request.setAttribute("flightSearchResults", result);
			 request.getRequestDispatcher("searchResultFlights.jsp").forward(request, response);
		 	}
		 finally {
			 	out.close();
			 }
	}		 
}
