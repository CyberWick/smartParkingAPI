package com.example.smartParkingAPI.domain;

public class Vehicles implements VIdentifiable{
	private String vehicle_no;
	private String lot_name;
	private String mallId;
	private int duration;
	Vehicles() {
		
	}
	public String getLot_name() {
		return lot_name;
	}

	public void setLot_name(String lot_name) {
		this.lot_name = lot_name;
	}

	public String getMallId() {
		return mallId;
	}

	public void setMallId(String mallId) {
		this.mallId = mallId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return vehicle_no;
	}

	@Override
	public void setId(String vechile_no) {
		// TODO Auto-generated method stub
		this.vehicle_no = vehicle_no;
	}


}
