package com.rapido.parent.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rapido.parent.dto.ResponseSelectDto;
import com.rapido.parent.dto.SelectRidedto;
import com.rapido.parent.repositry.CoordinatesRep;

import tools.jackson.databind.JsonNode;

@Service
public class CoordinateService {
	
	@Autowired
	private CoordinatesRep cr;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RedisService redisservice;
	public ResponseSelectDto selectrideservice(int id, SelectRidedto selectridedto) {
		double sourceLat = selectridedto.getSourceCoord().getLatitude();
		double sourceLon = selectridedto.getSourceCoord().getLongitude();
		double destinationLat = selectridedto.getDestinationCoord().getLatitude();
		double destinationLon = selectridedto.getDestinationCoord().getLongitude();
		String token = "pk.ed0ebe59f7a6d7e4937a2d6c6c0e697e";
		String url = "https://us1.locationiq.com/v1/directions/driving/" + sourceLon + "," + sourceLat + ";"
				+ destinationLon + "," + destinationLat + "?key=" + token + "&overview=false";
		JsonNode response = restTemplate.getForObject(url, JsonNode.class);
		double distanceInMeters = response.get("routes").get(0).get("distance").asDouble();
		double distance = distanceInMeters / 1000.0;
		double bikeFare = distance * 10;
		double autoFare = distance * 20;
		double cabFare = distance * 30;
		Map<String, Double> fare = new HashMap<>();
		fare.put("bike", bikeFare);
		fare.put("auto", autoFare);
		fare.put("cab", cabFare);
		ResponseSelectDto result = new ResponseSelectDto();
		result.setSource(selectridedto.getSourceCoord());	
		result.setDestination(selectridedto.getDestinationCoord());
		result.setDistance(distance);
		result.setFare(fare);
		redisservice.saveData(id, sourceLat, sourceLon, destinationLat, destinationLon, distance, fare);

		return result;
	}

}
