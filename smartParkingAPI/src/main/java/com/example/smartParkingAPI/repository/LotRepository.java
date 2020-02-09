package com.example.smartParkingAPI.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.smartParkingAPI.domain.ParkingLot;

@Repository
public class LotRepository extends InMemoryRepository<ParkingLot> {

	protected void updateIfExists(ParkingLot original, ParkingLot updated) {
		original.setDuration(updated.getDuration());
		original.setFloor_no(updated.getFloor_no());
		original.setStatus(updated.isStatus());
		original.setVehicle_no(updated.getVehicle_no());
		
	}
	public List<ParkingLot> findEmpty(){
		List<ParkingLot> empty = Collections.synchronizedList(new ArrayList<>());
		for(int i = 0;i<elements.size();i++) {
			if(elements.get(i).getVehicle_no().equals("")) {
				empty.add(elements.get(i));
			}
		}
		return empty;
		
	}
	public ParkingLot findNext() {
		for(int i = 0;i<elements.size();i++) {
			if(elements.get(i).getVehicle_no().equals("")) {
				return elements.get(i);
			}
		}
		
		return null;
		
	}
}
