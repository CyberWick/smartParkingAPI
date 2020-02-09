package com.example.smartParkingAPI.repository;

import org.springframework.stereotype.Repository;

import com.example.smartParkingAPI.domain.Vehicles;

@Repository
public class VehicleRepository extends InMemoryRepository<Vehicles> {

	protected void updateIfExists(Vehicles original, Vehicles updated) {
		original.setDuration(updated.getDuration());
		//original.setId(updated.getId());
		original.setLot_name(updated.getLot_name());
		original.setMallId(updated.getMallId());
		original.setVehicle_no(updated.getVehicle_no());
	}
}

