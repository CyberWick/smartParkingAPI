package com.example.smartParkingAPI.domain;

public interface Identifiable extends org.springframework.hateoas.Identifiable<String> {
	public void setId(String id);
}