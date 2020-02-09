package com.example.smartParkingAPI.repository;

import org.springframework.stereotype.Repository;
import com.example.smartParkingAPI.domain.ParkingLot;

@Repository
public class LotRepository extends InMemoryRepository<ParkingLot> {

	protected void updateIfExists(ParkingLot original, ParkingLot updated) {
		original.setDuration(updated.getDuration());
		original.setFloor_no(updated.getFloor_no());
		original.setLot_name(updated.getLot_name());
		original.setStatus(updated.isStatus());
		original.setVehicle_no(updated.getVehicle_no());
		
	}
}
