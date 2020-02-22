package com.example.smartParkingAPI.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.smartParkingAPI.PostgresConnection;
import com.example.smartParkingAPI.domain.ParkingLot;

@Repository
public class LotRepository {
	protected List<ParkingLot> elements = Collections.synchronizedList(new ArrayList<>());	
	public ParkingLot create(ParkingLot element) {
		try {
			Statement statement = PostgresConnection.connection.createStatement();
			int rs = statement.executeUpdate("Insert into parkinglot values ('"+ element.getId()+"', '"+element.getFloor_no()+"', "+element.isStatus()+", '"+ element.getVehicle_no()+"', "+ element.getDuration()+");");
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	
	public List<ParkingLot> findEmpty(){
		List<ParkingLot> empty = Collections.synchronizedList(new ArrayList<>());
		try {
			Statement statement = PostgresConnection.connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from parkinglot where status = false;");
            while(rs.next()){
            	ParkingLot p = new ParkingLot();
            	p.setId(rs.getString("id"));
            	p.setFloor_no(rs.getString("floor_no"));
            	p.setStatus(false);
            	p.setVehicle_no("");
            	p.setDuration(rs.getInt("duration"));
            	empty.add(p);
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empty;
		
	}
	public ParkingLot findNext() {
		try {
			Statement statement = PostgresConnection.connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from parkinglot where status = false LIMIT 1;");
            
            if(rs.next()!=false) {
            	ParkingLot p = new ParkingLot();
            	p.setId(rs.getString("id"));
            	p.setFloor_no(rs.getString("floor_no"));
            	p.setStatus(false);
            	p.setVehicle_no("");
            	p.setDuration(rs.getInt("duration"));
            	return p;
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return null;
		
	}


	public boolean update(String id, ParkingLot updatedLot) {
		// TODO Auto-generated method stub
		try {
			Statement statement = PostgresConnection.connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from parkinglot where id = '" + id + "';");
			if(rs.next()!=false){
				statement.executeUpdate("Update parkinglot set status = "+ updatedLot.isStatus() + ", vehicle_no = '" + updatedLot.getVehicle_no()+ "', duration = "+ updatedLot.getDuration()+ " where id = '" + id + "';");
            	return true;
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public ParkingLot findById(String id) {
		try {
			Statement statement = PostgresConnection.connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from parkinglot where id = '"+ id +"';");
            if(rs.next()!=false) {
            	ParkingLot p = new ParkingLot();
            	p.setId(rs.getString("id"));
            	p.setFloor_no(rs.getString("floor_no"));
            	p.setStatus(rs.getBoolean("status"));
            	p.setVehicle_no(rs.getString("vehicle_no"));
            	p.setDuration(rs.getInt("duration"));
            	return p;
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return null;
	}
}
