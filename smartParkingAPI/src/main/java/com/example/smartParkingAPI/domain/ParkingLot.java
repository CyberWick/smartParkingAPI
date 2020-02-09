package com.example.smartParkingAPI.domain;

//import com.dzone.albanoj2.example.rest.domain.Identifiable;

public class ParkingLot implements Identifiable{
	private boolean status;
	private String id;
	private String vehicle_no;
	private String floor_no;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
<<<<<<< HEAD
//	@Override
//	public Long getId() {
//		// TODO Auto-generated method stub
//		return id;
//	}
//	@Override
//	public void setId(Long id) {
//		// TODO Auto-generated method stub
//		this.id = id;
//	}
=======
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
>>>>>>> branch 'master' of https://github.com/CyberWick/smartParkingAPI.git
//	public void updateStatus (String vehicle_no) {
//		this.setVehicle_no(vehicle_no);
//	} incase of any further updation required
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return lot_name;
	}
}
