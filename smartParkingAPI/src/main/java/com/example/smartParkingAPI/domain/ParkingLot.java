package com.example.smartParkingAPI.domain;

//import com.dzone.albanoj2.example.rest.domain.Identifiable;

public class ParkingLot implements Identifiable{
	private boolean status;
	private Long id;
	private String vehicle_no;
	private String floor_no;
	private String lot_name;
	private int duration;
	ParkingLot() {
		
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getFloor_no() {
		return floor_no;
	}
	public void setFloor_no(String floor_no) {
		this.floor_no = floor_no;
	}
	public String getLot_name() {
		return lot_name;
	}
	public void setLot_name(String lot_name) {
		this.lot_name = lot_name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
//	public void updateStatus (String vehicle_no) {
//		this.setVehicle_no(vehicle_no);
//	} incase of any further updation required
}
