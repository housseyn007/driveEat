package com.driveeat.service;

import org.springframework.stereotype.Service;

@Service
public class DistanceBetween2Points {
	
	
	public Float distance(Double lat1,Double lon1, Float lat2, Float lon2) {
	  	float R =  6372.797f; // km (change this constant to get miles)
	  	float dLat = (float) ((lat2-lat1) * Math.PI / 180);
	  	float dLon = (float) ((lon2-lon1) * Math.PI / 180);
	  	float a = (float) (Math.sin(dLat/2) * Math.sin(dLat/2) +
	  		Math.cos(lat1 * Math.PI / 180 ) * Math.cos(lat2 * Math.PI / 180 ) *
	  		Math.sin(dLon/2) * Math.sin(dLon/2));
	  	float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));
	  	float d = R * c;
	  	if (d > 1) return (float) Math.rint(d); 
	  	else if(d > 3) return (float) Math.rint(d+1);
	  	return d;
	  	
	  }

}
