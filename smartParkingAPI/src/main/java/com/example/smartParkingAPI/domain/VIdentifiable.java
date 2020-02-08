package com.example.smartParkingAPI.domain;

public interface VIdentifiable extends org.springframework.hateoas.Identifiable<String>{
	public void setId(String vechile_no);
}
