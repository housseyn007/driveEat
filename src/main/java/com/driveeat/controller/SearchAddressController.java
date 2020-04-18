package com.driveeat.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.driveeat.entity.NearRestaurants;
import com.driveeat.entity.RestaurantSpecialities;
import com.driveeat.repository.RestaurantSpecialitiesRepository;
import com.driveeat.repository.SpecialitiesRepository;
import com.driveeat.service.DistanceBetween2Points;

@Controller
public class SearchAddressController {

	@Autowired
	private RestaurantSpecialitiesRepository restaurantSpecialitiesRepository;
	@Autowired
	private DistanceBetween2Points distance;
	@Autowired
	private SpecialitiesRepository specialitiesRepository;

	@PostMapping("/recherche-restaurants")
	public String showAddress(Model model,  Double lat, Double lng) {
		Float lat_2 = (float) (lat + 0.2000);
		Float lat_1 = (float) (lat - 0.2000);
		Float lng_1 = (float) (lng - 0.20000);
		Float lng_2 = (float) (lng + 0.20000);
		List<RestaurantSpecialities> restaurantSpecialities = restaurantSpecialitiesRepository
				.getCyrcleOfRestaurants(lat_1, lat_2, lng_1, lng_2);

		List<NearRestaurants> nearRestaurantsList = new ArrayList<NearRestaurants>();

		for (RestaurantSpecialities rs : restaurantSpecialities) {

			nearRestaurantsList.add(new NearRestaurants(distance.distance(lat, lng,
					rs.getRestaurants().getLatitude(), rs.getRestaurants().getLongitude()), rs));
		}
		Collections.sort(nearRestaurantsList, new Comparator<NearRestaurants>() {
			public int compare(NearRestaurants r1, NearRestaurants r2) {
				return r1.getDistance().compareTo(r2.getDistance());
			}
		});

//		System.out.println(nearRestaurantsList.size());
//		for (NearRestaurants r : nearRestaurantsList) {
//			System.out.println(r.getDistance() + " " + r.getRestaurantsSpecialities().getRestaurants().getAddress()
//					+ " " + r.getRestaurantsSpecialities().getRestaurants().getCity() + " latlng"
//					+ r.getRestaurantsSpecialities().getRestaurants().getLatitude() + ","
//					+ r.getRestaurantsSpecialities().getRestaurants().getLongitude() + " name "
//					+ r.getRestaurantsSpecialities().getRestaurants().getName());
//		}
		model.addAttribute("nearRestaurantsList", nearRestaurantsList);
		model.addAttribute("specialities", specialitiesRepository.findAll());
		return "searchWithAddress";

	}

}
