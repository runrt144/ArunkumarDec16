package com.service;

import java.io.IOException;

import javax.servlet.http.HttpServlet;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.flight.TripSearch;
import com.model.Search;

public class SearchService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TripSearch search(Search search) {

		RestTemplate restTemplate = new RestTemplate();
		TripSearch myPojo = new TripSearch();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String requestJson = "";
		String trip = search.getTrip();
		// String requestJson = "{ \"request\": { \"slice\": [ { \"origin\":
		// \"SFO\", \"destination\": \"MAA\",\"date\": \"2016-11-18\"}, {
		// \"origin\": \"MAA\", \"destination\": \"SFO\", \"date\":
		// \"2016-11-28\"}], \"passengers\": {\"adultCount\":
		// 1,\"infantInLapCount\": 0,\"infantInSeatCount\": 0,\"childCount\":
		// 0,\"seniorCount\": 0}, \"solutions\": 2, \"refundable\": false }}";

		if (trip.equals("round-trip"))
			requestJson = "{  \"request\": {   \"slice\": [ { \"origin\": \"" + search.getFrom()
					+ "\", \"destination\": \"" + search.getTo() + "\",\"date\": \"" + search.getDepDate()
					+ "\"}, { \"origin\": \"" + search.getTo() + "\", \"destination\": \"" + search.getFrom()
					+ "\", \"date\": \"" + search.getRetDate() + "\"}], \"passengers\": {\"adultCount\": "
					+ search.getAdult() + ",\"infantInLapCount\": " + search.getInfant()
					+ ",\"infantInSeatCount\": 0,\"childCount\": " + search.getChild()
					+ ",\"seniorCount\": 0}, \"solutions\": 10, \"refundable\": false }}";
		else
			requestJson = "{  \"request\": {   \"slice\": [ { \"origin\": \"" + search.getFrom()
					+ "\", \"destination\": \"" + search.getTo() + "\",\"date\": \"" + search.getDepDate()
					+ "\"}], \"passengers\": {\"adultCount\": " + search.getAdult() + ",\"infantInLapCount\": "
					+ search.getInfant() + ",\"infantInSeatCount\": 0,\"childCount\": " + search.getChild()
					+ ",\"seniorCount\": 0}, \"solutions\": 10, \"refundable\": false }}";

		//System.out.println("reguest Json : " + requestJson);

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

		restTemplate.setErrorHandler(new ResponseErrorHandler() {

			@Override
			public boolean hasError(ClientHttpResponse arg0) throws IOException {
				if(arg0.getStatusCode().is4xxClientError()){
					System.out.println("error code : " + arg0.getStatusText());
				}
				return false;
			}

			@Override
			public void handleError(ClientHttpResponse arg0) throws IOException {  
				System.out.println("error code : " + arg0.getStatusText());
			}
		});

		System.out.println(entity);
		ResponseEntity<String> flightSearchResults = null;
		try {
			flightSearchResults = restTemplate.exchange(
					"https://www.googleapis.com/qpxExpress/v1/trips/search?key=AIzaSyCXqvb_0xTaproyALoNbHyccTjqD4qb9VY",
					HttpMethod.POST, entity, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();

		try {
			// Convert JSON string to Object
			String jsonInString = flightSearchResults.getBody();
			System.out.println(jsonInString);
			myPojo = mapper.readValue(jsonInString, TripSearch.class);
			// request.setAttribute("flightSearchResults", myPojo);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myPojo;
		// response.sendRedirect("searchresults.jsp");

	}
}
