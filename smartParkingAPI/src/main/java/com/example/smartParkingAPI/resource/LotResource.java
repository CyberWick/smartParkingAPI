package com.example.smartParkingAPI.resource;

import org.springframework.hateoas.ResourceSupport;
import com.example.smartParkingAPI.domain.ParkingLot;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LotResource extends ResourceSupport{
	
	private final boolean status;
	private final long id;
	private final String vehicle_no;
	private final String floor_no;
	private final String lot_name;
	private final int duration;
	
	public LotResource( ParkingLot lot) {
		// TODO Auto-generated constructor stub
		
		this.status = lot.isStatus();
		this.id = lot.getId();
		this.vehicle_no = lot.getVehicle_no();
		this.floor_no = lot.getFloor_no();
		this.lot_name = lot.getLot_name();
		this.duration = lot.getDuration();
		
	}
	
	@JsonProperty("id")
	public long getResourceId() {
		return id;
	}
	
	public boolean isStatus() {
		return status;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public String getFloor_no() {
		return floor_no;
	}
	public String getLot_name() {
		return lot_name;
	}
	public int getDuration() {
		return duration;
	}
}
	
