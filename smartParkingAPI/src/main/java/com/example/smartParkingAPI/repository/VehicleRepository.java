package com.example.smartParkingAPI.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.smartParkingAPI.PostgresConnection;
import com.example.smartParkingAPI.domain.Vehicles;

@Repository
public class VehicleRepository {
	
	protected List<Vehicles> elements = Collections.synchronizedList(new ArrayList<>());

	public List<Vehicles> findAll() {
		List<Vehicles> vehicles = Collections.synchronizedList(new ArrayList<>());
		try {
			Statement statement = PostgresConnection.connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from vehicles;");
            while(rs.next()){
            	Vehicles v = new Vehicles();
            	v.setId(rs.getString("vehicle_no"));
            	v.setLot_name(rs.getString("lot_name"));
            	v.setMallId(rs.getString("mallId"));
            	v.setDuration(rs.getInt("duration"));
            	vehicles.add(v);
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicles;
	}
	
	public Vehicles create(Vehicles element) {
		try {
			Statement statement = PostgresConnection.connection.createStatement();
			int rs = statement.executeUpdate("Insert into vehicles values ('"+ element.getId()+"', '"+element.getLot_name()+"', '"+ element.getMallId()+"', "+ element.getDuration()+");");
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	
	
	public boolean delete(String vehicle_no) {
		try {
			Statement statement = PostgresConnection.connection.createStatement();
			int rs = statement.executeUpdate("Delete from vehicles where vehicle_no = '" + vehicle_no + "';");
			if(rs>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
	
	public Vehicles findById(String id) {
		try {
			Statement statement = PostgresConnection.connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from vehicles where vehicle_no = '"+ id+"';");
			if(rs.next()!=false){
            	Vehicles v = new Vehicles();
            	v.setId(rs.getString("vehicle_no"));
            	v.setLot_name(rs.getString("lot_name"));
            	v.setMallId(rs.getString("mallId"));
            	v.setDuration(rs.getInt("duration"));
            	return v;
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch blockvehicles
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean update(String id, Vehicles updated) {
		try {
			Statement statement = PostgresConnection.connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from vehicles where vehicle_no = '" + id + "';");
			if(rs.next()!=false){
				statement.executeUpdate("Update vehicles set lot_name = '"+ updated.getLot_name()+ "' , mallid = '" +updated.getMallId()+ "', duration = "+ updated.getDuration()+ " where vehicle_no = '" + id + "';");
	        	return true;
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

