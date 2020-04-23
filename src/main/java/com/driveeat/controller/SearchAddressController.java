package com.driveeat.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.driveeat.entity.NearRestaurants;
import com.driveeat.entity.RestaurantSpecialities;
import com.driveeat.entity.Specialities;
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

	private NearRestaurants nearRestaurants;

	@PostMapping("/recherche-restaurants")
	public String showAddress(Model model, Double lat, Double lng) {
		Float lat_2 = (float) (lat + 0.2000);
		Float lat_1 = (float) (lat - 0.2000);
		Float lng_1 = (float) (lng - 0.20000);
		Float lng_2 = (float) (lng + 0.20000);
		List<RestaurantSpecialities> restaurantSpecialities = restaurantSpecialitiesRepository
				.getCyrcleOfRestaurants(lat_1, lat_2, lng_1, lng_2);

		List<NearRestaurants> nearRestaurantsList = new ArrayList<NearRestaurants>();
		if (restaurantSpecialities.size() > 0) {
			for (int i = 0; i < restaurantSpecialities.size(); i++) {
				RestaurantSpecialities rs = restaurantSpecialities.get(i);
				if (i < 1) {
					nearRestaurants = new NearRestaurants();
					nearRestaurants.setDistance(distance.distance(lat, lng, rs.getRestaurants().getLatitude(),
							rs.getRestaurants().getLongitude()));
					nearRestaurants.setRestaurants(rs.getRestaurants());
					nearRestaurants.getSpecialities().add(rs.getSpecialities());
					nearRestaurantsList.add(nearRestaurants);
				} else {
					if (rs.getRestaurants().getRestaurantId() == restaurantSpecialities.get(i - 1).getRestaurants()
							.getRestaurantId()) {
						nearRestaurantsList.get(nearRestaurantsList.size() - 1).getSpecialities()
								.add(rs.getSpecialities());
					}

					else {
						nearRestaurants = new NearRestaurants();
						nearRestaurants.setDistance(distance.distance(lat, lng, rs.getRestaurants().getLatitude(),
								rs.getRestaurants().getLongitude()));
						nearRestaurants.setRestaurants(rs.getRestaurants());
						nearRestaurants.getSpecialities().add(rs.getSpecialities());
						nearRestaurantsList.add(nearRestaurants);

					}

				}
			}
		}

		Collections.sort(nearRestaurantsList, new Comparator<NearRestaurants>() {
			public int compare(NearRestaurants r1, NearRestaurants r2) {
				return r1.getDistance().compareTo(r2.getDistance());
			}
		});


		model.addAttribute("nearRestaurantsList", nearRestaurantsList);
		model.addAttribute("specialities", specialitiesRepository.findAll());
		return "searchWithAddress";

	}

}
